package uz.pdp.chat.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = "chats_users")
    private List<User> users;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Timestamp createdAt;

}
