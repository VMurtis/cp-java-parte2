package br.com.fiap.cp4.controller;

import br.com.fiap.cp4.dto.fornecedor.FornecedorDto;
import br.com.fiap.cp4.model.entities.Fornecedor;
import br.com.fiap.cp4.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }


    @GetMapping
    public String listar(Model model) {
        model.addAttribute("fornecedores", fornecedorService.getAll());
        return "fornecedor_listar";
    }


    @GetMapping("/adicionar")
    public String adicionarForm(Model model) {
        model.addAttribute("fornecedorDto", new FornecedorDto(null, "", "", "", ""));
        return "fornecedor_adicionar";
    }


    @PostMapping("/salvar")
    public String salvar(@ModelAttribute FornecedorDto dto) {
        fornecedorService.save(dto);
        return "redirect:/fornecedores";
    }


    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Fornecedor f = fornecedorService.buscarPorId(id);
        FornecedorDto dto = new FornecedorDto(f.getId(), f.getNome(), f.getCnpj(), f.getEmail(), f.getTelefone());
        model.addAttribute("fornecedorDto", dto);
        return "fornecedor_editar";
    }


    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute FornecedorDto dto) {
        fornecedorService.update(id, dto);
        return "redirect:/fornecedores";
    }


    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
        return "redirect:/fornecedores";
    }
}