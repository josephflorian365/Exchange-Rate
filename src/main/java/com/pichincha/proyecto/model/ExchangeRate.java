package com.pichincha.proyecto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="exchange_rate")
public class ExchangeRate implements Serializable {

    private static final long serialVersionUID = 6031430357957703812L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private Double amount;
    private String origin;
    private String target;
}
