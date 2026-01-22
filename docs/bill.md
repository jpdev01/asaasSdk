# Pagar Contas (Bill Payment)

Pague boletos de terceiros diretamente pela sua conta Asaas. Simplifique o pagamento de fornecedores, contas de consumo e outros boletos.

## 📋 Índice

- [Criar Pagamento](#criar-pagamento)
- [Listar Pagamentos](#listar-pagamentos)
- [Recuperar Pagamento](#recuperar-pagamento)
- [Cancelar Pagamento](#cancelar-pagamento)

## Criar Pagamento

### Pagamento por Linha Digitável

```java
import io.github.jpdev.asaassdk.rest.bill.Bill;

Bill pagamento = Bill.creator()
    .setIdentificationField("34191790010104351004791020150008291070026000")
    .create();

System.out.println("Pagamento criado: " + pagamento.getId());
System.out.println("Status: " + pagamento.getStatus());
System.out.println("Valor: R$ " + pagamento.getValue());
```

### Pagamento com Código de Barras

```java
Bill pagamento = Bill.creator()
    .setIdentificationField("34191790010104351004791020150008291070026000")
    .setDescription("Pagamento de fornecedor")
    .create();

System.out.println("Agendado para: " + pagamento.getScheduleDate());
```

### Pagamento Agendado

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 5); // Agendar para daqui a 5 dias
Date dataAgendamento = cal.getTime();

Bill pagamento = Bill.creator()
    .setIdentificationField("34191790010104351004791020150008291070026000")
    .setScheduleDate(dataAgendamento)
    .create();

System.out.println("Pagamento agendado para: " + pagamento.getScheduleDate());
```

### Pagamento com Desconto

```java
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;

Bill pagamento = Bill.creator()
    .setIdentificationField("34191790010104351004791020150008291070026000")
    .setDiscount(Money.create(new BigDecimal("10.00")))
    .setDescription("Pagamento com desconto")
    .create();

System.out.println("Valor original: R$ " + pagamento.getOriginalValue());
System.out.println("Desconto: R$ " + pagamento.getDiscount());
System.out.println("Valor a pagar: R$ " + pagamento.getValue());
```

## Listar Pagamentos

### Listar Todos

```java
import io.github.jpdev.asaassdk.rest.bill.ResourceSet;

ResourceSet<Bill> pagamentos = Bill.reader().read();

for (Bill pagamento : pagamentos.getData()) {
    System.out.println("ID: " + pagamento.getId());
    System.out.println("Valor: R$ " + pagamento.getValue());
    System.out.println("Status: " + pagamento.getStatus());
    System.out.println("Data: " + pagamento.getScheduleDate());
    System.out.println("---");
}
```

### Filtrar por Status

```java
import io.github.jpdev.asaassdk.enums.BillStatus;

// Apenas pagamentos pendentes
ResourceSet<Bill> pendentes = Bill.reader()
    .setStatus(BillStatus.PENDING)
    .read();

// Apenas pagamentos confirmados
ResourceSet<Bill> confirmados = Bill.reader()
    .setStatus(BillStatus.CONFIRMED)
    .read();
```

### Filtrar por Data

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.set(2024, Calendar.JANUARY, 1);
Date dataInicio = cal.getTime();

cal.set(2024, Calendar.DECEMBER, 31);
Date dataFim = cal.getTime();

ResourceSet<Bill> pagamentos = Bill.reader()
    .setStartDate(dataInicio)
    .setEndDate(dataFim)
    .read();
```

### Paginação

```java
ResourceSet<Bill> pagamentos = Bill.reader()
    .setLimit(50)
    .setOffset(0)
    .read();

System.out.println("Total: " + pagamentos.getTotalCount());
System.out.println("Tem mais: " + pagamentos.hasMore());
```

## Recuperar Pagamento

```java
Bill pagamento = Bill.fetcher("bill_123456789").fetch();

System.out.println("ID: " + pagamento.getId());
System.out.println("Valor: R$ " + pagamento.getValue());
System.out.println("Status: " + pagamento.getStatus());
System.out.println("Beneficiário: " + pagamento.getRecipient());
System.out.println("Data de pagamento: " + pagamento.getScheduleDate());
```

## Cancelar Pagamento

Cancele um pagamento agendado antes da execução:

```java
import io.github.jpdev.asaassdk.rest.bill.BillCancelled;

BillCancelled cancelado = Bill.canceller("bill_123456789").cancel();

if (cancelado.isCancelled()) {
    System.out.println("Pagamento cancelado com sucesso");
}
```

**Nota**: Apenas pagamentos com status `PENDING` ou `SCHEDULED` podem ser cancelados.

## Status de Pagamentos

| Status | Descrição |
|--------|-----------|
| `PENDING` | Aguardando processamento |
| `SCHEDULED` | Agendado |
| `CONFIRMED` | Confirmado |
| `CANCELLED` | Cancelado |
| `FAILED` | Falhou |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.bill.Bill;
import io.github.jpdev.asaassdk.rest.balance.FinanceBalance;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

public class ExemploPagamentoConta {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Verificar saldo antes de pagar
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        System.out.println("Saldo disponível: R$ " + saldo.getBalance());
        
        // Criar pagamento
        String linhaDigitavel = "34191790010104351004791020150008291070026000";
        
        Bill pagamento = Bill.creator()
            .setIdentificationField(linhaDigitavel)
            .setDescription("Pagamento de fornecedor XYZ")
            .create();
        
        System.out.println("\n=== PAGAMENTO CRIADO ===");
        System.out.println("ID: " + pagamento.getId());
        System.out.println("Beneficiário: " + pagamento.getRecipient());
        System.out.println("Valor: R$ " + pagamento.getValue());
        System.out.println("Status: " + pagamento.getStatus());
        System.out.println("Agendado para: " + pagamento.getScheduleDate());
        
        // Verificar novo saldo
        FinanceBalance novoSaldo = FinanceBalance.fetcher().fetch();
        System.out.println("\nNovo saldo: R$ " + novoSaldo.getBalance());
    }
}
```

## Validação de Linha Digitável

```java
public class ValidadorBoleto {
    
    public static boolean validarLinhaDigitavel(String linha) {
        // Remover espaços e caracteres especiais
        String linhaLimpa = linha.replaceAll("[^0-9]", "");
        
        // Linha digitável deve ter 47 dígitos
        if (linhaLimpa.length() != 47) {
            System.err.println("Linha digitável inválida: deve ter 47 dígitos");
            return false;
        }
        
        return true;
    }
    
    public static void pagarComValidacao(String linhaDigitavel) {
        if (!validarLinhaDigitavel(linhaDigitavel)) {
            return;
        }
        
        try {
            Bill pagamento = Bill.creator()
                .setIdentificationField(linhaDigitavel)
                .create();
            
            System.out.println("Pagamento criado: " + pagamento.getId());
        } catch (Exception e) {
            System.err.println("Erro ao criar pagamento: " + e.getMessage());
        }
    }
}
```

## Casos de Uso

### Pagamento de Fornecedores

```java
public class PagamentoFornecedor {
    
    public static void pagarFornecedor(String linhaDigitavel, String nomeFornecedor) {
        // Verificar saldo
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        
        Bill pagamento = Bill.creator()
            .setIdentificationField(linhaDigitavel)
            .setDescription("Pagamento fornecedor: " + nomeFornecedor)
            .create();
        
        System.out.println("Pagamento para " + nomeFornecedor + " criado");
        System.out.println("Valor: R$ " + pagamento.getValue());
        
        // Registrar no sistema
        registrarPagamento(pagamento.getId(), nomeFornecedor);
    }
    
    private static void registrarPagamento(String billId, String fornecedor) {
        // Salvar no banco de dados
        System.out.println("Pagamento registrado no sistema");
    }
}
```

### Pagamento em Lote

```java
import java.util.List;
import java.util.ArrayList;

public class PagamentoLote {
    
    public static void pagarLote(List<String> linhasDigitaveis) {
        List<Bill> pagamentosRealizados = new ArrayList<>();
        
        for (String linha : linhasDigitaveis) {
            try {
                Bill pagamento = Bill.creator()
                    .setIdentificationField(linha)
                    .create();
                
                pagamentosRealizados.add(pagamento);
                System.out.println("✅ Pagamento criado: " + pagamento.getId());
                
            } catch (Exception e) {
                System.err.println("❌ Erro ao pagar: " + linha);
                System.err.println("   " + e.getMessage());
            }
        }
        
        System.out.println("\nTotal de pagamentos: " + pagamentosRealizados.size());
    }
}
```

## Boas Práticas

### 1. Valide Antes de Pagar

```java
String linha = "34191.79001 01043.510047 79102.015000 8 29107002600000";
String linhaLimpa = linha.replaceAll("[^0-9]", "");

if (linhaLimpa.length() == 47) {
    Bill pagamento = Bill.creator()
        .setIdentificationField(linhaLimpa)
        .create();
}
```

### 2. Verifique Saldo

```java
FinanceBalance saldo = FinanceBalance.fetcher().fetch();
double valorBoleto = 500.00;

if (saldo.getBalance() >= valorBoleto) {
    Bill pagamento = Bill.creator()
        .setIdentificationField(linhaDigitavel)
        .create();
} else {
    System.err.println("Saldo insuficiente");
}
```

### 3. Trate Erros

```java
try {
    Bill pagamento = Bill.creator()
        .setIdentificationField(linhaDigitavel)
        .create();
} catch (AsaasException e) {
    if (e.getMessage().contains("insufficient balance")) {
        System.err.println("Saldo insuficiente");
    } else if (e.getMessage().contains("invalid")) {
        System.err.println("Linha digitável inválida");
    } else {
        System.err.println("Erro: " + e.getMessage());
    }
}
```

## Limitações

- Linha digitável deve ter 47 dígitos
- Pagamento só pode ser cancelado antes da execução
- Verificar saldo antes de criar pagamento
- Alguns boletos podem ter restrições de data

## Veja Também

- [Saldo](balance.md) - Verificar saldo disponível
- [Transferências](transfer.md) - Outras formas de pagamento
- [Extrato](financial.md) - Ver histórico de pagamentos

## Referências

- [Documentação Oficial - Pagamento de Contas](https://docs.asaas.com/reference/pagar-conta)
