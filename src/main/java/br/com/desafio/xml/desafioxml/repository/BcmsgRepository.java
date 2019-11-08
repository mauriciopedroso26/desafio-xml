package br.com.desafio.xml.desafioxml.repository;

import br.com.desafio.xml.desafioxml.domain.Bcmsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BcmsgRepository extends JpaRepository<Bcmsg, Long> {
}
