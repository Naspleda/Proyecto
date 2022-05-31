package com.portfolio.CEN.Security;

import com.portfolio.CEN.Entity.User;
import com.portfolio.CEN.Repository.UserRepo;
import com.portfolio.CEN.Security.Jwt.JwtTokenUtil;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth api.
 */
@RestController
public class AuthApi {

    /**
     * The Auth manager.
     */
    @Autowired
    AuthenticationManager authManager;

    /**
     * The Repo.
     */
    @Autowired
    UserRepo repo;

    /**
     * The Password encoder.
     */
    PasswordEncoder passwordEncoder;

    /**
     * The Jwt token util.
     */
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * Metodo para logear el usuario
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}