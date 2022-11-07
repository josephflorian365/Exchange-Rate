package com.pichincha.proyecto.service;

import com.pichincha.proyecto.model.ExchangeRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {
    Mono<ExchangeRate> save(ExchangeRate exchangeRate);
    Mono<ExchangeRate> findById(Long id);
    Flux<ExchangeRate> findAll();
    Mono<Void> deleteById(Long id);
    Mono<ExchangeRate> update(ExchangeRate exchangeRate);
}
