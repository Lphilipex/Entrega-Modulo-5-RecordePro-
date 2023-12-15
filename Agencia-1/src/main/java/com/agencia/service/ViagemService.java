package com.agencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia.model.Viagem;
import com.agencia.repository.ViagemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ViagemService {
    private final ViagemRepository viagemRepository;

    @Autowired
    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    public void salvarViagem(Viagem viagem) {
        viagemRepository.save(viagem);
    }

    public List<Viagem> listarTodos() {
        return viagemRepository.findAll();
    }

    public Viagem buscarViagemPorId(Long id) {
        Optional<Viagem> optionalViagem = viagemRepository.findById(id);
        return optionalViagem.orElse(null);
    }

    public void atualizarViagem(Viagem viagemAtualizada) {
        viagemRepository.save(viagemAtualizada);
    }
}
