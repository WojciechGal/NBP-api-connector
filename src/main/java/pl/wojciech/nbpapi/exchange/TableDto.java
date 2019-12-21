package pl.wojciech.nbpapi.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TableDto {

    private char table;

    @JsonProperty("no")
    private String number;

    @JsonProperty("effectiveDate")
    private LocalDate created;

    private List<RateDto> rates;
}
