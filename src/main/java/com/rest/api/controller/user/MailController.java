package com.rest.api.controller.user;

import com.rest.api.model.dto.user.MailRequestDto;
import com.rest.api.response.ApiResponse;
import com.rest.api.response.ResponseMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Api(tags = "메일 발송")
@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
@CrossOrigin("*")
public class MailController {

    private static final String HOST_NAVER = "smtp.naver.com"; // 네이버 호스트
    private static final String HOST_GOOGLE = "smtp.gmail.com"; // 구글 호스트

    private static final int PORT_NAVER = 587; // 네이버 포트
    private static final int PORT_GOOGLE = 465; // 구글 포트

    private static final String SEND_EMAIL = "wolfmob@naver.com"; // 전송에 사용할 이메일
    private static final String SEND_PASSWORD = "asfos9612!"; // 전송에 사용할 비밀번호
    
    @ApiOperation(value = "메일 전송 - 네이버", response = ApiResponse.class)
    @PostMapping("/send/naver")
    public ApiResponse send(@RequestBody MailRequestDto mailRequestDto){
        ResponseMap result = new ResponseMap();
        if(naverMailSend(mailRequestDto) == 1) {
            result.setCode(200);
        } else {
            result.setCode(500);
        }
        return result;
    }

    private int naverMailSend(MailRequestDto mailRequestDto) {

        // 프론트엔드에서 정보 get
        String[] receiveUsers = mailRequestDto.getReceiveUsers();
        String newPassword = mailRequestDto.getNewPassword();

        // 백엔드에서 메일 발송 정보 설정
        String title = "[HappyHouse] 비밀번호 재설정 안내입니다.";
        StringBuilder content = new StringBuilder();
        content.append("<div class='container' align='left'>");
        content.append("    <div>안녕하세요, HappyHouse입니다.</div>");
        content.append("    <div>고객님의 비밀번호를 재설정하여 다음과 같이 알려드립니다.</div><br>");
        content.append("    <div>비밀번호 : <strong style='background-color: yellow;'>" + newPassword +  "</strong></div><br>");
        content.append("    <div>안내된 비밀번호로 로그인 후 비밀번호 재설정 바랍니다.</div>");
        content.append("</div>");

        // SMTP 서버 정보를 설정한다.
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST_NAVER);
        props.put("mail.smtp.port", PORT_NAVER);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SEND_EMAIL, SEND_PASSWORD);
            }
        });

        // 메일을 보낸다.
        try {
            InternetAddress[] targets = new InternetAddress[receiveUsers.length];
            int len = receiveUsers.length;
            for(int i = 0 ; i < len ; i++){
                targets[i] = new InternetAddress(receiveUsers[i]);
            }
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SEND_EMAIL));
            message.addRecipients(Message.RecipientType.TO, targets);

            message.setSubject(title); // 메일 제목
            message.setContent(content.toString(),"text/html; charset=utf-8"); // 메일 내용
            message.setSentDate(new Date()); // 메일 발송 일시

            Transport.send(message);
            return 1;
        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;
        }
    }

}


