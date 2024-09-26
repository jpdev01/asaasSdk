This SDK was built by [@jpdev01](https://github.com/jpdev01) to facilitate the development of integrations with [Asaas](https://asaas.com.br)

## Installation

The recommended way to use the AWS SDK for Java in your project is to consume it from Maven Central. (includes all modules present in the API).
```xml
<dependency>
    <groupId>io.github.jpdev01</groupId>
    <artifactId>asaassdk</artifactId>
    <version>1.5-SNAPSHOT</version>
</dependency>
```

Before making any requests, you need to call the `init` method using your API key (just once)
```java
Asaas.init("your_api_key");
```

The API official documentation can be found [here](https://docs.asaas.com/docs/visao-geral)

## Documentation

- [Pix - QR Code e Chaves](pix_dict.md)
- [Pix - Transações](pix_dict.md)
- [Cobrança](payment.md)
- [Clientes](customeraccount.md)
- [Pague contas](bill.md)
- [Dados comerciais](commercialinfo.md)
- [Link de pagamento](paymentlink.md)
- [Status da conta](myaccount.md)
- [Sub conta](account.md)
- [Taxas](accountfee.md)
- [Número de conta](accountnumber.md)
- [Extrato](financial.md)
- [Saldo](balance.md)
- [Parcelamento](installment.md)
- [Transferência](transfer.md)
- [Notificações](notification.md)
- [Nota fiscal](invoice.md)
- [Assinaturas](subscription.md)
- [Webhooks](webhook.md)

## Extra

- [Configurações extras](extra.md)
- [Exemples](https://github.com/jpdev01/asaasSdk/blob/master/src/main/java/io/github/jpdev/asaassdk/doc/Examples.java)
- [Rate Limit](ratelimit.md)
- [Repositório](https://s01.oss.sonatype.org/content/repositories/snapshots/io/github/jpdev01/asaassdk/)