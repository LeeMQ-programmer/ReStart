package com.start.pro.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.start.pro.models.login.IService_Login;
import com.start.pro.util.Util_Message;

public class Sc_LoginFailureHandler implements AuthenticationFailureHandler{

	@Autowired
	private IService_Login service;
	
	@Autowired
	private Util_Message message;
	
	private String loginidname;
	private String loginpwdname;
	private String errormsgname;
	private String defaultFailureUrl;
	
	
	public String getLoginidname() {
		return loginidname;
	}

	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}
	
	public String getLoginpwdname() {
		return loginpwdname;
	}

	public void setLoginpwdname(String loginpwdname) {
		this.loginpwdname = loginpwdname;
	}

	public String getErrormsgname() {
		return errormsgname;
	}

	public void setErrormsgname(String errormsgname) {
		this.errormsgname = errormsgname;
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("로그인실패핸들러");
		String id = request.getParameter("username");
		String password = request.getParameter("password");
		String errormsg = null;
		
		if(exception instanceof BadCredentialsException) {
			loginFailureCount(id);
			errormsg = message.getMessage("error.BadCredentials");
		}else if(exception instanceof InternalAuthenticationServiceException) {
            errormsg = message.getMessage("error.BadCredentials");
        } else if(exception instanceof DisabledException) {
            errormsg = message.getMessage("error.Disaled");
        } else if(exception instanceof CredentialsExpiredException) {
            errormsg = message.getMessage("error.CredentialsExpired");
        }
		
		System.out.println(errormsg+"오류!");
		
		request.setAttribute("id", id);
		request.setAttribute("password", password);
		request.setAttribute("error", errormsg);
		
		
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
		
	}
	
	
	private void loginFailureCount(String id) {
		System.out.println(id);
		int cnt = Integer.parseInt(service.PWFail(id));
		System.out.println("이 사용자는 비밀번호를 "+cnt+"만큼 틀렸습니당");
		if(cnt >= 5) {
			System.out.println("캡챠 구현");
		}
	}
	
	
	
}
