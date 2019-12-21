package pl.wojciech.nbpapi.exchange;

import java.util.List;

public interface ExchangeRate {

    List<RateDto> getDataFromTable();
}
