package utez.edu.mx.gmuback.modules.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.gmuback.modules.user.dto.UpdateUserDTO;
import utez.edu.mx.gmuback.modules.user.dto.UserStudentDTO;
import utez.edu.mx.gmuback.utils.APIResponse;

@RestController
@RequestMapping("gmu-api/user/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<APIResponse>findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse>findById(@PathVariable("id") Long id){
        return userService.findbyId(id);
    }

    @PostMapping("")
    public ResponseEntity<APIResponse>saveUser(@RequestBody UserStudentDTO dto){
        return userService.saveUser(dto);
    }

    @PutMapping("")
    public ResponseEntity<APIResponse>updateUser(@RequestBody UpdateUserDTO dto){
        return userService.UpdateUser(dto);
    }

    @DeleteMapping("")
    public ResponseEntity<APIResponse>deleteUser(@RequestBody UpdateUserDTO dto){
        return userService.deleteUser(dto);
    }
}
