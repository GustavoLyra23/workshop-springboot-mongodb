package org.example.workshopmongodb.config;

import org.example.workshopmongodb.domain.Post;
import org.example.workshopmongodb.domain.User;
import org.example.workshopmongodb.dto.AuthorDto;
import org.example.workshopmongodb.dto.CommentDto;
import org.example.workshopmongodb.repository.PostRepository;
import org.example.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "John", "john@example.com");
        User u2 = new User(null, "Jane", "jane@example.com");
        User u3 = new User(null, "Jack", "jack@example.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post post = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para Sao Paulo abracos.", new AuthorDto(u1));

        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDto(u2));

        CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(u2));
        CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), new AuthorDto(u3));
        CommentDto c3 = new CommentDto("Tenha um otimo dia", sdf.parse("23/03/2018"), new AuthorDto(u2));

        post.getCommentDtoList().addAll(Arrays.asList(c1, c2, c3));

        postRepository.saveAll(Arrays.asList(post, post2));

        u1.getPosts().addAll(Arrays.asList(post, post2));
        userRepository.save(u1);


    }
}
