package br.kesehatan.entity

import org.hibernate.validator.constraints.NotBlank

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Doctor {

    @Id
    @GeneratedValue
    Long id

    @NotBlank
    String name

    @NotBlank
    String street

    String streetNo

}
