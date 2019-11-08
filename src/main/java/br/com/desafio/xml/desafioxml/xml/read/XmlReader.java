package br.com.desafio.xml.desafioxml.xml.read;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class XmlReader {

    public String readXml(String path) throws IOException {
        String line="",str="";

        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null)
        {
            str+=line;
        }

        br.close();
        return str;
    }
}
