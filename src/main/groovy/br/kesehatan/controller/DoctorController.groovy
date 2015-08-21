package br.kesehatan.controller

import br.kesehatan.entity.Doctor
import br.kesehatan.repository.IDoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController("/doctors")
class DoctorController {

    @Autowired
    IDoctorRepository doctorDao

    @RequestMapping(method = [RequestMethod.GET])
    public List<Doctor> findAll(){
        return doctorDao.findAll()
    }

    @RequestMapping(method = [RequestMethod.POST])
    public Doctor create(@RequestBody @Valid Doctor d){
        return doctorDao.save(d)
    }

}
