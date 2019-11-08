package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.GrupoSlc0001Liquid;
import br.com.desafio.xml.desafioxml.domain.Slc0001;
import br.com.desafio.xml.desafioxml.repository.Slc0001Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Slc0001Service {

    private final Slc0001Repository slc0001Repository;
    private final GrupoSlc0001LiquidService grupoSlc0001LiquidService;

    @Autowired
    public Slc0001Service(Slc0001Repository slc0001Repository, GrupoSlc0001LiquidService grupoSlc0001LiquidService) {
        this.slc0001Repository = slc0001Repository;
        this.grupoSlc0001LiquidService = grupoSlc0001LiquidService;
    }

    public Slc0001 save(Slc0001 slc0001){
        Slc0001 slc0001Saved = slc0001Repository.save(slc0001);

        iterateGrupoSlc0001LiquidAndSetSlc0001Foreignkey(slc0001.getGrupoSlc0001Liquid(), slc0001Saved);
        grupoSlc0001LiquidService.saveAll(slc0001.getGrupoSlc0001Liquid());

        return slc0001Saved;
    }

    private void iterateGrupoSlc0001LiquidAndSetSlc0001Foreignkey(List<GrupoSlc0001Liquid> grupoSlc0001LiquidList,
                                                                  Slc0001 slc0001Saved) {
        grupoSlc0001LiquidList.forEach(grupoSlc0001Liquid ->
                grupoSlc0001Liquid.setIdSlc0001(slc0001Saved.getIdSlc0001()));
    }
}
