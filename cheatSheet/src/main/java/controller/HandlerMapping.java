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
	
	// URL��û�� ���ڷ� �޾Ƽ�, Controller��ü�� ��ȯ
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
