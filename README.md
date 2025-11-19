<h1>MsEmail – API de Envio de E-mails</h1>

 ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
 ![Spring](https://img.shields.io/badge/Spring-6DB33F.svg?style=for-the-badge&logo=Spring&logoColor=white)
 [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

 <p>Para desenvolver esse projeto, foi usado Java, Spring Boot, Jakarta Validation e SMTP Gmail para envio de e-mails.</p> 
 <p>O objetivo desta API é enviar e-mails através do servidor SMTP do Gmail e armazenar informações das mensagens enviadas.</p> 
 <h2>Sumário</h2> 
 <ul> <li><a href="#func">Funcionalidades</a></li> 
   <li><a href="#pratic">Práticas adotadas</a></li> 
   <li><a href="#instalacao">Instalação</a></li> 
   <li><a href="#endpoints">API Endpoints</a></li> </ul>

   <h2 id="func">Funcionalidades</h2> 
   <ul> <li>Envio de e-mails usando o servidor SMTP do Gmail.</li> 
     <li>Validação completa dos dados enviados no corpo da requisição.</li> 
     <li>Persistência de cada e-mail enviado, incluindo data e status.</li> 
     <li>Consulta de e-mail enviado pelo ID.</li> 
     <li>Listagem de todos os e-mails enviados.</li> 
     <li>Camadas separadas: controller, service, domain, repository e infra.</li> </ul>

<h2 id="pratic">Metodologias e Práticas Implementadas</h2> 
    <ul> <li>API REST</li> 
      <li>Design Patterns e Princípios SOLID</li> 
      <li>Injeção de Dependências (Spring)</li> 
      <li>Tratamento de erros com Handler</li> 
      <li>Consultas com Spring Data JPA</li> 
      <li>Validação de dados com Jakarta Validation</li> </ul>

<h2 id="instalacao">Instalação</h2> <ol> <li>Clonar o repositório Git:</li>
  
    https://github.com/SEU-USUARIO/msemail.git

<li>Navegar para o diretório do projeto:</li>

    cd msemail

<li>Compilar o projeto com Maven:</li>

    mvn clean install

<li>Executar o projeto:</li>

    java -jar target/msemail.jar

</ol>

<h2 id="endpoints">API Endpoints</h2> 
<p>Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta <a href="https://www.postman.com/">Postman</a>.</p>

POST :8080/emails/sending-email

Request:

        {
          "ownerRef": "Sistema X",
          "emailFrom": "seuemail@gmail.com",
          "emailTo": "destinatario@gmail.com",
          "subject": "Título do e-mail",
          "text": "Conteúdo do e-mail enviado pela API."
        }

Response:

    {
      "id": "f23c1f2a-0f54-4b40-87cf-fd3ac1d9a654",
      "ownerRef": "Sistema X",
      "emailFrom": "seuemail@gmail.com",
      "emailTo": "destinatario@gmail.com",
      "subject": "Título do e-mail",
      "text": "Conteúdo do e-mail enviado pela API.",
      "sendDateEmail": "2024-02-05T12:10:22",
      "statusEmail": "SENT"
    }

  Buscar E-mail por ID

GET :8080/emails/{id}

Exemplo:

    GET :8080/emails/40b4a20e-1e55-4c5e-8cba-e231d2f98441

Listar Todos os E-mails

GET :8080/emails

Resposta:

      [
    {
      "id": "40b4a20e-1e55-4c5e-8cba-e231d2f98441",
      "emailFrom": "seuemail@gmail.com",
      "emailTo": "destinatario@gmail.com",
      "subject": "Olá!",
      "statusEmail": "SENT"
    },
    {
      "id": "9aa3b22c-7b7a-4eec-9e0a-53d997c32f88",
      "emailFrom": "seuemail@gmail.com",
      "emailTo": "outro@gmail.com",
      "subject": "Relatório",
      "statusEmail": "SENT"
    }
  ]
