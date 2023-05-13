package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.entities.Manufacturer
import br.edu.pucrs.resources.exceptions.ResourceNotFoundException
import br.edu.pucrs.resources.repositories.ManufacturerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ManufacturerService(private val manufacturerRepository: ManufacturerRepository) {

    fun save(manufacturer: Manufacturer): Manufacturer {
        return manufacturerRepository.save(manufacturer)
    }

    fun findAll(): List<Manufacturer> {
        return manufacturerRepository.findAll()
    }

    fun findById(id: UUID): Manufacturer {
        return manufacturerRepository.findById(id).orElseThrow { ResourceNotFoundException("Manufacturer not found") }
    }

    fun update(id: UUID, newManufacturer: Manufacturer): Manufacturer {
        val manufacturerAlreadyExist = findById(id)

        newManufacturer.name = newManufacturer.name

        return manufacturerRepository.save(newManufacturer)
    }
}
