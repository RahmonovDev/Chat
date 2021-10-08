package uz.pdp.chat.chat.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.chat.chat.payload.recieve.message.MessageDTO;
import uz.pdp.chat.chat.payload.recieve.message.MessageGetDTO;
import uz.pdp.chat.chat.payload.response.ApiResponse;
import uz.pdp.chat.chat.service.MessageService;

import javax.validation.Valid;

@RestController
@RequestMapping("/messages")
public class MessageController {

    final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/add")
    public HttpEntity<?> addMessage(@RequestBody @Valid MessageDTO messageDTO){
        ApiResponse apiResponse = messageService.addMessage(messageDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping("/get")
    public HttpEntity<?> getMessage(@RequestBody @Valid MessageGetDTO messageGetDTO){
        ApiResponse apiResponse = messageService.getMessageListByUserId(messageGetDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
