package org.zerock.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		
		return rawPassword.toString();
	}
	
	@Override
	public boolean matches(CharSequence rawPassord, String encodedPassword) {
		return rawPassord.toString().equals(encodedPassword);
	}
}
