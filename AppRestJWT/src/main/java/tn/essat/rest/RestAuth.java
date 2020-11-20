package tn.essat.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.config.GestionToken;
import tn.essat.config.JwtRequest;
import tn.essat.config.JwtResponse;
import tn.essat.model.User;
import tn.essat.service.IUserService;
@CrossOrigin("*")
@RestController
@RequestMapping("/auths")
public class RestAuth {
	
	@Autowired
	private GestionToken token_gen;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AuthenticationManager authmanager;
    
	@PostMapping("/login")
	public JwtResponse fnt(@RequestBody JwtRequest request) {
		Authentication auth1=authmanager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth1);
		User user=(User) userService.loadUserByUsername(request.getUsername());
		String token=token_gen.generateToken(user);	
		
		return new JwtResponse(token);
	}
}
