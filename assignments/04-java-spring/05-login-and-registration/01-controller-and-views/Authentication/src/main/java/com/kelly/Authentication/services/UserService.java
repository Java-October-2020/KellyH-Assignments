package com.kelly.Authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Authentication.models.User;
import com.kelly.Authentication.repositories.UserRepository;

@Service
public class UserService{
	@Autowired 
	private UserRepository uRepo;
	
	//hash password and register user (save in DB)
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}
	
	//Find user by email
	public User findUserByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	//Find by user id
	public User findUserById(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	
	//Authenticate user
	public boolean authenticateUser(String email, String password) {
	 User u = uRepo.findByEmail(email);
	 if (u == null) {
		 System.out.println("user returned null");
		 return false;
	 }
	 else {
		 if(BCrypt.checkpw(password, u.getPassword())) {
			 return true;
		 }
		 else {
			 System.out.println("check pw returned false");
			 return false;
		 }
	 }
	
	}
}