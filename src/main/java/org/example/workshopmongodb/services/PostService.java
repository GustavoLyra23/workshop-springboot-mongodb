package org.example.workshopmongodb.services;


import org.example.workshopmongodb.domain.Post;
import org.example.workshopmongodb.repository.PostRepository;
import org.example.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (!post.isPresent()) {
            throw new ObjectNotFoundException("User not found with id " + id);
        }
        return post.get();
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }

}
