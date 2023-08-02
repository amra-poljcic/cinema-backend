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
    private External external;

    public SchedulerProperties getScheduler() {
        return scheduler;
    }

    public void setScheduler(final SchedulerProperties scheduler) {
        this.scheduler = scheduler;
    }

    public External getExternal() {
        return external;
    }

    public void setExternal(final External external) {
        this.external = external;
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

    public static class External {
        private Auth0 auth0;

        public Auth0 getAuth0() {
            return auth0;
        }

        public void setAuth0(final Auth0 auth0) {
            this.auth0 = auth0;
        }
    }

    public static class Auth0 {
        private String audience;
        private String issuer;

        public String getAudience() {
            return audience;
        }

        public void setAudience(final String audience) {
            this.audience = audience;
        }

        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(final String issuer) {
            this.issuer = issuer;
        }
    }
}
