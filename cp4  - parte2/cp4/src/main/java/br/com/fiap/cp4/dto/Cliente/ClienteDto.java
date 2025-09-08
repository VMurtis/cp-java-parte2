package br.com.fiap.cp4.dto.Cliente;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;


public record ClienteDto(
        Long id,

        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "O CPF é obrigatório")
        String cpf,

        @NotBlank(message = "O email é obrigatório")
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone
) {
}
