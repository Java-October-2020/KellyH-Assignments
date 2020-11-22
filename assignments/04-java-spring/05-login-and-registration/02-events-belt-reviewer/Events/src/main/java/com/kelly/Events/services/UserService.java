package com.kelly.Events.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Events.models.Event;
import com.kelly.Events.models.User;
import com.kelly.Events.repositories.UserRepository;

@Service
public class UserService{
	@Autowired
	private UserRepository uRepo;
	
	//register
	public User registerUser(User newUser) {
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return uRepo.save(newUser);
	}
	//find one user
	public User findUserById(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	//find by email
	public User findUserByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	//authenticate user
	public boolean authenticateUser(String email, String password) {
		 User u = uRepo.findByEmail(email);
		 if (u == null) {
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

	//update user
	//delete delete
}