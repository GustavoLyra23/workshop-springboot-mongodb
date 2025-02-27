package org.example.workshopmongodb.services;


import org.example.workshopmongodb.domain.Post;
import org.example.workshopmongodb.repository.PostRepository;
import org.example.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return postRepository.findByTitle(title);
    }

    public List<Post> fullSearch(String author, Date from, Date to) {
        to = new Date(to.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(author, from, to);
    }

}
