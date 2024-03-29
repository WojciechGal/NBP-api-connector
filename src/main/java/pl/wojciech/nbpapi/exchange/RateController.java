package pl.wojciech.nbpapi.exchange;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class RateController {

    private final ExchangeRate exchangeRate;

    @RequestMapping("/")
    @ResponseBody
    public List<RateDto> getConcurencyTable() {
        return exchangeRate.getDataFromTable();
    }
}
