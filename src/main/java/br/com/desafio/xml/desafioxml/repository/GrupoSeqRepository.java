package br.com.desafio.xml.desafioxml.repository;

import br.com.desafio.xml.desafioxml.domain.GrupoSeq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSeqRepository extends JpaRepository<GrupoSeq, Long> {
}
