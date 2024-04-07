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

## Listar assinaturas
    
```java
ResourceSet<Subscription> subscriptionResourceSet = Subscription.reader().read();
```

Também é possível utilizar filtros

```java
ResourceSet<Subscription> subscriptionResourceSet = Subscription.reader()
                .setStatus(SubscriptionStatus.ACTIVE)
                .read();

ResourceSet<Subscription> subscriptionResourceSet = Subscription.reader()
                .setCustomer("cus_000072683044")
                .setStatus(SubscriptionStatus.ACTIVE)
                .read();
```