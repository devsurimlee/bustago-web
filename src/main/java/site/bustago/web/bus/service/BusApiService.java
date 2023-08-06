package site.bustago.web.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class BusApiService {
    public static final String BASE_URL = "http://ws.bus.go.kr/api/rest/stationinfo/getStationByName";
    private final RestTemplate restTemplate;

    @Autowired
    public BusApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getStationInfo(String serviceKey, String stSrch, String resultType) {

        try {
            stSrch = URLEncoder.encode(stSrch, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // Handle the exception here (e.g., logging, error handling)
        }

        String apiUrl = String.format("%s?serviceKey=%s&stSrch=%s&resultType=%s", BASE_URL, serviceKey, stSrch, resultType);
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
