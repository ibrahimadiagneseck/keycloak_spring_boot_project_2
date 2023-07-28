package ma.enset.supplierservice.sec;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {


    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // la gestion des roles et utilisateurs pour keycloak
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http); // la configuration par defaut
        http.authorizeRequests().antMatchers("/suppliers/**").hasAuthority("MANAGER");
    }
}
