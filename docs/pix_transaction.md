## Recuperar informações de uma transação Pix
```java
PixTransaction pixTransaction = PixTransaction.fetcher("PIX_TRANSACTION_ID").fetch();
```
Exemplo utilizando Identificador fim a fim:
```java
PixTransaction pixTransaction = PixTransaction.fetcher("E18236120202302141342s15536c561e").fetch();
```
Exemplo utilizando Identificador ID:
```java
PixTransaction pixTransaction = PixTransaction.fetcher("bc515f74-d5c7-4bc2-93e5-3bafc0a9b15d").fetch();
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

## Pagar um QR Code Pix
```java
final String examplePayload = "00020101021226730014br.gov.bcb.pix2551pix-h.asaas.com/pixqrcode/cobv/pay_76575613967995145204000053039865802BR5905ASAAS6009Joinville61088922827162070503***63045E7A";
PixTransaction pixTransactionQrCodeCreator = PixTransaction
        .qrCodeCreator()
        .setPayload(examplePayload)
        .setValue(Money.create(new BigDecimal(10.0)))
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