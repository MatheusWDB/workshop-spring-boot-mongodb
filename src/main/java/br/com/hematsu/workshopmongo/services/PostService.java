package br.com.hematsu.workshopmongo.services;

import org.springframework.stereotype.Service;

import br.com.hematsu.workshopmongo.domain.Post;
import br.com.hematsu.workshopmongo.repository.PostRepository;
import br.com.hematsu.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    private PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
