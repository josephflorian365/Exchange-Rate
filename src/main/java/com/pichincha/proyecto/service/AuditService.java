package com.pichincha.proyecto.service;

import com.pichincha.proyecto.model.Audit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuditService {
    Mono<Audit> save(Audit audit);
    Mono<Audit> findById(Long id);
    Flux<Audit> findAll();
}
