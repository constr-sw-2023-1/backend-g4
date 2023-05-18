package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Manufacturer
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

    fun update(newManufacturer: Manufacturer): Manufacturer {
        findById(newManufacturer.id!!)
        return manufacturerRepository.save(newManufacturer)
    }

    fun deleteById(id: UUID) {
        findById(id)
        return manufacturerRepository.deleteById(id)
    }
}
