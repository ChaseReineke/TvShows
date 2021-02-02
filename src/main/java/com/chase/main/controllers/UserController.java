package com.chase.main.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chase.main.models.User;
import com.chase.main.services.TvService;
import com.chase.main.services.UserService;


@Controller
public class UserController {
	
	private final UserService userService;
	private final TvService tvService;
	
	public UserController(UserService userService, TvService tvService) {
		this.userService = userService;
		this.tvService = tvService;
	}

	@GetMapping("/")
	public String login_registration(Model model) {
		model.addAttribute("user", new User());
		
		return "login_registration.jsp";
	}
	
	@PostMapping("/process_registration")
	public String process_registration(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {

		if(result.hasErrors()) {
			System.out.println("Problem found in registration.");
			return "login_registration.jsp";
		}
		
		else {
			System.out.println("Registration Succesfull!");
			userService.createUser(user);
			session.setAttribute("username", user.getUsername());
			session.setAttribute("id", user.getId());
			session.setAttribute("user", userService.findById(user.getId()));
			
			System.out.println("id created" + session.getAttribute("id"));
			return "redirect:/dashboard";
		}
		
	}
	
	@PostMapping("process_login")
	public String process_login(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		
		if(result.hasErrors()) {
			System.out.println("Problem found in registration.");
			return "redirect:/";
		}
		else if(userService.authenticateUser(user.getEmail(), user.getPassword())) {
			System.out.println("Authenticating User");
			
			session.setAttribute("username", userService.findByEmail(user.getEmail()).getUsername());
			session.setAttribute("id", userService.findByEmail(user.getEmail()).getId());

			return "redirect:/dashboard";
		}
		else {
			return "login_registration.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	public TvService getTvService() {
		return tvService;
	}}