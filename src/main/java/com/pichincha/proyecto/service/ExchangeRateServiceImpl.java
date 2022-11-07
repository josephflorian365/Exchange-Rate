package com.pichincha.proyecto.service;

import com.pichincha.proyecto.model.ExchangeRate;
import com.pichincha.proyecto.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@Transactional
public class ExchangeRateServiceImpl implements ExchangeRateService{
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public Mono<ExchangeRate> save(ExchangeRate exchangeRate) {
        return Mono.just(exchangeRateRepository.save(exchangeRate));
    }

    @Override
    public Mono<ExchangeRate> findById(Long id) {
        return Mono.just(exchangeRateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public Flux<ExchangeRate> findAll() {
        return Flux.fromIterable(exchangeRateRepository.findAll());
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        exchangeRateRepository.deleteById(id);
        return Mono.empty();
    }

    @Override
    public Mono<ExchangeRate> update(ExchangeRate exchangeRate) {
        return Mono.just(exchangeRateRepository.save(exchangeRate));
    }
}
