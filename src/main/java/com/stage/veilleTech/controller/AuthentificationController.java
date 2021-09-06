package com.stage.veilleTech.controller;

import com.stage.veilleTech.dto.auth.AuthentificationRequest;
import com.stage.veilleTech.dto.auth.AuthentificationResponse;
import com.stage.veilleTech.services.auth.ApplicationUserDetailsService;
import com.stage.veilleTech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthentificationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

//    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AuthentificationResponse> authenticate(@RequestBody AuthentificationRequest request)throws Exception{
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

    }catch (BadCredentialsException e){
        throw new Exception("Incorrect email or password ", e);
    }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

//        return ResponseEntity.ok(AuthentificationResponse.builder().accessToken(jwt).build());

        return ResponseEntity.ok(new AuthentificationResponse(jwt));

    }
}
