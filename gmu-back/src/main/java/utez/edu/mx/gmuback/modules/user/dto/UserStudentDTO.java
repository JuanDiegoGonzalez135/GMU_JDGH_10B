package utez.edu.mx.gmuback.modules.user.dto;

import lombok.Data;


@Data
public class UserStudentDTO {
    private String fullname;
    private String username;
    private String email;

    public UserStudentDTO() {
    }

    public UserStudentDTO(String fullname, String username, String email) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
}
