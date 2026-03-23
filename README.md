# ⚽ Convocation SOAP WebService

Sistema de convocação de jogadores utilizando **SOAP (JAX-WS)** com persistência em **PostgreSQL** e controle de banco via **Flyway (migrations)**.

---

# 🎯 Objetivo

Desenvolver um WebService SOAP sem uso de frameworks como Spring, aplicando:

* JAX-WS (SOAP)
* JDBC
* Flyway (migrations)
* Docker

---

# 🧱 Arquitetura

```id="arch-real"
src/main/java/br/com/fiap/soap
│
├── model
├── repository
├── service
├── publisher
├── config
```

---

# ⚙️ Tecnologias

* Java 21
* JAX-WS
* JDBC
* PostgreSQL
* Docker
* Flyway

---

# 🐳 Subindo o banco

```bash id="cmd-docker"
docker-compose up -d
```

---

# 🗄️ Migrations (Flyway)

Localização:

```id="cmd-migration"
src/main/resources/db/migration
```

Arquivos:

* `V1__create_table_players.sql`
* `V2__create_table_convocations.sql`

As tabelas são criadas automaticamente ao iniciar a aplicação.

---

# 🚀 Executando o projeto

Execute:

```id="cmd-run"
ServicePublisher.java
```

O sistema irá:

✔ executar migrations automaticamente
✔ criar tabelas
✔ subir o serviço SOAP

---

# 🌐 Endpoint SOAP

```id="cmd-url"
http://localhost:8080/convocation?wsdl
```

---

# 🔌 Operações disponíveis

| Método           | Descrição         |
| ---------------- | ----------------- |
| createPlayer     | Cria jogador      |
| listPlayers      | Lista jogadores   |
| callPlayer       | Convoca jogador   |
| listConvocations | Lista convocações |

---

# 🧪 Testando via curl

## Criar jogador

```bash id="curl-real-1"
curl --request POST \
  --url http://localhost:8080/convocation \
  --header 'Content-Type: text/xml;charset=UTF-8' \
  --data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.fiap.com.br/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:createPlayer>
         <name>Neymar</name>
         <position>Forward</position>
      </ser:createPlayer>
   </soapenv:Body>
</soapenv:Envelope>'
```

---

## Listar jogadores

```bash id="curl-real-2"
curl --request POST \
  --url http://localhost:8080/convocation \
  --header 'Content-Type: text/xml;charset=UTF-8' \
  --data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.fiap.com.br/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:listPlayers/>
   </soapenv:Body>
</soapenv:Envelope>'
```

---

## Convocar jogador

```bash id="curl-real-3"
curl --request POST \
  --url http://localhost:8080/convocation \
  --header 'Content-Type: text/xml;charset=UTF-8' \
  --data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.fiap.com.br/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:callPlayer>
         <playerId>1</playerId>
         <requestedBy>Neymar</requestedBy>
      </ser:callPlayer>
   </soapenv:Body>
</soapenv:Envelope>'
```

---

## Listar convocações

```bash id="curl-real-4"
curl -X POST http://localhost:8080/convocation \
-H "Content-Type: text/xml;charset=UTF-8" \
-d '
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <listConvocations/>
   </soapenv:Body>
</soapenv:Envelope>'
```

---

# 🔁 Fluxo

```id="flow-real"
Client
 ↓
SOAP Request
 ↓
WebService (JAX-WS)
 ↓
Service
 ↓
Repository (JDBC)
 ↓
PostgreSQL (Docker)
 ↓
SOAP Response
```

---

# 🧠 Decisões técnicas

* SOAP puro com JAX-WS
* Injeção de dependência manual
* Persistência com JDBC
* Migrations com Flyway

---

# 🚀 Melhorias futuras

* Validação de dados
* Retorno de IDs
* Filtro por usuário
* Tratamento de exceções

---

# 👨‍💻 Autores

* Lorran dos Santos - RM: 558982
* Fabiano Zague - RM: 555524
* Maria Clara - RM: 557478
* Pedro Certo - RM: 556268
* Vinicius Matareli - RM: 555200