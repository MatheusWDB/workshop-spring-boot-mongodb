package br.com.hematsu.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hematsu.workshopmongo.domain.User;
import br.com.hematsu.workshopmongo.dto.UserDTO;
import br.com.hematsu.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService service;

    UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
