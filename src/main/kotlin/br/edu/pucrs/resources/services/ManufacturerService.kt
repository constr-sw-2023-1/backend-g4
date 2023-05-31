package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.dto.request.ManufacturerUpdateDTO
import br.edu.pucrs.resources.dto.response.ManufacturerResponseDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO
import br.edu.pucrs.resources.exceptions.NotFoundException
import br.edu.pucrs.resources.exceptions.RequestValidationException
import br.edu.pucrs.resources.mapper.ManufacturerMapper
import br.edu.pucrs.resources.mapper.ResourceMapper
import br.edu.pucrs.resources.repositories.ManufacturerRepository
import br.edu.pucrs.resources.repositories.ManufacturerRepositoryImpl
import org.springframework.stereotype.Service
import java.util.*

@Service
class ManufacturerService(private val manufacturerRepository: ManufacturerRepository, private val manufacturerRepositoryImpl: ManufacturerRepositoryImpl) {

    fun save(manufacturer: Manufacturer): Manufacturer {
        return manufacturerRepository.save(manufacturer)
    }

    fun findAllByComplexQuery(params: Map<String, String>): List<ManufacturerResponseDTO> {
        return manufacturerRepositoryImpl.findAllByComplexQuery(params).filter { it.active }.map {
            ManufacturerMapper.toResponse(it)
        }
    }

    fun findById(id: UUID): Manufacturer {
        return manufacturerRepository.findById(id).filter { m -> m.active }.orElseThrow {
            NotFoundException(message = "Manufacturer not found with ID: $id")
        }
    }

    fun update(id: UUID, newManufacturer: ManufacturerUpdateDTO): Manufacturer {
        val manufacturerToUpdate = findById(id)

        if (newManufacturer.name == null) {
            throw RequestValidationException("Name is required")
        }

        manufacturerToUpdate.name = newManufacturer.name

        return manufacturerRepository.save(manufacturerToUpdate)
    }

    fun deleteById(id: UUID) {
        val manufacturer = findById(id)
        manufacturer.active = false
        manufacturerRepository.save(manufacturer)
    }

    fun updatePatch(id: UUID, manufacturer: ManufacturerUpdateDTO): Manufacturer {
        val manufacturerToUpdate = findById(id)

        if (manufacturer.name != null) {
            manufacturerToUpdate.name = manufacturer.name
        }

        return manufacturerRepository.save(manufacturerToUpdate)
    }
}
