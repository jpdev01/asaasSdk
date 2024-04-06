## Criar subconta
```java
Account account = Account.creator()
                .setName("Teste sub conta")
                .setBirthDate(new Date())
                .setCompanyType("LIMITED")
                .setEmail("joaoexample2@gmail.com")
                .setPostalCode("36572122")
                .setCpfCnpj("87.326.705/0001-81")
                .create();
```

## Recuperar subconta
```java
Account.fetcher(account.id).fetch();
```