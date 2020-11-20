package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.essat.dao.IUserDao;
import tn.essat.model.User;
@Service
public class UserService implements IUserService{

	
	@Autowired
	IUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User u=dao.findByUsername(username);
		if(u==null) {
			throw new UsernameNotFoundException("user inexistant !!");
		}
		return u;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Bean
	public PasswordEncoder PasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
