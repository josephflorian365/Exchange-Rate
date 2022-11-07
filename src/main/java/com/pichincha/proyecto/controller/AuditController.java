package com.pichincha.proyecto.controller;

import com.pichincha.proyecto.model.Audit;
import com.pichincha.proyecto.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping
    public Flux<Audit> findAll() {
        return auditService.findAll();
    }
}
