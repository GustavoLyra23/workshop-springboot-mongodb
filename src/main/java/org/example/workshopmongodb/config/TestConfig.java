package org.example.workshopmongodb.config;

import org.example.workshopmongodb.domain.User;
import org.example.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "John", "john@example.com");
        User u2 = new User(null, "Jane", "jane@example.com");
        User u3 = new User(null, "Jack", "jack@example.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
