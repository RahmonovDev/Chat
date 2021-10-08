package uz.pdp.chat.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.chat.chat.entity.Chat;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Integer> {

    boolean existsByName(String name);

    @Query(
            value = "select exists (select * from chats_users a " +
                    "where a.chat_id = ?1 and a.users_id = ?2 )",nativeQuery = true)
    boolean existsByUserId(Integer chatId,Integer userId);


    @Query(
            value = "select a.id,a.name,a.created_at from Chat a " +
                    "inner join chats_users b on a.id = b.chat_id " +
                    "where b.users_id = ?1 " +
                    "order by a.created_at",nativeQuery = true)
    List<Chat> chatListByUserId(Integer userId);

}
