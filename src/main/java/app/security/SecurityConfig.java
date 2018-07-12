package app.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecurityConfig {
	
	private List<String> forbiddenUserURLs = new ArrayList<>();
	private List<String> forbiddenGuestURLs = new ArrayList<>();
	
	public void configureAdminRights(String... urls) {
		forbiddenUserURLs.addAll(Arrays.asList(urls));
		forbiddenGuestURLs.addAll(Arrays.asList(urls));
	}
	
	public void configureUserRights(String... urls) {
		forbiddenGuestURLs.addAll(Arrays.asList(urls));
	}
	
	public List<String> getForbiddenURLs(String authority) {
		
		if (authority.equals("ADMIN")) {
			return new ArrayList<>();
		} else if (authority.equals("USER")){
			return forbiddenUserURLs;
		} else {
			return forbiddenGuestURLs;
		}
	}
}
