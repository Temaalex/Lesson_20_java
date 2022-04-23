//package ru.homework.lesson20.boot.Security;
//
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.filter.OncePerRequestFilter;
//import ru.homework.lesson20.boot.Security.Service.JwtService;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class JwtAuthorization extends OncePerRequestFilter {
//
//    private JwtService jwtService;
//
//    public JwtAuthorization(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token = getToken(request);
//        jwtService.verify(token);
//
//        filterChain.doFilter(request,response);
//    }
//
//    private String getToken(HttpServletRequest request) {
//
//        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (header != null && header.startsWith(TOKEN_PREFIX)){
//            return header.substring(TOKEN_PREFIX.length());
//        }
//        return null;
//    }
//
//    private  static final String TOKEN_PREFIX = "Block";
//}
