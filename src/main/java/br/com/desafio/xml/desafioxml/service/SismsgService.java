package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.Sismsg;
import br.com.desafio.xml.desafioxml.domain.Slc0001;
import br.com.desafio.xml.desafioxml.repository.SismsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SismsgService {

    private final SismsgRepository sismsgRepository;
    private final Slc0001Service slc0001Service;

    @Autowired
    public SismsgService(SismsgRepository sismsgRepository, Slc0001Service slc0001Service) {
        this.sismsgRepository = sismsgRepository;
        this.slc0001Service = slc0001Service;
    }

    public Sismsg save(Sismsg sismsg){
        Slc0001 slc0001 = slc0001Service.save(sismsg.getSlc0001());
        sismsg.setIdSlc0001(slc0001.getIdSlc0001());

        return sismsgRepository.save(sismsg);
    }
}
