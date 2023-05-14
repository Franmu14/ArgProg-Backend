package com.backend.crud.controller;

import com.backend.crud.dto.AboutMeDto;
import com.backend.crud.dto.Mensaje;
import com.backend.crud.entity.AboutMe;
import com.backend.crud.service.AboutMeService;
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
public class AboutMeController {

    @Autowired
    AboutMeService aboutMeService;

    @GetMapping("/lista")
    public ResponseEntity<List<AboutMe>> list() {
        List <AboutMe> list = aboutMeService.list();
        return  new ResponseEntity<List<AboutMe>>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AboutMe> getById(@PathVariable("id") int id){
        if (!aboutMeService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        AboutMe aboutMe = aboutMeService.getOne(id).get();
        return new ResponseEntity(aboutMe, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<AboutMe> getByNombre(@PathVariable("nombre") String nombre){
        if (!aboutMeService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        AboutMe aboutMe = aboutMeService.getByNombre(nombre).get();
        return new ResponseEntity(aboutMe, HttpStatus.OK);
    }

     @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AboutMeDto aboutMeDto){
         if(StringUtils.isBlank(aboutMeDto.getNombre()))
             return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
         if(StringUtils.isBlank(aboutMeDto.getOcupacion()))
             return new ResponseEntity(new Mensaje("La ocupación es obligatoria"), HttpStatus.BAD_REQUEST);
         if(StringUtils.isBlank(aboutMeDto.getDescripcion()))
             return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
         if(StringUtils.isBlank(aboutMeDto.getUrlimagen()))
             return new ResponseEntity(new Mensaje("La URL de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        AboutMe aboutMe = new AboutMe(aboutMeDto.getNombre(), aboutMeDto.getOcupacion(), aboutMeDto.getDescripcion(), aboutMeDto.getUrlimagen());
        aboutMeService.save(aboutMe);
        return new ResponseEntity(new Mensaje("Se ha creado exitosamente"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody AboutMeDto aboutMeDto){
        if(StringUtils.isBlank(aboutMeDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(aboutMeDto.getOcupacion()))
            return new ResponseEntity(new Mensaje("La ocupación es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(aboutMeDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(aboutMeDto.getUrlimagen()))
            return new ResponseEntity(new Mensaje("La URL de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);

        AboutMe aboutMe = aboutMeService.getOne(id).get();
        aboutMe.setNombre(aboutMeDto.getNombre());
        aboutMe.setOcupacion(aboutMeDto.getOcupacion());
        aboutMe.setDescripcion(aboutMeDto.getDescripcion());
        aboutMe.setUrlimagen(aboutMeDto.getUrlimagen());
        aboutMeService.save(aboutMe);
        return new ResponseEntity(new Mensaje("Se ha actualizado existosamente"), HttpStatus.OK);
    }

     /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!aboutMeService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        aboutMeService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
    }*/
}
