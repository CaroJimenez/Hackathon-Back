package utez.edu.mx.hackathon_back.controller.currency;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.hackathon_back.controller.currency.dto.CurrencyDTO;
import utez.edu.mx.hackathon_back.model.currency.Currency;
import utez.edu.mx.hackathon_back.service.currency.CurrencyService;
import utez.edu.mx.hackathon_back.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/currency")
@CrossOrigin(value = {"*"})
public class CurrencyController {
    @Autowired
    private CurrencyService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Currency>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Currency>> insert(@RequestBody CurrencyDTO currencyDTO){
        return new ResponseEntity<>(
                this.service.insert(currencyDTO.getCurrency()),
                HttpStatus.OK
        );
    }
}
