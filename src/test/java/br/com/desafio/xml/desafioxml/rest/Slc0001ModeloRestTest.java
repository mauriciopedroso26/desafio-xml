package br.com.desafio.xml.desafioxml.rest;

import br.com.desafio.xml.desafioxml.App;
import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import br.com.desafio.xml.desafioxml.utils.HeadersService;
import br.com.desafio.xml.desafioxml.utils.MessageService;
import br.com.desafio.xml.desafioxml.utils.Slc0001ModeloRestTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Slc0001ModeloRestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HeadersService headersService;

    @Autowired
    private Slc0001ModeloRestTestUtils slc0001ModeloRestTestUtils;

    @Autowired
    private MessageService messageService;

    @Before
    public void  init() {
        slc0001ModeloRestTestUtils.deleteAll();
    }

    @Test
    public void testProcess() {
        ResponseEntity<Slc0001Modelo> response =
                this.restTemplate.exchange("/api/admin/slc/process",
                        GET,
                        headersService.getHeaders(),
                        Slc0001Modelo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getIdSlc0001Modelo()).isNotNull();
    }

    @Test
    public void testFindAll() throws IOException, JAXBException {
        slc0001ModeloRestTestUtils.insertModelList();

        ResponseEntity<Slc0001Modelo[]> response =
                this.restTemplate.exchange("/api/admin/slc",
                        GET,
                        headersService.getHeaders(),
                        Slc0001Modelo[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().length).isEqualTo(3);
    }

    @Test
    public void testFindById() throws IOException, JAXBException {
        List<Slc0001Modelo> slc0001ModeloList = slc0001ModeloRestTestUtils.insertModelList();

        ResponseEntity<Slc0001Modelo> response =
                this.restTemplate.exchange("/api/admin/slc/" + slc0001ModeloList.get(0).getIdSlc0001Modelo(),
                        GET,
                        headersService.getHeaders(),
                        Slc0001Modelo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getIdSlc0001Modelo()).isNotNull();
        assertThat(response.getBody().getIdSlc0001Modelo()).isEqualTo(slc0001ModeloList.get(0).getIdSlc0001Modelo());
    }

    @Test
    public void testDeleteById() throws IOException, JAXBException {
        List<Slc0001Modelo> slc0001ModeloList = slc0001ModeloRestTestUtils.insertModelList();

        assertThat(slc0001ModeloRestTestUtils.findAll().size()).isEqualTo(3);

        ResponseEntity<String> response =
                this.restTemplate.exchange("/api/admin/slc/" + slc0001ModeloList.get(0).getIdSlc0001Modelo(),
                        DELETE,
                        headersService.getHeaders(),
                        String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isEqualTo(messageService.getMessage("delete.by.id", String.valueOf(slc0001ModeloList.get(0).getIdSlc0001Modelo())));
        assertThat(slc0001ModeloRestTestUtils.findAll().size()).isEqualTo(2);
    }

    @Test
    public void testDeleteAll() throws IOException, JAXBException {
        slc0001ModeloRestTestUtils.insertModelList();

        assertThat(slc0001ModeloRestTestUtils.findAll().size()).isEqualTo(3);

        ResponseEntity<String> response =
                this.restTemplate.exchange("/api/admin/slc",
                        DELETE,
                        headersService.getHeaders(),
                        String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isEqualTo(messageService.getMessage("delete.all", String.valueOf(1)));
        assertThat(slc0001ModeloRestTestUtils.findAll().size()).isEqualTo(0);
    }

    @Test
    public void testDeleteAllWitoutToDelete() {
        ResponseEntity<String> response =
                this.restTemplate.exchange("/api/admin/slc",
                        DELETE,
                        headersService.getHeaders(),
                        String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(messageService.getMessage("delete.all.not.found", String.valueOf(1)));
        assertThat(slc0001ModeloRestTestUtils.findAll().size()).isEqualTo(0);
    }

    @Test
    public void testDeleteByIdNotFound() {
        ResponseEntity<String> response =
                this.restTemplate.exchange("/api/admin/slc/1",
                        DELETE,
                        headersService.getHeaders(),
                        String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(messageService.getMessage("delete.by.id.not.found", String.valueOf(1)));
        assertThat(slc0001ModeloRestTestUtils.findAll().size()).isEqualTo(0);
    }
}
