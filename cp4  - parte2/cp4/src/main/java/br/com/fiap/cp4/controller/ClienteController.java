package br.com.fiap.cp4.controller;

import br.com.fiap.cp4.dto.Cliente.ClienteDto;
import br.com.fiap.cp4.model.entities.Cliente;
import br.com.fiap.cp4.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.getAll());
        return "cliente_listar";
    }

    // FORM ADICIONAR
    @GetMapping("/adicionar")
    public String adicionarForm(Model model) {
        model.addAttribute("clienteDto", new ClienteDto(null, "", "", "", ""));
        return "cliente_adicionar";
    }

    // SALVAR
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ClienteDto clienteDto) {
        clienteService.save(clienteDto);
        return "redirect:/clientes";
    }

    // FORM EDITAR
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteDto dto = new ClienteDto(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone());
        model.addAttribute("clienteDto", dto);
        return "cliente_editar";
    }

    // ATUALIZAR
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute ClienteDto clienteDto) {
        clienteService.update(id, clienteDto);
        return "redirect:/clientes";
    }

    // DELETAR
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }
}

