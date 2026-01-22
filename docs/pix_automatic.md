# PIX Automático (Débito Recorrente)

Configure débitos recorrentes via PIX. Ideal para assinaturas, mensalidades e pagamentos automáticos.

## 📋 Índice

- [Autorizações](#autorizações)
- [Instruções de Pagamento](#instruções-de-pagamento)
- [Gerenciar Autorizações](#gerenciar-autorizações)
- [Casos de Uso](#casos-de-uso)

## Autorizações

### Criar Autorização

```java
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.PixAutomaticAuthorization;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.ImmediateQrCodeCreator;
import io.github.jpdev.asaassdk.enums.PixAutomaticAuthorizationFrequency;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

// Data de início
Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.DAY_OF_MONTH, 1);
Date startDate = calendar.getTime();

// QR Code para autorização
ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
    .setDescription("Autorização PIX Automático")
    .setExpirationSeconds(3600) // 1 hora
    .setOriginalValue(Money.create(new BigDecimal("0.01"))); // Valor simbólico

// Criar autorização
PixAutomaticAuthorization authorization = PixAutomaticAuthorization.creator()
    .setCustomerId("cus_000007258649")
    .setStartDate(startDate)
    .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
    .setValue(Money.create(new BigDecimal("99.90")))
    .setContractId("CONTRATO_123")
    .setImmediateQrCode(qrCode)
    .create();

System.out.println("Autorização criada: " + authorization.getId());
System.out.println("QR Code: " + authorization.getQrCode());
System.out.println("Status: " + authorization.getStatus());
```

### Autorização Mensal

```java
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 1);

ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
    .setDescription("Mensalidade")
    .setExpirationSeconds(3600)
    .setOriginalValue(Money.create(new BigDecimal("0.01")));

PixAutomaticAuthorization auth = PixAutomaticAuthorization.creator()
    .setCustomerId("cus_000007258649")
    .setStartDate(cal.getTime())
    .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
    .setValue(Money.create(new BigDecimal("150.00")))
    .setContractId("MENSALIDADE_2024")
    .setImmediateQrCode(qrCode)
    .create();

System.out.println("Débito mensal de R$ 150,00 autorizado");
```

### Autorização Semanal

```java
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 1);

ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
    .setDescription("Pagamento semanal")
    .setExpirationSeconds(3600)
    .setOriginalValue(Money.create(new BigDecimal("0.01")));

PixAutomaticAuthorization auth = PixAutomaticAuthorization.creator()
    .setCustomerId("cus_000007258649")
    .setStartDate(cal.getTime())
    .setFrequency(PixAutomaticAuthorizationFrequency.WEEKLY)
    .setValue(Money.create(new BigDecimal("50.00")))
    .setContractId("SEMANAL_123")
    .setImmediateQrCode(qrCode)
    .create();

System.out.println("Débito semanal de R$ 50,00 autorizado");
```

## Listar Autorizações

### Listar Todas

```java
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.ResourceSet;

ResourceSet<PixAutomaticAuthorization> autorizacoes = PixAutomaticAuthorization.reader().read();

for (PixAutomaticAuthorization auth : autorizacoes.getData()) {
    System.out.println("ID: " + auth.getId());
    System.out.println("Cliente: " + auth.getCustomerId());
    System.out.println("Valor: R$ " + auth.getValue());
    System.out.println("Frequência: " + auth.getFrequency());
    System.out.println("Status: " + auth.getStatus());
    System.out.println("Contrato: " + auth.getContractId());
    System.out.println("---");
}
```

## Recuperar Autorização

```java
String authId = "uuid-da-autorizacao";

PixAutomaticAuthorization auth = PixAutomaticAuthorization.fetcher(authId).fetch();

System.out.println("=== AUTORIZAÇÃO ===");
System.out.println("ID: " + auth.getId());
System.out.println("Cliente: " + auth.getCustomerId());
System.out.println("Valor: R$ " + auth.getValue());
System.out.println("Frequência: " + auth.getFrequency());
System.out.println("Data início: " + auth.getStartDate());
System.out.println("Status: " + auth.getStatus());
System.out.println("Contrato: " + auth.getContractId());
```

## Cancelar Autorização

```java
String authId = "uuid-da-autorizacao";

PixAutomaticAuthorization cancelada = PixAutomaticAuthorization.deleter(authId).delete();

if (cancelada.getStatus().equals("CANCELLED")) {
    System.out.println("Autorização cancelada com sucesso");
}
```

## Instruções de Pagamento

### Criar Instrução

```java
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.enums.BillingType;

Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 3);

String authorizationId = "uuid-autorizacao-ativa";

Payment payment = Payment.creator()
    .setCustomer("cus_000007258649")
    .setBillingType(BillingType.PIX)
    .setDueDate(cal.getTime())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setDescription("Mensalidade")
    .setPixAutomaticAuthorizationId(authorizationId)
    .create();

System.out.println("Instrução de pagamento criada: " + payment.getId());
System.out.println("Será debitado automaticamente em: " + payment.getDueDate());
```

### Listar Instruções

```java
import io.github.jpdev.asaassdk.rest.pixautomatic.paymentinstruction.PixAutomaticPaymentInstruction;
import io.github.jpdev.asaassdk.rest.pixautomatic.paymentinstruction.ResourceSet;

ResourceSet<PixAutomaticPaymentInstruction> instrucoes = PixAutomaticPaymentInstruction.reader().read();

for (PixAutomaticPaymentInstruction inst : instrucoes.getData()) {
    System.out.println("ID: " + inst.getId());
    System.out.println("Valor: R$ " + inst.getValue());
    System.out.println("Data: " + inst.getDueDate());
    System.out.println("Status: " + inst.getStatus());
    System.out.println("---");
}
```

### Recuperar Instrução

```java
String instructionId = "uuid-instrucao";

PixAutomaticPaymentInstruction inst = PixAutomaticPaymentInstruction.fetcher(instructionId).fetch();

System.out.println("Instrução: " + inst.getId());
System.out.println("Valor: R$ " + inst.getValue());
System.out.println("Data de débito: " + inst.getDueDate());
System.out.println("Status: " + inst.getStatus());
```

## Casos de Uso

### Assinatura Mensal

```java
public class AssinaturaPixAutomatico {

    public static PixAutomaticAuthorization criarAssinatura(
        String clienteId,
        double valorMensal,
        String contratoId
    ) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
            .setDescription("Autorização de assinatura")
            .setExpirationSeconds(3600)
            .setOriginalValue(Money.create(new BigDecimal("0.01")));

        PixAutomaticAuthorization auth = PixAutomaticAuthorization.creator()
            .setCustomerId(clienteId)
            .setStartDate(cal.getTime())
            .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
            .setValue(Money.create(new BigDecimal(valorMensal)))
            .setContractId(contratoId)
            .setImmediateQrCode(qrCode)
            .create();

        System.out.println("Assinatura criada:");
        System.out.println("Valor mensal: R$ " + valorMensal);
        System.out.println("QR Code para autorização: " + auth.getQrCode());

        return auth;
    }

    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        criarAssinatura("cus_cliente", 49.90, "PLANO_PREMIUM_2024");
    }
}
```

### Academia/Escola

```java
public class MensalidadeAutomatica {

    public static void configurarMensalidade(
        String alunoId,
        double valorMensalidade
    ) {
        // Criar autorização
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
            .setDescription("Autorização mensalidade")
            .setExpirationSeconds(3600)
            .setOriginalValue(Money.create(new BigDecimal("0.01")));

        PixAutomaticAuthorization auth = PixAutomaticAuthorization.creator()
            .setCustomerId(alunoId)
            .setStartDate(cal.getTime())
            .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
            .setValue(Money.create(new BigDecimal(valorMensalidade)))
            .setContractId("MENSALIDADE_" + alunoId)
            .setImmediateQrCode(qrCode)
            .create();

        System.out.println("Mensalidade configurada:");
        System.out.println("Aluno: " + alunoId);
        System.out.println("Valor: R$ " + valorMensalidade);
        System.out.println("Cliente deve escanear: " + auth.getQrCode());
    }
}
```

### Serviço de Streaming

```java
public class StreamingPixAutomatico {

    public static void criarPlano(
        String usuarioId,
        String nomePlano,
        double valorMensal
    ) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
            .setDescription("Plano " + nomePlano)
            .setExpirationSeconds(3600)
            .setOriginalValue(Money.create(new BigDecimal("0.01")));

        PixAutomaticAuthorization auth = PixAutomaticAuthorization.creator()
            .setCustomerId(usuarioId)
            .setStartDate(cal.getTime())
            .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
            .setValue(Money.create(new BigDecimal(valorMensal)))
            .setContractId("STREAMING_" + nomePlano + "_" + usuarioId)
            .setImmediateQrCode(qrCode)
            .create();

        System.out.println("Plano " + nomePlano + " configurado");
        System.out.println("Débito mensal: R$ " + valorMensal);
    }
}
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.*;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.enums.*;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Calendar;

public class ExemploPixAutomatico {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");

        String clienteId = "cus_000007258649";

        // 1. Criar autorização
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
            .setDescription("Autorização PIX Automático")
            .setExpirationSeconds(3600)
            .setOriginalValue(Money.create(new BigDecimal("0.01")));

        PixAutomaticAuthorization auth = PixAutomaticAuthorization.creator()
            .setCustomerId(clienteId)
            .setStartDate(cal.getTime())
            .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
            .setValue(Money.create(new BigDecimal("99.90")))
            .setContractId("CONTRATO_2024_001")
            .setImmediateQrCode(qrCode)
            .create();

        System.out.println("=== AUTORIZAÇÃO CRIADA ===");
        System.out.println("ID: " + auth.getId());
        System.out.println("Status: " + auth.getStatus());
        System.out.println("QR Code: " + auth.getQrCode());
        System.out.println("\nCliente deve escanear o QR Code para autorizar");

        // Aguardar autorização do cliente...
        // Quando status = ACTIVE, criar instruções de pagamento

        // 2. Criar instrução de pagamento
        cal.add(Calendar.DAY_OF_MONTH, 2);

        Payment payment = Payment.creator()
            .setCustomer(clienteId)
            .setBillingType(BillingType.PIX)
            .setDueDate(cal.getTime())
            .setValue(Money.create(new BigDecimal("99.90")))
            .setDescription("Mensalidade")
            .setPixAutomaticAuthorizationId(auth.getId())
            .create();

        System.out.println("\n=== INSTRUÇÃO DE PAGAMENTO ===");
        System.out.println("ID: " + payment.getId());
        System.out.println("Valor: R$ " + payment.getValue());
        System.out.println("Data de débito: " + payment.getDueDate());

        // 3. Listar autorizações
        ResourceSet<PixAutomaticAuthorization> autorizacoes = PixAutomaticAuthorization.reader()
            .setCustomerId(clienteId)
            .read();

        System.out.println("\nTotal de autorizações: " + autorizacoes.getTotalCount());
    }
}
```

## Fluxo de Autorização

```
1. Criar autorização → Gera QR Code
2. Cliente escaneia QR Code → Autoriza no app do banco
3. Status muda para ACTIVE
4. Criar instruções de pagamento
5. Débitos automáticos conforme frequência
```

## Boas Práticas

### 1. Valide Status Antes de Criar Instrução

```java
PixAutomaticAuthorization auth = PixAutomaticAuthorization.fetcher(authId).fetch();

if (auth.getStatus().equals("ACTIVE")) {
    // Criar instrução de pagamento
    Payment payment = Payment.creator()
        .setPixAutomaticAuthorizationId(authId)
        .create();
} else {
    System.err.println("Autorização não está ativa");
}
```

### 2. Configure Tempo de Expiração Adequado

```java
ImmediateQrCodeCreator qrCode = new ImmediateQrCodeCreator()
    .setDescription("Autorização")
    .setExpirationSeconds(7200) // 2 horas
    .setOriginalValue(Money.create(new BigDecimal("0.01")));
```

### 3. Use IDs de Contrato Únicos

```java
String contratoId = "CONTRATO_" + clienteId + "_" + System.currentTimeMillis();

PixAutomaticAuthorization auth = PixAutomaticAuthorization.creator()
    .setContractId(contratoId)
    .create();
```

### 4. Monitore Autorizações Expiradas

```java
ResourceSet<PixAutomaticAuthorization> expiradas = PixAutomaticAuthorization.reader()
    .setStatus(PixAutomaticAuthorizationStatus.EXPIRED)
    .read();

if (expiradas.getTotalCount() > 0) {
    System.out.println("⚠️ " + expiradas.getTotalCount() + " autorizações expiradas");
}
```

## Limitações

- Cliente precisa autorizar via QR Code no app do banco
- Valor máximo por transação: conforme limite do banco
- Frequência mínima: diária
- Autorização pode ser cancelada pelo cliente a qualquer momento

## Veja Também

- [PIX - Transações](pix_transaction.md) - Transações PIX manuais
- [Assinaturas](subscription.md) - Assinaturas via cartão
- [Cobranças](payment.md) - Criar cobranças

## Referências

- [Documentação Oficial - PIX Automático](https://docs.asaas.com/reference/pix-automatico)
- [Banco Central - PIX Automático](https://www.bcb.gov.br/estabilidadefinanceira/pix)
