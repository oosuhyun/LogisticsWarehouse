package com.example.LogisticsWarehouse.controller;

import com.example.LogisticsWarehouse.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;

//    @RequestMapping("/login/kakao")
//    public String home(@RequestParam(value = "code", required = false) String code) throws Exception{
//        System.out.println("#########" + code);
//        String access_Token = kakaoService.getAccessToken(code);
//        System.out.println("###access_Token#### : " + access_Token);
//        return "testpage";
//    }

    @RequestMapping("/login/kakao")
    public String home(@RequestParam(value = "code", required = false) String code) throws Exception{
        System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code);
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
//        System.out.println("###profile_image#### : " + userInfo.get("profile_image"));
        return "testPage";
    }

}
