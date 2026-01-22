# Número de Conta (Account Number)

Consulte os dados bancários da sua conta Asaas. Use para receber transferências TED/DOC de outras instituições.

## 📋 Índice

- [Recuperar Dados Bancários](#recuperar-dados-bancários)
- [Informações Disponíveis](#informações-disponíveis)
- [Como Usar](#como-usar)

## Recuperar Dados Bancários

```java
import io.github.jpdev.asaassdk.rest.accountnumber.AccountNumber;

AccountNumber dadosBancarios = AccountNumber.fetcher().fetch();

System.out.println("=== DADOS BANCÁRIOS ===");
System.out.println("Banco: " + dadosBancarios.getBank());
System.out.println("Agência: " + dadosBancarios.getAgency());
System.out.println("Agência (com dígito): " + dadosBancarios.getAgencyDigit());
System.out.println("Conta: " + dadosBancarios.getAccount());
System.out.println("Conta (com dígito): " + dadosBancarios.getAccountDigit());
System.out.println("Tipo de conta: " + dadosBancarios.getAccountType());
```

## Informações Disponíveis

### Dados Completos

```java
AccountNumber dados = AccountNumber.fetcher().fetch();

// Banco
String banco = dados.getBank(); // Ex: "085" (Ailos)
String nomeBanco = dados.getBankName(); // Ex: "Ailos"

// Agência
String agencia = dados.getAgency(); // Ex: "0001"
String agenciaDigito = dados.getAgencyDigit(); // Ex: "0001-0"

// Conta
String conta = dados.getAccount(); // Ex: "12345"
String contaDigito = dados.getAccountDigit(); // Ex: "12345-6"

// Tipo
String tipoConta = dados.getAccountType(); // Ex: "CONTA_CORRENTE"

System.out.println("Banco: " + nomeBanco + " (" + banco + ")");
System.out.println("Agência: " + agenciaDigito);
System.out.println("Conta: " + contaDigito);
System.out.println("Tipo: " + tipoConta);
```

### Formato para Exibição

```java
AccountNumber dados = AccountNumber.fetcher().fetch();

String dadosFormatados = String.format(
    "Banco: %s (%s)\nAgência: %s\nConta: %s\nTipo: %s",
    dados.getBankName(),
    dados.getBank(),
    dados.getAgencyDigit(),
    dados.getAccountDigit(),
    dados.getAccountType()
);

System.out.println(dadosFormatados);
```

## Como Usar

### Receber TED/DOC

```java
AccountNumber dados = AccountNumber.fetcher().fetch();

System.out.println("=== PARA RECEBER TED/DOC ===");
System.out.println("Informe os seguintes dados:");
System.out.println();
System.out.println("Banco: " + dados.getBankName() + " (Código: " + dados.getBank() + ")");
System.out.println("Agência: " + dados.getAgency());
System.out.println("Conta: " + dados.getAccount() + "-" + dados.getAccountDigit().split("-")[1]);
System.out.println("Tipo: Conta Corrente");
System.out.println("Titular: [Seu Nome/Razão Social]");
System.out.println("CPF/CNPJ: [Seu CPF/CNPJ]");
```

### Exibir no Sistema

```java
public class DadosBancariosView {
    
    public static void exibirDadosBancarios() {
        AccountNumber dados = AccountNumber.fetcher().fetch();
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       DADOS BANCÁRIOS ASAAS            ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Banco: " + dados.getBankName());
        System.out.println("║ Código: " + dados.getBank());
        System.out.println("║ Agência: " + dados.getAgencyDigit());
        System.out.println("║ Conta: " + dados.getAccountDigit());
        System.out.println("║ Tipo: " + dados.getAccountType());
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        exibirDadosBancarios();
    }
}
```

### Gerar Comprovante

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComprovanteGerador {
    
    public static String gerarComprovante() {
        AccountNumber dados = AccountNumber.fetcher().fetch();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = LocalDateTime.now().format(formatter);
        
        StringBuilder comprovante = new StringBuilder();
        comprovante.append("═══════════════════════════════════════\n");
        comprovante.append("        DADOS BANCÁRIOS ASAAS          \n");
        comprovante.append("═══════════════════════════════════════\n\n");
        comprovante.append("Banco: ").append(dados.getBankName()).append("\n");
        comprovante.append("Código do Banco: ").append(dados.getBank()).append("\n");
        comprovante.append("Agência: ").append(dados.getAgencyDigit()).append("\n");
        comprovante.append("Conta: ").append(dados.getAccountDigit()).append("\n");
        comprovante.append("Tipo: ").append(dados.getAccountType()).append("\n\n");
        comprovante.append("───────────────────────────────────────\n");
        comprovante.append("Gerado em: ").append(dataHora).append("\n");
        comprovante.append("═══════════════════════════════════════\n");
        
        return comprovante.toString();
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        System.out.println(gerarComprovante());
    }
}
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.accountnumber.AccountNumber;

public class ExemploDadosBancarios {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Recuperar dados bancários
        AccountNumber dados = AccountNumber.fetcher().fetch();
        
        // Exibir informações
        System.out.println("═══════════════════════════════════════");
        System.out.println("     SEUS DADOS BANCÁRIOS ASAAS        ");
        System.out.println("═══════════════════════════════════════\n");
        
        System.out.println("Banco:");
        System.out.println("  Nome: " + dados.getBankName());
        System.out.println("  Código: " + dados.getBank());
        
        System.out.println("\nAgência:");
        System.out.println("  Número: " + dados.getAgency());
        System.out.println("  Com dígito: " + dados.getAgencyDigit());
        
        System.out.println("\nConta:");
        System.out.println("  Número: " + dados.getAccount());
        System.out.println("  Com dígito: " + dados.getAccountDigit());
        
        System.out.println("\nTipo de Conta:");
        System.out.println("  " + dados.getAccountType());
        
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("Use estes dados para receber TED/DOC");
        System.out.println("═══════════════════════════════════════");
    }
}
```

## Informações Importantes

### Banco Asaas

O Asaas opera através do banco **Ailos** (código 085):

```
Banco: Ailos
Código: 085
Tipo de Conta: Conta Corrente
```

### Formato dos Dados

| Campo | Formato | Exemplo |
|-------|---------|---------|
| Banco | 3 dígitos | `085` |
| Agência | 4 dígitos | `0001` |
| Agência com dígito | 4 dígitos + hífen + 1 dígito | `0001-0` |
| Conta | 5-7 dígitos | `12345` |
| Conta com dígito | 5-7 dígitos + hífen + 1 dígito | `12345-6` |

## Casos de Uso

### 1. Receber Pagamento de Cliente

```java
// Cliente quer fazer TED para sua conta
AccountNumber dados = AccountNumber.fetcher().fetch();

String mensagem = String.format(
    "Para realizar o pagamento via TED, use:\n\n" +
    "Banco: %s (%s)\n" +
    "Agência: %s\n" +
    "Conta: %s\n" +
    "Favorecido: [Seu Nome]\n" +
    "CPF/CNPJ: [Seu Documento]",
    dados.getBankName(),
    dados.getBank(),
    dados.getAgencyDigit(),
    dados.getAccountDigit()
);

System.out.println(mensagem);
// Enviar por email/SMS para o cliente
```

### 2. Integração com Sistema

```java
public class ContaBancariaService {
    
    private AccountNumber dadosCache;
    
    public AccountNumber getDadosBancarios() {
        if (dadosCache == null) {
            dadosCache = AccountNumber.fetcher().fetch();
        }
        return dadosCache;
    }
    
    public String getBanco() {
        return getDadosBancarios().getBank();
    }
    
    public String getAgencia() {
        return getDadosBancarios().getAgency();
    }
    
    public String getConta() {
        return getDadosBancarios().getAccount();
    }
    
    public String getContaCompleta() {
        return getDadosBancarios().getAccountDigit();
    }
}
```

### 3. Validação de Depósito

```java
// Verificar se depósito foi para conta correta
public boolean validarDepositoRecebido(String agenciaInformada, String contaInformada) {
    AccountNumber dados = AccountNumber.fetcher().fetch();
    
    String agenciaCorreta = dados.getAgency();
    String contaCorreta = dados.getAccount();
    
    return agenciaInformada.equals(agenciaCorreta) && 
           contaInformada.equals(contaCorreta);
}
```

## Boas Práticas

### 1. Cache os Dados

```java
// Dados bancários não mudam frequentemente
private static AccountNumber dadosBancariosCache = null;

public static AccountNumber getDadosBancarios() {
    if (dadosBancariosCache == null) {
        dadosBancariosCache = AccountNumber.fetcher().fetch();
    }
    return dadosBancariosCache;
}
```

### 2. Formate para Exibição

```java
public static String formatarDadosBancarios() {
    AccountNumber dados = getDadosBancarios();
    
    return String.format(
        "Banco: %s (%s) | Ag: %s | Conta: %s",
        dados.getBankName(),
        dados.getBank(),
        dados.getAgency(),
        dados.getAccountDigit()
    );
}
```

### 3. Valide Antes de Usar

```java
AccountNumber dados = AccountNumber.fetcher().fetch();

if (dados.getBank() != null && dados.getAccount() != null) {
    // Dados válidos, pode usar
    System.out.println("Conta: " + dados.getAccountDigit());
} else {
    System.err.println("Erro ao recuperar dados bancários");
}
```

## Limitações

- Os dados bancários são fixos e definidos pelo Asaas
- Não é possível alterar agência ou conta
- Cada conta Asaas tem dados bancários únicos
- Subcontas possuem dados bancários próprios

## Veja Também

- [Saldo](balance.md) - Consultar saldo da conta
- [Extrato](financial.md) - Ver movimentações
- [Transferências](transfer.md) - Enviar transferências

## Referências

- [Documentação Oficial - Dados Bancários](https://docs.asaas.com/reference/consultar-dados-bancarios)
