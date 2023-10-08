package utez.edu.mx.hackathon_back.service.email;

import utez.edu.mx.hackathon_back.model.email.EmailsDetails;
import utez.edu.mx.hackathon_back.utils.Response;

public interface EmailService {
    Response<EmailsDetails> sendMailWithAttachment(EmailsDetails details);
    Response<EmailsDetails> sendSimpleMail(EmailsDetails details);


}
