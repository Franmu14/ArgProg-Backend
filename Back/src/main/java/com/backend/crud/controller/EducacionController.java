package com.backend.crud.controller;

import com.backend.crud.dto.EducacionDto;
import com.backend.crud.dto.Mensaje;
import com.backend.crud.entity.Educacion;
import com.backend.crud.service.EducacionService;
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
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/listaedu")
    public ResponseEntity<List<Educacion>> list() {
        List <Educacion> list = educacionService.list();
        return  new ResponseEntity<List<Educacion>>(list, HttpStatus.OK);
    }

    @GetMapping("/detailedu/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if (!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @GetMapping("/detailtituloedu/{titulo}")
    public ResponseEntity<Educacion> getByTitulo(@PathVariable("titulo") String titulo){
        if (!educacionService.existsByTitulo(titulo))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getByTitulo(titulo).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/createedu")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
        if (StringUtils.isBlank(educacionDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("LA URL de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(educacionDto.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(educacionDto.getFecha()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(educacionDto.getInstitucion()))
            return new ResponseEntity(new Mensaje("La institución es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(educacionDto.getInstitucion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(educacionDto.getUrlimagen(), educacionDto.getTitulo(), educacionDto.getFecha(), educacionDto.getInstitucion(), educacionDto.getDescripcion());
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Se ha creado exitosamente"), HttpStatus.OK);

    }

    @PutMapping("/updateedu/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EducacionDto educacionDto){
        if(StringUtils.isBlank(educacionDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("La URL de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getFecha()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getInstitucion()))
            return new ResponseEntity(new Mensaje("La institución es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setUrlimagen(educacionDto.getUrlimagen());
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setFecha(educacionDto.getFecha());
        educacion.setInstitucion(educacionDto.getInstitucion());
        educacion.setDescripcion(educacionDto.getDescripcion());
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Se ha actualizado existosamente"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteedu/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
    }
}
