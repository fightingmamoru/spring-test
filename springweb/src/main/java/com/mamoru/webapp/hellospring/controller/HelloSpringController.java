package com.mamoru.webapp.hellospring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringController
{
	// Add Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloSpringController.class);

	private static final String JSP_PATH = "hellospring/";

	@RequestMapping(value = "/helloSpring")
	public ModelAndView hello()
	{
		// Add log for controller start
		String logMessage = "START HelloSpringController";
		LOGGER.debug("HelloSpringLogger - {}", logMessage);

		ModelAndView mav = new ModelAndView();

		mav.setViewName(JSP_PATH + "hellospring");

		mav.addObject("title", "[Spring Web MVC]");
		mav.addObject("message", "Hello Spring!");

		// Add log for controller end
		logMessage = "END HelloSpringController";
		LOGGER.debug("HelloSpringLogger - {}", logMessage);

		return mav;
	}
}
