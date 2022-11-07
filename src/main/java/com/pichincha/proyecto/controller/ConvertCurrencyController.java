package com.pichincha.proyecto.controller;

import com.pichincha.proyecto.model.ConvertCurrency;
import com.pichincha.proyecto.service.ConvertCurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/convert-currency")
public class ConvertCurrencyController {

    @Autowired
    private ConvertCurrencyServiceImpl convertCurrencyServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<String> convert(@RequestBody ConvertCurrency convertCurrency, Authentication authentication) {
        return convertCurrencyServiceImpl.convert(convertCurrency, authentication);
    }
}
