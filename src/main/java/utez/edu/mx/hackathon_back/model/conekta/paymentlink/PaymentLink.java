package utez.edu.mx.hackathon_back.model.conekta.paymentlink;

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
public class PaymentLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
