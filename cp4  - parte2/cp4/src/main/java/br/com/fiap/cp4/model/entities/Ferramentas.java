package br.com.fiap.cp4.model.entities;

import br.com.fiap.cp4.dto.Ferramenta.FerramentaDto;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "TDS_TB_FERRAMENTA")
@SequenceGenerator(name = "ferramenta", sequenceName = "SQ_TAB_FERRAMENTA", allocationSize = 1)
public class Ferramentas {

    @Id
    @Column(name = "id_ferramenta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ferramenta")
    private Long id;

    @Column(name = "nome_ferramenta")
    private String nome;

    @Column(name = "tipo_ferramenta")
    private String tipo;

    @Column(name = "tamanho_ferramenta")
    private String tamanho;

    @Column(name = "preco_ferramenta")
    private double preco;



    public Ferramentas(FerramentaDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.tipo = dto.tipo();
        this.tamanho = dto.tamanho();
        this.preco = dto.preco();
    }



}
