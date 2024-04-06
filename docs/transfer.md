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