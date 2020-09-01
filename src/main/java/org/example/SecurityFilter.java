package org.example;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import org.glassfish.jersey.internal.util.Base64;

import java.util.List;
import java.util.StringTokenizer;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
        System.out.println(authHeader.get(0));
        if(authHeader.size()>0) {
            String authToken = authHeader.get(0);
            authToken = authToken.replaceFirst("Basic ", "");
            String decodedString = Base64.decodeAsString(authToken);
            StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
            System.out.println(tokenizer.nextToken());
            System.out.println(tokenizer.nextToken());
        }
    }
}
