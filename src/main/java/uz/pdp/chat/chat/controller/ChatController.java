package uz.pdp.chat.chat.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.chat.chat.payload.recieve.chat.ChatDTO;
import uz.pdp.chat.chat.payload.recieve.chat.ChatGetDTO;
import uz.pdp.chat.chat.payload.response.ApiResponse;
import uz.pdp.chat.chat.service.ChatService;

import javax.validation.Valid;

@RestController
@RequestMapping("/chats")
public class ChatController {

    final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/add")
    public HttpEntity<?> addChat(@RequestBody @Valid ChatDTO chatDTO){
        ApiResponse apiResponse = chatService.addChat(chatDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping("/get")
    public HttpEntity<?> getList(@RequestBody @Valid ChatGetDTO chatGetDTO){
        ApiResponse apiResponse = chatService.getList(chatGetDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
