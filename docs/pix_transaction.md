# PIX - Transações

Envie e receba pagamentos PIX de forma rápida e segura. Realize transferências via chave PIX, dados bancários ou QR Code.

## 📋 Índice

- [Criar Transação PIX](#criar-transação-pix)
- [Pagar QR Code](#pagar-qr-code)
- [Listar Transações](#listar-transações)
- [Recuperar Transação](#recuperar-transação)
- [Cancelar Transação](#cancelar-transação)
- [PIX Recorrente](#pix-recorrente)

## Criar Transação PIX

### Via Chave PIX - CPF

```java
import io.github.jpdev.asaassdk.rest.transfer.Transfer;
import io.github.jpdev.asaassdk.enums.PixAddressKeyType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;

Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("12345678900")
    .setPixAddressKeyType(PixAddressKeyType.CPF)
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Pagamento fornecedor")
    .create();

System.out.println("Transferência realizada: " + transfer.getId());
System.out.println("Status: " + transfer.getStatus());
```

### Via Chave PIX - Email

```java
Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("destinatario@email.com")
    .setPixAddressKeyType(PixAddressKeyType.EMAIL)
    .setValue(Money.create(new BigDecimal("50.00")))
    .setDescription("Pagamento de serviço")
    .create();
```

### Via Chave PIX - Telefone

```java
Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("+5547999999999")
    .setPixAddressKeyType(PixAddressKeyType.PHONE)
    .setValue(Money.create(new BigDecimal("75.50")))
    .setDescription("Transferência")
    .create();
```

### Via Chave PIX - CNPJ

```java
Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("12345678000190")
    .setPixAddressKeyType(PixAddressKeyType.CNPJ)
    .setValue(Money.create(new BigDecimal("1000.00")))
    .setDescription("Pagamento de nota fiscal")
    .create();
```

### Via Chave PIX - Aleatória (EVP)

```java
Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("123e4567-e89b-12d3-a456-426614174000")
    .setPixAddressKeyType(PixAddressKeyType.EVP)
    .setValue(Money.create(new BigDecimal("250.00")))
    .setDescription("Pagamento")
    .create();
```

### Via Dados Bancários

Quando o destinatário não possui chave PIX:

```java
import io.github.jpdev.asaassdk.rest.transfer.BankAccountSetting;
import io.github.jpdev.asaassdk.rest.transfer.BankSetting;
import io.github.jpdev.asaassdk.enums.BankAccountType;
import java.util.Date;

BankAccountSetting bankAccount = new BankAccountSetting()
    .setBank(new BankSetting().setCode("085")) // Código do banco
    .setAccountName("João Silva")
    .setOwnerName("João Silva")
    .setOwnerBirthDate(new Date(1990, 0, 1))
    .setCpfCnpj("12345678900")
    .setAgency("0001")
    .setAccount("12345")
    .setAccountDigit("6")
    .setBankAccountType(BankAccountType.CONTA_CORRENTE);

Transfer transfer = Transfer.pixManualCreator()
    .setBankAccount(bankAccount)
    .setValue(Money.create(new BigDecimal("150.00")))
    .setDescription("Pagamento via dados bancários")
    .create();

System.out.println("PIX enviado: " + transfer.getId());
```

### Com Agendamento

Agende uma transferência PIX para data futura:

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 3); // Daqui a 3 dias
Date dataAgendamento = cal.getTime();

Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("12345678900")
    .setPixAddressKeyType(PixAddressKeyType.CPF)
    .setValue(Money.create(new BigDecimal("200.00")))
    .setDescription("Pagamento agendado")
    .setScheduleDate(dataAgendamento)
    .create();

System.out.println("PIX agendado para: " + transfer.getScheduleDate());
```

## Pagar QR Code

### QR Code Estático

```java
import io.github.jpdev.asaassdk.rest.pix.PixTransaction;

String payload = "00020101021226730014br.gov.bcb.pix2551pix-h.asaas.com...";

PixTransaction transaction = PixTransaction.qrCodeCreator()
    .setPayload(payload)
    .setValue(Money.create(new BigDecimal("50.00")))
    .setDescription("Pagamento via QR Code")
    .create();

System.out.println("Pagamento realizado: " + transaction.getId());
System.out.println("Status: " + transaction.getStatus());
```

### QR Code Dinâmico

QR Codes dinâmicos já possuem o valor embutido:

```java
String payloadDinamico = "00020101021226770014br.gov.bcb.pix...";

PixTransaction transaction = PixTransaction.qrCodeCreator()
    .setPayload(payloadDinamico)
    .create();

System.out.println("Pagamento de R$ " + transaction.getValue() + " realizado");
```

### Validar QR Code Antes de Pagar

```java
import io.github.jpdev.asaassdk.rest.pix.PixDecodedQrCode;

// Primeiro, decodificar o QR Code
PixDecodedQrCode decoded = PixDecodedQrCode.decoder()
    .setPayload(payload)
    .create();

System.out.println("Beneficiário: " + decoded.getName());
System.out.println("Valor: R$ " + decoded.getValue());
System.out.println("Descrição: " + decoded.getDescription());

// Confirmar e pagar
PixTransaction transaction = PixTransaction.qrCodeCreator()
    .setPayload(payload)
    .create();
```

## Listar Transações

### Listar Todas

```java
import io.github.jpdev.asaassdk.rest.pix.ResourceSet;

ResourceSet<PixTransaction> transactions = PixTransaction.reader().read();

for (PixTransaction tx : transactions.getData()) {
    System.out.println("ID: " + tx.getId());
    System.out.println("Tipo: " + tx.getType());
    System.out.println("Valor: R$ " + tx.getValue());
    System.out.println("Status: " + tx.getStatus());
    System.out.println("Data: " + tx.getDateCreated());
    System.out.println("---");
}
```

### Filtrar por Tipo

```java
import io.github.jpdev.asaassdk.enums.PixTransactionType;

// Apenas débitos (enviados)
ResourceSet<PixTransaction> debitos = PixTransaction.reader()
    .setType(PixTransactionType.DEBIT)
    .read();

// Apenas créditos (recebidos)
ResourceSet<PixTransaction> creditos = PixTransaction.reader()
    .setType(PixTransactionType.CREDIT)
    .read();
```

### Filtrar por Status

```java
import io.github.jpdev.asaassdk.enums.PixTransactionStatus;

// Apenas concluídas
ResourceSet<PixTransaction> concluidas = PixTransaction.reader()
    .setStatus(PixTransactionStatus.DONE)
    .read();

// Apenas pendentes
ResourceSet<PixTransaction> pendentes = PixTransaction.reader()
    .setStatus(PixTransactionStatus.PENDING)
    .read();
```

### Filtrar por Data

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.set(2024, Calendar.JANUARY, 1);
Date dataInicio = cal.getTime();

cal.set(2024, Calendar.JANUARY, 31);
Date dataFim = cal.getTime();

ResourceSet<PixTransaction> transactions = PixTransaction.reader()
    .setStartDate(dataInicio)
    .setEndDate(dataFim)
    .read();
```

### Filtrar por Chave PIX

```java
ResourceSet<PixTransaction> transactions = PixTransaction.reader()
    .setPixAddressKey("12345678900")
    .read();
```

### Paginação

```java
ResourceSet<PixTransaction> transactions = PixTransaction.reader()
    .setLimit(50)
    .setOffset(0)
    .read();

System.out.println("Total: " + transactions.getTotalCount());
System.out.println("Tem mais: " + transactions.hasMore());
```

## Recuperar Transação

### Por ID

```java
PixTransaction transaction = PixTransaction.fetcher("bc515f74-d5c7-4bc2-93e5-3bafc0a9b15d").fetch();

System.out.println("Valor: R$ " + transaction.getValue());
System.out.println("Status: " + transaction.getStatus());
System.out.println("Tipo: " + transaction.getType());
System.out.println("Chave PIX: " + transaction.getPixAddressKey());
```

### Por Identificador Fim a Fim (End to End ID)

```java
PixTransaction transaction = PixTransaction.fetcher("E18236120202302141342s15536c561e").fetch();

System.out.println("Transação encontrada: " + transaction.getId());
```

## Cancelar Transação

Cancele uma transação PIX agendada ou pendente:

```java
PixTransaction cancelled = PixTransaction.canceller("35363f6e-93e2-11ec-b9d9-96f4053b1bd4").create();

if (cancelled.getStatus() == PixTransactionStatus.CANCELLED) {
    System.out.println("Transação cancelada com sucesso");
}
```

**Nota**: Apenas transações com status `PENDING` ou `SCHEDULED` podem ser canceladas.

## PIX Recorrente

Configure transferências PIX automáticas:

### Mensal

```java
import io.github.jpdev.asaassdk.rest.transfer.PixRecurring;
import io.github.jpdev.asaassdk.enums.PixRecurringFrequency;

PixRecurring recurring = new PixRecurring()
    .setFrequency(PixRecurringFrequency.MONTHLY)
    .setQuantity(12); // 12 meses

Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("12345678900")
    .setPixAddressKeyType(PixAddressKeyType.CPF)
    .setValue(Money.create(new BigDecimal("500.00")))
    .setDescription("Aluguel mensal")
    .setRecurring(recurring)
    .create();

System.out.println("PIX recorrente configurado por 12 meses");
```

### Semanal

```java
PixRecurring recurring = new PixRecurring()
    .setFrequency(PixRecurringFrequency.WEEKLY)
    .setQuantity(4); // 4 semanas

Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("fornecedor@email.com")
    .setPixAddressKeyType(PixAddressKeyType.EMAIL)
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Pagamento semanal")
    .setRecurring(recurring)
    .create();
```

### Diário

```java
PixRecurring recurring = new PixRecurring()
    .setFrequency(PixRecurringFrequency.DAILY)
    .setQuantity(30); // 30 dias

Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("+5547999999999")
    .setPixAddressKeyType(PixAddressKeyType.PHONE)
    .setValue(Money.create(new BigDecimal("50.00")))
    .setDescription("Pagamento diário")
    .setRecurring(recurring)
    .create();
```

## Status de Transações

| Status | Descrição |
|--------|-----------|
| `PENDING` | Aguardando processamento |
| `SCHEDULED` | Agendada |
| `DONE` | Concluída |
| `CANCELLED` | Cancelada |
| `FAILED` | Falhou |
| `AWAITING_RISK_ANALYSIS` | Aguardando análise de risco |

## Tipos de Transação

| Tipo | Descrição |
|------|-----------|
| `DEBIT` | Débito (enviado) |
| `CREDIT` | Crédito (recebido) |

## Códigos de Banco

Principais bancos para transferência via dados bancários:

| Código | Banco |
|--------|-------|
| `001` | Banco do Brasil |
| `033` | Santander |
| `104` | Caixa Econômica |
| `237` | Bradesco |
| `341` | Itaú |
| `077` | Banco Inter |
| `260` | Nubank |
| `290` | PagSeguro |
| `323` | Mercado Pago |
| `085` | Ailos |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.transfer.Transfer;
import io.github.jpdev.asaassdk.rest.pix.*;
import io.github.jpdev.asaassdk.enums.*;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;

public class ExemploPixTransacao {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // 1. Enviar PIX via chave
        Transfer transfer = Transfer.pixAddressKeyCreator()
            .setPixAddressKey("12345678900")
            .setPixAddressKeyType(PixAddressKeyType.CPF)
            .setValue(Money.create(new BigDecimal("100.00")))
            .setDescription("Pagamento fornecedor")
            .create();
        
        System.out.println("PIX enviado: " + transfer.getId());
        
        // 2. Pagar QR Code
        String qrCodePayload = "00020101021226730014br.gov.bcb.pix...";
        
        // Decodificar primeiro
        PixDecodedQrCode decoded = PixDecodedQrCode.decoder()
            .setPayload(qrCodePayload)
            .create();
        
        System.out.println("Pagando para: " + decoded.getName());
        System.out.println("Valor: R$ " + decoded.getValue());
        
        // Confirmar pagamento
        PixTransaction payment = PixTransaction.qrCodeCreator()
            .setPayload(qrCodePayload)
            .create();
        
        System.out.println("Pagamento realizado: " + payment.getId());
        
        // 3. Listar transações do dia
        ResourceSet<PixTransaction> transactions = PixTransaction.reader()
            .setStartDate(new Date())
            .read();
        
        System.out.println("\nTransações de hoje:");
        for (PixTransaction tx : transactions.getData()) {
            String tipo = tx.getType() == PixTransactionType.DEBIT ? "Enviado" : "Recebido";
            System.out.println(tipo + ": R$ " + tx.getValue());
        }
    }
}
```

## Boas Práticas

### 1. Valide Dados Antes de Enviar

```java
String cpf = "123.456.789-00";
String cpfLimpo = cpf.replaceAll("[^0-9]", "");

if (cpfLimpo.length() == 11) {
    Transfer transfer = Transfer.pixAddressKeyCreator()
        .setPixAddressKey(cpfLimpo)
        .setPixAddressKeyType(PixAddressKeyType.CPF)
        .setValue(Money.create(valor))
        .create();
}
```

### 2. Trate Erros Adequadamente

```java
try {
    Transfer transfer = Transfer.pixAddressKeyCreator()
        .setPixAddressKey("chave_invalida")
        .setPixAddressKeyType(PixAddressKeyType.CPF)
        .setValue(Money.create(new BigDecimal("100.00")))
        .create();
} catch (AsaasException e) {
    if (e.getMessage().contains("insufficient balance")) {
        System.err.println("Saldo insuficiente");
    } else if (e.getMessage().contains("invalid key")) {
        System.err.println("Chave PIX inválida");
    } else {
        System.err.println("Erro: " + e.getMessage());
    }
}
```

### 3. Confirme Valores Altos

```java
BigDecimal valor = new BigDecimal("5000.00");

if (valor.compareTo(new BigDecimal("1000.00")) > 0) {
    System.out.println("ATENÇÃO: Transferência de valor alto - R$ " + valor);
    // Solicitar confirmação adicional
}
```

### 4. Monitore Rate Limit

```java
Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("12345678900")
    .setPixAddressKeyType(PixAddressKeyType.CPF)
    .setValue(Money.create(new BigDecimal("100.00")))
    .create();

RateLimit rateLimit = transfer.getRateLimit();
System.out.println("Requisições restantes: " + rateLimit.getRemaining());
```

## Limitações

- Valor mínimo: R$ 0,01
- Valor máximo: Depende do limite da sua conta
- Horário: 24/7 (PIX funciona todos os dias)
- Tempo de processamento: Instantâneo (até 10 segundos)
- Cancelamento: Apenas para transações pendentes ou agendadas

## Veja Também

- [PIX - QR Code e Chaves](pix_dict.md) - Gerenciar chaves e QR codes
- [PIX Automático](pix_automatic.md) - Débito recorrente via PIX
- [Transferências](transfer.md) - TED e transferências internas

## Referências

- [Documentação Oficial - PIX](https://docs.asaas.com/reference/pix)
- [Banco Central - PIX](https://www.bcb.gov.br/estabilidadefinanceira/pix)
