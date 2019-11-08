package br.com.desafio.xml.desafioxml.rest;

import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import br.com.desafio.xml.desafioxml.service.Slc0001ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/admin/slc")
public class Slc0001Rest {

    private final Slc0001ModeloService slc0001ModeloService;

    @Autowired
    public Slc0001Rest(Slc0001ModeloService slc0001ModeloService) {
        this.slc0001ModeloService = slc0001ModeloService;
    }

    @GetMapping("/process")
    public ResponseEntity<Slc0001Modelo> processSlc() throws IOException, JAXBException {
        return new ResponseEntity<>(this.slc0001ModeloService.processSlc(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Slc0001Modelo>> findAll() {
        return new ResponseEntity<>(this.slc0001ModeloService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Slc0001Modelo>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.slc0001ModeloService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        slc0001ModeloService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.slc0001ModeloService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
