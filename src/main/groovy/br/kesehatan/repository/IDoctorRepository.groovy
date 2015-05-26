package br.kesehatan.repository

import br.kesehatan.entity.Doctor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IDoctorRepository extends CrudRepository<Doctor, Long> {

    Iterable<Doctor> findAll()
    Doctor save(Doctor d)
}
