## Recuperar extrato
```java
ResourceSet<FinancialTransaction> financialTransactionResourceSet = FinancialTransaction
                .reader()
                .read();
```

Filtros também podem ser utilizados:
```java
ResourceSet<FinancialTransaction> financialTransactionResourceSet = FinancialTransaction
                .reader()
                .setTransferId("transferId")
                .read();
```