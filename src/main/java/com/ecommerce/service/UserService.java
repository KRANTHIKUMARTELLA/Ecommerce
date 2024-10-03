package com.ecommerce.service;
import com.ecommerce.model.Role;
import com.ecommerce.model.Users;
import com.ecommerce.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.repository.UserRepository;
import com.ecommerce.requestwrapper.UserRegistrationRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private  UserRepository userRepository;

	@Autowired
	private  PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.authorities(user.getRoles().stream()
						.map(role -> new SimpleGrantedAuthority(role.getName()))
						.toArray(SimpleGrantedAuthority[]::new))
				.build();

	}
	@PostConstruct
	public void initRoles() {
		List<String> roleNames = Arrays.asList("ROLE_USER", "ROLE_ADMIN", "ROLE_SUPERADMIN");

		for (String roleName : roleNames) {
			if (roleRepository.findByName(roleName).isEmpty()) {
				Role role = new Role(roleName);
				roleRepository.save(role);
			}
		}
	}

	@PostConstruct
	public void initAdminUser() {
		if (userRepository.findByUsername("superadmin").isEmpty()) {
			Role superAdminRole = roleRepository.findByName("ROLE_SUPERADMIN").get();


			Users admin = new Users(
					"superadmin",
					passwordEncoder.encode("superadmin"),
					Collections.singleton(superAdminRole),
					"superadmin@example.com",
					"1234567890",
					"defaultAdminPic.png",
					"Admin Address"
			);
			userRepository.save(admin);
		}
	}

	public void registerUser(UserRegistrationRequest request, String roleUser) {

		Role role = roleRepository.findByName(roleUser).get();

		Users user = new Users(
				request.getUsername(),
				passwordEncoder.encode(request.getPassword()),
				Collections.singleton(role),
				request.getEmail(),
				request.getPhone(),
				request.getPicture(),
				request.getAddress()
		);
		userRepository.save(user);
	}
	}

