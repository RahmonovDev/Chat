package uz.pdp.chat.chat.service;

import org.springframework.stereotype.Service;
import uz.pdp.chat.chat.entity.User;
import uz.pdp.chat.chat.payload.recieve.user.UserDTO;
import uz.pdp.chat.chat.payload.response.ApiResponse;
import uz.pdp.chat.chat.repository.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse addUser(UserDTO userDTO){
        boolean exists = userRepository.existsByUsername(userDTO.getUsername());

        if (exists) return new ApiResponse("Such a username already exists",false);

        User user = new User();
        user.setUsername(userDTO.getUsername());

        User savedUser = userRepository.save(user);

        return new ApiResponse("id : "+ savedUser.getId(),true);
    }
}
