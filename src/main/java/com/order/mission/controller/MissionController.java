package com.order.mission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.mission.entities.Mission;
import com.order.mission.model.MissionModel;
import com.order.mission.services.IServiceMission;
import com.order.mission.services.ServiceMissionImpl;

public class MissionController {

	@Autowired
	IServiceMission ims;
	
	@RequestMapping(value="/addmission", method=RequestMethod.GET)
	public String addMission(Model model) {
		model.addAttribute("missionM", new MissionModel());
		return "mission";
	}
	
	@RequestMapping(value="/addmiss", method=RequestMethod.POST)
	public String addMission(MissionModel mM, Model model) {
		Mission m = new Mission(mM.getSubject(), mM.getDestination(), departureTime, returnTime, creationDate, expiryDate, rejectionRaison, comment)
		
		ims.AddMission(m);
				model.addAttribute("missionM", new MissionModel());
		return "mission";
	}
	
}
