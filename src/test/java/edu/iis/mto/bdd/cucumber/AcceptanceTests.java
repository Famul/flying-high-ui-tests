package edu.iis.mto.bdd.cucumber;

import org.junit.BeforeClass;

public class AcceptanceTests {

    private static final String GECKODRIVER_NAME = "geckodriver.exe";
    private static final String GECKO_PATH = "C:\\Users\\student\\Documents\\mto 187684\\geckodriver\\";

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.gecko.driver", GECKO_PATH + GECKODRIVER_NAME);

    }
}
