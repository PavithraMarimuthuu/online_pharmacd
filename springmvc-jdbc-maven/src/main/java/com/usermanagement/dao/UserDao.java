package com.usermanagement.dao;

import java.util.List;

import com.usermanagement.model.Users;

public interface UserDao {
	 public int save(Users user);
	 
	 public int update(Users user);
	 
	 public Users get(int id);
     
	 public int delete(int id);
	     
	 public List<Users> list();

}
