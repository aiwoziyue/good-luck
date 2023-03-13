package space.shizi.goodluck.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import space.shizi.goodluck.entity.GoodLuck;
import space.shizi.goodluck.repository.GoodLuckRepository;
import space.shizi.goodluck.util.CwlUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
@EnableScheduling
public class Task {
    static String url = "http://www.cwl.gov.cn/cwl_admin/front/cwlkj/search/kjxx/findDrawNotice";

    @Resource
    private GoodLuckRepository goodLuckRepository;

    /**
     * 每周二、四、日的 00：00：00 执行，获取最新开奖信息
     * 说明 @Scheduled(fixedDelay = 10000000) 立即执行，fixedDelay 是上一次执行完成到下一次开始执行之间的毫秒时间
     */
    // @Scheduled(fixedDelay = 10000000)
    @Scheduled(cron = "0 0 0 ? * 2,4,7")
    public void start() {
        flushLastGoodLuck();
    }

    private void flushLastGoodLuck() {
        // "name=ssq&pageNo=1&pageSize=30&systemType=PC"
        Map<String, Object> params = new HashMap<>();
        params.put("name", "ssq");
        params.put("pageNo", "1");
        params.put("pageSize", "1");
        params.put("systemType", "PC");
        List<GoodLuck> result = CwlUtil.page(params);
        if (!result.isEmpty()) {
            goodLuckRepository.save(result.get(0));
        }
    }

}
