package br.kesehatan.controller

import br.kesehatan.repository.IDoctorRepository
import br.kesehatan.entity.Doctor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DoctorController {

    @Autowired
    IDoctorRepository doctorDao

    @RequestMapping(value = "/doctors", method = [RequestMethod.GET])
    public List<Doctor> findAll(){
        return doctorDao.findAll()
    }

    @RequestMapping(value = "/doctors", method = [RequestMethod.POST])
    public Doctor create(@RequestBody Doctor d){
        return doctorDao.save(d)
    }

}
