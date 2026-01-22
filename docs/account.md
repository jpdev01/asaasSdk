# Subcontas (Accounts)

Crie e gerencie subcontas vinculadas à sua conta principal. Ideal para marketplaces, franquias e empresas que precisam segregar operações.

## 📋 Índice

- [Criar Subconta](#criar-subconta)
- [Recuperar Subconta](#recuperar-subconta)
- [Listar Subcontas](#listar-subcontas)
- [Atualizar Subconta](#atualizar-subconta)
- [Casos de Uso](#casos-de-uso)

## Criar Subconta

### Subconta Pessoa Jurídica

```java
import io.github.jpdev.asaassdk.rest.account.Account;
import java.util.Date;

Account subconta = Account.creator()
    .setName("Loja Parceira LTDA")
    .setEmail("contato@lojaparceira.com")
    .setCpfCnpj("12.345.678/0001-90")
    .setBirthDate(new Date(2020, 0, 1)) // Data de fundação
    .setCompanyType("LIMITED") // Tipo de empresa
    .setPhone("4733334444")
    .setMobilePhone("47999999999")
    .setPostalCode("89010-000")
    .setAddress("Rua Principal")
    .setAddressNumber("100")
    .setProvince("Centro")
    .create();

System.out.println("Subconta criada: " + subconta.getId());
System.out.println("Wallet ID: " + subconta.getWalletId());
```

### Subconta Pessoa Física

```java
Account subconta = Account.creator()
    .setName("João Silva")
    .setEmail("joao@exemplo.com")
    .setCpfCnpj("123.456.789-00")
    .setBirthDate(new Date(1990, 0, 15))
    .setPhone("47999999999")
    .setPostalCode("89010-000")
    .setAddress("Rua das Flores")
    .setAddressNumber("50")
    .setProvince("Centro")
    .create();
```

### Subconta com Dados Completos

```java
Account subconta = Account.creator()
    .setName("Empresa XYZ LTDA")
    .setEmail("financeiro@empresaxyz.com")
    .setCpfCnpj("12345678000190")
    .setBirthDate(new Date(2018, 5, 10))
    .setCompanyType("LIMITED")
    .setPhone("4733334444")
    .setMobilePhone("47988888888")
    .setPostalCode("89010-000")
    .setAddress("Avenida Brasil")
    .setAddressNumber("1000")
    .setComplement("Sala 201")
    .setProvince("Centro")
    .setSite("https://empresaxyz.com")
    .setIncomeValue(50000.00) // Faturamento mensal estimado
    .create();

System.out.println("Subconta criada com sucesso!");
System.out.println("ID: " + subconta.getId());
System.out.println("Wallet ID: " + subconta.getWalletId());
```

## Recuperar Subconta

```java
Account subconta = Account.fetcher("acc_123456789").fetch();

System.out.println("Nome: " + subconta.getName());
System.out.println("Email: " + subconta.getEmail());
System.out.println("CPF/CNPJ: " + subconta.getCpfCnpj());
System.out.println("Wallet ID: " + subconta.getWalletId());
System.out.println("Status: " + subconta.getStatus());
```

## Listar Subcontas

```java
import io.github.jpdev.asaassdk.rest.account.ResourceSet;

ResourceSet<Account> subcontas = Account.reader().read();

for (Account subconta : subcontas.getData()) {
    System.out.println("ID: " + subconta.getId());
    System.out.println("Nome: " + subconta.getName());
    System.out.println("Email: " + subconta.getEmail());
    System.out.println("Wallet ID: " + subconta.getWalletId());
    System.out.println("---");
}
```

## Atualizar Subconta

```java
Account atualizada = Account.updater("acc_123456789")
    .setName("Novo Nome da Empresa")
    .setEmail("novoemail@empresa.com")
    .setPhone("4733335555")
    .update();

System.out.println("Subconta atualizada: " + atualizada.getName());
```

## Tipos de Empresa

| Tipo | Descrição | Valor |
|------|-----------|-------|
| MEI | Microempreendedor Individual | `"MEI"` |
| Limitada | Sociedade Limitada | `"LIMITED"` |
| Individual | Empresário Individual | `"INDIVIDUAL"` |
| Associação | Associação | `"ASSOCIATION"` |

## Casos de Uso

### Marketplace

```java
// Criar subconta para cada vendedor
Account vendedor1 = Account.creator()
    .setName("Vendedor A LTDA")
    .setEmail("vendedora@marketplace.com")
    .setCpfCnpj("12345678000190")
    .setBirthDate(new Date(2020, 0, 1))
    .setCompanyType("LIMITED")
    .setPostalCode("89010-000")
    .create();

// Usar o walletId para split de pagamentos
String walletId = vendedor1.getWalletId();
```

### Franquia

```java
// Criar subconta para cada franqueado
Account franquia = Account.creator()
    .setName("Franquia Centro")
    .setEmail("centro@franquia.com")
    .setCpfCnpj("98765432000100")
    .setBirthDate(new Date(2021, 0, 1))
    .setCompanyType("LIMITED")
    .setPostalCode("89010-000")
    .create();
```

### Filiais

```java
// Criar subconta para cada filial
Account filial = Account.creator()
    .setName("Filial Sul")
    .setEmail("sul@empresa.com")
    .setCpfCnpj("11122233000144")
    .setBirthDate(new Date(2019, 0, 1))
    .setCompanyType("LIMITED")
    .setPostalCode("89010-000")
    .create();
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.account.Account;
import java.util.Date;

public class ExemploSubconta {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Criar subconta
        Account subconta = Account.creator()
            .setName("Parceiro Comercial LTDA")
            .setEmail("parceiro@exemplo.com")
            .setCpfCnpj("12345678000190")
            .setBirthDate(new Date(2020, 0, 1))
            .setCompanyType("LIMITED")
            .setPhone("4733334444")
            .setPostalCode("89010-000")
            .setAddress("Rua Comercial")
            .setAddressNumber("500")
            .setProvince("Centro")
            .create();
        
        System.out.println("Subconta criada!");
        System.out.println("ID: " + subconta.getId());
        System.out.println("Wallet ID: " + subconta.getWalletId());
        
        // Recuperar subconta
        Account recuperada = Account.fetcher(subconta.getId()).fetch();
        System.out.println("Nome: " + recuperada.getName());
        
        // Listar todas as subcontas
        ResourceSet<Account> subcontas = Account.reader().read();
        System.out.println("Total de subcontas: " + subcontas.getTotalCount());
    }
}
```

## Boas Práticas

### 1. Armazene o Wallet ID

```java
Account subconta = Account.creator()
    .setName("Vendedor")
    .setCpfCnpj("12345678000190")
    .create();

// Salvar no banco de dados
String walletId = subconta.getWalletId();
// Use este ID para splits e transferências
```

### 2. Valide Dados Antes de Criar

```java
String cnpj = "12.345.678/0001-90";
String cnpjLimpo = cnpj.replaceAll("[^0-9]", "");

if (cnpjLimpo.length() == 14) {
    Account subconta = Account.creator()
        .setCpfCnpj(cnpjLimpo)
        .setName("Empresa")
        .create();
}
```

### 3. Trate Erros

```java
try {
    Account subconta = Account.creator()
        .setName("Empresa")
        .setCpfCnpj("12345678000190")
        .create();
} catch (AsaasException e) {
    System.err.println("Erro ao criar subconta: " + e.getMessage());
}
```

## Campos Obrigatórios

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `name` | String | Nome da pessoa/empresa |
| `email` | String | Email de acesso |
| `cpfCnpj` | String | CPF ou CNPJ |
| `birthDate` | Date | Data de nascimento/fundação |
| `postalCode` | String | CEP |

## Veja Também

- [Cobranças com Split](payment_split.md) - Dividir pagamentos entre subcontas
- [Transferências](transfer.md) - Transferir entre contas
- [Clientes](customeraccount.md) - Gerenciar clientes

## Referências

- [Documentação Oficial - Subcontas](https://docs.asaas.com/reference/criar-subconta)
