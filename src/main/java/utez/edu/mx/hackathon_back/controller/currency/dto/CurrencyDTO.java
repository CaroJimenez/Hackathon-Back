package utez.edu.mx.hackathon_back.controller.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.hackathon_back.model.currency.Currency;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrencyDTO {
    private Long id;
    private String name;
    private Boolean status;

    public Currency getCurrency(){
        return new Currency(
                getId(),
                getName(),
                getStatus()
        );
    }
}
