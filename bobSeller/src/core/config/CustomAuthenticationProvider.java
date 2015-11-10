package core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		// Datos del form de login
		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials();
		
		User user = (User) customUserDetailsService.loadUserByUsername(principal);
		
		if (user != null) {
			
			// Comprobar contraseña
			if (credentials.equals(user.getPassword())) {
				return new UsernamePasswordAuthenticationToken(principal, user.getPassword(), user.getAuthorities());
			}
			else{
				throw new BadCredentialsException("Error de login");
			}
			
		} 
		else {
			throw new BadCredentialsException("Error de login");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
