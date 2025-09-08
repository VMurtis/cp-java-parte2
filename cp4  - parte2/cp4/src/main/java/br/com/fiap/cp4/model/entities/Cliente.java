package br.com.fiap.cp4.model.entities;


import br.com.fiap.cp4.dto.Cliente.ClienteDto;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "TDS_TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TDS_TB_CLIENTE", allocationSize = 1)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cliente")
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome_cliente",nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf_cliente", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "email_cliente",length = 100)
    private String email;

    @Column(name = "telefone_cliente",length = 20)
    private String telefone;

    public Cliente(ClienteDto dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.telefone = dto.telefone();
    }


}
