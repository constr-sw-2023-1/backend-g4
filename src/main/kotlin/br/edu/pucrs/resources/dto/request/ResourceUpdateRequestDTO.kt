package br.edu.pucrs.resources.dto.request

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.domain.Type
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ResourceUpdateRequestDTO(
    @field:NotBlank(message = "Descrição não pode ser nulo.")
    var description: String?,
    @field:NotNull(message = "Tipo não pode ser nulo.")
    var type: Type?,
    @field:NotNull(message = "Fabricante não pode ser nulo.")
    var manufacturer: Manufacturer?,
    @field:NotNull(message = "Configurações não pode ser nulo.")
    var configurations: ArrayList<ConfigurationRequestDTO>?
)