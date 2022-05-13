package com.rest.api.handler;

import com.rest.api.config.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 헤더에서 JWT를 받아오기
        String token = jwtProvider.resolveToken((HttpServletRequest) request);

        // 유효한 토큰인지 확인
        if (token != null && jwtProvider.validateJwtToken(request, token)) {
            // 토큰이 유효하면 토큰으로부터 유저정보 받아오기
            Authentication authentication = jwtProvider.getAuthentication(token);

            // SecurityContext에 Authentication 객체를 저장한다.
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}
