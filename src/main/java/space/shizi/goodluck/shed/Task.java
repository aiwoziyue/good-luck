package space.shizi.goodluck.shed;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Task {

    /**
     * 每周二、四、日的 00：00：00 执行，获取最新开奖信息
     */
    @Scheduled(cron = "0 0 0 ? * 2,4,7")
    public void start() {
        System.out.println("123");
    }
}
