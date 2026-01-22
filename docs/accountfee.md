# Taxas da Conta (Account Fees)

Consulte as taxas aplicadas à sua conta Asaas. Entenda os custos de cada operação.

## 📋 Índice

- [Recuperar Taxas](#recuperar-taxas)
- [Tipos de Taxas](#tipos-de-taxas)
- [Exemplos de Cálculo](#exemplos-de-cálculo)

## Recuperar Taxas

```java
import io.github.jpdev.asaassdk.rest.accountfee.AccountFee;

AccountFee taxas = AccountFee.fetcher().fetch();

System.out.println("=== TAXAS DA CONTA ===");
System.out.println("\nPix:");
System.out.println("Taxa Pix: R$ " + taxas.getPixFee());

System.out.println("\nBoleto:");
System.out.println("Taxa Boleto: R$ " + taxas.getBankSlipFee());

System.out.println("\nCartão de Crédito:");
System.out.println("Taxa à vista: " + taxas.getCreditCardFee() + "%");
System.out.println("Taxa parcelado em 2x: " + taxas.getCreditCardFeeInstallment2() + "%");
System.out.println("Taxa parcelado em 3x: " + taxas.getCreditCardFeeInstallment3() + "%");

System.out.println("\nTransferências:");
System.out.println("Taxa TED: R$ " + taxas.getTransferFee());
System.out.println("Taxa Pix: R$ " + taxas.getPixTransferFee());
```

## Tipos de Taxas

### Recebimento

####

```java
AccountFee taxas = AccountFee.fetcher().fetch();

double taxaPix = taxas.getPixFee();
System.out.println("Taxa para receber via Pix: R$ " + taxaPix);

// Exemplo: Receber R$ 100,00 via Pix
double valorRecebido = 100.00;
double taxaCobrada = taxaPix;
double valorLiquido = valorRecebido - taxaCobrada;

System.out.println("Valor bruto: R$ " + valorRecebido);
System.out.println("Taxa: R$ " + taxaCobrada);
System.out.println("Valor líquido: R$ " + valorLiquido);
```

#### Boleto

```java
double taxaBoleto = taxas.getBankSlipFee();
System.out.println("Taxa para receber via Boleto: R$ " + taxaBoleto);

// Exemplo: Receber R$ 500,00 via Boleto
double valorRecebido = 500.00;
double taxaCobrada = taxaBoleto;
double valorLiquido = valorRecebido - taxaCobrada;

System.out.println("Valor bruto: R$ " + valorRecebido);
System.out.println("Taxa: R$ " + taxaCobrada);
System.out.println("Valor líquido: R$ " + valorLiquido);
```

#### Cartão de Crédito

```java
// À vista
double taxaCartaoVista = taxas.getCreditCardFee();
System.out.println("Taxa cartão à vista: " + taxaCartaoVista + "%");

// Parcelado em 2x
double taxaCartao2x = taxas.getCreditCardFeeInstallment2();
System.out.println("Taxa cartão 2x: " + taxaCartao2x + "%");

// Parcelado em 3x
double taxaCartao3x = taxas.getCreditCardFeeInstallment3();
System.out.println("Taxa cartão 3x: " + taxaCartao3x + "%");

// Exemplo: Receber R$ 1.000,00 no cartão à vista
double valorRecebido = 1000.00;
double taxaCobrada = valorRecebido * (taxaCartaoVista / 100);
double valorLiquido = valorRecebido - taxaCobrada;

System.out.println("\nCartão à vista:");
System.out.println("Valor bruto: R$ " + valorRecebido);
System.out.println("Taxa (" + taxaCartaoVista + "%): R$ " + taxaCobrada);
System.out.println("Valor líquido: R$ " + valorLiquido);
```

### Transferências

#### TED

```java
double taxaTed = taxas.getTransferFee();
System.out.println("Taxa para TED: R$ " + taxaTed);

// Exemplo: Transferir R$ 1.000,00 via TED
double valorTransferencia = 1000.00;
double taxaCobrada = taxaTed;
double valorDebitado = valorTransferencia + taxaCobrada;

System.out.println("Valor da transferência: R$ " + valorTransferencia);
System.out.println("Taxa: R$ " + taxaCobrada);
System.out.println("Total debitado: R$ " + valorDebitado);
```

#### Pix (Envio)

```java
double taxaPixEnvio = taxas.getPixTransferFee();
System.out.println("Taxa para enviar Pix: R$ " + taxaPixEnvio);

// Exemplo: Enviar R$ 500,00 via Pix
double valorTransferencia = 500.00;
double taxaCobrada = taxaPixEnvio;
double valorDebitado = valorTransferencia + taxaCobrada;

System.out.println("Valor da transferência: R$ " + valorTransferencia);
System.out.println("Taxa: R$ " + taxaCobrada);
System.out.println("Total debitado: R$ " + valorDebitado);
```

## Exemplos de Cálculo

### Calcular Valor Líquido de uma Venda

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraTaxas {

    public static void calcularRecebimentoPix(double valorVenda) {
        AccountFee taxas = AccountFee.fetcher().fetch();

        double taxaPix = taxas.getPixFee();
        double valorLiquido = valorVenda - taxaPix;

        System.out.println("=== RECEBIMENTO VIA Pix ===");
        System.out.println("Valor da venda: R$ " + valorVenda);
        System.out.println("Taxa Asaas: R$ " + taxaPix);
        System.out.println("Você recebe: R$ " + valorLiquido);
    }

    public static void calcularRecebimentoCartao(double valorVenda, int parcelas) {
        AccountFee taxas = AccountFee.fetcher().fetch();

        double percentualTaxa = 0;
        if (parcelas == 1) {
            percentualTaxa = taxas.getCreditCardFee();
        } else if (parcelas == 2) {
            percentualTaxa = taxas.getCreditCardFeeInstallment2();
        } else if (parcelas == 3) {
            percentualTaxa = taxas.getCreditCardFeeInstallment3();
        }

        double taxaCobrada = valorVenda * (percentualTaxa / 100);
        double valorLiquido = valorVenda - taxaCobrada;

        System.out.println("=== RECEBIMENTO VIA CARTÃO ===");
        System.out.println("Valor da venda: R$ " + valorVenda);
        System.out.println("Parcelas: " + parcelas + "x");
        System.out.println("Taxa (" + percentualTaxa + "%): R$ " + taxaCobrada);
        System.out.println("Você recebe: R$ " + valorLiquido);
    }

    public static void main(String[] args) {
        calcularRecebimentoPix(100.00);
        System.out.println();
        calcularRecebimentoCartao(1000.00, 1);
    }
}
```

### Comparar Formas de Pagamento

```java
public class ComparadorTaxas {

    public static void compararTaxas(double valorVenda) {
        AccountFee taxas = AccountFee.fetcher().fetch();

        System.out.println("=== COMPARAÇÃO DE TAXAS ===");
        System.out.println("Valor da venda: R$ " + valorVenda);
        System.out.println();

        // Pix
        double liquidoPix = valorVenda - taxas.getPixFee();
        System.out.println("Pix:");
        System.out.println("  Você recebe: R$ " + liquidoPix);

        // Boleto
        double liquidoBoleto = valorVenda - taxas.getBankSlipFee();
        System.out.println("Boleto:");
        System.out.println("  Você recebe: R$ " + liquidoBoleto);

        // Cartão à vista
        double taxaCartao = valorVenda * (taxas.getCreditCardFee() / 100);
        double liquidoCartao = valorVenda - taxaCartao;
        System.out.println("Cartão à vista:");
        System.out.println("  Você recebe: R$ " + liquidoCartao);

        // Melhor opção
        double melhorValor = Math.max(liquidoPix, Math.max(liquidoBoleto, liquidoCartao));
        String melhorOpcao = "";
        if (melhorValor == liquidoPix) melhorOpcao = "Pix";
        else if (melhorValor == liquidoBoleto) melhorOpcao = "Boleto";
        else melhorOpcao = "Cartão";

        System.out.println();
        System.out.println("Melhor opção: " + melhorOpcao);
    }

    public static void main(String[] args) {
        compararTaxas(500.00);
    }
}
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.accountfee.AccountFee;

public class ExemploTaxas {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");

        // Recuperar taxas
        AccountFee taxas = AccountFee.fetcher().fetch();

        System.out.println("=== TAXAS DA SUA CONTA ===\n");

        // Recebimento
        System.out.println("RECEBIMENTO:");
        System.out.println("Pix: R$ " + taxas.getPixFee());
        System.out.println("Boleto: R$ " + taxas.getBankSlipFee());
        System.out.println("Cartão à vista: " + taxas.getCreditCardFee() + "%");
        System.out.println("Cartão 2x: " + taxas.getCreditCardFeeInstallment2() + "%");
        System.out.println("Cartão 3x: " + taxas.getCreditCardFeeInstallment3() + "%");

        System.out.println("\nTRANSFERÊNCIAS:");
        System.out.println("TED: R$ " + taxas.getTransferFee());
        System.out.println("Pix: R$ " + taxas.getPixTransferFee());

        // Exemplo de cálculo
        System.out.println("\n=== EXEMPLO: VENDA DE R$ 100,00 ===");
        double valorVenda = 100.00;

        double liquidoPix = valorVenda - taxas.getPixFee();
        System.out.println("Recebendo via Pix: R$ " + liquidoPix);

        double liquidoBoleto = valorVenda - taxas.getBankSlipFee();
        System.out.println("Recebendo via Boleto: R$ " + liquidoBoleto);

        double taxaCartao = valorVenda * (taxas.getCreditCardFee() / 100);
        double liquidoCartao = valorVenda - taxaCartao;
        System.out.println("Recebendo via Cartão: R$ " + liquidoCartao);
    }
}
```

## Taxas Típicas

**Nota**: As taxas variam conforme o plano contratado. Consulte sempre via API.

| Operação | Taxa Típica |
|----------|-------------|
| Pix (receber) | R$ 0,99 a R$ 3,49 |
| Boleto | R$ 1,99 a R$ 3,49 |
| Cartão à vista | 2,99% a 4,99% |
| Cartão parcelado | 3,99% a 6,99% |
| TED | R$ 3,50 a R$ 10,00 |
| Pix (enviar) | R$ 0,00 a R$ 3,50 |

## Boas Práticas

### 1. Cache as Taxas

```java
// Evite consultar a cada operação
private static AccountFee taxasCache = null;
private static long ultimaAtualizacao = 0;

public static AccountFee getTaxas() {
    long agora = System.currentTimeMillis();

    // Atualizar cache a cada 1 hora
    if (taxasCache == null || (agora - ultimaAtualizacao) > 3600000) {
        taxasCache = AccountFee.fetcher().fetch();
        ultimaAtualizacao = agora;
    }

    return taxasCache;
}
```

### 2. Mostre ao Cliente

```java
// Transparência nas taxas
double valorProduto = 100.00;
double taxaPix = taxas.getPixFee();
double valorTotal = valorProduto + taxaPix;

System.out.println("Produto: R$ " + valorProduto);
System.out.println("Taxa Pix: R$ " + taxaPix);
System.out.println("Total: R$ " + valorTotal);
```

### 3. Repasse as Taxas

```java
// Adicionar taxa ao valor da venda
double valorProduto = 100.00;
double taxaPix = taxas.getPixFee();
double valorComTaxa = valorProduto + taxaPix;

Payment payment = Payment.creator()
    .setCustomer(clienteId)
    .setBillingType(BillingType.Pix)
    .setValue(Money.create(new BigDecimal(valorComTaxa)))
    .create();
```

## Veja Também

- [Saldo](balance.md) - Consultar saldo disponível
- [Extrato](financial.md) - Ver movimentações
- [Cobranças](payment.md) - Criar cobranças

## Referências

- [Documentação Oficial - Taxas](https://docs.asaas.com/reference/consultar-taxas)
- [Planos Asaas](https://www.asaas.com/precos)
