package utez.edu.mx.hackathon_back.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.hackathon_back.model.user.User;
import utez.edu.mx.hackathon_back.service.user.UserService;
import utez.edu.mx.hackathon_back.utils.Response;

@RestController
@RequestMapping("${apiPrefix}/user")
@CrossOrigin(value = {"*"})
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/{email}")
    public ResponseEntity<Response<User>> getOne(@PathVariable("email") String email){
        return new ResponseEntity<>(
                this.service.getOne(email),
                HttpStatus.OK
        );
    }
    @PostMapping("/{email}/{credit}")
    public ResponseEntity<Response<User>> insertCredit(@PathVariable("email")String email, @PathVariable("credit")Integer credit){
        return new ResponseEntity<>(
                this.service.insertCredit(email,credit),
                HttpStatus.OK
        );
    }
    @PostMapping("/payment/{email}/{credit}")
    public ResponseEntity<Response<User>> paymentCredit(@PathVariable("email")String email, @PathVariable("credit")Integer credit){
        return new ResponseEntity<>(
                this.service.paymentCredit(email,credit),
                HttpStatus.OK
        );
    }
}
