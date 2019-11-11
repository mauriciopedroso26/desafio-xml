package br.com.desafio.xml.desafioxml.utils;

import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import br.com.desafio.xml.desafioxml.service.Slc0001ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Slc0001ModeloRestTestUtils {

    private final Slc0001ModeloService slc0001ModeloService;

    @Autowired
    public Slc0001ModeloRestTestUtils(Slc0001ModeloService slc0001ModeloService) {
        this.slc0001ModeloService = slc0001ModeloService;
    }

    public List<Slc0001Modelo> insertModelList() throws IOException, JAXBException {
        List<Slc0001Modelo> slc0001ModeloList = new ArrayList<>();

        slc0001ModeloList.add(slc0001ModeloService.processSlc());
        slc0001ModeloList.add(slc0001ModeloService.processSlc());
        slc0001ModeloList.add(slc0001ModeloService.processSlc());

        return slc0001ModeloList;
    }

    public void deleteAll(){
        slc0001ModeloService.deleteAll();
    }

    public List<Slc0001Modelo> findAll(){
        return slc0001ModeloService.findAll();
    }
}
