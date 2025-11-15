package utez.edu.mx.gmuback.modules.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utez.edu.mx.gmuback.utils.APIResponse;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<APIResponse> findAll(){
        APIResponse body =new APIResponse(
                "Operacion exitosa",
                userRepository.findAll(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(body,body.getStatus());
    }
}
