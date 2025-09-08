package br.com.fiap.cp4.service;



import br.com.fiap.cp4.dto.fornecedor.FornecedorDto;
import br.com.fiap.cp4.model.entities.Fornecedor;
import br.com.fiap.cp4.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }



    public Fornecedor save(FornecedorDto dto) {

        return fornecedorRepository.save(new Fornecedor(dto));
    }

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }




    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrada com ID: " + id));
    }

    public Fornecedor update(Long id, FornecedorDto dto) {
        Fornecedor existente = buscarPorId(id);
        existente.setNome(dto.nome());
        existente.setCnpj(dto.cnpj());
        existente.setEmail(dto.email());
        existente.setTelefone(dto.telefone());
        return fornecedorRepository.save(existente);
    }


    // Deletar
    public void deletar(Long id) {
        if (!fornecedorRepository.existsById(id)) {
            throw new RuntimeException("Ferramenta não encontrada para exclusão com ID: " + id);
        }
        fornecedorRepository.deleteById(id);
    }

    @Transactional
    public Fornecedor atualizarFornecedorParcial(Long id, FornecedorDto dto) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        Fornecedor fornecedorAtualizado = Fornecedor.builder()
                .id(fornecedorExistente.getId())
                .nome(dto.nome() != null ? dto.nome() : fornecedorExistente.getNome())
                .cnpj(dto.cnpj() != null ? dto.cnpj() : fornecedorExistente.getCnpj())
                .email(dto.email() != null ? dto.email() : fornecedorExistente.getEmail())
                .telefone(dto.telefone() != null ? dto.telefone() : fornecedorExistente.getTelefone())
                .build();

        return fornecedorRepository.saveAndFlush(fornecedorAtualizado);
    }

    public Fornecedor buscarPorCnpj(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com CNPJ: " + cnpj));
    }



}
