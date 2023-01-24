package photoboothmap.server.src.user.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpReq {
    private String name;
    private String email;
    private String password;
}
