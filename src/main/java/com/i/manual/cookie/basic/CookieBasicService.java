package com.i.manual.cookie.basic;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieBasicService {
	
	public void RequestBackend(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie cookie = new Cookie("CookieName","Backend");
		cookie.setPath(request.getContextPath()); 	// 경로
		cookie.setMaxAge(3600); 					// 유효시간
	    cookie.setHttpOnly(true); 					// 클라이언트 스크립트에서 접근 불가
	    cookie.setSecure(true); 					// HTTPS에서만 전송
	    //cookie.setDomain("example.com"); 			// 도메인 설정 (필요한 경우)

		response.addCookie(cookie);
	}
	
	public void CheckCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("쿠키의 모든 정보 값 출력");
				System.out.println("cookie Name   : " + cookie.getName());
				System.out.println("cookie Value  : " + cookie.getValue());
				System.out.println("cookie Secure : " + cookie.getSecure());	// Http 서버에서는 무조건 false가 나온다
				System.out.println("cookie Path   : " + cookie.getPath());
				System.out.println("cookie Age    : " + cookie.getMaxAge());	// 무조건 -1 출력됨. 브라우저 옵션에서 제대로 된 값 확인 가능
				System.out.println("cookie Domain : " + cookie.getDomain());
			}
		} else {
			System.out.println("쿠키가 없습니다.");
		}
	}

}
