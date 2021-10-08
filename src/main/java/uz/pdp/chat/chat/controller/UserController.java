package uz.pdp.chat.chat.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.chat.chat.payload.recieve.user.UserDTO;
import uz.pdp.chat.chat.payload.response.ApiResponse;
import uz.pdp.chat.chat.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public HttpEntity<?> addUser(@RequestBody @Valid UserDTO userDTO){
        ApiResponse apiResponse = userService.addUser(userDTO);
        return ResponseEntity.status(apiResponse.isSuccess()? 201 : 409).body(apiResponse);
    }

}
