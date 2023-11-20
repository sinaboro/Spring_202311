package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLlginSuccessHandler implements AuthenticationSuccessHandler{@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.warn("Login Success");
		List<String> roleNames = new ArrayList<String>();	
		
		auth.getAuthorities().forEach(auth2 -> roleNames.add(auth2.getAuthority()));
		
		/*
		 * log.warn("-----------------------------");
		 * 
		 * log.warn(auth.getName()); log.warn(auth.getPrincipal().toString());
		 * 
		 * log.warn("-----------------------------");
		 */
		log.warn("Role names : " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/sample/admin");
			return ;
		}else if(roleNames.contains("ROLE_MEMBER")){
			response.sendRedirect("/sample/member");
			return ;
		}
		
		response.sendRedirect("/");
	}

}










