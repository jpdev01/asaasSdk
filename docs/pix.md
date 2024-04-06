## Criar um QR Code Pix estático
```java
PixQrCode qrCode = PixQrCode
        .creator()
        .setAddressKey("SUA_CHAVE_PIX")
        .setDescription("teste")
        .setValue(new BigDecimal("0.01")).create();
```

## Recuperar informações de uma transação Pix
```java
PixTransaction pixTransaction = PixTransaction.fetcher("PIX_TRANSACTION_ID").fetch()
```
Exemplo:
```java
PixTransaction pixTransaction = PixTransaction.fetcher("bc515f74-d5c7-4bc2-93e5-3bafc0a9b15d").fetch()
```

## Criar uma transação Pix
### Via chave
```java
Transfer transfer = Transfer.pixAddressKeyCreator()
        .setPixAddressKey("CHAVE")
        .setValue(Money.create(new BigDecimal(0.01)))
        .setDescription("teste")
        .setPixAddressKeyType(PixAddressKeyType.CPF)
        .create();
```
### Via dados bancários
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
Transfer transfer = Transfer.pixManualCreator()
        .setBankAccount(bankAccountSetting)
        .setValue(Money.create(new BigDecimal(1.01)))
        .create();
```

## Cancelar uma transação Pix

Para cancelar uma transação Pix, você deve informar o id da transação Pix que deseja cancelar.

```java
PixTransaction cancelledPixTransaction = PixTransaction
                .canceller("35363f6e-93e2-11ec-b9d9-96f4053b1bd4")
                .create();
```

## Decodificar um QR Code Pix
```
PixDecodedQrCode decodedQrCode = PixDecodedQrCode.decoder()
                        .setPayload("payload")
                        .create();
```

## Listar transações Pix
```java
ResourceSet<PixTransaction> pixTransactionResourceSet = PixTransaction.reader().read();
```

Também é possível utilizar filtros

```java
ResourceSet<PixTransaction> pixTransactionResourceSet = PixTransaction.reader()
                .setType(PixTransactionType.DEBIT)
                .read();
```

## Recuperar chaves Pix ativas
```java
ResourceSet<PixAddressKey> pixAddressKeyList = PixAddressKey.reader()
                .setStatus(PixAddressKeyStatus.ACTIVE)
                .read();
```