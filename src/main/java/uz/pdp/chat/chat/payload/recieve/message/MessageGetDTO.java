package uz.pdp.chat.chat.payload.recieve.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MessageGetDTO {
    @NotNull
    private Integer chat;
}
