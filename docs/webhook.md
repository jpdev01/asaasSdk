## Configurando um webhook

```java
Webhook configuredWebhook = Webhook.creator()
        .setName("Teste")
        .setUrl("https://www.exemplo.com/webhook/asaas")
        .setEmail("joe@gmail.com")
        .setSendType(SendType.SEQUENTIALLY)
        .addEvent(Event.PAYMENT_RECEIVED)
        .create();
```

## Listar configurações de webhook

```java
ResourceSet<Webhook> webhookResourceSet = Webhook.reader().read();
```