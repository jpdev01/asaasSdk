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