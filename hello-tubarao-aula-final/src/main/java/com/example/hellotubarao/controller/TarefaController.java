package com.example.hellotubarao.controller;

import com.example.hellotubarao.controller.dto.TarefaRequestDto;
import com.example.hellotubarao.entity.Tarefa;
import com.example.hellotubarao.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public Tarefa adicionarTarefa(TarefaRequestDto request){
        return tarefaService.salvarTarefa(request);
    }

    @GetMapping
    public List<Tarefa> listarTarefas(){
        return tarefaService.listarTarefas();
    }

}
