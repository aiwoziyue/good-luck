package space.shizi.goodluck.tasks;

import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import space.shizi.goodluck.entity.GoodLuck;
import space.shizi.goodluck.entity.Probability;
import space.shizi.goodluck.model.ProbabilityType;
import space.shizi.goodluck.repository.GoodLuckRepository;
import space.shizi.goodluck.repository.ProbabilityRepository;
import space.shizi.goodluck.util.CwlUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Configuration
@EnableScheduling
public class Task {

    @Resource
    private GoodLuckRepository goodLuckRepository;

    @Resource
    private ProbabilityRepository probabilityRepository;

    /**
     * 每周二、四、日的 00：00：00 执行，获取最新开奖信息
     * 说明 @Scheduled(fixedDelay = 10000000) 立即执行，fixedDelay 是上一次执行完成到下一次开始执行之间的毫秒时间
     */
    // @Scheduled(fixedDelay = 10000000)
    @Scheduled(cron = "0 0 23 ? * 2,4,7")
    public void start() {
        boolean flushed = flushLastGoodLuck();
        if (flushed) {
            updateOccurrenceStatisticsOfProbability();
        }
    }

    private void updateOccurrenceStatisticsOfProbability() {
        Probability probability = probabilityRepository.findFirstByTypeAndDateDesc(ProbabilityType.OccurrenceStatistics);
        if (Objects.nonNull(probability)) {
            GoodLuck goodLuck = goodLuckRepository.findFirstByOrderByCodeDesc();
            if (Objects.nonNull(goodLuck)) {
                Probability save = saveNextProbability(probability, goodLuck);
                log.info("updateOccurrenceStatisticsOfProbability:{}", save);
            }
        }
    }

    private Probability saveNextProbability(Probability probability, GoodLuck goodLuck) {
        Probability np = new Probability();
        BeanUtils.copyProperties(probability, np);

        np.setType(ProbabilityType.OccurrenceStatistics);
        np.setDate(Date.valueOf(LocalDate.now()));

        String blueNum = goodLuck.getBlue();
        String blueField = "red" + blueNum;
        add1(np, blueField);

        String red = goodLuck.getRed();
        String[] redArray = red.split(",");
        for (String redNum : redArray) {
            String redField = "red" + redNum;
            add1(np, redField);
        }

        return probabilityRepository.save(np);
    }

    private void add1(Object np, String methodName) {
        Object fieldValue = ReflectUtil.getFieldValue(np, methodName);
        if (fieldValue instanceof BigDecimal) {
            BigDecimal value = (BigDecimal) fieldValue;
            ReflectUtil.setFieldValue(np, methodName, value.add(BigDecimal.ONE));
        }
    }

    private boolean flushLastGoodLuck() {
        // "name=ssq&pageNo=1&pageSize=30&systemType=PC"
        Map<String, Object> params = new HashMap<>();
        params.put("name", "ssq");
        params.put("pageNo", "1");
        params.put("pageSize", "1");
        params.put("systemType", "PC");
        List<GoodLuck> result = CwlUtil.page(params);
        if (!result.isEmpty()) {
            GoodLuck save = goodLuckRepository.save(result.get(0));
            log.info("flushLastGoodLuck:{}", save);
            return true;
        }
        log.error("flushLastGoodLuck error");
        return false;
    }

}
