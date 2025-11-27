package utez.edu.mx.gmuback.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UpdateUserDTO {
    private String username;
    private String email;
    private Long id;

    public UpdateUserDTO(String username, String email, Long id) {
        this.username = username;
        this.email = email;
        this.id = id;
    }

    public UpdateUserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
