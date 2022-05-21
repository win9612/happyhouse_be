package com.rest.api.controller.user;

import com.google.gson.Gson;
import com.rest.api.model.service.user.AccountService;
import com.rest.api.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/social/login")
public class SocialController {

    private final Gson gson;
    private final AccountService accountService;

    @PostMapping("/kakao")
    public ApiResponse kakao(@RequestBody String req) {
        Map<String, Object> map = gson.fromJson(req, Map.class);

        return accountService.socialLoginOrRegist(map);
    }

}
