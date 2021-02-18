package com.gonne.crawling;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrawlingApplicationTests {

    private static WebDriver driver; // 크롬 웹드라이버
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_PATH = "C:\\chromedriver_win32\\chromedriver.exe";
    private static final String TEST_URL = "URL 주소";
    private static final String PROJECT_URL = "추가 주소";
    
    private WebElement element; // 웹 크롤링 요소

    @BeforeEach
    public void init() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH); // 크롬드라이버 위치
        ChromeOptions options = new ChromeOptions();
        //options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options); // 드라이버 생성
    }

    @AfterEach
    public void teardown() {
        driver.close(); // 드라이버 종료
    }

    @Test
    public void test_setCrawling() {
        try {
            driver.get(TEST_URL); Thread.sleep(500);

            // 아이디 입력
            element = driver.findElement(By.id("userId")); Thread.sleep(500);
            element.sendKeys("아이디");

            // 비밀번호 입력
            element = driver.findElement(By.id("passwd")); Thread.sleep(500);
            element.sendKeys("비밀번호");

            element.submit();

            Thread.sleep(2000);

            driver.get(TEST_URL + PROJECT_URL); Thread.sleep(500);

            Thread.sleep(4000);

            

        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
