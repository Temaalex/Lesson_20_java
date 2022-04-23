//package ru.homework.lesson20.boot.Security;
//
//
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static java.util.stream.Collectors.toList;
//
//@Service
//public class JwtService {
//    private JWTVerifier verifier;
//
//    public JwtService(@Value("${my-config.secret:123}") String secret) {
//        this.verifier = JWT.require(
//                Algorithm.HMAC256(secret)).build();
//    }
//
//    public  boolean verify (String token){
//        try {
//            final DecodedJWT decodedJwt = verifier.verify(token);
//            final String[] roleNames = decodedJwt.getClaim("roles").asArray(String.class);
//
//
//            final String username = decodedJwt.getSubject();
//            final List<SimpleGrantedAuthority> roles = Arrays.stream(roleNames)
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(toList());
//
//            final SecurityContext securityContext = SecurityContextHolder.getContext();
//            securityContext.setAuthentication(
//                    new UsernamePasswordAuthenticationToken(username, null, roles));
//            return true;
//        } catch (Exception err){
//            return false;
//        }
//    }
//
//}
