package com.pichincha.proyecto.service;

import com.pichincha.proyecto.model.Audit;
import com.pichincha.proyecto.model.ExchangeRate;
import com.pichincha.proyecto.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuditServiceImpl implements AuditService{

    @Autowired
    private AuditRepository auditRepository;

    @Override
    public Mono<Audit> save(Audit audit) {
        return Mono.just(auditRepository.save(audit));
    }

    @Override
    public Mono<Audit> findById(Long id) {
        return Mono.just(auditRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public Flux<Audit> findAll() {
        return Flux.fromIterable(auditRepository.findAll());
    }
}
