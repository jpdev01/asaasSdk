This SDK was built by [@jpdev01](https://github.com/jpdev01) to facilitate the development of integrations with https://asaas.com.br

## Hot to use the SDK

The recommended way to use the AWS SDK for Java in your project is to consume it from Maven Central. (includes all modules present in the API).
```xml
<dependency>
    <groupId>io.github.jpdev01</groupId>
    <artifactId>asaassdk</artifactId>
    <version>1.2-SNAPSHOT</version>
</dependency>
```

## Scheduling invoice
```java
Invoice invoice = Invoice.creator()
                .setServiceDescription("Nota fiscal da Fatura 101940. Descrição dos Serviços: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS")
                .setObservations("Mensal referente aos trabalhos de Junho.")
                .setValue(Money.create(300))
                .setDeductions(Money.create(2))
                .setEffectiveDate(new Date())
                .setMunicipalServiceName("Análise e Desenvolvimento de Sistemas")
                .setTaxes(
                        new Taxes()
                                .setRetainIss(true)
                                .setIss(Money.create(3))
                                .setCofins(Money.create(3))
                                .setCsll(Money.create(1))
                                .setInss(Money.create(3))
                                .setIr(Money.create(1.5))
                                .setPis(Money.create(0.65))
                )
                .create();
```
== teste