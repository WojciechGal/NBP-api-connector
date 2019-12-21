package pl.wojciech.nbpapi.exchange;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RateDto {

    private String currency;
    private String code;
    private BigDecimal mid;
}
