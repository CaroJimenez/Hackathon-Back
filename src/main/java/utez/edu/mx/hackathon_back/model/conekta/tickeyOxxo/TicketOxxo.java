package utez.edu.mx.hackathon_back.model.conekta.tickeyOxxo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.hackathon_back.utils.Response;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketOxxo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String barcode_url;
    @Column(nullable = false)
    private Integer expires_at;
    @Column(nullable = false)
    private Integer created_at;
    @Column(nullable = false)
    private String store_name;
    @Column(nullable = false)
    private String reference;

}
