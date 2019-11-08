package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.GrupoSeq;
import br.com.desafio.xml.desafioxml.repository.GrupoSeqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoSeqService {

    private final GrupoSeqRepository grupoSeqRepository;

    @Autowired
    public GrupoSeqService(GrupoSeqRepository grupoSeqRepository) {
        this.grupoSeqRepository = grupoSeqRepository;
    }

    public GrupoSeq save(GrupoSeq grupoSeq){
        return grupoSeqRepository.save(grupoSeq);
    }

    public List<GrupoSeq> saveAll(List<GrupoSeq> grupoSeqList){
        return grupoSeqRepository.saveAll(grupoSeqList);
    }
}
