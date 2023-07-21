package com.personal.cinema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "properties")
public class YAMLConfig {
    private SchedulerProperties scheduler;

    public SchedulerProperties getScheduler() {
        return scheduler;
    }

    public void setScheduler(final SchedulerProperties scheduler) {
        this.scheduler = scheduler;
    }

    public static class SchedulerProperties {
        private Duration userBanCheck;

        public Duration getUserBanCheck() {
            return userBanCheck;
        }

        public void setUserBanCheck(final Duration userBanCheck) {
            this.userBanCheck = userBanCheck;
        }
    }
}
