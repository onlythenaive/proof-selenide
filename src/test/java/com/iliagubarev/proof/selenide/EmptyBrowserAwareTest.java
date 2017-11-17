package com.iliagubarev.proof.selenide;

import static com.codeborne.selenide.Selenide.*;
import com.iliagubarev.proof.selenide.utility.BrowserAwareTest;
import org.junit.Test;

public class EmptyBrowserAwareTest extends BrowserAwareTest {

    @Test
    public void runsSampleTest() {
        open("/");
    }
}
