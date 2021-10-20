package controller;

import java.util.HashMap;
import java.util.Map;

import controller.Member.LoginController;

public class HandlerMapping {
	private Map<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
	}
	
	// URL요청을 인자로 받아서, Controller객체를 반환
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
