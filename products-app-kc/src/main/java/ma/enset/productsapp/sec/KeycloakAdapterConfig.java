package ma.enset.productsapp.sec;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdapterConfig {

    @Bean
    public KeycloakSpringBootConfigResolver springBootConfigResolver() { // dire a keycloak adapter, utilise la conf de springboot et non keycloak.json dans les resources
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public KeycloakRestTemplate keycloakRestTemplate(KeycloakClientRequestFactory keycloakClientRequestFactory) { // dire a keycloak adapter, utilise la conf de springboot et non keycloak.json dans les resources
        return new KeycloakRestTemplate(keycloakClientRequestFactory);
    }
}
