package com.neueda.quickstartdemo;

import java.util.UUID;

public class SecurePasswordGenerator implements PasswordGenerator {

    boolean useUUIDs;

    public SecurePasswordGenerator(boolean useUUIDs) {
        this.useUUIDs = useUUIDs;
    }

    @Override
    public String getNewPassword() {
        if (useUUIDs)
            return UUID.randomUUID().toString();
        else
            return new java.util.Random().ints(8, 0, 36)
        .mapToObj(i -> i < 10 ? String.valueOf(i) : String.valueOf((char) ('a' + i - 10)))
        .reduce("", String::concat);
    }
}
