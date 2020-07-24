package com.order.mission.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itextpdf.text.DocumentException;
import com.order.mission.entities.Mission;
import com.order.mission.services.IServiceMission;

public class Test {

	public static void main(String[] args) throws DocumentException, IOException {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IServiceMission sm =(IServiceMission) context.getBean("serviceMission");
		Mission m = sm.getMission(4);
		System.out.println(m.getSubject());
		sm.generatePDF(m);
	}
}
