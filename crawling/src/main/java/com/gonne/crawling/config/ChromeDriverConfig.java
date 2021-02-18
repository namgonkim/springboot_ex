package com.gonne.crawling.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zxcv9455@naver.com on 2021-02-18
 * Blog : http://velog.io/@namgonkim
 * Github : http://github.com/namgonkim
 */
@Configuration
public class ChromeDriverConfig {

    private static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(ChromeDriverConfig.class);
    private static final String CHROME_DRIVER_ID = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "C:\\chromedriver_win32\\chromedriver.exe";

    @Bean
    public WebDriver getDriver() {
        return driver;
    }

    @Bean
    public WebDriver setUpChromeDriver() throws Exception {
        System.setProperty(CHROME_DRIVER_ID, CHROME_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        try {
            driver = new ChromeDriver(options);
            logger.info("### [driver access] info: {}", driver.toString());
        } catch (Exception e) {
            logger.error("### [driver errer] msg: {}, cause: {}", e.getMessage(), e.getCause());
        }
        return driver;
    }

}
