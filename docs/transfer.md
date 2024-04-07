## Recuperar transferências
```java
ResourceSet<Transfer> transferList = Transfer.reader().read();
```

## Criar transferência TED
```java
BankAccountSetting bankAccountSetting = new BankAccountSetting()
                .setBank(new BankSetting().setCode("085"))
                .setAccountName("Paulo")
                .setOwnerName("Paulo")
                .setOwnerBirthDate(new Date())
                .setCpfCnpj("06928316000124")
                .setAgency("0108")
                .setAccount("10895")
                .setAccountDigit("5")
                .setBankAccountType(BankAccountType.CONTA_CORRENTE);

Transfer ted = Transfer.tedCreator()
                .setBankAccount(bankAccountSetting)
                .setValue(Money.create(new BigDecimal(1.01)))
                .create();
```

## Transferir entre contas Asaas
Só é possível fazer transferência entre contas Asaas para contas que possuam vínculo entre si, como conta raiz e subconta, ou duas subcontas de mesma conta raiz.

```java
Transfer internal = Transfer.internalCreator()
                .setValue(Money.create(new BigDecimal(10)))Só é possível fazer transferência entre contas Asaas para contas que possuam vínculo entre si, como conta raiz e subconta, ou duas subcontas de mesma conta raiz.
                .setWalletId("0021c712-d963-4d86-a59d-031e7ac51a2e")
                .create();
```

## Recuperar transferência por id

```java
Transfer transfer = Transfer.fetcher("transfer_id").fetch();
```