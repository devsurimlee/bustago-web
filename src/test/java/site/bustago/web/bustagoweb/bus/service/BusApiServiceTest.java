package site.bustago.web.bustagoweb.bus.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import site.bustago.web.bus.service.BusApiService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class BusApiServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BusApiService busApiService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Add the JSON message converter to the RestTemplate
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);
    }

    @Test
    void testGetStationInfo() {
        String mockApiResponse = "<xml>Mocked API Response</xml>";
        String serviceKey = "7EL82Qdmbmo7z%2FXLrPTpCSFznbTV5KOOaM8Ix9gXP3NjDfm2mqOVvV1lb7nUugRA%2BFZYMvzqyya0aO752WMklw%3D%3D";
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

        when(restTemplate.getForObject(apiUrl, String.class)).thenReturn(mockApiResponse);


        String response = busApiService.getStationInfo(serviceKey, stSrch, resultType);

        System.out.println(response);

    }
}
