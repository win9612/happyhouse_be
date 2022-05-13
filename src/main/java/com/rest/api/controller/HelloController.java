package com.rest.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. helloworld"})
@RequiredArgsConstructor
@RestController
public class HelloController {
    /*
    1. 화면에 helloworld가 출력됩니다.
    */
    @GetMapping(value = "/helloworld/string")
    public String helloworldString() {
        return "helloworld";
    }
    
    @ApiOperation(value = "헬로월드 json", notes = "설명")
    @GetMapping(value = "/helloworld/json")
    @ResponseBody
    public Hello helloworldJson() {
        Hello hello = new Hello();
        hello.message = hashPassword("ssafy");
        return hello;
    }

    public static class Hello {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
