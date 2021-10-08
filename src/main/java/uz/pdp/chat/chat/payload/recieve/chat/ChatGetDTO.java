package uz.pdp.chat.chat.payload.recieve.chat;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatGetDTO {
    @NotNull
    private Integer user;
}
