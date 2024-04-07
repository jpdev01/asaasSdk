## Criar uma assinatura

Ao criar a assinatura a primeira mensalidade será gerada vencendo na data enviada no parâmetro nextDueDate.

```java
Subscription subscription = Subscription.creator()
                .setCustomer("cus_000072683044")
                .setBillingType(BillingType.BOLETO)
                .setNextDueDate(new Date())
                .setValue(Money.create(50))
                .setCycle(SubscriptionCycle.MONTHLY)
                .setDescription("Assinatura Plano Pró")
                .create();
```