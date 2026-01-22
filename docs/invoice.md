# Notas Fiscais (Invoices)

Emita notas fiscais de serviço (NF-e) diretamente pela plataforma Asaas. Automatize a emissão de notas para suas cobranças.

## 📋 Índice

- [Criar Nota Fiscal](#criar-nota-fiscal)
- [Listar Notas Fiscais](#listar-notas-fiscais)
- [Recuperar Nota Fiscal](#recuperar-nota-fiscal)
- [Cancelar Nota Fiscal](#cancelar-nota-fiscal)
- [Impostos](#impostos)

## Criar Nota Fiscal

### Nota Fiscal Básica

```java
import io.github.jpdev.asaassdk.rest.invoice.Invoice;
import io.github.jpdev.asaassdk.rest.invoice.Taxes;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

Invoice nota = Invoice.creator()
    .setServiceDescription("Desenvolvimento de software")
    .setValue(Money.create(new BigDecimal("1000.00")))
    .setEffectiveDate(new Date())
    .setMunicipalServiceName("Análise e Desenvolvimento de Sistemas")
    .create();

System.out.println("Nota fiscal criada: " + nota.getId());
System.out.println("Número: " + nota.getNumber());
System.out.println("Status: " + nota.getStatus());
```

### Nota Fiscal com Impostos

```java
Taxes impostos = new Taxes()
    .setRetainIss(true)
    .setIss(Money.create(new BigDecimal("50.00")))      // ISS 5%
    .setCofins(Money.create(new BigDecimal("30.00")))   // COFINS 3%
    .setCsll(Money.create(new BigDecimal("10.00")))     // CSLL 1%
    .setInss(Money.create(new BigDecimal("30.00")))     // INSS 3%
    .setIr(Money.create(new BigDecimal("15.00")))       // IR 1.5%
    .setPis(Money.create(new BigDecimal("6.50")));      // PIS 0.65%

Invoice nota = Invoice.creator()
    .setServiceDescription("Consultoria em TI")
    .setValue(Money.create(new BigDecimal("1000.00")))
    .setEffectiveDate(new Date())
    .setMunicipalServiceName("Consultoria em Tecnologia da Informação")
    .setTaxes(impostos)
    .create();

System.out.println("Nota fiscal com impostos criada");
System.out.println("Valor bruto: R$ " + nota.getValue());
System.out.println("Impostos: R$ " + nota.getTaxes().getTotal());
```

### Nota Fiscal com Deduções

```java
Invoice nota = Invoice.creator()
    .setServiceDescription("Desenvolvimento de aplicativo mobile")
    .setValue(Money.create(new BigDecimal("5000.00")))
    .setDeductions(Money.create(new BigDecimal("100.00")))
    .setEffectiveDate(new Date())
    .setMunicipalServiceName("Desenvolvimento de Software")
    .create();

System.out.println("Valor: R$ " + nota.getValue());
System.out.println("Deduções: R$ " + nota.getDeductions());
System.out.println("Valor líquido: R$ " + (nota.getValue() - nota.getDeductions()));
```

### Nota Fiscal com Observações

```java
Invoice nota = Invoice.creator()
    .setServiceDescription("Manutenção de sistemas")
    .setObservations("Referente aos serviços prestados em Janeiro/2024. " +
                    "Pagamento via PIX. Obrigado pela preferência!")
    .setValue(Money.create(new BigDecimal("2000.00")))
    .setEffectiveDate(new Date())
    .setMunicipalServiceName("Manutenção de Software")
    .create();

System.out.println("Nota fiscal criada com observações");
```

### Nota Fiscal para Cobrança Específica

```java
Invoice nota = Invoice.creator()
    .setPayment("pay_123456789") // ID da cobrança
    .setServiceDescription("Serviço de hospedagem")
    .setValue(Money.create(new BigDecimal("300.00")))
    .setEffectiveDate(new Date())
    .setMunicipalServiceName("Hospedagem de Sites")
    .create();

System.out.println("Nota fiscal vinculada à cobrança");
```

## Listar Notas Fiscais

### Listar Todas

```java
import io.github.jpdev.asaassdk.rest.invoice.ResourceSet;

ResourceSet<Invoice> notas = Invoice.reader().read();

for (Invoice nota : notas.getData()) {
    System.out.println("ID: " + nota.getId());
    System.out.println("Número: " + nota.getNumber());
    System.out.println("Valor: R$ " + nota.getValue());
    System.out.println("Status: " + nota.getStatus());
    System.out.println("Data: " + nota.getEffectiveDate());
    System.out.println("---");
}
```

### Filtrar por Status

```java
import io.github.jpdev.asaassdk.enums.InvoiceStatus;

// Apenas notas autorizadas
ResourceSet<Invoice> autorizadas = Invoice.reader()
    .setStatus(InvoiceStatus.AUTHORIZED)
    .read();

// Apenas notas canceladas
ResourceSet<Invoice> canceladas = Invoice.reader()
    .setStatus(InvoiceStatus.CANCELLED)
    .read();
```

### Filtrar por Cliente

```java
ResourceSet<Invoice> notas = Invoice.reader()
    .setCustomer("cus_000050606806")
    .read();

System.out.println("Notas do cliente: " + notas.getTotalCount());
```

### Filtrar por Data

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.set(2024, Calendar.JANUARY, 1);
Date dataInicio = cal.getTime();

cal.set(2024, Calendar.JANUARY, 31);
Date dataFim = cal.getTime();

ResourceSet<Invoice> notas = Invoice.reader()
    .setStartDate(dataInicio)
    .setEndDate(dataFim)
    .read();
```

### Paginação

```java
ResourceSet<Invoice> notas = Invoice.reader()
    .setLimit(50)
    .setOffset(0)
    .read();

System.out.println("Total: " + notas.getTotalCount());
System.out.println("Tem mais: " + notas.hasMore());
```

## Recuperar Nota Fiscal

```java
Invoice nota = Invoice.fetcher("inv_000000000232").fetch();

System.out.println("=== NOTA FISCAL ===");
System.out.println("ID: " + nota.getId());
System.out.println("Número: " + nota.getNumber());
System.out.println("Valor: R$ " + nota.getValue());
System.out.println("Status: " + nota.getStatus());
System.out.println("Descrição: " + nota.getServiceDescription());
System.out.println("Data de emissão: " + nota.getEffectiveDate());
System.out.println("PDF: " + nota.getPdfUrl());
System.out.println("XML: " + nota.getXmlUrl());
```

## Cancelar Nota Fiscal

```java
import io.github.jpdev.asaassdk.rest.invoice.InvoiceCancelled;

InvoiceCancelled cancelada = Invoice.canceller("inv_000000000232")
    .setReason("Erro na emissão")
    .cancel();

if (cancelada.isCancelled()) {
    System.out.println("Nota fiscal cancelada com sucesso");
}
```

**Nota**: Apenas notas com status `AUTHORIZED` podem ser canceladas.

## Impostos

### Tabela de Impostos Comuns

| Imposto | Descrição | Alíquota Típica |
|---------|-----------|-----------------|
| ISS | Imposto Sobre Serviços | 2% a 5% |
| COFINS | Contribuição para Financiamento da Seguridade Social | 3% |
| CSLL | Contribuição Social sobre o Lucro Líquido | 1% |
| INSS | Instituto Nacional do Seguro Social | 3% |
| IR | Imposto de Renda | 1,5% |
| PIS | Programa de Integração Social | 0,65% |

### Calcular Impostos

```java
public class CalculadoraImpostos {
    
    public static Taxes calcularImpostos(double valorServico) {
        double iss = valorServico * 0.05;      // 5%
        double cofins = valorServico * 0.03;   // 3%
        double csll = valorServico * 0.01;     // 1%
        double inss = valorServico * 0.03;     // 3%
        double ir = valorServico * 0.015;      // 1.5%
        double pis = valorServico * 0.0065;    // 0.65%
        
        return new Taxes()
            .setRetainIss(true)
            .setIss(Money.create(new BigDecimal(iss)))
            .setCofins(Money.create(new BigDecimal(cofins)))
            .setCsll(Money.create(new BigDecimal(csll)))
            .setInss(Money.create(new BigDecimal(inss)))
            .setIr(Money.create(new BigDecimal(ir)))
            .setPis(Money.create(new BigDecimal(pis)));
    }
    
    public static void main(String[] args) {
        double valor = 1000.00;
        Taxes impostos = calcularImpostos(valor);
        
        System.out.println("Valor do serviço: R$ " + valor);
        System.out.println("Total de impostos: R$ " + impostos.getTotal());
        System.out.println("Valor líquido: R$ " + (valor - impostos.getTotal()));
    }
}
```

## Status de Notas Fiscais

| Status | Descrição |
|--------|-----------|
| `SCHEDULED` | Agendada para emissão |
| `AUTHORIZED` | Autorizada pela prefeitura |
| `PROCESSING_CANCELLATION` | Processando cancelamento |
| `CANCELLED` | Cancelada |
| `ERROR` | Erro na emissão |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.invoice.Invoice;
import io.github.jpdev.asaassdk.rest.invoice.Taxes;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

public class ExemploNotaFiscal {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Criar cobrança
        Payment cobranca = Payment.creator()
            .setCustomer("cus_000050606806")
            .setBillingType(BillingType.PIX)
            .setDueDate(new Date())
            .setValue(Money.create(new BigDecimal("1000.00")))
            .setDescription("Desenvolvimento de software")
            .create();
        
        System.out.println("Cobrança criada: " + cobranca.getId());
        
        // Aguardar pagamento...
        // Quando pago, emitir nota fiscal
        
        // Calcular impostos
        double valorServico = 1000.00;
        Taxes impostos = new Taxes()
            .setRetainIss(true)
            .setIss(Money.create(new BigDecimal(valorServico * 0.05)))
            .setCofins(Money.create(new BigDecimal(valorServico * 0.03)))
            .setCsll(Money.create(new BigDecimal(valorServico * 0.01)))
            .setInss(Money.create(new BigDecimal(valorServico * 0.03)))
            .setIr(Money.create(new BigDecimal(valorServico * 0.015)))
            .setPis(Money.create(new BigDecimal(valorServico * 0.0065)));
        
        // Emitir nota fiscal
        Invoice nota = Invoice.creator()
            .setPayment(cobranca.getId())
            .setServiceDescription("Desenvolvimento de software sob medida")
            .setObservations("Referente ao projeto XYZ. Obrigado!")
            .setValue(Money.create(new BigDecimal(valorServico)))
            .setEffectiveDate(new Date())
            .setMunicipalServiceName("Análise e Desenvolvimento de Sistemas")
            .setTaxes(impostos)
            .create();
        
        System.out.println("\n=== NOTA FISCAL EMITIDA ===");
        System.out.println("ID: " + nota.getId());
        System.out.println("Número: " + nota.getNumber());
        System.out.println("Valor: R$ " + nota.getValue());
        System.out.println("Status: " + nota.getStatus());
        System.out.println("PDF: " + nota.getPdfUrl());
        System.out.println("XML: " + nota.getXmlUrl());
    }
}
```

## Automação

### Emitir Nota Automaticamente Após Pagamento

```java
public class EmissaoAutomatica {
    
    public static void processarPagamento(String paymentId) {
        // Verificar se pagamento foi confirmado
        Payment payment = Payment.fetcher(paymentId).fetch();
        
        if (payment.getStatus().equals("RECEIVED") || 
            payment.getStatus().equals("CONFIRMED")) {
            
            // Emitir nota fiscal
            emitirNotaFiscal(payment);
        }
    }
    
    private static void emitirNotaFiscal(Payment payment) {
        Taxes impostos = calcularImpostos(payment.getValue());
        
        Invoice nota = Invoice.creator()
            .setPayment(payment.getId())
            .setServiceDescription(payment.getDescription())
            .setValue(Money.create(payment.getValue()))
            .setEffectiveDate(new Date())
            .setMunicipalServiceName("Serviços de TI")
            .setTaxes(impostos)
            .create();
        
        System.out.println("Nota fiscal emitida: " + nota.getId());
        
        // Enviar por email para o cliente
        enviarNotaPorEmail(payment.getCustomer(), nota.getPdfUrl());
    }
}
```

### Webhook para Emissão Automática

```java
// Configurar webhook para receber notificação de pagamento
Webhook webhook = Webhook.creator()
    .setUrl("https://seusite.com/webhook/pagamento")
    .addEvent(Event.PAYMENT_RECEIVED)
    .create();

// No endpoint do webhook:
public void receberWebhook(WebhookPayload payload) {
    if (payload.getEvent().equals("PAYMENT_RECEIVED")) {
        String paymentId = payload.getPayment().getId();
        emitirNotaFiscal(paymentId);
    }
}
```

## Boas Práticas

### 1. Valide Dados Antes de Emitir

```java
public static boolean validarDados(String descricao, double valor) {
    if (descricao == null || descricao.isEmpty()) {
        System.err.println("Descrição obrigatória");
        return false;
    }
    
    if (valor <= 0) {
        System.err.println("Valor deve ser maior que zero");
        return false;
    }
    
    return true;
}
```

### 2. Trate Erros de Emissão

```java
try {
    Invoice nota = Invoice.creator()
        .setServiceDescription("Serviço")
        .setValue(Money.create(new BigDecimal("1000.00")))
        .setEffectiveDate(new Date())
        .create();
} catch (AsaasException e) {
    System.err.println("Erro ao emitir nota: " + e.getMessage());
    // Registrar erro e tentar novamente depois
}
```

### 3. Armazene URLs de PDF e XML

```java
Invoice nota = Invoice.creator()
    .setServiceDescription("Serviço")
    .setValue(Money.create(new BigDecimal("1000.00")))
    .create();

// Salvar no banco de dados
String pdfUrl = nota.getPdfUrl();
String xmlUrl = nota.getXmlUrl();
salvarNoBanco(nota.getId(), pdfUrl, xmlUrl);
```

## Veja Também

- [Cobranças](payment.md) - Criar cobranças para emitir notas
- [Clientes](customeraccount.md) - Gerenciar clientes
- [Webhooks](webhook.md) - Automatizar emissão

## Referências

- [Documentação Oficial - Notas Fiscais](https://docs.asaas.com/reference/emitir-nota-fiscal)
