package com.backend.crud.controller;

import com.backend.crud.dto.ProyectosDto;
import com.backend.crud.dto.Mensaje;
import com.backend.crud.entity.Proyectos;
import com.backend.crud.service.ProyectosService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aboutme")
//si lo hago con firebase
//@CrossOrigin(origins = "")
//conexión con Angular
@CrossOrigin (origins = "http://localhost:4200")
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/listapro")
    public ResponseEntity<List<Proyectos>> list() {
        List <Proyectos> list = proyectosService.list();
        return  new ResponseEntity<List<Proyectos>>(list, HttpStatus.OK);
    }

    @GetMapping("/detailpro/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if (!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @GetMapping("/detailtitulopro/{nombre}")
    public ResponseEntity<Proyectos> getByNombre(@PathVariable("Nombre") String nombre){
        if (!proyectosService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getByNombre(nombre).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @PostMapping("/createpro")
    public ResponseEntity<?> create(@RequestBody ProyectosDto proyectosDto){
        if (StringUtils.isBlank(proyectosDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("La URL de la imagen es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(proyectosDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(proyectosDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(proyectosDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("La URL de ver proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        Proyectos proyectos = new Proyectos(proyectosDto.getUrlimagen(), proyectosDto.getNombre(), proyectosDto.getDescripcion(), proyectosDto.getUrlproyecto());
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Se ha creado exitosamente"), HttpStatus.OK);

    }

    @PutMapping("/updatepro/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectosDto proyectosDto){
        if(StringUtils.isBlank(proyectosDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("La URL de la imagen es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("El descripcion es obligatoriA"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getUrlproyecto()))
            return new ResponseEntity(new Mensaje("La URL de ver proyecto es obligatoria"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setUrlimagen(proyectosDto.getUrlimagen());
        proyectos.setNombre(proyectosDto.getNombre());
        proyectos.setDescripcion(proyectosDto.getDescripcion());
        proyectos.setUrlproyecto(proyectosDto.getUrlproyecto());
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Se ha actualizado existosamente"), HttpStatus.OK);
    }

    @DeleteMapping("/deletepro/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
    }
}
