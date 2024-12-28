## Criar cobrança com split
```java
SplitSetting split1 = new SplitSetting()
        .setWalletId("635b5330-3931-4ab2-b78c-3c59f136c535")
        .setFixedValue(Money.create(10));

Payment payment = Payment.creator()
                .setCustomer("cus_000050606806")
                .setBillingType(BillingType.PIX)
                .setDueDate(new Date())
                .setValue(Money.create(new BigDecimal(10.01)))
                .setDescription("Teste")
                .addSplit(split1)
                .create();
```

É possível adicionar mais splits para carteiras diferentes:
```java
.addSplit(split1)
.addSplit(split1);
```

## Listar splits pagos
```java
PaymentSplitPaidReader reader = Split.paidReader()
reader.read();
```

## Listar splits recebidos
```java
PaymentSplitReceivedReader reader = Split.receivedReader()
reader.read();
```