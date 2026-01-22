# Clientes (Customer Accounts)

Gerencie seus clientes de forma eficiente. Clientes são necessários para criar cobranças, assinaturas e outras operações.

## 📋 Índice

- [Criar Cliente](#criar-cliente)
- [Listar Clientes](#listar-clientes)
- [Recuperar Cliente](#recuperar-cliente)
- [Atualizar Cliente](#atualizar-cliente)
- [Deletar Cliente](#deletar-cliente)
- [Restaurar Cliente](#restaurar-cliente)

## Criar Cliente

### Cliente Pessoa Física (CPF)

```java
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;

CustomerAccount cliente = CustomerAccount.creator()
    .setName("João Silva")
    .setCpfCnpj("12345678900")
    .setEmail("joao@exemplo.com")
    .setPhone("47999999999")
    .setMobilePhone("47988888888")
    .create();

System.out.println("Cliente criado: " + cliente.getId());
```

### Cliente Pessoa Jurídica (CNPJ)

```java
CustomerAccount empresa = CustomerAccount.creator()
    .setName("Empresa XYZ Ltda")
    .setCpfCnpj("12345678000190")
    .setEmail("contato@empresa.com")
    .setPhone("4733334444")
    .setCompany("Empresa XYZ Ltda")
    .create();
```

### Cliente com Endereço Completo

```java
CustomerAccount cliente = CustomerAccount.creator()
    .setName("Maria Santos")
    .setCpfCnpj("98765432100")
    .setEmail("maria@exemplo.com")
    .setPhone("47999999999")
    .setPostalCode("89010-000")
    .setAddress("Rua das Flores")
    .setAddressNumber("123")
    .setComplement("Apto 45")
    .setProvince("Centro")
    .setCity("Blumenau")
    .setState("SC")
    .create();

System.out.println("Cliente criado com endereço completo");
```

### Cliente com Informações Adicionais

```java
CustomerAccount cliente = CustomerAccount.creator()
    .setName("Pedro Oliveira")
    .setCpfCnpj("11122233344")
    .setEmail("pedro@exemplo.com")
    .setPhone("47999999999")
    .setExternalReference("CLI-2024-001") // Referência externa
    .setNotificationDisabled(false) // Habilitar notificações
    .setAdditionalEmails("financeiro@exemplo.com,cobranca@exemplo.com")
    .create();
```

### Cliente Estrangeiro

```java
CustomerAccount estrangeiro = CustomerAccount.creator()
    .setName("John Doe")
    .setEmail("john@example.com")
    .setPhone("+1234567890")
    .setForeignCustomer(true)
    .create();
```

## Listar Clientes

### Listar Todos

```java
import io.github.jpdev.asaassdk.rest.customeraccount.ResourceSet;

ResourceSet<CustomerAccount> clientes = CustomerAccount.reader().read();

for (CustomerAccount cliente : clientes.getData()) {
    System.out.println("ID: " + cliente.getId());
    System.out.println("Nome: " + cliente.getName());
    System.out.println("Email: " + cliente.getEmail());
    System.out.println("CPF/CNPJ: " + cliente.getCpfCnpj());
    System.out.println("---");
}
```

### Filtrar por Nome

```java
ResourceSet<CustomerAccount> clientes = CustomerAccount.reader()
    .setName("João")
    .read();
```

### Filtrar por Email

```java
ResourceSet<CustomerAccount> clientes = CustomerAccount.reader()
    .setEmail("joao@exemplo.com")
    .read();
```

### Filtrar por CPF/CNPJ

```java
ResourceSet<CustomerAccount> clientes = CustomerAccount.reader()
    .setCpfCnpj("12345678900")
    .read();
```

### Filtrar por Referência Externa

```java
ResourceSet<CustomerAccount> clientes = CustomerAccount.reader()
    .setExternalReference("CLI-2024-001")
    .read();
```

### Paginação

```java
ResourceSet<CustomerAccount> clientes = CustomerAccount.reader()
    .setLimit(50) // 50 registros por página
    .setOffset(0) // Página inicial
    .read();

System.out.println("Total de clientes: " + clientes.getTotalCount());
System.out.println("Tem próxima página: " + clientes.hasMore());

// Próxima página
if (clientes.hasMore()) {
    ResourceSet<CustomerAccount> proximaPagina = CustomerAccount.reader()
        .setLimit(50)
        .setOffset(50)
        .read();
}
```

## Recuperar Cliente

Busque um cliente específico pelo ID:

```java
CustomerAccount cliente = CustomerAccount.fetcher("cus_000050606806").fetch();

System.out.println("Nome: " + cliente.getName());
System.out.println("Email: " + cliente.getEmail());
System.out.println("CPF/CNPJ: " + cliente.getCpfCnpj());
System.out.println("Telefone: " + cliente.getPhone());
System.out.println("Endereço: " + cliente.getAddress());
System.out.println("Cidade: " + cliente.getCity());
System.out.println("Estado: " + cliente.getState());
```

## Atualizar Cliente

### Atualizar Dados Básicos

```java
CustomerAccount clienteAtualizado = CustomerAccount.updater("cus_000050606806")
    .setName("João Silva Santos")
    .setEmail("joao.novo@exemplo.com")
    .setPhone("47988887777")
    .update();

System.out.println("Cliente atualizado com sucesso");
```

### Atualizar Endereço

```java
CustomerAccount clienteAtualizado = CustomerAccount.updater("cus_000050606806")
    .setPostalCode("89010-100")
    .setAddress("Rua Nova")
    .setAddressNumber("456")
    .setComplement("Casa")
    .setProvince("Bairro Novo")
    .setCity("Blumenau")
    .setState("SC")
    .update();
```

### Atualizar Notificações

```java
CustomerAccount clienteAtualizado = CustomerAccount.updater("cus_000050606806")
    .setNotificationDisabled(true) // Desabilitar notificações
    .update();
```

### Atualizar Emails Adicionais

```java
CustomerAccount clienteAtualizado = CustomerAccount.updater("cus_000050606806")
    .setAdditionalEmails("novo1@exemplo.com,novo2@exemplo.com")
    .update();
```

## Deletar Cliente

Delete um cliente que não possui cobranças ativas:

```java
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccountDeleted;

CustomerAccountDeleted deleted = CustomerAccount.deleter("cus_000050606806").delete();

if (deleted.isDeleted()) {
    System.out.println("Cliente deletado com sucesso");
}
```

**Nota**: Apenas clientes sem cobranças pendentes ou ativas podem ser deletados.

## Restaurar Cliente

Restaure um cliente que foi deletado:

```java
CustomerAccount cliente = CustomerAccount.restorer("cus_000050606806").create();

System.out.println("Cliente restaurado: " + cliente.getId());
System.out.println("Nome: " + cliente.getName());
```

## Validações

### CPF/CNPJ

O SDK valida automaticamente o formato do CPF/CNPJ:

- **CPF**: 11 dígitos (com ou sem formatação)
  - Exemplos válidos: `12345678900`, `123.456.789-00`
- **CNPJ**: 14 dígitos (com ou sem formatação)
  - Exemplos válidos: `12345678000190`, `12.345.678/0001-90`

### Email

O email deve estar em formato válido:
- `usuario@dominio.com`
- `usuario.nome@dominio.com.br`

### Telefone

Telefones devem incluir DDD:
- Fixo: `4733334444` ou `(47) 3333-4444`
- Celular: `47999999999` ou `(47) 99999-9999`

### CEP

CEP deve ter 8 dígitos:
- `89010000` ou `89010-000`

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;
import io.github.jpdev.asaassdk.rest.customeraccount.ResourceSet;

public class ExemploClientes {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Criar cliente
        CustomerAccount novoCliente = CustomerAccount.creator()
            .setName("Ana Paula Costa")
            .setCpfCnpj("12345678900")
            .setEmail("ana@exemplo.com")
            .setPhone("47999999999")
            .setPostalCode("89010-000")
            .setAddress("Rua Principal")
            .setAddressNumber("100")
            .setProvince("Centro")
            .setCity("Blumenau")
            .setState("SC")
            .create();
        
        System.out.println("Cliente criado: " + novoCliente.getId());
        
        // Buscar cliente
        CustomerAccount cliente = CustomerAccount.fetcher(novoCliente.getId()).fetch();
        System.out.println("Cliente encontrado: " + cliente.getName());
        
        // Atualizar cliente
        CustomerAccount atualizado = CustomerAccount.updater(cliente.getId())
            .setPhone("47988888888")
            .update();
        System.out.println("Telefone atualizado: " + atualizado.getPhone());
        
        // Listar todos os clientes
        ResourceSet<CustomerAccount> clientes = CustomerAccount.reader()
            .setLimit(10)
            .read();
        
        System.out.println("Total de clientes: " + clientes.getTotalCount());
        for (CustomerAccount c : clientes.getData()) {
            System.out.println("- " + c.getName() + " (" + c.getEmail() + ")");
        }
    }
}
```

## Boas Práticas

### 1. Use Referência Externa

Mantenha uma referência do seu sistema:

```java
CustomerAccount cliente = CustomerAccount.creator()
    .setName("Cliente Teste")
    .setCpfCnpj("12345678900")
    .setExternalReference("ID_DO_SEU_SISTEMA_123")
    .create();
```

### 2. Valide Dados Antes de Enviar

```java
String cpf = "123.456.789-00";
String cpfLimpo = cpf.replaceAll("[^0-9]", ""); // Remove formatação

if (cpfLimpo.length() == 11) {
    CustomerAccount cliente = CustomerAccount.creator()
        .setCpfCnpj(cpfLimpo)
        // ... outros campos
        .create();
}
```

### 3. Trate Erros Adequadamente

```java
try {
    CustomerAccount cliente = CustomerAccount.creator()
        .setName("Teste")
        .setCpfCnpj("12345678900")
        .create();
} catch (AsaasException e) {
    if (e.getMessage().contains("cpfCnpj already exists")) {
        System.err.println("Cliente já cadastrado com este CPF/CNPJ");
    } else {
        System.err.println("Erro ao criar cliente: " + e.getMessage());
    }
}
```

### 4. Mantenha Dados Atualizados

```java
// Atualizar email quando cliente solicitar
CustomerAccount.updater(clienteId)
    .setEmail(novoEmail)
    .update();
```

## Campos Disponíveis

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|-------------|-----------|
| `name` | String | Sim | Nome do cliente |
| `cpfCnpj` | String | Sim* | CPF ou CNPJ |
| `email` | String | Não | Email principal |
| `phone` | String | Não | Telefone fixo |
| `mobilePhone` | String | Não | Telefone celular |
| `address` | String | Não | Endereço |
| `addressNumber` | String | Não | Número |
| `complement` | String | Não | Complemento |
| `province` | String | Não | Bairro |
| `postalCode` | String | Não | CEP |
| `city` | String | Não | Cidade |
| `state` | String | Não | Estado (UF) |
| `externalReference` | String | Não | Referência externa |
| `notificationDisabled` | Boolean | Não | Desabilitar notificações |
| `additionalEmails` | String | Não | Emails adicionais (separados por vírgula) |
| `company` | String | Não | Nome da empresa (PJ) |
| `foreignCustomer` | Boolean | Não | Cliente estrangeiro |

*Obrigatório exceto para clientes estrangeiros

## Veja Também

- [Cobranças](payment.md) - Criar cobranças para clientes
- [Assinaturas](subscription.md) - Criar assinaturas recorrentes
- [Notificações](notification.md) - Gerenciar notificações de clientes

## Referências

- [Documentação Oficial - Clientes](https://docs.asaas.com/reference/criar-novo-cliente)
