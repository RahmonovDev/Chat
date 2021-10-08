package uz.pdp.chat.chat.payload.recieve.chat;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Set<Integer> users;
}
