package br.com.hematsu.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.hematsu.workshopmongo.domain.User;
import br.com.hematsu.workshopmongo.dto.UserDTO;
import br.com.hematsu.workshopmongo.repository.UserRepository;
import br.com.hematsu.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
