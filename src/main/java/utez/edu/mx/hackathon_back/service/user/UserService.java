package utez.edu.mx.hackathon_back.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import utez.edu.mx.hackathon_back.model.email.EmailsDetails;
import utez.edu.mx.hackathon_back.model.user.User;
import utez.edu.mx.hackathon_back.model.user.UserRepository;
import utez.edu.mx.hackathon_back.service.email.EmailService;
import utez.edu.mx.hackathon_back.utils.Response;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private EmailService emailService;

    @Transactional(readOnly = true )
    public Response<User> getOne(String email){
        Optional<User> user = this.repository.findByEmail(email);
        if(user.isPresent()){
            return new Response<>(
                    user.get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Not found"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<User> insertCredit(String email,Integer credit){
        Optional<User> user = this.repository.findByEmail(email);
        if(user.isPresent()){
            user.get().setCredit(credit);
            return new Response<>(
                    this.repository.saveAndFlush(user.get()),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Not found"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<User> paymentCredit(@PathVariable("email")String email, @PathVariable("payment")Integer payment){
        Optional<User> user = this.repository.findByEmail(email);
        if(user.isPresent()){
            user.get().setCredit(user.get().getCredit() - payment);
            EmailsDetails emailsDetails = new EmailsDetails();
            emailsDetails.setAmount(payment);
            emailsDetails.setRecipient(user.get().getEmail());
            emailService.sendSimpleMail(emailsDetails);
            return new Response<>(
                    this.repository.saveAndFlush(user.get()),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Not found"
        );
    }

}
