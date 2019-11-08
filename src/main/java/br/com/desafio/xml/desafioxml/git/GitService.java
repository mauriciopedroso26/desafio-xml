package br.com.desafio.xml.desafioxml.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Service
public class GitService {

    public void cloneRepository(String repoUrl, String cloneDirectoryPath) {
        try {
            Git clone = Git.cloneRepository()
                    .setURI(repoUrl)
                    .setDirectory(Paths.get(cloneDirectoryPath).toFile())
                    .call();

            clone.getRepository().close();

        } catch (GitAPIException e) {
            System.out.println("Exception occurred while cloning repository");
            e.printStackTrace();
        }

    }
}
