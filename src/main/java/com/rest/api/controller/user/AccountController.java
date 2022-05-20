package com.rest.api.controller.user;

import com.rest.api.model.dto.user.AccountDto;
import com.rest.api.model.service.user.AccountService;
import com.rest.api.response.ApiResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Base64;

@Api(tags = "회원관리")
@RequestMapping("/app/account")
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/regist")
    public ApiResponse account(@RequestBody @Valid AccountDto accountDto) {
        return accountService.addAccount(accountDto);
    }

    @GetMapping("/profile")
    public ResponseEntity<AccountDto> profile(@RequestHeader(value="token")String token) throws ParseException {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");

        String payload = new String(decoder.decode((chunks[1])));

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(payload);

        String email = (String) jsonObject.get("email");


        return new ResponseEntity<AccountDto>(accountService.getAccount(email), HttpStatus.OK);
    }
}
