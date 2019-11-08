package br.com.desafio.xml.desafioxml.service;

import br.com.desafio.xml.desafioxml.domain.Bcmsg;
import br.com.desafio.xml.desafioxml.domain.Sismsg;
import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import br.com.desafio.xml.desafioxml.file.FileService;
import br.com.desafio.xml.desafioxml.xml.read.XmlReader;
import br.com.desafio.xml.desafioxml.git.GitService;
import br.com.desafio.xml.desafioxml.repository.Slc0001ModeloRepository;
import br.com.desafio.xml.desafioxml.xml.converter.XmlToSlc0001ModeloConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class Slc0001ModeloService {

    @Value("${repo.url}")
    private String repoUrl;

    private final GitService gitService;
    private final FileService fileService;
    private final BcmsgService bcmsgService;
    private final SismsgService sismsgService;
    private final XmlReader xmlReader;
    private final XmlToSlc0001ModeloConverter xmlToSlc0001ModeloConverter;
    private final Slc0001ModeloRepository slc0001ModeloRepository;

    @Autowired
    public Slc0001ModeloService(GitService gitService, FileService fileService, BcmsgService bcmsgService, SismsgService sismsgService, XmlReader xmlReader,
                                XmlToSlc0001ModeloConverter xmlToSlc0001ModeloConverter, Slc0001ModeloRepository slc0001ModeloRepository) {
        this.gitService = gitService;
        this.fileService = fileService;
        this.bcmsgService = bcmsgService;
        this.sismsgService = sismsgService;
        this.xmlReader = xmlReader;
        this.xmlToSlc0001ModeloConverter = xmlToSlc0001ModeloConverter;
        this.slc0001ModeloRepository = slc0001ModeloRepository;
    }

    public Slc0001Modelo processSlc() throws IOException, JAXBException {
        String cloneDirectoryPath = System.getProperty("java.io.tmpdir") + "developer-challenge";
        gitService.cloneRepository(repoUrl, cloneDirectoryPath);
        String xml = xmlReader.readXml(cloneDirectoryPath + "/" + "SLC0001-modelo.xml");
        fileService.deleteDirectory(cloneDirectoryPath);
        Slc0001Modelo slc0001Modelo = xmlToSlc0001ModeloConverter.xmlToSlc0001ModeloConverte(xml);

        Bcmsg bcmsg = bcmsgService.save(slc0001Modelo.getBcmsg());
        slc0001Modelo.setIdBcmsg(bcmsg.getIdBcmsg());

        Sismsg sismsg = sismsgService.save(slc0001Modelo.getSismsg());
        slc0001Modelo.setIdSismsg(sismsg.getIdSismsg());

        return slc0001ModeloRepository.save(slc0001Modelo);
    }

    public List<Slc0001Modelo> findAll() {
        return slc0001ModeloRepository.findAll();
    }

    public Optional<Slc0001Modelo> findById(Long id){
        return slc0001ModeloRepository.findById(id);
    }

    public void deleteAll(){
        slc0001ModeloRepository.deleteAll();
    }

    public void deleteById(Long id){
        slc0001ModeloRepository.deleteById(id);
    }
}
