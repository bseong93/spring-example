package net.example.myapp.login.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.example.myapp.login.vo.LoginVO;

@Service
public class LoginServiceImpl implements UserDetailsService {
	
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginVO loginVO = new LoginVO();	
		LoginVO resultLoginVO = null;
		
		loginVO.setUserId(username);
		resultLoginVO = (LoginVO)loginDAO.selectOne("LoginMapper.SELECT_001", loginVO);
		
		if(resultLoginVO == null) {
			throw new UsernameNotFoundException("ID : " + username + " is invalid id");
		}
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		UserDetails userDetails = new User(username, resultLoginVO.getUserPw(), roles);
		
		
		return userDetails;
	}

}
