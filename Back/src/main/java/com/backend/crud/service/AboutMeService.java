package com.backend.crud.service;

import com.backend.crud.entity.AboutMe;
import com.backend.crud.repository.AboutMeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutMeService {

    @Autowired
    AboutMeRepository aboutMeRepository;

    public List<AboutMe> list(){
        return aboutMeRepository.findAll();
    }

    public Optional<AboutMe> getOne(int id) {
        return aboutMeRepository.findById(id);
    }

    public Optional<AboutMe> getByNombre(String nombre) {
        return aboutMeRepository.findByNombre(nombre);
    }

    public void save(AboutMe aboutMe) {
        aboutMeRepository.save(aboutMe);
    }

    public void delete(int id) {
        aboutMeRepository.deleteById(id);
    }

    public boolean existsById (int id) {
        return aboutMeRepository.existsById(id);
    }

    public boolean existsByNombre (String nombre) {
        return aboutMeRepository.existsByNombre(nombre);
    }
}
