package com.order.mission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.mission.entities.Professor;
import com.order.mission.model.UserModel;
import com.order.mission.services.IServiceProf;
import com.order.mission.validator.ProfValidator;

@Controller
public class ProfController {

	@Autowired
	IServiceProf sp;

	@Autowired
	ProfValidator pv;


	@RequestMapping(value="/profil")
	public String index(){
		return "login";
	}
	
	@RequestMapping(value= {"/","/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String signUpPage(Model model) {
		model.addAttribute("userForm", new UserModel());
		return "register";
	}

	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String signUpPage(@ModelAttribute("userForm") UserModel userForm, BindingResult bindingResult, Model model) {
		pv.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "register";
		}

		sp.addProfessor(new Professor(userForm.getEmail(), userForm.getUsername(), userForm.getPassword(), 
				userForm.getLastName(), userForm.getFirstName(), userForm.getBirthDate(),userForm.getAdresses(),
				userForm.getCity(), userForm.getPhone(), userForm.getMobile(),userForm.getNumCIN(), 
				userForm.getResume(), userForm.getPhoto(), userForm.getCINPrinted(), userForm.getStatus()));

		//ss.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

}
