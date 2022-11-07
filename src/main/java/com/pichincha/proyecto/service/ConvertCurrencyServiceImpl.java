package com.pichincha.proyecto.service;

import com.pichincha.proyecto.model.Audit;
import com.pichincha.proyecto.model.ConvertCurrency;
import com.pichincha.proyecto.model.ExchangeRate;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;


@Service
public class ConvertCurrencyServiceImpl {

    @Autowired
    private ExchangeRateServiceImpl exchangeRateServiceImpl;

    @Autowired
    private AuditServiceImpl auditServiceImpl;

    public Mono<String> convert (ConvertCurrency convertCurrency, Authentication authentication) {
        Long id = convertCurrency.getExchangeRate();
        Mono<ExchangeRate> exchangeRate = getExchangeRate(id);
        Double startingAmount = convertCurrency.getAmount();
        Double amountExchangeRate = exchangeRate.block().getAmount();
        String currencyExchangeRate = exchangeRate.block().getCurrency();
        String originCurrencySymbol = exchangeRate.block().getOrigin();
        String targetCurrencySymbol = exchangeRate.block().getTarget();
        Double finalAmount = operateConversion(startingAmount, amountExchangeRate);
        Audit audit = new Audit();
        LocalDateTime dateTime = LocalDateTime.now();
        audit.setDate(dateTime);
        audit.setExchangeRate(exchangeRate.block().getId());
        audit.setUserName(authentication.getName());
        String getRol = null;
        for (GrantedAuthority rol : authentication.getAuthorities()){
            getRol = rol.getAuthority().toString();
        }
        audit.setRol(getRol);
        auditServiceImpl.save(audit);
        return Mono.just("El monto equilante de " + currencyExchangeRate + " es: "
                + originCurrencySymbol + " " + startingAmount + " = " + targetCurrencySymbol + " " + finalAmount);
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
