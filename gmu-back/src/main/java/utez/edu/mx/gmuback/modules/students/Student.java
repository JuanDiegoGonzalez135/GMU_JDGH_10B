package utez.edu.mx.gmuback.modules.students;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    @Column(name = "full_name", nullable = false)
    private  String full_name;

    @OneToOne
    @JoinColumn(name = "id_user", unique = true)
    private User user;

    public Student() {
    }

    public Student(Long id, String matricula, String full_name, User user) {
        this.id = id;
        this.matricula = matricula;
        this.full_name = full_name;
        this.user = user;
    }
}
