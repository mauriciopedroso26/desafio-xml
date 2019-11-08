package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.GrupoSlc0001LiquidProdt;
import br.com.desafio.xml.desafioxml.repository.GrupoSlc0001LiquidProdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSlc0001LiquidProdtService {

    private final GrupoSlc0001LiquidProdtRepository grupoSlc0001LiquidProdtRepository;

    @Autowired
    public GrupoSlc0001LiquidProdtService(GrupoSlc0001LiquidProdtRepository grupoSlc0001LiquidProdtRepository) {
        this.grupoSlc0001LiquidProdtRepository = grupoSlc0001LiquidProdtRepository;
    }

    public GrupoSlc0001LiquidProdt save(GrupoSlc0001LiquidProdt grupoSlc0001LiquidProdt) {
        return grupoSlc0001LiquidProdtRepository.save(grupoSlc0001LiquidProdt);
    }

    public List<GrupoSlc0001LiquidProdt> saveAll(List<GrupoSlc0001LiquidProdt> grupoSlc0001LiquidProdtList) {
        return grupoSlc0001LiquidProdtRepository.saveAll(grupoSlc0001LiquidProdtList);
    }
}
