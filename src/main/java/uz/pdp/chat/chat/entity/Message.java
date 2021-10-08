package uz.pdp.chat.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Chat chat;

    @ManyToOne
    private User author;

    @Column(nullable = false)
    private String text;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Timestamp createdAt;

}
