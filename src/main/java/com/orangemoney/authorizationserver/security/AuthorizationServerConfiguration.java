package com.orangemoney.authorizationserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{

	
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailService;
	
	@Value("${orange.money.api.token.expiration}")
	private int expiration; 
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthorizationServerConfiguration() {
		super();
	}
	
	@Bean
	public TokenStore tokenStore(){
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter(){
		final JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey("oui214hmui23o4hm1pui3o2hp4m1o3h2m1o43");
		
		return jwtAccessTokenConverter;
	}
	
	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer configurer) {
		configurer.tokenStore(tokenStore()).authenticationManager(authenticationManager)
		.accessTokenConverter(accessTokenConverter());
		configurer.userDetailsService(userDetailService);
	}

	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception{
		clients.inMemory()
		.withClient("Rahul")
		.secret("12345678")
		.accessTokenValiditySeconds(3600)		
		.scopes("read","write")
		.authorizedGrantTypes("password","refresh_token");
		
		
		/*clients.inMemory()
		.withClient("Rahul")
		.secret("12345678")
		.accessTokenValiditySeconds(3600)		
		.scopes("read","write")
		.authorizedGrantTypes("password","refresh_token");*/	
	}
	
	/*@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("rahul")
		.secret("12345678")
		.authorizedGrantTypes("client_credentials")
		.scopes("read","write");
	}*/
	
}
