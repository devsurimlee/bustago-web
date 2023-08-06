package site.bustago.web.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.bustago.web.bus.service.BusApiService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class BusApiController {
    private final BusApiService busApiService;

    @Autowired
    public BusApiController(BusApiService busApiService) {
        this.busApiService = busApiService;
    }

    @GetMapping("/getStationInfo")
    public String getStationInfo() {

        String serviceKey = "7EL82Qdmbmo7z/XLrPTpCSFznbTV5KOOaM8Ix9gXP3NjDfm2mqOVvV1lb7nUugRA+FZYMvzqyya0aO752WMklw==";
        String stSrch = "석촌역";
        String resultType = "json";
        String apiUrl = "";
        try {
            apiUrl = "http://ws.bus.go.kr/api/rest/stationinfo/getStationByName" +
                    "?serviceKey=" + serviceKey +
                    "&stSrch=" + URLEncoder.encode(stSrch, "UTF-8") +
                    "&resultType=" + resultType;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return busApiService.getStationInfo(serviceKey, stSrch, resultType);
    }
}
