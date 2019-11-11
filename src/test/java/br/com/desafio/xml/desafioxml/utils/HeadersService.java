package br.com.desafio.xml.desafioxml.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class HeadersService {

    public HttpEntity getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(null, headers);
    }
}
