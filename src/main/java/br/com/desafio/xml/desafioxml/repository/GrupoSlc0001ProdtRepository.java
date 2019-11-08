package br.com.desafio.xml.desafioxml.repository;

import br.com.desafio.xml.desafioxml.domain.GrupoSlc0001Prodt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSlc0001ProdtRepository extends JpaRepository<GrupoSlc0001Prodt, Long> {
}
