## Sandbox
You can use the sandbox environment to test your integration. To do this, you need to call the `initSandbox` method before making any requests.
```java
Asaas.initSandbox("your_api_key");
```

## Timeout

The default timeout is 30000 milliseconds. You can change it by calling the `setTimeout` method.
```java
Asaas.setTimeout(10000);
```

## Rate Limit

Possuímos limites de solicitações em certos endpoints onde o abuso pode de certa forma comprometer o desempenho e o uso das APIs do Asaas. Medimos as requisições e podemos restringi-las quando a quantidade permitida é ultrapassada.

Você pode verificar o status nos cabeçalhos de resposta após uma requisição:
```java
Transfer transfer = Transfer.pixAddressKeyCreator()
        .setPixAddressKey("PIX_KEY")
        .setValue(Money.create(0.01))
        .setDescription("teste")
        .setPixAddressKeyType(PixAddressKeyType.CPF)
        .create();

transfer.getRateLimit(); // Here you can get the rate limit of the last request
```