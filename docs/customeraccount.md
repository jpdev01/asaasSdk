## Criar cliente

Para criar um cliente, utilize CustomerAccount
    
```java
CustomerAccount customerAccount = CustomerAccount.creator()
                .setName("criado via API")
                .setCpfCnpj("10030823005")
                .create();
```

## Recuperar cliente
```java
CustomerAccount customerAccount = CustomerAccount.fetcher("cus_xxxxxxxxxx").fetch();
```