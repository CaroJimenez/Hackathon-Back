package utez.edu.mx.hackathon_back.model.conekta.paymentCash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(nullable = false)
    private String amount;
    @Column(nullable = false)
    private String customer_name;
    @Column(nullable = false)
    private String customer_email;
    @Column(nullable = false)
    private String customer_phone;
    @Column(nullable = false)
    private Integer status; //0 pending - 1 done - 2 cancelled
}
