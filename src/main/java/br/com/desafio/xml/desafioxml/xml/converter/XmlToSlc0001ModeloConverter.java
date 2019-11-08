package br.com.desafio.xml.desafioxml.xml.converter;

import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class XmlToSlc0001ModeloConverter {

    public Slc0001Modelo xmlToSlc0001ModeloConverte(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Slc0001Modelo.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(xml);
        Slc0001Modelo unmarshal = (Slc0001Modelo) unmarshaller.unmarshal(reader);
        reader.close();

        return unmarshal;
    }
}
