package com.backend.crud.repository;

import com.backend.crud.entity.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//...extends JpaRepository<classname, typeofid>...
//option: ...extends CrudRepository
@Repository
public interface AboutMeRepository extends JpaRepository<AboutMe, Integer> {

    Optional<AboutMe> findByNombre (String nombre);
    boolean existsByNombre(String nombre);
}
