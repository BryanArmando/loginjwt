package com.login.loginjwt.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.loginjwt.domain.Role;
import com.login.loginjwt.domain.User;
import com.login.loginjwt.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    @ApiOperation(value = "Obtener usuarios"
            ,notes = "Este es un método que permite obtener los usuarios")
    @GetMapping("/public/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @ApiOperation(value = "Guardar usuario"
            ,notes = "Método para guardar un usuario")
    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @ApiOperation(value = "Guardar un rol"
            ,notes = "Método para guardar usuario")
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @ApiOperation(value = "Agregar rol a usuario"
            ,notes = "Método para agregar a un usuario un rol")
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    /*
    @PostMapping("public/user/login")
    public ResponseEntity<User> logearse(@RequestParam("username") String username, @RequestParam("password") String password){

    }

     */



    private final AuthenticationManager authenticationManager;

    @ApiOperation(value = "Iniciar Sesión"
            ,notes = "Este método permite ingresar usuario y contraseña para autenticarse y obtener un Token de autorización para los Endpoints privados")
   @PostMapping("/public/user/login")
    public Authentication general(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        username= request.getParameter("username");
        password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);


       //response.setContentType(APPLICATION_JSON_VALUE);
       return authenticationManager.authenticate(authenticationToken);
    }


}
@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}

