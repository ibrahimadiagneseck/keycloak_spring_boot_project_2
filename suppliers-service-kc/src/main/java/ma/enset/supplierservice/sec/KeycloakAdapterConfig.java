package ma.enset.supplierservice.sec;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdapterConfig {

    @Bean
    public KeycloakSpringBootConfigResolver springBootConfigResolver() { // dire a keycloak adapter, utilise la conf de springboot et non keycloak.json dans les resources
        return new KeycloakSpringBootConfigResolver();
    }
}
