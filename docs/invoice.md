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