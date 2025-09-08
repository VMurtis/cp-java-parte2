package br.com.fiap.cp4.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;

public record FornecedorDto(
        Long id,

        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "O CNPJ é obrigatório")
        String cnpj,
        @NotBlank(message = "O email é obrigatório")
        String email,
        @NotBlank(message = "O telefone é obrigatório")
        String telefone
) {

}
