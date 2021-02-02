package com.chase.main.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chase.main.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	public List<User> findAll();
	
	public User findByEmail(String email);
}