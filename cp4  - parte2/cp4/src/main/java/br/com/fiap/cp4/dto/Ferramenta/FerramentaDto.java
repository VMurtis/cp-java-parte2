package br.com.fiap.cp4.dto.Ferramenta;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FerramentaDto(
        Long id,
        @NotBlank(message = "O nome não pode estar vazio")
        String nome,
        @NotBlank(message = "O tipo não pode estar vazio")
        String tipo,
        @NotBlank(message = "O tamanho é obrigatório")
        String tamanho,
        @NotNull(message = "O preço é obrigatório")
        double preco
) {


}
