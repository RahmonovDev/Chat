package uz.pdp.chat.chat.service;

import org.springframework.stereotype.Service;
import uz.pdp.chat.chat.entity.Chat;
import uz.pdp.chat.chat.entity.User;
import uz.pdp.chat.chat.payload.recieve.chat.ChatDTO;
import uz.pdp.chat.chat.payload.recieve.chat.ChatGetDTO;
import uz.pdp.chat.chat.payload.response.ApiResponse;
import uz.pdp.chat.chat.repository.ChatRepository;
import uz.pdp.chat.chat.repository.UserRepository;

import java.util.List;

@Service
public class ChatService {

    final ChatRepository chatRepository;
    final UserRepository userRepository;

    public ChatService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    public ApiResponse getList(ChatGetDTO chatGetDTO){
        boolean exists = userRepository.existsById(chatGetDTO.getUser());
        if (!exists) return new ApiResponse("User not found",false);
        return new ApiResponse(chatRepository.chatListByUserId(chatGetDTO.getUser()),true);
    }

    public ApiResponse addChat(ChatDTO chatDTO){
        boolean exists = chatRepository.existsByName(chatDTO.getName());
        if (exists) return new ApiResponse("Such a name already exist",false);

        List<User> users = userRepository.findAllByIdIn(chatDTO.getUsers());
        if (users.size() != chatDTO.getUsers().size()) return new ApiResponse("Conflict on adding users",false);

        Chat chat = new Chat();
        chat.setName(chatDTO.getName());
        chat.setUsers(users);

        Chat savedChat = chatRepository.save(chat);
        return new ApiResponse("chat id : " + savedChat.getId(),true);
    }
}
