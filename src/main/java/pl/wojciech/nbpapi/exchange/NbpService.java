package pl.wojciech.nbpapi.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NbpService implements ExchangeRate {

    private static final String NBP_API_TABLE = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";

    @Override
    public List<RateDto> getDataFromTable() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TableDto[]> forEntity = restTemplate.getForEntity(NBP_API_TABLE, TableDto[].class);

        TableDto[] body = forEntity.getBody();

        Arrays.stream(body).map(TableDto::getRates)
                .flatMap(b -> b.stream())
                .forEach(r -> log.info("rate: {}", r));

        List<RateDto> rates = Arrays.stream(body).map(TableDto::getRates)
                .flatMap(b -> b.stream())
                .collect(Collectors.toList());

        return rates;
    }
}
