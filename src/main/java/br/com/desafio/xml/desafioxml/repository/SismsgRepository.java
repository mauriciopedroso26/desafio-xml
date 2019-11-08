package br.com.desafio.xml.desafioxml.repository;

import br.com.desafio.xml.desafioxml.domain.Sismsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SismsgRepository extends JpaRepository<Sismsg, Long> {
}
