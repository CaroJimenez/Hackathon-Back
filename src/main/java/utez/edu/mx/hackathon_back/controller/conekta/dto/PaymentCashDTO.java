package utez.edu.mx.hackathon_back.controller.conekta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.hackathon_back.model.conekta.paymentCash.PaymentCash;
import utez.edu.mx.hackathon_back.model.currency.Currency;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentCashDTO {

    private Long id;
    private Currency currency;
    private String amount;
    private String description;
    private String reference_id;
    private String customer_name;
    private String customer_email;
    private String customer_phone;

    public PaymentCash getPaymentCash(){
        return new PaymentCash(
                getId(),
                getCurrency(),
                getAmount(),
                getDescription(),
                getReference_id(),
                getCustomer_name(),
                getCustomer_email(),
                getCustomer_phone()
        );
    }
}
