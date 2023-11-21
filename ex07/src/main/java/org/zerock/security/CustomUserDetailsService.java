package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.CustomUser;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;


@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load user by username >> " + username);
		
		MemberVO vo =   memberMapper.read(username);
		
		log.warn("queried by member mapper >> " + vo);
	
		return vo == null ? null : new CustomUser(vo);
	}

}
