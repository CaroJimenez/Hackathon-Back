package utez.edu.mx.hackathon_back.model.conekta.paymentCash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCashRepository extends JpaRepository<PaymentCash, Long> {
}
