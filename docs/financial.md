# Extrato Financeiro (Financial Transactions)

Consulte todas as movimentações financeiras da sua conta Asaas. Acompanhe entradas, saídas e taxas.

## 📋 Índice

- [Listar Transações](#listar-transações)
- [Filtros Disponíveis](#filtros-disponíveis)
- [Tipos de Transação](#tipos-de-transação)
- [Relatórios](#relatórios)

## Listar Transações

### Listar Todas

```java
import io.github.jpdev.asaassdk.rest.financial.FinancialTransaction;
import io.github.jpdev.asaassdk.rest.financial.ResourceSet;

ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader().read();

for (FinancialTransaction transacao : transacoes.getData()) {
    System.out.println("Data: " + transacao.getDate());
    System.out.println("Tipo: " + transacao.getType());
    System.out.println("Valor: R$ " + transacao.getValue());
    System.out.println("Descrição: " + transacao.getDescription());
    System.out.println("Saldo: R$ " + transacao.getBalance());
    System.out.println("---");
}
```

## Filtros Disponíveis

### Filtrar por Data

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.set(2024, Calendar.JANUARY, 1);
Date dataInicio = cal.getTime();

cal.set(2024, Calendar.JANUARY, 31);
Date dataFim = cal.getTime();

ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
    .setStartDate(dataInicio)
    .setEndDate(dataFim)
    .read();

System.out.println("Transações de Janeiro/2024: " + transacoes.getTotalCount());
```

### Filtrar por Tipo

```java
import io.github.jpdev.asaassdk.enums.FinancialTransactionType;

// Apenas recebimentos
ResourceSet<FinancialTransaction> recebimentos = FinancialTransaction.reader()
    .setType(FinancialTransactionType.PAYMENT_RECEIVED)
    .read();

// Apenas transferências
ResourceSet<FinancialTransaction> transferencias = FinancialTransaction.reader()
    .setType(FinancialTransactionType.TRANSFER)
    .read();
```

### Filtrar por Cobrança

```java
ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
    .setPaymentId("pay_123456789")
    .read();

System.out.println("Transações da cobrança: " + transacoes.getTotalCount());
```

### Filtrar por Transferência

```java
ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
    .setTransferId("transfer_123456789")
    .read();
```

### Filtrar por Assinatura

```java
ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
    .setSubscriptionId("sub_123456789")
    .read();
```

### Paginação

```java
ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
    .setLimit(100)
    .setOffset(0)
    .read();

System.out.println("Total de transações: " + transacoes.getTotalCount());
System.out.println("Tem mais: " + transacoes.hasMore());

// Próxima página
if (transacoes.hasMore()) {
    ResourceSet<FinancialTransaction> proximaPagina = FinancialTransaction.reader()
        .setLimit(100)
        .setOffset(100)
        .read();
}
```

## Tipos de Transação

| Tipo | Descrição |
|------|-----------|
| `PAYMENT_RECEIVED` | Pagamento recebido |
| `PAYMENT_FEE` | Taxa de pagamento |
| `TRANSFER` | Transferência enviada |
| `TRANSFER_FEE` | Taxa de transferência |
| `PAYMENT_REFUND` | Estorno de pagamento |
| `CHARGEBACK` | Chargeback |
| `INVOICE_FEE` | Taxa de nota fiscal |
| `ANTICIPATION` | Antecipação |
| `ANTICIPATION_FEE` | Taxa de antecipação |

## Relatórios

### Relatório Mensal

```java
import java.time.LocalDate;
import java.time.ZoneId;

public class RelatorioMensal {
    
    public static void gerarRelatorio(int mes, int ano) {
        LocalDate inicio = LocalDate.of(ano, mes, 1);
        LocalDate fim = inicio.plusMonths(1).minusDays(1);
        
        Date dataInicio = Date.from(inicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataFim = Date.from(fim.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
            .setStartDate(dataInicio)
            .setEndDate(dataFim)
            .read();
        
        double totalEntradas = 0;
        double totalSaidas = 0;
        double totalTaxas = 0;
        
        for (FinancialTransaction t : transacoes.getData()) {
            if (t.getType().equals(FinancialTransactionType.PAYMENT_RECEIVED)) {
                totalEntradas += t.getValue();
            } else if (t.getType().contains("FEE")) {
                totalTaxas += t.getValue();
            } else if (t.getType().equals(FinancialTransactionType.TRANSFER)) {
                totalSaidas += t.getValue();
            }
        }
        
        System.out.println("=== RELATÓRIO " + mes + "/" + ano + " ===");
        System.out.println("Total de transações: " + transacoes.getTotalCount());
        System.out.println("Entradas: R$ " + String.format("%.2f", totalEntradas));
        System.out.println("Saídas: R$ " + String.format("%.2f", totalSaidas));
        System.out.println("Taxas: R$ " + String.format("%.2f", totalTaxas));
        System.out.println("Saldo: R$ " + String.format("%.2f", (totalEntradas - totalSaidas - totalTaxas)));
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        gerarRelatorio(1, 2024); // Janeiro de 2024
    }
}
```

### Extrato Detalhado

```java
public class ExtratoDetalhado {
    
    public static void gerarExtrato(Date dataInicio, Date dataFim) {
        ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
            .setStartDate(dataInicio)
            .setEndDate(dataFim)
            .read();
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║              EXTRATO FINANCEIRO                        ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        
        for (FinancialTransaction t : transacoes.getData()) {
            String tipo = formatarTipo(t.getType());
            String valor = String.format("R$ %.2f", t.getValue());
            String saldo = String.format("R$ %.2f", t.getBalance());
            
            System.out.println("║ Data: " + t.getDate());
            System.out.println("║ Tipo: " + tipo);
            System.out.println("║ Valor: " + valor);
            System.out.println("║ Saldo: " + saldo);
            System.out.println("║ Descrição: " + t.getDescription());
            System.out.println("╠════════════════════════════════════════════════════════╣");
        }
        
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    
    private static String formatarTipo(String tipo) {
        switch (tipo) {
            case "PAYMENT_RECEIVED": return "Pagamento Recebido";
            case "PAYMENT_FEE": return "Taxa de Pagamento";
            case "TRANSFER": return "Transferência";
            case "TRANSFER_FEE": return "Taxa de Transferência";
            default: return tipo;
        }
    }
}
```

### Análise de Fluxo de Caixa

```java
public class FluxoCaixa {
    
    public static void analisarFluxo(Date dataInicio, Date dataFim) {
        ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
            .setStartDate(dataInicio)
            .setEndDate(dataFim)
            .read();
        
        Map<String, Double> entradas = new HashMap<>();
        Map<String, Double> saidas = new HashMap<>();
        
        for (FinancialTransaction t : transacoes.getData()) {
            String tipo = t.getType();
            double valor = t.getValue();
            
            if (tipo.equals("PAYMENT_RECEIVED")) {
                entradas.put(tipo, entradas.getOrDefault(tipo, 0.0) + valor);
            } else {
                saidas.put(tipo, saidas.getOrDefault(tipo, 0.0) + valor);
            }
        }
        
        System.out.println("=== ANÁLISE DE FLUXO DE CAIXA ===\n");
        
        System.out.println("ENTRADAS:");
        entradas.forEach((tipo, valor) -> 
            System.out.println("  " + tipo + ": R$ " + String.format("%.2f", valor))
        );
        
        System.out.println("\nSAÍDAS:");
        saidas.forEach((tipo, valor) -> 
            System.out.println("  " + tipo + ": R$ " + String.format("%.2f", valor))
        );
        
        double totalEntradas = entradas.values().stream().mapToDouble(Double::doubleValue).sum();
        double totalSaidas = saidas.values().stream().mapToDouble(Double::doubleValue).sum();
        
        System.out.println("\nRESUMO:");
        System.out.println("Total Entradas: R$ " + String.format("%.2f", totalEntradas));
        System.out.println("Total Saídas: R$ " + String.format("%.2f", totalSaidas));
        System.out.println("Saldo Período: R$ " + String.format("%.2f", (totalEntradas - totalSaidas)));
    }
}
```

### Exportar para CSV

```java
import java.io.FileWriter;
import java.io.IOException;

public class ExportadorCSV {
    
    public static void exportarParaCSV(Date dataInicio, Date dataFim, String arquivo) {
        ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
            .setStartDate(dataInicio)
            .setEndDate(dataFim)
            .read();
        
        try (FileWriter writer = new FileWriter(arquivo)) {
            // Cabeçalho
            writer.append("Data,Tipo,Valor,Saldo,Descrição\n");
            
            // Dados
            for (FinancialTransaction t : transacoes.getData()) {
                writer.append(t.getDate().toString()).append(",");
                writer.append(t.getType()).append(",");
                writer.append(String.valueOf(t.getValue())).append(",");
                writer.append(String.valueOf(t.getBalance())).append(",");
                writer.append(t.getDescription()).append("\n");
            }
            
            System.out.println("Extrato exportado para: " + arquivo);
            
        } catch (IOException e) {
            System.err.println("Erro ao exportar: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JANUARY, 1);
        Date inicio = cal.getTime();
        
        cal.set(2024, Calendar.JANUARY, 31);
        Date fim = cal.getTime();
        
        exportarParaCSV(inicio, fim, "extrato_janeiro_2024.csv");
    }
}
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.financial.FinancialTransaction;
import io.github.jpdev.asaassdk.rest.financial.ResourceSet;
import java.util.Calendar;
import java.util.Date;

public class ExemploExtrato {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Definir período (últimos 30 dias)
        Calendar cal = Calendar.getInstance();
        Date dataFim = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, -30);
        Date dataInicio = cal.getTime();
        
        // Buscar transações
        ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
            .setStartDate(dataInicio)
            .setEndDate(dataFim)
            .setLimit(100)
            .read();
        
        System.out.println("=== EXTRATO - ÚLTIMOS 30 DIAS ===\n");
        System.out.println("Total de transações: " + transacoes.getTotalCount());
        System.out.println();
        
        // Calcular totais
        double totalEntradas = 0;
        double totalSaidas = 0;
        
        for (FinancialTransaction t : transacoes.getData()) {
            System.out.println("Data: " + t.getDate());
            System.out.println("Tipo: " + t.getType());
            System.out.println("Valor: R$ " + t.getValue());
            System.out.println("Saldo após: R$ " + t.getBalance());
            System.out.println("---");
            
            if (t.getType().equals("PAYMENT_RECEIVED")) {
                totalEntradas += t.getValue();
            } else {
                totalSaidas += t.getValue();
            }
        }
        
        System.out.println("\n=== RESUMO ===");
        System.out.println("Total Entradas: R$ " + String.format("%.2f", totalEntradas));
        System.out.println("Total Saídas: R$ " + String.format("%.2f", totalSaidas));
        System.out.println("Saldo Período: R$ " + String.format("%.2f", (totalEntradas - totalSaidas)));
    }
}
```

## Boas Práticas

### 1. Use Paginação para Grandes Volumes

```java
int offset = 0;
int limit = 100;
boolean temMais = true;

while (temMais) {
    ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
        .setLimit(limit)
        .setOffset(offset)
        .read();
    
    // Processar transações
    processarTransacoes(transacoes.getData());
    
    temMais = transacoes.hasMore();
    offset += limit;
}
```

### 2. Filtre por Período Específico

```java
// Evite buscar todo o histórico
Calendar cal = Calendar.getInstance();
cal.add(Calendar.MONTH, -1); // Último mês

ResourceSet<FinancialTransaction> transacoes = FinancialTransaction.reader()
    .setStartDate(cal.getTime())
    .setEndDate(new Date())
    .read();
```

### 3. Cache de Relatórios

```java
private static Map<String, RelatorioCache> cache = new HashMap<>();

public static RelatorioCache getRelatorio(String periodo) {
    if (!cache.containsKey(periodo)) {
        cache.put(periodo, gerarRelatorio(periodo));
    }
    return cache.get(periodo);
}
```

## Veja Também

- [Saldo](balance.md) - Consultar saldo atual
- [Cobranças](payment.md) - Ver cobranças recebidas
- [Transferências](transfer.md) - Ver transferências realizadas

## Referências

- [Documentação Oficial - Extrato](https://docs.asaas.com/reference/listar-extrato)
