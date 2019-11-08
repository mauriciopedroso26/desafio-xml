package br.com.desafio.xml.desafioxml.repository;

import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Slc0001ModeloRepository extends JpaRepository<Slc0001Modelo, Long> {
}
