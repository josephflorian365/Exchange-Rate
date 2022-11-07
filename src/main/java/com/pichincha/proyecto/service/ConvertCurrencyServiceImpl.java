package com.pichincha.proyecto.service;

import com.pichincha.proyecto.model.ConvertCurrency;
import com.pichincha.proyecto.model.ExchangeRate;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class ConvertCurrencyServiceImpl {

    @Autowired
    private ExchangeRateServiceImpl exchangeRateServiceImpl;

    public Mono<String> convert (ConvertCurrency convertCurrency) {
        Long id = convertCurrency.getExchangeRate();
        Mono<ExchangeRate> exchangeRate = getExchangeRate(id);
        Double amountInitial = convertCurrency.getAmount();
        Double amountExchangeRate = exchangeRate.block().getAmount();
        String currencyExchangeRate = exchangeRate.block().getCurrency();
        String originCurrencySymbol = exchangeRate.block().getOrigin();
        String targetCurrencySymbol = exchangeRate.block().getTarget();
        Double response = operateConversion(amountInitial, amountExchangeRate);
        return Mono.just("El monto equilante de " + currencyExchangeRate + " es: "
                + originCurrencySymbol + " " + amountInitial + " = " + targetCurrencySymbol + " " + response);
    }

    public Mono<ExchangeRate> getExchangeRate(Long id) {
        Mono<ExchangeRate> exchangeRate = exchangeRateServiceImpl.findById(id);
        return exchangeRate;
    }

    public Double operateConversion(Double amount, Double exchangeRateAmount){
        Double result = amount * exchangeRateAmount;
        return  result;
    }
}
