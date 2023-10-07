package utez.edu.mx.hackathon_back.model.conekta.paymentCash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.hackathon_back.model.currency.Currency;

import javax.persistence.*;

@Table()
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentCash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "currency")
    private Currency currency;
    @Column(nullable = false)
    private String amount;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private String reference_id;
    @Column(nullable = false)
    private String customer_name;
    @Column(nullable = false)
    private String customer_email;
    @Column(nullable = false)
    private String customer_phone;


}
