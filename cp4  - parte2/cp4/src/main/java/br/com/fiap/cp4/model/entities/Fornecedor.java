package br.com.fiap.cp4.model.entities;

import br.com.fiap.cp4.dto.fornecedor.FornecedorDto;
import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TDS_TB_FORNECEDOR")
@SequenceGenerator(name = "fornecedor", sequenceName = "SQ_TDS_TB_FORNECEDOR", allocationSize = 1)
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "fornecedor")
    private Long id;

    @Column(name = "nome_fornecedor", nullable = false, length = 100)
    private String nome;

    @Column(name = "cnpj_fornecedor",nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "email_fornecedor",length = 100)
    private String email;

    @Column(name = "telefone_fornecedor",length = 20)
    private String telefone;

    public Fornecedor(FornecedorDto dto) {
        this.nome = dto.nome();
        this.cnpj = dto.cnpj();
        this.email = dto.email();
        this.telefone = dto.telefone();
    }

}