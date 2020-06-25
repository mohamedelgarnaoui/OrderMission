package com.order.mission.security;

public interface SecurityService {
	String findLoggedInUsername();
    void autologin(String matricule, String password);
}
