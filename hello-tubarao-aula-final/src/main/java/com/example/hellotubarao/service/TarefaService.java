package com.example.hellotubarao.service;

import com.example.hellotubarao.controller.dto.TarefaRequestDto;
import com.example.hellotubarao.entity.Tarefa;
import com.example.hellotubarao.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(TarefaRequestDto requestDto){
        Tarefa entity = new Tarefa();
        entity.setTitulo(requestDto.titulo());
        entity.setTexto(requestDto.texto());

        return tarefaRepository.save(entity);
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

}
