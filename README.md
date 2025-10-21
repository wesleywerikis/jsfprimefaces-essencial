# 🧩 JSF PrimeFaces Essencial

Projeto criado para **estudo prático dos conceitos fundamentais de JavaServer Faces (JSF)** com **PrimeFaces**, utilizando **Maven**, **CDI (Weld)**, **JPA (Hibernate)** e **MySQL**.  
O objetivo é compreender a arquitetura básica de aplicações web Java EE (Jakarta EE) e exercitar boas práticas de persistência e camadas.

---

## 🎯 Objetivo do Projeto

Aprender o desenvolvimento de aplicações JSF integradas a banco de dados, com foco em:
- Criação de páginas dinâmicas com **XHTML** e componentes **PrimeFaces**;
- **Integração JPA/Hibernate** para persistência de entidades;
- Uso de **CDI (Weld)** para injeção de dependência e escopos;
- Boas práticas em camadas `model`, `repository` e `view`;
- Configuração de **schemas automáticos e dados iniciais** via `persistence.xml`.

---

## 🧱 Tecnologias e Ferramentas

| Camada | Tecnologia / Versão |
|--------|----------------------|
| Linguagem | **Java 8** |
| Framework Web | **JSF 2.2 (GlassFish implementation)** |
| Componentes UI | **PrimeFaces 6.0** |
| Persistência | **JPA / Hibernate Core 5.2.3.Final** |
| Validação | **Hibernate Validator 5.3.0.Final** |
| Injeção de Dependência | **Weld (CDI 2.4.0.Final)** |
| Banco de Dados | **MySQL 8.0.33** |
| Servidor de Aplicação | **Tomcat 9+** |
| Build Tool | **Maven** |

---

## ⚙️ Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/com/jsfprimefaces/erp/
 │   │   ├── model/        
 │   │   │   ├── Empresa.java         # Entidade principal (Empresa)
 │   │   │   ├── RamoAtividade.java   # Entidade auxiliar (Ramos de atividade)
 │   │   │   └── TipoEmpresa.java     # Enum (MEI, LTDA, EIRELI, SA)
 │   │   └── repository/
 │   │       ├── Empresas.java        # CRUD e consultas com JPA
 │   │       ├── RamoAtividades.java  # Consultas com CriteriaBuilder
 │   │       ├── CamadaPersistencia.java # Teste de inserção e listagem
 │   │       └── SchemaGeneration.java   # Teste de geração de schema
 │   └── resources/
 │       └── META-INF/
 │           ├── persistence.xml         # Configuração do JPA e schema generation
 │           ├── beans.xml               # Ativação do CDI (Weld)
 │           └── sql/
 │               └── dados-iniciais.sql  # Script de dados de exemplo
 └── webapp/
     ├── META-INF/
     │   └── context.xml                 # Configuração de recursos
     ├── WEB-INF/
     │   ├── web.xml                     # Configuração do JSF e CDI
     │   └── templates/                  # Layout base e fragments
     └── pages/                          # Páginas JSF (ex: empresas.xhtml)
```

---

## 🗄️ Banco de Dados

Configuração no arquivo `src/main/resources/META-INF/persistence.xml`:

```xml
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/erpjsfprimefaces" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="root" />
<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
<property name="javax.persistence.sql-load-script-source" value="META-INF/sql/dados-iniciais.sql" />
```

O script `dados-iniciais.sql` é automaticamente executado ao iniciar a aplicação, criando registros de exemplo para:
- **RamoAtividade** (Distribuição de alimentos, Telecomunicações, Vestuário, etc.);
- **Empresa** (Mercado do João, Fale Mais, Maria de Souza da Silva...).

---

## 🧩 Camada de Persistência

A camada de repositórios utiliza **EntityManager** diretamente, com métodos simples e expressivos:
```java
public class Empresas {
    private EntityManager manager;

    public Empresa guardar(Empresa empresa) {
        return manager.merge(empresa);
    }

    public List<Empresa> pesquisar(String nome) {
        String jpql = "from Empresa where nomeFantasia like :nomeFantasia";
        return manager.createQuery(jpql, Empresa.class)
                      .setParameter("nomeFantasia", nome + "%")
                      .getResultList();
    }
}
```

Também há suporte a **Criteria API** para consultas dinâmicas em `RamoAtividades`.

---

## ▶️ Como Executar o Projeto

1. **Importe** o projeto Maven no Eclipse ou VS Code (com extensão Java).
2. Configure o **Tomcat 9+** como servidor.
3. Certifique-se de que o **MySQL** está ativo e acessível (usuário `root` / senha `root`).
4. Faça o **deploy** do `.war` gerado pelo Maven.
5. Acesse no navegador:  
   👉 `http://localhost:8080/jsfprimefaces-essencial`

Durante a inicialização:
- As tabelas são criadas automaticamente (`drop-and-create`);
- O script `dados-iniciais.sql` é executado;
- O log exibirá as queries SQL (`hibernate.show_sql=true`).

---

## 🧠 Conceitos Aplicados

- **POO (Programação Orientada a Objetos)**: entidades modelam objetos do mundo real (`Empresa`, `RamoAtividade`, `TipoEmpresa`);
- **JPA/Hibernate**: abstração do acesso ao banco de dados via mapeamento objeto-relacional (ORM);
- **CDI (Weld)**: injeção de dependência e ciclo de vida controlado;
- **DAO/Repository Pattern**: classes específicas para persistência (`Empresas`, `RamoAtividades`);
- **Camadas de Arquitetura**: separação entre domínio, persistência e visão;
- **Enumeração**: controle de tipos fixos (`TipoEmpresa`).

---

## 📚 Créditos e Referência

Baseado no curso **JSF e PrimeFaces Essencial** da [AlgaWorks](https://www.algaworks.com/).  
Adaptado para fins de **estudo, prática individual e aprofundamento em arquitetura Java EE**.

---

## 🚀 Próximos Passos

- Adicionar camada **Service/Bean** para controle via Managed Beans JSF;  
- Criar interface com **PrimeFaces DataTable** e formulários de cadastro;  
- Implementar mensagens de validação (`FacesMessage` + Hibernate Validator);  
- Evoluir para **Payara / Jakarta EE 10** futuramente.
