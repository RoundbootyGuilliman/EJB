package app.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecurityConfig {
	
	private List<String> adminURLs = new ArrayList<>();
	private List<String> userURLs = new ArrayList<>();
	private List<String> guestURLs = new ArrayList<>();
	
	public void configureAdminRights(String... urls) {
		adminURLs.addAll(Arrays.asList(urls));
	}
	
	public void configureUserRights(String... urls) {
		adminURLs.addAll(Arrays.asList(urls));
		userURLs.addAll(Arrays.asList(urls));
		
	}
	
	public void configureGuestRights(String... urls) {
		adminURLs.addAll(Arrays.asList(urls));
		userURLs.addAll(Arrays.asList(urls));
		guestURLs.addAll(Arrays.asList(urls));
	}
	
	public List<String> getAllowedURLs(String authority) {
		
		if (authority.equals("ADMIN")) {
			return adminURLs;
		} else if (authority.equals("USER")) {
			return userURLs;
		} else {
			return guestURLs;
		}
	}
}
