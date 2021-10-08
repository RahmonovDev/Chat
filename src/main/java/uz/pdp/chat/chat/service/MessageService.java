package uz.pdp.chat.chat.service;

import org.springframework.stereotype.Service;
import uz.pdp.chat.chat.entity.Chat;
import uz.pdp.chat.chat.entity.Message;
import uz.pdp.chat.chat.entity.User;
import uz.pdp.chat.chat.payload.recieve.message.MessageDTO;
import uz.pdp.chat.chat.payload.recieve.message.MessageGetDTO;
import uz.pdp.chat.chat.payload.response.ApiResponse;
import uz.pdp.chat.chat.repository.ChatRepository;
import uz.pdp.chat.chat.repository.MessageRepository;
import uz.pdp.chat.chat.repository.UserRepository;

import java.util.Optional;

@Service
public class MessageService {

    final MessageRepository messageRepository;
    final ChatRepository chatRepository;
    final UserRepository userRepository;

    public MessageService(ChatRepository chatRepository, MessageRepository messageRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public ApiResponse addMessage(MessageDTO messageDTO){
        Optional<Chat> chatOptional = chatRepository.findById(messageDTO.getChat());
        if (!chatOptional.isPresent()) return new ApiResponse("Chat not found",false);
        Chat chat = chatOptional.get();

        Optional<User> userOptional = userRepository.findById(messageDTO.getAuthor());
        if (!userOptional.isPresent()) return new ApiResponse("Author not found",false);
        User user = userOptional.get();

        boolean exists = chatRepository.existsByUserId(chat.getId(), user.getId());
        if(!exists) return new ApiResponse("Cannot add messages to this chat with this user",false);

        Message message = new Message();

        message.setChat(chat);
        message.setAuthor(user);
        message.setText(messageDTO.getText());
        Message savedMessage = messageRepository.save(message);

        return new ApiResponse("Message ID : "+ savedMessage.getId(),true);
    }

    public ApiResponse getMessageListByUserId(MessageGetDTO messageGetDTO){
        boolean exists = chatRepository.existsById(messageGetDTO.getChat());
        if (!exists) return new ApiResponse("Message not found",false);

        return new ApiResponse(messageRepository.findAllByChat_IdOrderByCreatedAtAsc(messageGetDTO.getChat()),true);
    }
}
