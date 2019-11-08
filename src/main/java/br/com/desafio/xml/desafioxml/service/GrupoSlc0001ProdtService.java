package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.GrupoSlc0001Prodt;
import br.com.desafio.xml.desafioxml.repository.GrupoSlc0001ProdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSlc0001ProdtService {

    private final GrupoSlc0001ProdtRepository grupoSlc0001ProdtRepository;
    private final GrupoSlc0001LiquidProdtService grupoSlc0001LiquidProdtService;

    @Autowired
    public GrupoSlc0001ProdtService(GrupoSlc0001ProdtRepository grupoSlc0001ProdtRepository, GrupoSlc0001LiquidProdtService grupoSlc0001LiquidProdtService) {
        this.grupoSlc0001ProdtRepository = grupoSlc0001ProdtRepository;
        this.grupoSlc0001LiquidProdtService = grupoSlc0001LiquidProdtService;
    }

    public GrupoSlc0001Prodt save(GrupoSlc0001Prodt grupoSlc0001Prodt){
        return grupoSlc0001ProdtRepository.save(grupoSlc0001Prodt);
    }

    public List<GrupoSlc0001Prodt> saveAll(List<GrupoSlc0001Prodt> grupoSlc0001ProdtList){
        List<GrupoSlc0001Prodt> grupoSlc0001ProdtListSaved = grupoSlc0001ProdtRepository.saveAll(grupoSlc0001ProdtList);

        iterateGrupoSlc0001ProdtSavedToGetGrupoSlc001LiquidProdt(grupoSlc0001ProdtListSaved);

        return grupoSlc0001ProdtListSaved;
    }


    private void iterateGrupoSlc0001ProdtSavedToGetGrupoSlc001LiquidProdt(List<GrupoSlc0001Prodt> grupoSlc0001ProdtListSaved) {
        grupoSlc0001ProdtListSaved.forEach(grupoSlc0001Prodt -> {
            iterateGrupoSlc0001LiquidProdtAndSetGrupoSlc0001ProdtForeignkey(grupoSlc0001Prodt);

            grupoSlc0001LiquidProdtService.saveAll(grupoSlc0001Prodt.getGrupoSlc0001LiquidProdt());
        });
    }

    private void iterateGrupoSlc0001LiquidProdtAndSetGrupoSlc0001ProdtForeignkey(GrupoSlc0001Prodt grupoSlc0001Prodt) {
        grupoSlc0001Prodt.getGrupoSlc0001LiquidProdt().forEach(grupoSlc0001LiquidProdt ->
                grupoSlc0001LiquidProdt.setIdGrupoSlc0001Prodt(grupoSlc0001Prodt.getIdGrupoSlc0001Prodt()));
    }
}
