package com.billy.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class JWTTOKenVerification extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (httpServletRequest.getServletPath().equals("/api/registerDonor") ||
                (httpServletRequest.getServletPath().equals("/api/registerAdmin"))


        ) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {

            // verify token
            // get token from header request
            String authorization = httpServletRequest.getHeader("Authorization");
            if (!authorization.startsWith("Bearer ")) {
                throw new JWTVerificationException("Invalid token passed");
            }
            // extract token
            String token = authorization.replace("Bearer ", "");
            Algorithm algorithm = Algorithm.HMAC256(SecurityUtils.secret.getBytes());
            // verify token
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .build().verify(token);
            String username = decodedJWT.getSubject();
            String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
            List<SimpleGrantedAuthority> grantedAuthorities = Arrays.stream(roles).
                    map(SimpleGrantedAuthority::new).collect(Collectors.toList());

            // getSecurityContextHolder and add authentication
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    grantedAuthorities
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(httpServletRequest, httpServletResponse);

        }
    }


}
