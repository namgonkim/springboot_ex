package com.gonne.crawling.controller;

import com.gonne.crawling.config.ChromeDriverConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zxcv9455@naver.com on 2021-02-18
 * Blog : http://velog.io/@namgonkim
 * Github : http://github.com/namgonkim
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "api/ocrai")
public class CrawlingController {

    @Autowired
    public WebDriver getDriver;
    public String url = "https://www.naver.com";

    private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);

    @GetMapping
    public String getDriverOn() throws Exception{
        logger.info(getDriver.toString());
        getDriver.get(url); Thread.sleep(3000);

        return "SUCCESS";
    }


}
