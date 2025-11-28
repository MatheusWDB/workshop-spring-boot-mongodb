package br.com.hematsu.workshopmongo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hematsu.workshopmongo.domain.User;
import br.com.hematsu.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService service;

    UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
