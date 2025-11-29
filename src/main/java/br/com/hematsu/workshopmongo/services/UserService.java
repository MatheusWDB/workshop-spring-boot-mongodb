package br.com.hematsu.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.hematsu.workshopmongo.domain.User;
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
}
