package utez.edu.mx.gmuback.modules.user.dto;

import utez.edu.mx.gmuback.modules.students.dto.StudentDTO;

public class UserDTO {
    private String username;
    private String email;
    private StudentDTO matrucula;

    public UserDTO(String username, String email, StudentDTO matrucula) {
        this.username = username;
        this.email = email;
        this.matrucula = matrucula;
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

    public StudentDTO getMatrucula() {
        return matrucula;
    }

    public void setMatrucula(StudentDTO matrucula) {
        this.matrucula = matrucula;
    }
}
