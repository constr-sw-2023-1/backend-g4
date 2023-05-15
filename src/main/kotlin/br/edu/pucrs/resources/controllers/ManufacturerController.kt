package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.services.ManufacturerService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
<<<<<<< HEAD
@RequestMapping("/manufacturers")
=======
@RequestMapping("/api/manufacturer")
>>>>>>> 68c771612413638cd237879cfa499dda6513ef40
class ManufacturerController(private val manufacturerService: ManufacturerService) {

    @PostMapping
    fun save(@RequestBody manufacturer: Manufacturer): Manufacturer {
        return manufacturerService.save(manufacturer)
    }

    @GetMapping
    fun findAll(): List<Manufacturer> {
        return manufacturerService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): Manufacturer {
        return manufacturerService.findById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody manufacturer: Manufacturer): Manufacturer {
        return manufacturerService.update(id, manufacturer)
    }

}
