package utez.edu.mx.gmuback.modules.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Modifying
    @Query(value = "DELETE FROM student WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id")Long id);
}
