package utez.edu.mx.hackathon_back.service.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.hackathon_back.model.currency.Currency;
import utez.edu.mx.hackathon_back.model.currency.CurrencyRepository;
import utez.edu.mx.hackathon_back.utils.Response;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CurrencyService {
    @Autowired
    private CurrencyRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Currency>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = SQLException.class)
    public Response<Currency> insert(Currency currency){
        return new Response<>(
                this.repository.save(currency),
                false,
                200,
                "OK"
        );
    }
}
