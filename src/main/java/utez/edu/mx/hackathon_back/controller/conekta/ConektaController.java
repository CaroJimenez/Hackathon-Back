package utez.edu.mx.hackathon_back.controller.conekta;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.hackathon_back.controller.conekta.dto.PaymentCashDTO;
import utez.edu.mx.hackathon_back.model.conekta.paymentCash.PaymentCash;
import utez.edu.mx.hackathon_back.model.conekta.tickeyOxxo.TicketOxxo;
import utez.edu.mx.hackathon_back.service.conekta.paymentCash.PaymentCashService;
import utez.edu.mx.hackathon_back.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/conekta")
@CrossOrigin(value = {"*"})
public class ConektaController {
    @Autowired
    private PaymentCashService service;

    @PostMapping("/")
    public ResponseEntity<Response<TicketOxxo>> createOrderCash(@RequestBody PaymentCashDTO paymentCashDTO){
        return new ResponseEntity<>(
                this.service.createOxxoPayment(paymentCashDTO.getPaymentCash()),
                HttpStatus.OK
        );
    }
    @GetMapping("/")
    public ResponseEntity<Response<List<PaymentCash>>> getAllPaymentsCash(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
}
