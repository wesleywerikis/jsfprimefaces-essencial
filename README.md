# JSF PrimeFaces Essencial

Projeto criado para estudo dos conceitos fundamentais de **JavaServer Faces (JSF)** com **PrimeFaces**, utilizando **Maven** e **Tomcat**.

## 🎯 Objetivo

Aprender na prática o desenvolvimento de aplicações web com JSF e PrimeFaces, abordando:
- Criação de páginas dinâmicas com XHTML e componentes PrimeFaces;
- Integração com entidades JPA;
- Manipulação de dados com Managed Beans;
- Boas práticas com camadas `model`, `repository` e `view`.

## 🧱 Tecnologias Utilizadas

- **Java 8**
- **JSF 2.2 (GlassFish)**
- **PrimeFaces 6.0**
- **Hibernate Validator / Core**
- **MySQL 6.0.4**
- **Maven**
- **Tomcat**

## ⚙️ Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/com/jsfprimefaces/erp/
 │   │   ├── model/        # Entidades JPA (Empresa, RamoAtividade, TipoEmpresa)
 │   │   └── repository/   # Classes utilitárias e persistência (SchemaGeneration)
 │   └── resources/
 │       └── META-INF/
 │           ├── persistence.xml       # Configuração do JPA (DataBasePU)
 │           └── sql/dados-iniciais.sql # Script de dados de exemplo
 └── webapp/
     └── WEB-INF/
         └── templates e páginas JSF
```

## 🗄️ Banco de Dados

Configuração no arquivo `persistence.xml`:
```xml
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/erpjsfprimefaces" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="" />
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
```

Script inicial: `src/main/resources/META-INF/sql/dados-iniciais.sql`  
Contém registros de exemplo para `RamoAtividade` e `Empresa`.

## ▶️ Execução

1. **Importe** o projeto Maven no Eclipse.
2. Configure o **Tomcat** (versão 9 ou superior).
3. Inicie o servidor e acesse a aplicação no navegador.
4. Verifique o log da console para geração das tabelas e dados.

## 📚 Créditos

Projeto baseado no curso **JSF e PrimeFaces Essencial** da [AlgaWorks](https://www.algaworks.com/).  
Adaptado para estudo e prática individual.
