## Criar um QR Code Pix estático
```java
PixQrCode qrCode = PixQrCode
        .creator()
        .setAddressKey("SUA_CHAVE_PIX")
        .setDescription("teste")
        .setValue(new BigDecimal("0.01")).create();
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