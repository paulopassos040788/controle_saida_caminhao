# Controle de Saída de Caminhão

Este projeto é uma API para controle de saída de caminhões de um depósito. A API permite o cadastro de motoristas e veículos (caminhões), além de registrar a data, horário, destino e quilometragem da saída do veículo da empresa e posteriormente registrar sua entrada na empresa.

## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA (Java Persistence API)
- PostgreSQL

## Funcionalidades

- Cadastro de Motoristas
- Cadastro de Veículos (Caminhões)
- Registro de Saída de Veículos
  - Data
  - Horário
  - Destino
  - Quilometragem
- Registro de Entrada de Veículos

## Estrutura do Projeto

O projeto possui três entidades principais:

1. **Motorista**
   - `id`: Identificador único do motorista
   - `nome`: Nome do motorista
   - `cnh`: Número da CNH do motorista

2. **Veículo**
   - `id`: Identificador único do veículo
   - `placa`: Placa do veículo
   - `modelo`: Modelo do veículo

3. **Registro de Saída**
   - `id`: Identificador único do registro
   - `data_saida`: Data da saída
   - `horario_saida`: Horário da saída
   - `destino`: Destino do veículo
   - `quilometragem`: Quilometragem do veículo na saída
   - `motorista`: Referência ao motorista
   - `veiculo`: Referência ao veículo
   - `data_entrada`: Data da entrada
   - `horario_entrada`: Horário da entrada

## Endpoints da API

- Motoristas
  - `POST /motoristas`: Cadastrar um novo motorista
  - `GET /motoristas` : Listar todos os motoristas
  - `GET /motoristas/{id}` : Obter detalhes de um motorista específico
  - `PUT /motoristas/{id}` : Atualizar informações de um motorista
  - `DELETE /motoristas/{id}`: Remover um motorista

- Veículos
  - `POST /veiculos` : Cadastrar um novo veículo
  - `GET /veiculos` : Listar todos os veículos
  - `GET /veiculos/{id}` : Obter detalhes de um veículo específico
  - `PUT /veiculos/{id}` : Atualizar informações de um veículo
  - `DELETE /veiculos/{id}`: Remover um veículo

- Registros de Saída e entrada
  - `POST /registro-saida`: Registrar a saída de um veículo
  - `POST /registro-entrada`: Registrar da entrada de um veículo
  - `GET /registros-entrada-saida` : Listar todos os registros
  - `PUT /registros-entrada-saida/{id}` : Atualizar informações de um registro
  - `DELETE /registros-entrada-saida/{id}` : Remover um registro

## Como Executar o Projeto

1. Clone o repositório:
