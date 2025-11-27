package utez.edu.mx.gmuback.modules.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.gmuback.modules.rol.Role;
import utez.edu.mx.gmuback.modules.students.Student;
import utez.edu.mx.gmuback.modules.students.StudentRepository;
import utez.edu.mx.gmuback.modules.students.dto.StudentDTO;
import utez.edu.mx.gmuback.modules.user.dto.UpdateUserDTO;
import utez.edu.mx.gmuback.modules.user.dto.UserDTO;
import utez.edu.mx.gmuback.modules.user.dto.UserStudentDTO;
import utez.edu.mx.gmuback.utils.APIResponse;
import utez.edu.mx.gmuback.utils.PasswordUtils;

import java.sql.SQLClientInfoException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    private UserDTO convertEntityToDTO (User u){
        StudentDTO s = new StudentDTO(
                u.getStudent().getFullname(),
                u.getStudent().getMatricula()
        );

        return new UserDTO(
                u.getUsername(),
                u.getEmail(),
                s
        );
    }


    private List<UserDTO> convertEntitiesToDTOs(List<User> us) {
        List<UserDTO> list = new ArrayList<>();
        for (User u : us) {
            list.add(convertEntityToDTO(u));
        }
        return list;
    }

    public UserService(UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<APIResponse> findAll(){
        APIResponse body =new APIResponse(
                "Operacion exitosa",
                convertEntitiesToDTOs(userRepository.findAll()),
                HttpStatus.OK
        );
        return new ResponseEntity<>(body,body.getStatus());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<APIResponse> findbyId(Long id){
        APIResponse body = null;
        User found = userRepository.findById(id).orElse(null);
        if ( found != null){
            body= new APIResponse("Operacion exitosa",convertEntityToDTO(found), HttpStatus.OK);
        }else{
            body= new APIResponse(true, "Usuario no existe", HttpStatus.NOT_FOUND); //Mensaje , error, HttpStatus
        }
        return new ResponseEntity<>(body,body.getStatus());
    }

    @Transactional(rollbackFor = {SQLClientInfoException.class, Exception.class})
    public ResponseEntity<APIResponse>saveUser(UserStudentDTO dto){
        APIResponse body = null;
        try {
            User u = new User();
            u.setRol(Role.STUDENT.getName());
            u.setUsername(dto.getUsername());
            u.setEmail(dto.getEmail());
            u.setPassword(PasswordUtils.generateEncodePassword(dto.getUsername(), dto.getFullname()));
            u = userRepository.saveAndFlush(u);

            //guardar Estudaiante
            //2025gmu19-024700
            Student s = new Student();
            s.setFullname(dto.getFullname());
            s.setMatricula(generateMatricula());
            s.setUser(u);

            studentRepository.saveAndFlush(s);

            body = new APIResponse("Operacion exitosa", HttpStatus.CREATED);
        }catch (Exception ex){
            body= new APIResponse(true, "Usuario no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(body,body.getStatus());
    }

    private String generateMatricula(){
        LocalDateTime now=LocalDateTime.now();
        return now.getYear()+"gmu"+now.getMonthValue()+""+now.getDayOfMonth()+"-"+now.getHour()+""+now.getMinute()+now.getSecond();

    }

    @Transactional(rollbackFor = {SQLClientInfoException.class, Exception.class})
    public ResponseEntity<APIResponse>UpdateUser(UpdateUserDTO dto){
        APIResponse body = null;
        User found = userRepository.findById(dto.getId()).orElse(null);
        if (found != null){
            try {
                found.setEmail(dto.getEmail() != null ? dto.getEmail() : found.getEmail());
                found.setUsername(dto.getUsername() != null ? dto.getUsername() : found.getUsername());
                body = new APIResponse("Operacion exitosa", HttpStatus.OK);
            }catch (Exception ex){
                ex.printStackTrace();
                body= new APIResponse(true, "No se pudo actualizar", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            body= new APIResponse(true, "Usuario no existe", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(body,body.getStatus());
    }

    @Transactional(rollbackFor = {SQLClientInfoException.class, Exception.class})
    public ResponseEntity<APIResponse>deleteUser(UpdateUserDTO dto){
        APIResponse body = null;
        User found = userRepository.findById(dto.getId()).orElse(null);
        if (found != null){
            try {
                studentRepository.deleteById(found.getStudent().getId());
                userRepository.deleteById(found.getId());
                body = new APIResponse("Operacion exitosa", HttpStatus.OK);
            }catch (Exception ex){
                ex.printStackTrace();
                body= new APIResponse(true, "No se pudo eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            body= new APIResponse(true, "Usuario no existe", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(body,body.getStatus());
    }
}
