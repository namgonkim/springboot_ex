package com.gonne.publ.service;

import com.gonne.publ.config.ApplicationYamlRead;
import com.gonne.publ.dto.APIDto;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by zxcv9455@naver.com on 2021-02-24
 * Blog : http://velog.io/@namgonkim
 * Github : http://github.com/namgonkim
 */
@Service
public class PublicAPIService {

    @Autowired
    private ApplicationYamlRead applicationYamlRead;


    public String getCoronaAPIService() {
        StringBuffer result = new StringBuffer();
        String serviceKey = applicationYamlRead.getServiceKey();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
            //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode("20210201", "UTF-8")); /*검색할 생성일 범위의 시작*/
            urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode("20210223", "UTF-8")); /*검색할 생성일 범위의 종료*/

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode());

            BufferedReader bufferedReader;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            String returnLine;
            // result.append("<xmp>");
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
                System.out.println(returnLine);
            }

            bufferedReader.close();
            conn.disconnect();
            //System.out.println(result);



        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();

    }

    public String getCoronaAPIService(APIDto apiDto) {
        StringBuffer result = new StringBuffer();
        String serviceKey = applicationYamlRead.getServiceKey();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
            //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(apiDto.getPageNo(), "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(apiDto.getNumOfRows(), "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(apiDto.getStartCreateDt(), "UTF-8")); /*검색할 생성일 범위의 시작*/
            urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(apiDto.getEndCreateDt(), "UTF-8")); /*검색할 생성일 범위의 종료*/

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode());

            BufferedReader bufferedReader;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            String returnLine;
            // result.append("<xmp>");
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
                System.out.println(returnLine);
            }

            bufferedReader.close();
            conn.disconnect();
            //System.out.println(result);



        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();

    }



    public JSONObject convertJSON(String xmlString) {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        return jsonObject;
    }

}
