package com.backend.crud.service;

import com.backend.crud.entity.Educacion;
import com.backend.crud.repository.EducacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    public List<Educacion> list(){
        return educacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return educacionRepository.findById(id);
    }

    public Optional<Educacion> getByTitulo(String titulo) {
        return educacionRepository.findByTitulo(titulo);
    }

    public void save(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    public void delete(int id) {
        educacionRepository.deleteById(id);
    }

    public boolean existsById (int id) {
        return educacionRepository.existsById(id);
    }

    public boolean existsByTitulo (String titulo) {
        return educacionRepository.existsByTitulo(titulo);
    }
}
