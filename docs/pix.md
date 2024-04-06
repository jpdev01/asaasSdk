## Cancelar uma transação Pix

Para cancelar uma transação Pix, você deve informar o id da transação Pix que deseja cancelar.

```java
PixTransaction cancelledPixTransaction = PixTransaction
                .canceller("35363f6e-93e2-11ec-b9d9-96f4053b1bd4")
                .create();
```