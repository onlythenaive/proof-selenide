package com.iliagubarev.proof.selenide.utility;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

public abstract class EnvironmentAwareTest {

    private Map<String, String> values;

    @Before
    public void prepare() {
        values = new HashMap<>(System.getenv());
    }

    protected String env(final String key) {
        return values.get(key);
    }

    protected boolean envBoolean(final String key) {
        return values.get(key).equalsIgnoreCase("true");
    }

    protected void env(final String key, final String value) {
        values.put(key, value);
    }
}
