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

```java
Payment.refunder(paymentId)
        .setValue(new BigDecimal("valor"))
        .create();
```