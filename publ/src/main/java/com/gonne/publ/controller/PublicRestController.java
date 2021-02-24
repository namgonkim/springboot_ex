package com.gonne.publ.controller;

import com.gonne.publ.config.ApplicationYamlRead;
import com.gonne.publ.dto.APIDto;
import com.gonne.publ.service.PublicAPIService;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by zxcv9455@naver.com on 2021-02-24
 * Blog : http://velog.io/@namgonkim
 * Github : http://github.com/namgonkim
 */

@RestController
public class PublicRestController {

    @Autowired
    private PublicAPIService publicAPIService;

    @GetMapping(value = "/api/v2/corona", produces = "application/json; charset=UTF-8")
    public String callApiToJson() {
        String res = publicAPIService.getCoronaAPIService();
        JSONObject resToJSON = publicAPIService.convertJSON(res);
        System.out.println(resToJSON.toString());
        return resToJSON.toString();
    }

    @PostMapping("/api/v2/corona")
    public String callAPIToJson(@RequestBody APIDto apiDto) {
        String res = publicAPIService.getCoronaAPIService(apiDto);
        JSONObject resToJSON = publicAPIService.convertJSON(res);
        return resToJSON.toString();
    }


    @GetMapping("/api/corona")
    public String callAPI() {

        String res = publicAPIService.getCoronaAPIService();
        return res;
    }
}
