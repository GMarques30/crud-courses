# CRUD de gerenciamento de cursos

Bem-vindo ao projeto de CRUD de gerenciamento de cursos!

## Funcionalidades

A API deve implementar as seguintes funcionalidades:

- Criar um novo curso
- Listar todos os cursos
- Atualizar um curso pelo `courseId`
- Remover um curso pelo `courseId`
- Marcar um curso como ativo ou inativo

### Estrutura de um curso

Cada curso deve ter as seguintes propriedades:

- `courseId` - Identificador único
- `name` - Nome do curso
- `category` - Categoria do curso
- `status` - Status de atividade do curso (ativo/inativo)
- `created_at` - Data de criação
- `updated_at` - Data de última atualização

### Rotas

- **POST `/course`**  
  Criação de um novo curso. Campos esperados no `body`: `name`, `category` e `status`.  
  Os campos `courseId`, `created_at` e `updated_at` são preenchidos automaticamente.

- **GET `/course`**  
  Listagem de todos os cursos.

- **PUT `/course/:courseId`**  
  Atualização de um curso pelo `courseId`. No `body` da requisição, deve receber os campos `name` e/ou `category`.
  O campo `status` será ignorado nesta rota.

- **DELETE `/course/:courseId`**  
  Remoção de um curso pelo `courseId`.

- **PATCH `/course/:courseId/active`**  
  Atualiza o status de atividade (`status`) de um curso, alternando entre `activated` e `deactivated`.

## Requisitos

- Java Development Kit (JDK) 8 ou superior
- IDE de sua escolha (Eclipse, IntelliJ IDEA, NetBeans, etc.)

## Licença
Este projeto está licenciado sob a MIT License.
