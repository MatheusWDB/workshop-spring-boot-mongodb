package br.com.hematsu.workshopmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hematsu.workshopmongo.domain.User;
import br.com.hematsu.workshopmongo.repository.UserRepository;

@Service
public class UserService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }
}
