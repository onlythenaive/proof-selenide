package com.iliagubarev.proof.selenide.utility;

import com.codeborne.selenide.Configuration;

public abstract class BrowserAwareTest extends EnvironmentAwareTest {

    @Override
    public void prepare() {
        super.prepare();
        setupDefaultsIfAbsent();
        Configuration.baseUrl = url();
        Configuration.browser = browser();
        Configuration.holdBrowserOpen = browserHoldOpen();
    }

    protected String browser() {
        return env(BROWSER_PROPERTY_KEY);
    }

    protected boolean browserHoldOpen() {
        return envBoolean(BROWSER_HOLD_OPEN_PROPERTY_KEY);
    }

    protected String login() {
        return env(LOGIN_PROPERTY_KEY);
    }

    protected String password() {
        return env(PASSWORD_PROPERTY_KEY);
    }

    protected String url() {
        return env(URL_PROPERTY_KEY);
    }

    private static final String BROWSER_PROPERTY_KEY = "TVAC_AUTOTEST_BROWSER";
    private static final String BROWSER_HOLD_OPEN_PROPERTY_KEY = "TVAC_AUTOTEST_BROWSER_LEAVE_OPEN";
    private static final String LOGIN_PROPERTY_KEY = "TVAC_AUTOTEST_LOGIN";
    private static final String PASSWORD_PROPERTY_KEY = "TVAC_AUTOTEST_PASSWORD";
    private static final String URL_PROPERTY_KEY = "TVAC_AUTOTEST_URL";

    private void setupDefaultsIfAbsent() {
        setupDefaultIfAbsent(BROWSER_PROPERTY_KEY, "phantomjs");
        setupDefaultIfAbsent(BROWSER_HOLD_OPEN_PROPERTY_KEY, "false");
        setupDefaultIfAbsent(LOGIN_PROPERTY_KEY, "test");
        setupDefaultIfAbsent(PASSWORD_PROPERTY_KEY, "test");
        setupDefaultIfAbsent(URL_PROPERTY_KEY, "unknown-domain");
    }

    private void setupDefaultIfAbsent(final String key, final String value) {
        if (env(key) == null) {
            env(key, value);
        }
    }
}
