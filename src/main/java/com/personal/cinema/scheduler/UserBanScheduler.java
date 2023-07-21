package com.personal.cinema.scheduler;

import com.personal.cinema.service.api.KeyValueService;
import com.personal.cinema.service.api.UserService;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserBanScheduler implements Runnable {
    private static final String LAST_BAN_CHECK_KEY = "LAST_BAN_CHECK";
    private final UserService userService;
    private final KeyValueService keyValueService;

    public UserBanScheduler(final UserService userService, final KeyValueService keyValueService) {
        this.userService = userService;
        this.keyValueService = keyValueService;
    }

    @Override
    public void run() {
        final Instant endTime = Instant.now();
        final String lastBanCheck = keyValueService.get(LAST_BAN_CHECK_KEY);
        final Instant startTime = lastBanCheck != null ? Instant.parse(lastBanCheck) : Instant.EPOCH;

        userService.saveAll(userService.listUserAbsence(startTime, endTime));
        keyValueService.put(LAST_BAN_CHECK_KEY, endTime.toString());
    }
}
