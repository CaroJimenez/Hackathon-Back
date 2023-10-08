package utez.edu.mx.hackathon_back.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import utez.edu.mx.hackathon_back.model.email.EmailsDetails;
import utez.edu.mx.hackathon_back.utils.Response;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class EmailServiceImpl implements  EmailService  {
    @Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;


    @Override
    public Response<EmailsDetails> sendMailWithAttachment(EmailsDetails details) {
        return null;
    }

    @Override
    public Response<EmailsDetails> sendSimpleMail(EmailsDetails details) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        String subject = "PAGO CONFIRMADO OXXOPAY";
        Date dateNow = new Date();
        String content = "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "    <title>Confirmación de Pago</title>"
                + "</head>"
                + "<body style=\"font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #41A98f;\">"
                + "    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#41A98f\">"
                + "        <tr>"
                + "            <td style=\"padding: 20px 0; text-align: center;\">"
                + "            </td>"
                + "        </tr>"
                + "    </table>"
                + "    <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" bgcolor=\"#ffffff\" style=\"border-collapse: collapse; margin: 20px auto; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\">"
                + "        <tr>"
                + "            <td style=\"padding: 40px 30px; text-align: center;\">"
                + "                <h1 style=\"font-size: 24px; color: #333;\">¡Pago Realizado con Éxito!</h1>"
                + "                <p style=\"font-size: 16px; color: #666; margin-top: 20px;\">Estimado " + details.getRecipient() + ",</p>"
                + "                <p style=\"font-size: 16px; color: #666;\">Le informamos que su pago por la cantidad de " + details.getAmount() + " ha sido procesado exitosamente.</p>"
                + "                <p style=\"font-size: 16px; color: #666;\">Fecha de Pago: " + dateNow + "</p>"
                + "                <p style=\"font-size: 16px; color: #666;\">Si tiene alguna pregunta o necesita asistencia adicional, no dude en ponerse en contacto con nuestro equipo de soporte.</p>"
                + "                <p style=\"font-size: 16px; color: #666;\">¡Gracias por su pago y por ser nuestro cliente!</p>"
                + "            </td>"
                + "        </tr>"
                + "    </table>"
                + "    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#41A98f\">"
                + "        <tr>"
                + "            <td style=\"padding: 20px 0; text-align: center;\">"
                + "                <p style=\"font-size: 14px; color: #888;\">Este correo electrónico fue generado automáticamente. Por favor, no responda a este mensaje.</p>"
                + "            </td>"
                + "        </tr>"
                + "    </table>"
                + "</body>"
                + "</html>";

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(content, true);
            mimeMessageHelper.setSubject(subject);
            javaMailSender.send(mimeMessage);
            return new Response<>(
                    details,
                    false,
                    200,
                    "Email send Successfully"
            );
        }catch (MessagingException e){
            return new Response<>(
                    details,
                    true,
                    400,
                    "Email not send Successfully"
            );
        }    }
}
