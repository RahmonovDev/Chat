package uz.pdp.chat.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.chat.chat.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllByChat_IdOrderByCreatedAtAsc(int chatId);
}
