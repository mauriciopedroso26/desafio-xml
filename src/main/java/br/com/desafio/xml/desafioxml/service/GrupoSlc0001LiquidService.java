package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.GrupoSlc0001Liquid;
import br.com.desafio.xml.desafioxml.repository.GrupoSlc0001LiquidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSlc0001LiquidService {

    private final GrupoSlc0001LiquidRepository grupoSlc0001LiquidRepository;
    private final GrupoSlc0001ProdtService grupoSlc0001ProdtService;

    @Autowired
    public GrupoSlc0001LiquidService(GrupoSlc0001LiquidRepository grupoSlc0001LiquidRepository, GrupoSlc0001ProdtService grupoSlc0001ProdtService) {
        this.grupoSlc0001LiquidRepository = grupoSlc0001LiquidRepository;
        this.grupoSlc0001ProdtService = grupoSlc0001ProdtService;
    }

    public GrupoSlc0001Liquid save(GrupoSlc0001Liquid grupoSlc0001Liquid){
        return grupoSlc0001LiquidRepository.save(grupoSlc0001Liquid);
    }

    public List<GrupoSlc0001Liquid> saveAll(List<GrupoSlc0001Liquid> grupoSlc0001LiquidList){
        List<GrupoSlc0001Liquid> grupoSlc0001LiquidListSaved = grupoSlc0001LiquidRepository.saveAll(grupoSlc0001LiquidList);

        iterateGrupoSlc0001LiquidSavedToGetGrupoSlc001Prodt(grupoSlc0001LiquidListSaved);

        return grupoSlc0001LiquidListSaved;
    }

    private void iterateGrupoSlc0001LiquidSavedToGetGrupoSlc001Prodt(List<GrupoSlc0001Liquid> grupoSlc0001LiquidListSaved) {
        grupoSlc0001LiquidListSaved.forEach(grupoSlc0001Liquid -> {
            iterateGrupoSlc0001ProdtAndSetGrupoSlc0001LiquidForeignkey(grupoSlc0001Liquid);

            grupoSlc0001ProdtService.saveAll(grupoSlc0001Liquid.getGrupoSlc0001Prodt());
        });
    }

    private void iterateGrupoSlc0001ProdtAndSetGrupoSlc0001LiquidForeignkey(GrupoSlc0001Liquid grupoSlc0001Liquid) {
        grupoSlc0001Liquid.getGrupoSlc0001Prodt().forEach(grupoSlc0001Prodt ->
                grupoSlc0001Prodt.setIdGrupoSlc0001Liquid(grupoSlc0001Liquid.getIdGrupoSlc0001Liquid()));
    }
}
