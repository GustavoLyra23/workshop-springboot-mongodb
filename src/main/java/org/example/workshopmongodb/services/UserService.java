package org.example.workshopmongodb.services;


import org.example.workshopmongodb.domain.User;
import org.example.workshopmongodb.dto.UserDto;
import org.example.workshopmongodb.repository.UserRepository;
import org.example.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ObjectNotFoundException("User not found with id " + id);
        }
        return user.get();
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

   public User fromDto(UserDto userDto){
        return new User(userDto.getId(),userDto.getName(),userDto.getEmail());
   }
}
