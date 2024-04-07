## Criar um QR Code Pix estático
```java
PixQrCode qrCode = PixQrCode
        .creator()
        .setAddressKey("SUA_CHAVE_PIX")
        .setDescription("teste")
        .setValue(new BigDecimal("0.01")).create();
```

## Cancelar uma transação Pix

Para cancelar uma transação Pix, você deve informar o id da transação Pix que deseja cancelar.

```java
PixTransaction cancelledPixTransaction = PixTransaction
                .canceller("35363f6e-93e2-11ec-b9d9-96f4053b1bd4")
                .create();
```

## Decodificar um QR Code Pix
```java
PixDecodedQrCode decodedQrCode = PixDecodedQrCode.decoder()
                        .setPayload("payload")
                        .create();
```

## Recuperar chaves Pix ativas
```java
ResourceSet<PixAddressKey> pixAddressKeyList = PixAddressKey.reader()
                .setStatus(PixAddressKeyStatus.ACTIVE)
                .read();
```