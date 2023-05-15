package com.backend.crud.service;

import com.backend.crud.entity.Experiencia;
import com.backend.crud.repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return experienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByTitulo(String titulo) {
        return experienciaRepository.findByTitulo(titulo);
    }

    public void save(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    public void delete(int id) {
        experienciaRepository.deleteById(id);
    }

    public boolean existsById (int id) {
        return experienciaRepository.existsById(id);
    }

    public boolean existsByTitulo (String titulo) {
        return experienciaRepository.existsByTitulo(titulo);
    }
}
