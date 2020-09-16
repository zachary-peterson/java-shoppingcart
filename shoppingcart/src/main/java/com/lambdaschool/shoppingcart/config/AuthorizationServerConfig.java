package com.lambdaschool.shoppingcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

// Authorization - always clients to access - username / password => client id / client secret
// Authentication - users - username / password. Restrict Resources
// Access Token - identifies the user
//
// Authorization - Server
// Security Config - password encryption, toke location, authorization - authentication
// ResourceServer - who has access to what - change the most
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
    static final String CLIENT_ID = System.getenv("OAUTHCLIENTID");
    static final String CLIENT_SECRET = System.getenv("OAUTHCLIENTSECRET");
    static final String GRANT_TYPE_PASSWORD = "password";
    static final String AUTHORIZATION_CODE = "authorization_code";
    static final String SCOPE_WRITE = "write";
    static final String SCOPE_READ = "read";
    static final String TRUST = "trust";
    static final int ACCESS_TOKEN_VALIDITY_SECONDS = -1;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients.inMemory()
            .withClient(CLIENT_ID)
        .secret(encoder.encode(CLIENT_SECRET))
        .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE)
        .scopes(SCOPE_WRITE, SCOPE_READ, TRUST)
        .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
    {
        endpoints.tokenStore(tokenStore)
            .authenticationManager(authenticationManager);
        endpoints.pathMapping("/oauth/token", "/login");
    }


}
