package br.com.fiap.cp4.controller;

import br.com.fiap.cp4.dto.Ferramenta.FerramentaDto;
import br.com.fiap.cp4.model.entities.Ferramentas;
import br.com.fiap.cp4.service.FerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ferramentas")
public class FerramentaController {

    @Autowired
    private FerramentaService ferramentaService;

    public FerramentaController(FerramentaService ferramentaService) {
        this.ferramentaService = ferramentaService;
    }


    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ferramentas", ferramentaService.getAll());
        return "ferramenta_listar";
    }


    @GetMapping("/adicionar")
    public String adicionarForm(Model model) {
        model.addAttribute("ferramentaDto", new FerramentaDto(null, "", "", "", 0));
        return "ferramenta_adicionar";
    }


    @PostMapping("/salvar")
    public String salvar(@ModelAttribute FerramentaDto ferramentaDto) {
        ferramentaService.save(ferramentaDto);
        return "redirect:/ferramentas";
    }


    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Ferramentas f = ferramentaService.buscarPorId(id);
        FerramentaDto dto = new FerramentaDto(f.getId(), f.getNome(), f.getTipo(), f.getTamanho(), f.getPreco());
        model.addAttribute("ferramentaDto", dto);
        return "ferramenta_editar";
    }


    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute FerramentaDto dto) {
        ferramentaService.update(id, dto);
        return "redirect:/ferramentas";
    }


    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        ferramentaService.deletar(id);
        return "redirect:/ferramentas";
    }
}