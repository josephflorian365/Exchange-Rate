package com.pichincha.proyecto.controller;

import com.pichincha.proyecto.model.ExchangeRate;
import com.pichincha.proyecto.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/exchange")
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ExchangeRate> save(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.save(exchangeRate);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ExchangeRate> update(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.update(exchangeRate);
    }

    @GetMapping("/{id}")
    public Mono<ExchangeRate> findById(@PathVariable("id") Long id) {
        return exchangeRateService.findById(id);
    }

    @GetMapping
    public Flux<ExchangeRate> findAll() {
        return exchangeRateService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable("id") Long id) {
        return exchangeRateService.deleteById(id);
    }
}
