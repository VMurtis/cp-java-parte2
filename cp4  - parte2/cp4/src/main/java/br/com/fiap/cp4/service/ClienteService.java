package br.com.fiap.cp4.service;

import br.com.fiap.cp4.dto.Cliente.ClienteDto;
import br.com.fiap.cp4.model.entities.Cliente;
import br.com.fiap.cp4.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public Cliente save(ClienteDto dto) {

        return clienteRepository.save(new Cliente(dto));
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }




    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrada com ID: " + id));
    }


    public Cliente update(Long id, ClienteDto dto) {
        Cliente existente = buscarPorId(id);
        existente.setNome(dto.nome());
        existente.setCpf(dto.cpf());
        existente.setEmail(dto.email());
        existente.setTelefone(dto.telefone());
        return clienteRepository.save(existente);
    }


    // Deletar
    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrada para exclusão com ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

    @Transactional
    public Cliente atualizarClienteParcial(Long id, ClienteDto dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .id(clienteExistente.getId())
                .nome(dto.nome() != null ? dto.nome() : clienteExistente.getNome())
                .cpf(dto.cpf() != null ? dto.cpf() : clienteExistente.getCpf())
                .email(dto.email() != null ? dto.email() : clienteExistente.getEmail())
                .telefone(dto.telefone() != null ? dto.telefone() : clienteExistente.getTelefone())
                .build();

        return clienteRepository.saveAndFlush(clienteAtualizado);
    }


    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com CPF: " + cpf));
    }

}
