package com.generation.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.generation.farmacia.model.Usuario;
import com.generation.farmacia.repository.UsuarioRepository;
import com.generation.farmacia.security.JwtService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    // Cadastro de funcionário/usuário
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    // Login e geração de token
    @PostMapping("/logar")
    public ResponseEntity<String> logar(@RequestBody Usuario usuario) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(usuario.getUsuario(), usuario.getSenha())
        );

        String token = jwtService.generateToken((org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(token);
    }
}
