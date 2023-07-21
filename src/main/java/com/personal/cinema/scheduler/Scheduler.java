package com.personal.cinema.scheduler;

import com.personal.cinema.config.YAMLConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private final ThreadPoolTaskScheduler taskScheduler;
    private final UserBanScheduler userBanScheduler;
    private final YAMLConfig yamlConfig;

    public Scheduler(final ThreadPoolTaskScheduler taskScheduler,
                     final UserBanScheduler userBanScheduler,
                     final YAMLConfig yamlConfig) {
        this.taskScheduler = taskScheduler;
        this.userBanScheduler = userBanScheduler;
        this.yamlConfig = yamlConfig;
    }

    @PostConstruct
    public void schedule() {
        taskScheduler.scheduleWithFixedDelay(userBanScheduler, yamlConfig.getScheduler().getUserBanCheck());
    }
}
