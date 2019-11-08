package br.com.desafio.xml.desafioxml.file;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    public void deleteDirectory(String path) throws IOException {
        File dirToDelete = new File (path);
        FileUtils.deleteDirectory(dirToDelete);
    }
}
