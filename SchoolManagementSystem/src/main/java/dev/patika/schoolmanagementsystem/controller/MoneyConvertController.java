package dev.patika.schoolmanagementsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/convert")
public class MoneyConvertController {

    private final static String convertEndPoint = "http://localhost:8080/convert/tltodollar";
    private final static String convertEndPoint2 = "http://localhost:8080/convert/dollartotl";

    RestTemplate restTemplate = new RestTemplate();

    // Access tltodollar endpoint in ConverOperation module
    @GetMapping("/Endpoint")
    public String convertOperation() {

        String result = restTemplate.getForObject(convertEndPoint,String.class);
        return result;
    }

    // Access dollartotl endpoint in ConverOperation module
    @GetMapping("/Endpoint2")
    public String convertOperation2() {

        String result2 = restTemplate.getForObject(convertEndPoint2,String.class);
        return result2;
    }


}
