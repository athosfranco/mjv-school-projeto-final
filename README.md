<p align="center">
  <img src="https://i.ibb.co/B2YvGD5/output-onlinepngtools.png" alt="Sublime's custom image"/>
</p>
<h1 align="center">MJV Clinic - Projeto Final da MJV School Java</h1>

## 🐣 Introdução
Neste repositório está armazenado o código-fonte do Projeto Final desenvolvido para a MJV School Java.

O Projeto Final consiste em considerarmos um contexto hipotético (criado pelo próprio aluno) para aplicar o conhecimento adquirido durante a School. 


## 💭 Contexto 
<p align="center">"Somos uma pequena clínica privada localizada no interior de São Paulo e queremos um sistema simples para gerenciar e manipular os cadastros dos nossos pacientes, médicos e consultas realizadas."</p>

## ✅ Objetivo

Desenvolver um sistema simples, mas completo e consistente, que permita que os funcionários da clínica possam CRIAR, CONSULTAR, EDITAR e EXCLUIR registros de pacientes, médicos e consultas.

Esses registros precisam estar salvos em um banco de dados.

## 📦 Desenvolvimento

Inicialmente foi desenvolvido um Diagrama de classes UML para conceber visualmente a estrutura do projeto:

![Diagrama](https://i.ibb.co/brP60Jj/diagrama-UML.png)

Com o Diagrama mapeado, fica mais fácil implementar os relacionamentos entre as entidades do projeto. 

O projeto foi desenvolvido em Java, utilizando Spring Boot framework. Foi utilizado Spring Data JPA  para implementar a camada de persistência dos dados e o banco de dados PostgreSQL.

## 🛠️ Tecnologias & Ferramentas
- Java (Projeto Maven)
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Astah

## 🚀 Como utilizar

A API foi hospedada na plataforma Heroku. A Endpoint base é: https://athos-clinica-medica-api-mjv.herokuapp.com/

A API possui uma documentação disponível no Swagger, acessível no link: https://athos-clinica-medica-api-mjv.herokuapp.com/swagger-ui/index.html#

## Exemplos de JSON para método POST

### Endpoint /pacientes
O método POST adiciona um novo `paciente` no banco de dados.
```
{
  "matriculaPlanoDeSaude": "string",
  "pessoa": {
    "nomeCompleto": "LUIS JOAO DA SILVA",
    "dataNascimento": "1995-08-12",
    "cpf": "string",
    "rg": "string",
    "telefone": "string",
    "email": "string",
    "endereco": {
      "logradouro": "string",
      "numero": 0,
      "bairro": "string",
      "complemento": "string",
      "cep": "string"
    }
  }
}
```

### Endpoint /medicos
O método POST adiciona um novo `medico` no banco de dados. Caso haja conteúdo dentro da array de `especialidades`, também será adicionado uma `especialidade` no banco de dados. 
```
{
  "pessoa": {
    "nomeCompleto": "FERNANDA MACHADO PRADO",
    "dataNascimento": "1990-03-14",
    "cpf": "string",
    "rg": "string",
    "telefone": "string",
    "email": "string",
    "endereco": {
      "logradouro": "string",
      "numero": 0,
      "bairro": "string",
      "complemento": "string",
      "cep": "string"
    }
  },
  "codigoCRM": "string",
  "especialidades": [
    {
      "titulo": "DENTISTA"
    }
  ]
}

```

### Endpoint /consultas
O método POST adiciona uma nova `consulta` no banco de dados. É necessário que já existam cadastros prévios de `paciente` e `medico` no banco.
```{
  "paciente": {
    "id": 2
    },
  "medico": {
    "id": 4
  },
  "motivo": "Dor de cabeça",
  "prescricao": "Paracetamol 250mg",
  "valorConsulta": 67.80
}
```

### Endpoint /especialidades
O método POST adiciona uma nova `especialidade` ao banco de dados.
```
{
  "titulo": "string"
}
```

## ✒️ Desenvolvedor

Athos Franco de Sá Feitosa 
