package app.security;

import java.util.Arrays;
import java.util.List;

public class SecurityConfig {
	
	private List<String> adminURLs;
	private List<String> userURLs;
	private List<String> guestURLs;
	
	public void configureAdminRights(String... urls) {
		adminURLs = Arrays.asList(urls);
	}
	
	public void configureUserRights(String... urls) {
		userURLs = Arrays.asList(urls);
	}
	
	public void configureGuestRights(String... urls) {
		guestURLs = Arrays.asList(urls);
	}
	
	public List<String> getAdminURLs() {
		return adminURLs;
	}
	
	public List<String> getUserURLs() {
		return userURLs;
	}
	
	public List<String> getGuestURLs() {
		return guestURLs;
	}
}
