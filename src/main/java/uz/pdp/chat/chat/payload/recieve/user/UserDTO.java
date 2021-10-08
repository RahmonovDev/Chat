package uz.pdp.chat.chat.payload.recieve.user;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    @NotNull
    private String username;

}
