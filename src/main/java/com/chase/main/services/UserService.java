package com.chase.main.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.chase.main.models.User;
import com.chase.main.repos.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}


	public User createUser(User u) {
		String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashed);
		return userRepo.save(u);
	}
	

	public List<User> findAllUsers() {
		return userRepo.findAll();
	}
	
	public User findById(Long id) {
		return userRepo.findById(id).get();
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	

	public User updateUser(User u) {
		return userRepo.save(u);
	}
	

	public void deleteUser(User u) {
		userRepo.delete(u);
	}

	
	public boolean authenticateUser(String email, String password) {
		User u = userRepo.findByEmail(email);
		
		if(u == null) {
			return false;
		}
		
		else {
			if(BCrypt.checkpw(password, u.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}