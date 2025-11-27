package utez.edu.mx.gmuback.modules.students;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.gmuback.modules.user.User;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private  Long id;

    @Column(name = "matricula", nullable = false, unique = true)
    private  String matricula;

    @Column(name = "fullname", nullable = false)
    private  String fullname;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "id_user", unique = true)
    private User user;

    public Student() {
    }

    public Student(Long id, String matricula, String fullname, User user) {
        this.id = id;
        this.matricula = matricula;
        this.fullname = fullname;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
