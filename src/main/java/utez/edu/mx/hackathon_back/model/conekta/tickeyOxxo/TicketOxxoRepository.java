package utez.edu.mx.hackathon_back.model.conekta.tickeyOxxo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketOxxoRepository extends JpaRepository<TicketOxxo, Long> {
}
