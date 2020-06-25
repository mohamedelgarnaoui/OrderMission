package com.order.mission.security;

import java.util.HashSet; 
import java.util.List; 
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.services.IServiceProf;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired 
	IServiceProf s;

	@Override
	@Transactional(readOnly = true) 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		
		Professor prof = s.getProfByMatricule(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		List<Privileges> p = s.getallpreviligebyprof(prof.getIdProfessor()); 
		
		for (Privileges privileges :p) {
			grantedAuthorities.add(new SimpleGrantedAuthority(privileges.getName()));
		} 

		return new org.springframework.security.core.userdetails.User(prof.getMatricule(), prof.getPassword(), grantedAuthorities);
	}

}
