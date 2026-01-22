## ⚙️ Configuração

### Timeout

Configure o timeout das requisições (padrão: 30000ms):

```java
Asaas.setTimeout(10000); // 10 segundos
```

### Rate Limit

Verifique os limites de requisição após cada chamada:

```java
Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("sua_chave_pix")
    .setValue(Money.create(10.00))
    .setPixAddressKeyType(PixAddressKeyType.CPF)
    .create();

RateLimit rateLimit = transfer.getRateLimit();
System.out.println("Requisições restantes: " + rateLimit.getRemaining());
```
