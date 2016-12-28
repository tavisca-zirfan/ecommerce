package com.ngdfw.furniture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ngdfw.furniture.model.Menu;
import com.ngdfw.furniture.service.MenuService;

public class MenuInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MenuService ms;
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView==null)
			return;
		Menu menu = ms.getMainMenu();
		modelAndView.addObject("menu", menu);
		System.out.println("executing handler");
	}
}
