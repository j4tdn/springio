package com.spring.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Configure Spring Security Filter
 * Web Browser >> Spring Security Filter >> Servlet Container
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	// 1. context-path/login(GET) 
	// 2. login.jsp(username, password, _csrf_token(...))
	//    ACTIONC: context-path/login METHOD=POST 
	// 3. Verify credential with data in  configure(AuthenticationManagerBuilder auth)
	// 4.1 FAILED  >> context-path/login?error
	// 4.2 SUCCESS >> /AUTHENTICATE >> /
}
