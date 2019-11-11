- O projeto consiste em ler um arquivo XML, coletar cada um dos dados e salvar no banco de dados H2, banco em memória.

- Foi criado testes unitários com Junit para garantir melhor funcionamento do serviço.

O serviço foi disponibilizado em um servidor EC2 da Amazon, mas por motivos de segurança, não é possível acessar o banco de dados remotamente, somento local.

<h3>Tecnologias utilizadas</h3>

- [x] Java 8.
- [x] Spring.
- [x] JPA.
- [x] Rest.
- [x] Maven.

<h3>Url publica do serviço</h3>
 * http://ec2-52-91-19-205.compute-1.amazonaws.com

<h3>Acesso local ao banco em memória H2</h3>

 * http://localhost:8080/h2-console/

Ao acessar o banco preencha com os dados a seguir:
 * Driver Class: org.h2.Driver
 * JDBC URL: jdbc:h2:mem:testdb
 * User Name: sa

<h3>Urls disponibilizadas</h3>

 - As palavras GET e DELETE que estão antes das urls, são os verbos HTTP a serem utilizados antes da chamada de cada url.

 <h4>Para processar o arquivo xml e salvar no banco de dados: </h4>

  - GET: http://ec2-52-91-19-205.compute-1.amazonaws.com:8080/api/admin/slc/process

 <h4>Para buscar todos os registros salvos no banco de dados:</h4>

  - GET: http://ec2-52-91-19-205.compute-1.amazonaws.com:8080/api/admin/slc

 <h4>Para buscar um registro pelo id:</h4>

  - GET: http://ec2-52-91-19-205.compute-1.amazonaws.com:8080/api/admin/slc/1

  - O número 1 após a url, neste caso é o id do registro a ser buscado no banco de dados.

 <h4>Para deletar um registro pelo id:</h4>

  - DELETE: http://ec2-52-91-19-205.compute-1.amazonaws.com:8080/api/admin/slc/1

  - O número 1 após a url, neste caso é o id do registro a ser deletado no banco de dados.

 <h4>Para deletar todos os registros salvos no banco de dados:</h4>

  - DELETE: http://ec2-52-91-19-205.compute-1.amazonaws.com:8080/api/admin/slc