## Criar cobrança
```java
Payment payment = Payment.creator()
                .setCustomer("cus_000050606806")
                .setBillingType(BillingType.PIX)
                .setDueDate(new Date())
                .setValue(Money.create(new BigDecimal(10.01)))
                .setDescription("Teste")
                .create();
```

## Criar uma cobrança parcelada
```java
Payment payment = Payment.creator()
                .setCustomer("cus_000072683114")
                .setBillingType(BillingType.PIX)
                .setDueDate(new Date())
                .setInstallmentCount(2)
                .setInstallmentValue(Money.create(50))
                .setDescription("Teste")
                .create();
```

## Estornar uma cobrança recebida

Para estornar uma cobrança de forma total:
```java
Payment.refunder(paymentId)
        .create();
```

Para estornar parcialmente, informe o valor a ser estornado:
```java
Payment.refunder(266093389L).setValue(new BigDecimal("10.0")).create();
```

## Recuperar cobranças
```java
ResourceSet<Payment> paymentResourceSet = Payment.reader().read();
```
Filtros também podem ser utilizados:
```java
ResourceSet<Payment> paymentResourceSet = Payment.reader()
                .setStatus(PaymentStatus.RECEIVED)
                .read();
```
Filtrando pela data de vencimento:
```java
ResourceSet<Payment> paymentResourceSet = Payment.reader()
                .setStatus(PaymentStatus.RECEIVED)
                .setStartPaymentDate(new Date())
                .setFinishDueDate(new Date())
                .read()
```

## Recuperar status cobrança
```java
Payment.statusFetcher("ID").fetch();
```
Exemplo:
```java
PaymentStatusData paymentStatusData = Payment.statusFetcher("pay_9087711026766517").fetch();
```

## Remover cobrança
```java
PaymentDeleted paymentDeleted = Payment.deleter(payment.getId()).delete();
```

## Resgatar cobrança deletada
```java
Payment payment = Payment.restorer(payment.getId()).create();
```

## Relacionados
- [Cobrança com Split](payment_split.md)