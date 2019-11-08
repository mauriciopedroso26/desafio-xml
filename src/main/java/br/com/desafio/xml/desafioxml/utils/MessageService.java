package br.com.desafio.xml.desafioxml.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code, String...args){
        final Locale currentLocale = LocaleContextHolder.getLocale();

        String message = messageSource.getMessage(code, args, currentLocale);

        message = message.replaceAll("\"", "");

        return message;
    }
}