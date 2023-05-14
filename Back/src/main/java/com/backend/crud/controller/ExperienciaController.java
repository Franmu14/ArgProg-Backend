package com.backend.crud.controller;

import com.backend.crud.dto.ExperienciaDto;
import com.backend.crud.dto.Mensaje;
import com.backend.crud.entity.Experiencia;
import com.backend.crud.service.ExperienciaService;
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
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/listaexp")
    public ResponseEntity<List<Experiencia>> list() {
        List <Experiencia> list = experienciaService.list();
        return  new ResponseEntity<List<Experiencia>>(list, HttpStatus.OK);
    }

    @GetMapping("/detailexp/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if (!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @GetMapping("/detailtituloexp/{titulo}")
    public ResponseEntity<Experiencia> getByTitulo(@PathVariable("titulo") String titulo){
        if (!experienciaService.existsByTitulo(titulo))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getByTitulo(titulo).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

     @PostMapping("/createexp")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto){
         if (StringUtils.isBlank(experienciaDto.getUrlimagen()))
             return new ResponseEntity(new Mensaje("La URL de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(experienciaDto.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
         if (StringUtils.isBlank(experienciaDto.getFecha()))
             return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(experienciaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = new Experiencia(experienciaDto.getUrlimagen(), experienciaDto.getTitulo(), experienciaDto.getFecha(), experienciaDto.getDescripcion());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Se ha creado exitosamente"), HttpStatus.OK);

    }

    @PutMapping("/updateexp/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ExperienciaDto experienciaDto){
        if(StringUtils.isBlank(experienciaDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("La URL de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getTitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getFecha()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienciaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setUrlimagen(experienciaDto.getUrlimagen());
        experiencia.setTitulo(experienciaDto.getTitulo());
        experiencia.setFecha(experienciaDto.getFecha());
        experiencia.setDescripcion(experienciaDto.getDescripcion());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Se ha actualizado existosamente"), HttpStatus.OK);
    }

     @DeleteMapping("/deleteexp/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
    }
}
