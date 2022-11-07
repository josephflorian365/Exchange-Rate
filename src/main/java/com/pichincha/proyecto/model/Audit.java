package com.pichincha.proyecto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="audit")
public class Audit implements Serializable {

    private static final long serialVersionUID = 6031430357957703812L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String rol;
    private Long exchangeRate;
    private LocalDateTime date;
}
