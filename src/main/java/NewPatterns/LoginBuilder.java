package NewPatterns;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LoginBuilder {

    private String username;
    private String password;

}
