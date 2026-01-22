# Cobranças com Split (Payment Split)

Divida pagamentos entre múltiplas contas automaticamente. Ideal para marketplaces, franquias e plataformas multi-vendedor.

## 📋 Índice

- [Criar Cobrança com Split](#criar-cobrança-com-split)
- [Tipos de Split](#tipos-de-split)
- [Listar Splits](#listar-splits)
- [Casos de Uso](#casos-de-uso)

## Criar Cobrança com Split

### Split com Valor Fixo

```java
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.rest.payment.SplitSetting;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

// Definir split para vendedor
SplitSetting splitVendedor = new SplitSetting()
    .setWalletId("635b5330-3931-4ab2-b78c-3c59f136c535")
    .setFixedValue(Money.create(new BigDecimal("50.00")));

// Criar cobrança com split
Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.PIX)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Venda no marketplace")
    .addSplit(splitVendedor)
    .create();

System.out.println("Cobrança criada: " + payment.getId());
System.out.println("Vendedor receberá: R$ 50,00");
System.out.println("Plataforma receberá: R$ 50,00");
```

### Split com Percentual

```java
SplitSetting splitVendedor = new SplitSetting()
    .setWalletId("635b5330-3931-4ab2-b78c-3c59f136c535")
    .setPercentualValue(new BigDecimal("80.00")); // 80% para o vendedor

Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.CREDIT_CARD)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Venda com comissão")
    .addSplit(splitVendedor)
    .create();

System.out.println("Vendedor receberá: R$ 80,00 (80%)");
System.out.println("Plataforma receberá: R$ 20,00 (20%)");
```

### Split para Múltiplos Vendedores

```java
// Split para vendedor 1
SplitSetting split1 = new SplitSetting()
    .setWalletId("wallet-vendedor-1")
    .setFixedValue(Money.create(new BigDecimal("40.00")));

// Split para vendedor 2
SplitSetting split2 = new SplitSetting()
    .setWalletId("wallet-vendedor-2")
    .setFixedValue(Money.create(new BigDecimal("30.00")));

// Criar cobrança com múltiplos splits
Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.PIX)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Compra com múltiplos vendedores")
    .addSplit(split1)
    .addSplit(split2)
    .create();

System.out.println("Vendedor 1: R$ 40,00");
System.out.println("Vendedor 2: R$ 30,00");
System.out.println("Plataforma: R$ 30,00");
```

### Split com Taxas Personalizadas

```java
SplitSetting splitVendedor = new SplitSetting()
    .setWalletId("wallet-vendedor")
    .setFixedValue(Money.create(new BigDecimal("90.00")))
    .setTotalFixedValue(Money.create(new BigDecimal("5.00"))); // Taxa fixa adicional

Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.BOLETO)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Venda com taxa")
    .addSplit(splitVendedor)
    .create();
```

## Tipos de Split

### Por Valor Fixo

```java
SplitSetting split = new SplitSetting()
    .setWalletId("wallet-id")
    .setFixedValue(Money.create(new BigDecimal("50.00")));
```

### Por Percentual

```java
SplitSetting split = new SplitSetting()
    .setWalletId("wallet-id")
    .setPercentualValue(new BigDecimal("75.00")); // 75%
```

### Misto (Fixo + Percentual)

```java
SplitSetting split = new SplitSetting()
    .setWalletId("wallet-id")
    .setFixedValue(Money.create(new BigDecimal("10.00")))
    .setPercentualValue(new BigDecimal("70.00")); // R$ 10 + 70% do restante
```

## Listar Splits

### Listar Splits Pagos

```java
import io.github.jpdev.asaassdk.rest.split.Split;
import io.github.jpdev.asaassdk.rest.split.PaymentSplitPaidReader;
import io.github.jpdev.asaassdk.rest.split.ResourceSet;

PaymentSplitPaidReader reader = Split.paidReader();
ResourceSet splits = reader.read();

for (Object split : splits.getData()) {
    System.out.println("Split pago: " + split);
}
```

### Listar Splits Recebidos

```java
import io.github.jpdev.asaassdk.rest.split.PaymentSplitReceivedReader;

PaymentSplitReceivedReader reader = Split.receivedReader();
ResourceSet splits = reader.read();

for (Object split : splits.getData()) {
    System.out.println("Split recebido: " + split);
}
```

### Filtrar por Data

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.set(2024, Calendar.JANUARY, 1);
Date dataInicio = cal.getTime();

cal.set(2024, Calendar.JANUARY, 31);
Date dataFim = cal.getTime();

PaymentSplitPaidReader reader = Split.paidReader()
    .setStartDate(dataInicio)
    .setEndDate(dataFim);

ResourceSet splits = reader.read();
```

## Casos de Uso

### Marketplace

```java
public class MarketplaceSplit {
    
    public static Payment criarVendaMarketplace(
        String clienteId,
        String vendedorWalletId,
        double valorProduto,
        double comissaoPlataforma
    ) {
        double valorVendedor = valorProduto - comissaoPlataforma;
        
        SplitSetting splitVendedor = new SplitSetting()
            .setWalletId(vendedorWalletId)
            .setFixedValue(Money.create(new BigDecimal(valorVendedor)));
        
        Payment payment = Payment.creator()
            .setCustomer(clienteId)
            .setBillingType(BillingType.PIX)
            .setDueDate(new Date())
            .setValue(Money.create(new BigDecimal(valorProduto)))
            .setDescription("Venda no marketplace")
            .addSplit(splitVendedor)
            .create();
        
        System.out.println("Venda criada:");
        System.out.println("Total: R$ " + valorProduto);
        System.out.println("Vendedor: R$ " + valorVendedor);
        System.out.println("Comissão: R$ " + comissaoPlataforma);
        
        return payment;
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        criarVendaMarketplace(
            "cus_cliente",
            "wallet_vendedor",
            100.00,
            15.00 // 15% de comissão
        );
    }
}
```

### Franquia

```java
public class FranquiaSplit {
    
    public static Payment criarVendaFranquia(
        String clienteId,
        String franqueadoWalletId,
        double valorVenda
    ) {
        // 90% para franqueado, 10% para franqueadora
        SplitSetting splitFranqueado = new SplitSetting()
            .setWalletId(franqueadoWalletId)
            .setPercentualValue(new BigDecimal("90.00"));
        
        Payment payment = Payment.creator()
            .setCustomer(clienteId)
            .setBillingType(BillingType.CREDIT_CARD)
            .setDueDate(new Date())
            .setValue(Money.create(new BigDecimal(valorVenda)))
            .setDescription("Venda franquia")
            .addSplit(splitFranqueado)
            .create();
        
        System.out.println("Franqueado: R$ " + (valorVenda * 0.9));
        System.out.println("Franqueadora: R$ " + (valorVenda * 0.1));
        
        return payment;
    }
}
```

### Plataforma de Serviços

```java
public class PlataformaServicos {
    
    public static Payment criarPagamentoServico(
        String clienteId,
        String prestadorWalletId,
        double valorServico,
        double taxaPlataforma
    ) {
        double valorPrestador = valorServico - taxaPlataforma;
        
        SplitSetting splitPrestador = new SplitSetting()
            .setWalletId(prestadorWalletId)
            .setFixedValue(Money.create(new BigDecimal(valorPrestador)));
        
        Payment payment = Payment.creator()
            .setCustomer(clienteId)
            .setBillingType(BillingType.PIX)
            .setDueDate(new Date())
            .setValue(Money.create(new BigDecimal(valorServico)))
            .setDescription("Pagamento de serviço")
            .addSplit(splitPrestador)
            .create();
        
        return payment;
    }
}
```

### Carrinho com Múltiplos Vendedores

```java
public class CarrinhoMultiVendedor {
    
    public static class ItemCarrinho {
        String vendedorWalletId;
        double valor;
        
        public ItemCarrinho(String walletId, double valor) {
            this.vendedorWalletId = walletId;
            this.valor = valor;
        }
    }
    
    public static Payment criarPagamentoCarrinho(
        String clienteId,
        List<ItemCarrinho> itens
    ) {
        double valorTotal = 0;
        Payment.Creator paymentCreator = Payment.creator()
            .setCustomer(clienteId)
            .setBillingType(BillingType.PIX)
            .setDueDate(new Date());
        
        // Adicionar split para cada vendedor
        for (ItemCarrinho item : itens) {
            valorTotal += item.valor;
            
            SplitSetting split = new SplitSetting()
                .setWalletId(item.vendedorWalletId)
                .setFixedValue(Money.create(new BigDecimal(item.valor)));
            
            paymentCreator.addSplit(split);
        }
        
        Payment payment = paymentCreator
            .setValue(Money.create(new BigDecimal(valorTotal)))
            .setDescription("Compra com múltiplos vendedores")
            .create();
        
        System.out.println("Carrinho criado com " + itens.size() + " vendedores");
        System.out.println("Valor total: R$ " + valorTotal);
        
        return payment;
    }
}
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.rest.payment.SplitSetting;
import io.github.jpdev.asaassdk.rest.account.Account;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

public class ExemploSplit {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Criar subconta para vendedor
        Account vendedor = Account.creator()
            .setName("Vendedor Parceiro")
            .setEmail("vendedor@marketplace.com")
            .setCpfCnpj("12345678000190")
            .setBirthDate(new Date(2020, 0, 1))
            .setCompanyType("LIMITED")
            .setPostalCode("89010-000")
            .create();
        
        System.out.println("Vendedor criado: " + vendedor.getId());
        System.out.println("Wallet ID: " + vendedor.getWalletId());
        
        // Criar cobrança com split
        double valorTotal = 100.00;
        double comissao = 15.00; // 15%
        double valorVendedor = valorTotal - comissao;
        
        SplitSetting split = new SplitSetting()
            .setWalletId(vendedor.getWalletId())
            .setFixedValue(Money.create(new BigDecimal(valorVendedor)));
        
        Payment payment = Payment.creator()
            .setCustomer("cus_000050606806")
            .setBillingType(BillingType.PIX)
            .setDueDate(new Date())
            .setValue(Money.create(new BigDecimal(valorTotal)))
            .setDescription("Venda no marketplace")
            .addSplit(split)
            .create();
        
        System.out.println("\n=== COBRANÇA COM SPLIT ===");
        System.out.println("ID: " + payment.getId());
        System.out.println("Valor total: R$ " + valorTotal);
        System.out.println("Vendedor recebe: R$ " + valorVendedor);
        System.out.println("Plataforma recebe: R$ " + comissao);
    }
}
```

## Cálculo de Splits

### Calculadora de Comissão

```java
public class CalculadoraSplit {
    
    public static double calcularComissao(double valorVenda, double percentualComissao) {
        return valorVenda * (percentualComissao / 100);
    }
    
    public static double calcularValorVendedor(double valorVenda, double percentualComissao) {
        return valorVenda - calcularComissao(valorVenda, percentualComissao);
    }
    
    public static void exibirResumo(double valorVenda, double percentualComissao) {
        double comissao = calcularComissao(valorVenda, percentualComissao);
        double valorVendedor = calcularValorVendedor(valorVenda, percentualComissao);
        
        System.out.println("=== RESUMO DO SPLIT ===");
        System.out.println("Valor da venda: R$ " + String.format("%.2f", valorVenda));
        System.out.println("Comissão (" + percentualComissao + "%): R$ " + String.format("%.2f", comissao));
        System.out.println("Vendedor recebe: R$ " + String.format("%.2f", valorVendedor));
    }
    
    public static void main(String[] args) {
        exibirResumo(100.00, 15.00);
    }
}
```

## Boas Práticas

### 1. Valide Wallet IDs

```java
public static boolean validarWalletId(String walletId) {
    if (walletId == null || walletId.isEmpty()) {
        System.err.println("Wallet ID inválido");
        return false;
    }
    return true;
}
```

### 2. Verifique Valores

```java
public static boolean validarSplit(double valorTotal, double valorSplit) {
    if (valorSplit > valorTotal) {
        System.err.println("Valor do split maior que o total");
        return false;
    }
    return true;
}
```

### 3. Registre Splits

```java
// Salvar informações do split no banco de dados
public static void registrarSplit(String paymentId, String walletId, double valor) {
    // Implementar persistência
    System.out.println("Split registrado: " + paymentId);
}
```

## Limitações

- Valor mínimo de split: R$ 1,00
- Soma dos splits não pode exceder o valor total
- Wallet ID deve ser de subconta vinculada
- Splits são processados após confirmação do pagamento

## Veja Também

- [Subcontas](account.md) - Criar subcontas para vendedores
- [Cobranças](payment.md) - Criar cobranças
- [Transferências](transfer.md) - Transferir entre contas

## Referências

- [Documentação Oficial - Split](https://docs.asaas.com/reference/split-de-pagamento)
