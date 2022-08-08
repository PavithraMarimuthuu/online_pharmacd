package com.usermanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.usermanagement.model.Users;

class UserDaoTest {
	private DriverManagerDataSource dataSource;
	private UserDao dao;
	
	@BeforeEach
	void setupBeforeEach(){
		
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
		dataSource.setUsername("root");
		dataSource.setPassword("Pavithra@2101");
		dao= new UserDaoImpl(dataSource);
		
		
	}
	

	@Test
	void testSave() {
		
		Users user =new Users( "pavithra", "pavithramv01@gmail.com", "9940875229", "1");
		int result = dao.save(user);
		assertTrue(result>0);
		
	}

	@Test
	void testUpdate() {
		
		Users user =new Users( 7,"pavithra", "pavithram@gmail.com", "9940875229", "6");
		int result = dao.update(user);
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		Integer id=1;
		Users user=dao.get(id);
		if(user!= null)
		{
			System.out.println(user);
		}
		assertNotNull(user);
	}

	@Test
	void testDelete() {
		int id=12;
		int result = dao.delete(id);
		
		assertTrue(result> 0);
	}

	@Test
	void testList() {
		List<Users> listUsers = dao.list();
		 
		for(Users auser : listUsers) {
			System.out.println(auser);
		}
		
		assertTrue(!listUsers.isEmpty());	
	}

}
