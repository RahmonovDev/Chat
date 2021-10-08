package uz.pdp.chat.chat.payload.recieve.message;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDTO {

    @NotNull
    private Integer chat;

    @NotNull
    private Integer author;

    @NotNull
    @NotBlank
    private String text;

}
