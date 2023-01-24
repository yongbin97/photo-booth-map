package photoboothmap.server.src.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import photoboothmap.server.src.user.model.SignUpReq;
import photoboothmap.server.src.user.model.User;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();

        log.info("users={}", users);

        return users;
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable int userId){
        Optional<User> reqUser = userRepository.findById(userId);

        return reqUser;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody SignUpReq signUpReq){
        User newUser = User.builder()
                        .name(signUpReq.getName())
                        .email(signUpReq.getEmail())
                        .password(signUpReq.getPassword())
                        .build();
        log.info("new_user={}", newUser);
        return userRepository.save(newUser);
    }

}
