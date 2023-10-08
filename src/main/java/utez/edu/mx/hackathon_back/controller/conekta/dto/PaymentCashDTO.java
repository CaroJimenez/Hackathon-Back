package utez.edu.mx.hackathon_back.controller.conekta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.hackathon_back.model.conekta.paymentCash.PaymentCash;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentCashDTO {

    private Long id;
    private String amount;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private Integer status;

    public PaymentCash getPaymentCash(){
        return new PaymentCash(
                getId(),
                getAmount(),
                getCustomer_name(),
                getCustomer_email(),
                getCustomer_phone(),
                getStatus()
        );
    }
}
