# Pix Automático

## Autorizações

### Criar autorização Pix Automático

```java
/*
    any date
 */
Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.DAY_OF_MONTH, 1);
Date startDate = calendar.getTime();

ImmediateQrCodeCreator immediateQrCodeCreator = new ImmediateQrCodeCreator()
    .setDescription("teste")
    .setExpirationSeconds(3600)
    .setOriginalValue(Money.create(10));

PixAutomaticAuthorization authorization = PixAutomaticAuthorization.creator()
    .setCustomerId("cus_000007258649") // your customer_id
    .setStartDate(startDate)
    .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
    .setValue(Money.create(100))
    .setContractId("CONTRACT_ID_123")
    .setImmediateQrCode(immediateQrCodeCreator)
    .create();
```

### Listar autorizações Pix Automático

```java
ResourceSet<PixAutomaticAuthorization> authorizationResourceSet = PixAutomaticAuthorization.reader().read();

for (PixAutomaticAuthorization authorization : authorizationResourceSet.getData()) {
    System.out.println(authorization.getContractId());
}
```

### Recuperar uma autorização do Pix Automático

```java
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.PixAutomaticAuthorization;

String id = "uuidv4";
PixAutomaticAuthorization authorization = PixAutomaticAuthorization.fetcher(id).fetch();
```

### Cancelar autorização

```java
String id = "uuidv4";

PixAutomaticAuthorization cancelledAuthorization = PixAutomaticAuthorization
    .deleter("AUTHORIZATION_ID")
    .delete();
```

## Instruções de Pagamento

### Criar instrução de pagamento

```java
Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.DAY_OF_MONTH, 3); // any date

String activeAuthorizationId = "uuidv4";

Payment payment = Payment.creator()
    .setCustomer("cus_000007258649") // your customer_id
    .setBillingType(BillingType.PIX)
    .setDueDate(calendar.getTime())
    .setValue(Money.create(100))
    .setDescription("Test")
    .setPixAutomaticAuthorizationId(activeAuthorizationId)
    .create();
```

### Listar instruções de pagamento

```java
ResourceSet<PixAutomaticPaymentInstruction> paymentInstructionResourceSet = PixAutomaticPaymentInstruction
    .reader()
    .read();

for (PixAutomaticPaymentInstruction instruction : paymentInstructionResourceSet.getData()) {
    System.out.println(instruction.getId());
    System.out.println(instruction.getDueDate());
}
```

### Recuperar instrução de pagamento específica

```java
String id = "uuidv4";

PixAutomaticPaymentInstruction paymentInstruction = PixAutomaticPaymentInstruction
    .fetcher(id)
    .fetch();
```
