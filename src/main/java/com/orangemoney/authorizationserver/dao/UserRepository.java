package com.orangemoney.authorizationserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orangemoney.authorizationserver.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

	/*@Query("select u from User u where username=userName")
	public User findUserByUserName(String userName);*/
	
	/*@Query("select * from User")
	public List<User> findAllUsers();*/
	
	@Override
	User findOne(String userName);
	
	@Override
	Iterable<User> findAll();
}
