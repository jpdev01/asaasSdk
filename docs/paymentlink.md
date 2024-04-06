## Criar um link de pagamento
```java
PaymentLink paymentLink = PaymentLink.creator()
        .setName("name")
        .setBillingType(BillingType.PIX)
        .setChargeType(PaymentLinkChargeType.INSTALLMENT)
        .setEndDate(new Date())
        .setDueDateLimitDays(10)
        .setMaxInstallmentCount(2)
        .create();
```

## Atualizar Link de pagamento
```java
PaymentLink updated = PaymentLink.updater(paymentLink.getId())
               .setName("name")
               .setBillingType(BillingType.PIX)
               .setChargeType(PaymentLinkChargeType.INSTALLMENT)
               .setEndDate(new Date())
               .setDueDateLimitDays(10)
               .setMaxInstallmentCount(2)
               .update();
```

## Deletar um link de pagamento
```java
DeletedResource deletedPaymentLink = PaymentLink
                .deleter("725104409743")
                .delete();
```

## Listar links de pagamento
```java
ResourceSet<PaymentLink> paymentLinkResourceSet = PaymentLink
                .reader()
                .read();
```

## Recuperar um link de pagamento
```java
PaymentLink link = PaymentLink.fetcher("725104409743").fetch();
```