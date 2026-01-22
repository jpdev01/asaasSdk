# Cobranças (Payments)

Gerencie cobranças de forma simples e eficiente. O Asaas suporta múltiplas formas de pagamento: PIX, Boleto e Cartão de Crédito.

## 📋 Índice

- [Criar Cobrança](#criar-cobrança)
- [Criar Cobrança Parcelada](#criar-cobrança-parcelada)
- [Listar Cobranças](#listar-cobranças)
- [Recuperar Cobrança](#recuperar-cobrança)
- [Verificar Status](#verificar-status)
- [Estornar Cobrança](#estornar-cobrança)
- [Deletar Cobrança](#deletar-cobrança)
- [Restaurar Cobrança](#restaurar-cobrança)

## Criar Cobrança

### Cobrança PIX

```java
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.PIX)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.50")))
    .setDescription("Pagamento de serviço")
    .create();

System.out.println("ID da cobrança: " + payment.getId());
System.out.println("QR Code PIX: " + payment.getPixQrCode());
```

### Cobrança Boleto

```java
Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.BOLETO)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("250.00")))
    .setDescription("Mensalidade")
    .create();

System.out.println("Link do boleto: " + payment.getBankSlipUrl());
```

### Cobrança Cartão de Crédito

```java
Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.CREDIT_CARD)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("150.00")))
    .setDescription("Compra de produto")
    .create();
```

### Cobrança com Desconto

```java
Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.PIX)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Pagamento com desconto")
    .setDiscount(Money.create(new BigDecimal("10.00")))
    .create();
```

### Cobrança com Juros e Multa

```java
Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.BOLETO)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("500.00")))
    .setDescription("Mensalidade")
    .setInterest(Money.create(new BigDecimal("2.00"))) // Juros por dia
    .setFine(Money.create(new BigDecimal("10.00"))) // Multa
    .create();
```

## Criar Cobrança Parcelada

Crie cobranças divididas em múltiplas parcelas:

```java
Payment payment = Payment.creator()
    .setCustomer("cus_000072683114")
    .setBillingType(BillingType.CREDIT_CARD)
    .setDueDate(new Date())
    .setInstallmentCount(3) // 3 parcelas
    .setInstallmentValue(Money.create(new BigDecimal("50.00"))) // R$ 50,00 cada
    .setDescription("Compra parcelada")
    .create();

System.out.println("Total: R$ 150,00 em 3x de R$ 50,00");
```

## Listar Cobranças

### Listar Todas

```java
import io.github.jpdev.asaassdk.rest.payment.ResourceSet;

ResourceSet<Payment> payments = Payment.reader().read();

for (Payment payment : payments.getData()) {
    System.out.println("ID: " + payment.getId());
    System.out.println("Valor: " + payment.getValue());
    System.out.println("Status: " + payment.getStatus());
    System.out.println("---");
}
```

### Filtrar por Status

```java
import io.github.jpdev.asaassdk.enums.PaymentStatus;

ResourceSet<Payment> payments = Payment.reader()
    .setStatus(PaymentStatus.RECEIVED)
    .read();
```

### Filtrar por Data de Vencimento

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.set(2024, Calendar.JANUARY, 1);
Date dataInicio = cal.getTime();

cal.set(2024, Calendar.DECEMBER, 31);
Date dataFim = cal.getTime();

ResourceSet<Payment> payments = Payment.reader()
    .setStartDueDate(dataInicio)
    .setFinishDueDate(dataFim)
    .read();
```

### Filtrar por Data de Pagamento

```java
ResourceSet<Payment> payments = Payment.reader()
    .setStatus(PaymentStatus.RECEIVED)
    .setStartPaymentDate(dataInicio)
    .setFinishPaymentDate(dataFim)
    .read();
```

### Filtrar por Cliente

```java
ResourceSet<Payment> payments = Payment.reader()
    .setCustomer("cus_000050606806")
    .read();
```

### Paginação

```java
ResourceSet<Payment> payments = Payment.reader()
    .setLimit(50) // 50 registros por página
    .setOffset(0) // Página inicial
    .read();

System.out.println("Total de cobranças: " + payments.getTotalCount());
System.out.println("Tem próxima página: " + payments.hasMore());
```

## Recuperar Cobrança

Busque uma cobrança específica pelo ID:

```java
Payment payment = Payment.fetcher("pay_123456789").fetch();

System.out.println("Cliente: " + payment.getCustomer());
System.out.println("Valor: " + payment.getValue());
System.out.println("Status: " + payment.getStatus());
System.out.println("Data de vencimento: " + payment.getDueDate());
```

## Verificar Status

Consulte apenas o status de uma cobrança:

```java
import io.github.jpdev.asaassdk.rest.payment.PaymentStatusData;

PaymentStatusData status = Payment.statusFetcher("pay_9087711026766517").fetch();

System.out.println("Status: " + status.getStatus());
System.out.println("Pago em: " + status.getPaymentDate());
```

## Estornar Cobrança

### Estorno Total

```java
import io.github.jpdev.asaassdk.rest.payment.PaymentRefund;

PaymentRefund refund = Payment.refunder("pay_123456789")
    .create();

System.out.println("Estorno realizado: " + refund.getId());
System.out.println("Valor estornado: " + refund.getValue());
```

### Estorno Parcial

```java
PaymentRefund refund = Payment.refunder("pay_123456789")
    .setValue(new BigDecimal("50.00")) // Estornar apenas R$ 50,00
    .create();

System.out.println("Estorno parcial de R$ 50,00 realizado");
```

### Estorno com Descrição

```java
PaymentRefund refund = Payment.refunder("pay_123456789")
    .setDescription("Produto com defeito")
    .create();
```

## Deletar Cobrança

Delete uma cobrança que ainda não foi paga:

```java
import io.github.jpdev.asaassdk.rest.payment.PaymentDeleted;

PaymentDeleted deleted = Payment.deleter("pay_123456789").delete();

if (deleted.isDeleted()) {
    System.out.println("Cobrança deletada com sucesso");
}
```

**Nota**: Apenas cobranças com status `PENDING` podem ser deletadas.

## Restaurar Cobrança

Restaure uma cobrança que foi deletada:

```java
Payment payment = Payment.restorer("pay_123456789").create();

System.out.println("Cobrança restaurada: " + payment.getId());
System.out.println("Status atual: " + payment.getStatus());
```

## Status de Cobranças

| Status | Descrição |
|--------|-----------|
| `PENDING` | Aguardando pagamento |
| `RECEIVED` | Pagamento recebido |
| `CONFIRMED` | Pagamento confirmado |
| `OVERDUE` | Vencida |
| `REFUNDED` | Estornada |
| `RECEIVED_IN_CASH` | Recebida em dinheiro |
| `REFUND_REQUESTED` | Estorno solicitado |
| `CHARGEBACK_REQUESTED` | Chargeback solicitado |
| `CHARGEBACK_DISPUTE` | Disputa de chargeback |
| `AWAITING_CHARGEBACK_REVERSAL` | Aguardando reversão de chargeback |
| `DUNNING_REQUESTED` | Negativação solicitada |
| `DUNNING_RECEIVED` | Negativação confirmada |
| `AWAITING_RISK_ANALYSIS` | Aguardando análise de risco |

## Tipos de Cobrança

| Tipo | Descrição |
|------|-----------|
| `BillingType.PIX` | Pagamento via PIX |
| `BillingType.BOLETO` | Boleto bancário |
| `BillingType.CREDIT_CARD` | Cartão de crédito |
| `BillingType.DEBIT_CARD` | Cartão de débito |
| `BillingType.UNDEFINED` | Não definido (cliente escolhe) |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

public class ExemploCobranca {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Criar cliente
        CustomerAccount cliente = CustomerAccount.creator()
            .setName("Maria Silva")
            .setCpfCnpj("12345678900")
            .setEmail("maria@exemplo.com")
            .create();
        
        // Criar cobrança PIX
        Payment cobranca = Payment.creator()
            .setCustomer(cliente.getId())
            .setBillingType(BillingType.PIX)
            .setDueDate(new Date())
            .setValue(Money.create(new BigDecimal("150.00")))
            .setDescription("Pagamento de serviço")
            .create();
        
        System.out.println("Cobrança criada com sucesso!");
        System.out.println("ID: " + cobranca.getId());
        System.out.println("QR Code: " + cobranca.getPixQrCode());
        System.out.println("Valor: R$ " + cobranca.getValue());
    }
}
```

## Veja Também

- [Cobranças com Split](payment_split.md) - Dividir pagamentos entre múltiplas contas
- [Assinaturas](subscription.md) - Cobranças recorrentes
- [Links de Pagamento](paymentlink.md) - Criar páginas de checkout
- [Clientes](customeraccount.md) - Gerenciar clientes

## Referências

- [Documentação Oficial - Cobranças](https://docs.asaas.com/reference/criar-nova-cobranca)
