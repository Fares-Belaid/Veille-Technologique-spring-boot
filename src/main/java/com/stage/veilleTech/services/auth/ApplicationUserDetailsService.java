package com.stage.veilleTech.services.auth;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.entity.Collaborateur;
import com.stage.veilleTech.exception.EntityNotFoundException;
import com.stage.veilleTech.exception.ErrorCodes;
import com.stage.veilleTech.repository.CollaborateurRepository;
import com.stage.veilleTech.services.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private CollaborateurService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        CollaborateurDto collaborateur = service.findByEmail(email);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        collaborateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

        return new User(collaborateur.getEmail(), collaborateur.getPassword(), authorities);
    }
}
