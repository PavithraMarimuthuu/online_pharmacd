package com.usermanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.usermanagement.dao.UserDao;
import com.usermanagement.model.Users;

@Controller
public class MainController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/")
	public ModelAndView listUser(ModelAndView model) {
		List<Users> listUser = userDao.list();
		model.addObject("listUser", listUser);
		model.setViewName("index");
		
		return model;
	}
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    Users user = new Users();
	    model.addObject("user", user);
	    model.setViewName("ContactForm");
	    return model;
	}
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Users user) {
	    userDao.save(user);
	    return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/updateContact", method = RequestMethod.POST)
	public ModelAndView updateContact(@ModelAttribute Users user) {
	    userDao.update(user);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int Id = Integer.parseInt(request.getParameter("id"));
	    userDao.delete(Id);
	    return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int Id = Integer.parseInt(request.getParameter("id"));
	    Users user = userDao.get(Id);
	    ModelAndView model = new ModelAndView("ContactForm");
	    model.addObject("user", user);
	   
	 
	    return model;
	}

}
