package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.Bcmsg;
import br.com.desafio.xml.desafioxml.domain.GrupoSeq;
import br.com.desafio.xml.desafioxml.repository.BcmsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BcmsgService {

    private final BcmsgRepository bcmsgRepository;
    private final GrupoSeqService grupoSeqService;

    @Autowired
    public BcmsgService(BcmsgRepository bcmsgRepository, GrupoSeqService grupoSeqService) {
        this.bcmsgRepository = bcmsgRepository;
        this.grupoSeqService = grupoSeqService;
    }

    public Bcmsg save(Bcmsg bcmsg){
        Bcmsg bcmsgSaved = bcmsgRepository.save(bcmsg);
        iterateGrupoSeqAndSetBcmsgForeignkey(bcmsg.getGrupoSeq(), bcmsgSaved);
        grupoSeqService.saveAll(bcmsg.getGrupoSeq());

        return bcmsgSaved;
    }

    private void iterateGrupoSeqAndSetBcmsgForeignkey(List<GrupoSeq> grupoSeqList, Bcmsg bcmsgSaved) {
        grupoSeqList.forEach(grupoSeq -> grupoSeq.setIdBcmsg(bcmsgSaved.getIdBcmsg()));
    }
}
