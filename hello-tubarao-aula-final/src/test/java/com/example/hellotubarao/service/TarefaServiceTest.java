package com.example.hellotubarao.service;

import com.example.hellotubarao.controller.dto.TarefaRequestDto;
import com.example.hellotubarao.entity.Tarefa;
import com.example.hellotubarao.repository.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock // Cria uma versão fake ou mockada do TarefaRespository
          // Todos os métodos de TarefaRepository são subistituidos por mocks
    TarefaRepository tarefaRepository;

    @InjectMocks // Indica que o TarefaService recebe o Mock do TarefaRepository
    TarefaService tarefaService;

    @Test
    void salvarTarefa() {
        // Given - preparação

        TarefaRequestDto requestDto = new TarefaRequestDto("titulo", "texto");
        Tarefa tarefa = new Tarefa(1L, "titulo", "texto");

        // stub, ou seja, item que indica o retorno de um método
        // quando eu executar o "save" retorne o valore de "tarefa"
        when(tarefaRepository.save(any())).thenReturn(tarefa);

        // When - Execução teste
        Tarefa resultado = tarefaService.salvarTarefa(requestDto);

        // Then - então
        assertEquals(tarefa, resultado);

        Assertions.assertNotEquals(null, resultado);
        Assertions.assertTrue(resultado.getId()==1L);

        verify(tarefaRepository, times(1))
                .save(any()); // valida se o when anterior foi executado uma vez
    }

    @Test
    void listarTarefas() {
        // Given - preparação
        Tarefa tarefa = new Tarefa(1L, "titulo", "texto");
        when(tarefaRepository.findAll()).thenReturn(Collections.singletonList(tarefa));

        // When - Execução teste
        List<Tarefa> resultado = tarefaService.listarTarefas();

        // Then - então
        assertEquals(tarefa, resultado.get(0));
        assertNotNull(resultado);
        Assertions.assertTrue(resultado.get(0).getId()==1L);
        verify(tarefaRepository).findAll();
    }
}