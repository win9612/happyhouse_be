package com.rest.api.controller;

import com.rest.api.model.dto.AccountDto;
import com.rest.api.model.service.AccountService;
import com.rest.api.response.ApiResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Account")
@RequestMapping("/app/account")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/account")
    public ApiResponse account(@RequestBody @Valid AccountDto accountDto) {
        return accountService.addAccount(accountDto);
    }
}
