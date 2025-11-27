package utez.edu.mx.gmuback.modules.students.dto;

public class StudentDTO {
    String fullname;
    String matricula;

    String email;

    public StudentDTO() {
    }

    public StudentDTO(String fullname, String matricula) {
        this.fullname = fullname;
        this.matricula = matricula;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
