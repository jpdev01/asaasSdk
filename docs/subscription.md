# Assinaturas (Subscriptions)

Crie e gerencie cobranças recorrentes automáticas. Ideal para SaaS, academias, escolas e qualquer negócio com pagamentos mensais.

## 📋 Índice

- [Criar Assinatura](#criar-assinatura)
- [Listar Assinaturas](#listar-assinaturas)
- [Recuperar Assinatura](#recuperar-assinatura)
- [Atualizar Assinatura](#atualizar-assinatura)
- [Cancelar Assinatura](#cancelar-assinatura)
- [Ciclos de Cobrança](#ciclos-de-cobrança)

## Criar Assinatura

### Assinatura Mensal

```java
import io.github.jpdev.asaassdk.rest.subscription.Subscription;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.enums.SubscriptionCycle;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Plano Premium")
    .create();

System.out.println("Assinatura criada: " + assinatura.getId());
System.out.println("Próximo vencimento: " + assinatura.getNextDueDate());
```

### Assinatura Anual

```java
Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.BOLETO)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("999.00")))
    .setCycle(SubscriptionCycle.YEARLY)
    .setDescription("Plano Anual")
    .create();
```

### Assinatura Semanal

```java
Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.PIX)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("29.90")))
    .setCycle(SubscriptionCycle.WEEKLY)
    .setDescription("Plano Semanal")
    .create();
```

### Assinatura Trimestral

```java
Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("249.90")))
    .setCycle(SubscriptionCycle.QUARTERLY)
    .setDescription("Plano Trimestral")
    .create();
```

### Assinatura Semestral

```java
Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("499.90")))
    .setCycle(SubscriptionCycle.SEMIANNUALLY)
    .setDescription("Plano Semestral")
    .create();
```

### Assinatura com Desconto

```java
Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Plano Premium com desconto")
    .setDiscount(Money.create(new BigDecimal("10.00"))) // R$ 10 de desconto
    .create();

System.out.println("Valor com desconto: R$ 89,90");
```

### Assinatura com Juros e Multa

```java
Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.BOLETO)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("150.00")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Mensalidade")
    .setInterest(Money.create(new BigDecimal("2.00"))) // R$ 2,00 por dia de atraso
    .setFine(Money.create(new BigDecimal("10.00"))) // R$ 10,00 de multa
    .create();
```

### Assinatura com Data de Término

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.add(Calendar.MONTH, 12); // 12 meses a partir de hoje
Date dataTermino = cal.getTime();

Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Plano com término definido")
    .setEndDate(dataTermino)
    .create();

System.out.println("Assinatura válida até: " + assinatura.getEndDate());
```

### Assinatura com Número Máximo de Cobranças

```java
Subscription assinatura = Subscription.creator()
    .setCustomer("cus_000072683044")
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Plano de 6 meses")
    .setMaxPayments(6) // Apenas 6 cobranças
    .create();
```

## Listar Assinaturas

### Listar Todas

```java
import io.github.jpdev.asaassdk.rest.subscription.ResourceSet;

ResourceSet<Subscription> assinaturas = Subscription.reader().read();

for (Subscription assinatura : assinaturas.getData()) {
    System.out.println("ID: " + assinatura.getId());
    System.out.println("Cliente: " + assinatura.getCustomer());
    System.out.println("Valor: R$ " + assinatura.getValue());
    System.out.println("Status: " + assinatura.getStatus());
    System.out.println("Ciclo: " + assinatura.getCycle());
    System.out.println("Próximo vencimento: " + assinatura.getNextDueDate());
    System.out.println("---");
}
```

### Filtrar por Status

```java
import io.github.jpdev.asaassdk.enums.SubscriptionStatus;

// Apenas assinaturas ativas
ResourceSet<Subscription> ativas = Subscription.reader()
    .setStatus(SubscriptionStatus.ACTIVE)
    .read();

// Apenas assinaturas expiradas
ResourceSet<Subscription> expiradas = Subscription.reader()
    .setStatus(SubscriptionStatus.EXPIRED)
    .read();
```

### Filtrar por Cliente

```java
ResourceSet<Subscription> assinaturas = Subscription.reader()
    .setCustomer("cus_000072683044")
    .read();

System.out.println("Cliente possui " + assinaturas.getTotalCount() + " assinatura(s)");
```

### Filtrar por Cliente e Status

```java
ResourceSet<Subscription> assinaturasAtivas = Subscription.reader()
    .setCustomer("cus_000072683044")
    .setStatus(SubscriptionStatus.ACTIVE)
    .read();
```

### Filtrar por Tipo de Cobrança

```java
// Assinaturas com cartão de crédito
ResourceSet<Subscription> cartao = Subscription.reader()
    .setBillingType(BillingType.CREDIT_CARD)
    .read();

// Assinaturas com PIX
ResourceSet<Subscription> pix = Subscription.reader()
    .setBillingType(BillingType.PIX)
    .read();
```

### Paginação

```java
ResourceSet<Subscription> assinaturas = Subscription.reader()
    .setLimit(50)
    .setOffset(0)
    .read();

System.out.println("Total: " + assinaturas.getTotalCount());
System.out.println("Tem mais: " + assinaturas.hasMore());
```

## Recuperar Assinatura

```java
Subscription assinatura = Subscription.fetcher("sub_123456789").fetch();

System.out.println("ID: " + assinatura.getId());
System.out.println("Cliente: " + assinatura.getCustomer());
System.out.println("Valor: R$ " + assinatura.getValue());
System.out.println("Status: " + assinatura.getStatus());
System.out.println("Ciclo: " + assinatura.getCycle());
System.out.println("Próximo vencimento: " + assinatura.getNextDueDate());
System.out.println("Data de criação: " + assinatura.getDateCreated());
```

## Atualizar Assinatura

### Atualizar Valor

```java
Subscription atualizada = Subscription.updater("sub_123456789")
    .setValue(Money.create(new BigDecimal("149.90")))
    .update();

System.out.println("Novo valor: R$ " + atualizada.getValue());
```

### Atualizar Forma de Pagamento

```java
Subscription atualizada = Subscription.updater("sub_123456789")
    .setBillingType(BillingType.PIX)
    .update();

System.out.println("Nova forma de pagamento: PIX");
```

### Atualizar Próximo Vencimento

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 15);
Date novoVencimento = cal.getTime();

Subscription atualizada = Subscription.updater("sub_123456789")
    .setNextDueDate(novoVencimento)
    .update();

System.out.println("Próximo vencimento: " + atualizada.getNextDueDate());
```

### Atualizar Descrição

```java
Subscription atualizada = Subscription.updater("sub_123456789")
    .setDescription("Plano Premium Plus")
    .update();
```

### Atualizar Múltiplos Campos

```java
Subscription atualizada = Subscription.updater("sub_123456789")
    .setValue(Money.create(new BigDecimal("199.90")))
    .setDescription("Plano Enterprise")
    .setBillingType(BillingType.CREDIT_CARD)
    .update();
```

## Cancelar Assinatura

```java
import io.github.jpdev.asaassdk.rest.subscription.SubscriptionDeleted;

SubscriptionDeleted cancelada = Subscription.deleter("sub_123456789").delete();

if (cancelada.isDeleted()) {
    System.out.println("Assinatura cancelada com sucesso");
}
```

**Nota**: Ao cancelar uma assinatura, as cobranças futuras não serão mais geradas.

## Ciclos de Cobrança

| Ciclo | Descrição | Enum |
|-------|-----------|------|
| Semanal | A cada 7 dias | `SubscriptionCycle.WEEKLY` |
| Quinzenal | A cada 15 dias | `SubscriptionCycle.BIWEEKLY` |
| Mensal | A cada mês | `SubscriptionCycle.MONTHLY` |
| Bimestral | A cada 2 meses | `SubscriptionCycle.BIMONTHLY` |
| Trimestral | A cada 3 meses | `SubscriptionCycle.QUARTERLY` |
| Semestral | A cada 6 meses | `SubscriptionCycle.SEMIANNUALLY` |
| Anual | A cada ano | `SubscriptionCycle.YEARLY` |

## Status de Assinaturas

| Status | Descrição |
|--------|-----------|
| `ACTIVE` | Assinatura ativa |
| `EXPIRED` | Assinatura expirada |
| `INACTIVE` | Assinatura inativa |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;
import io.github.jpdev.asaassdk.rest.subscription.Subscription;
import io.github.jpdev.asaassdk.enums.*;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

public class ExemploAssinatura {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Criar cliente
        CustomerAccount cliente = CustomerAccount.creator()
            .setName("João Silva")
            .setCpfCnpj("12345678900")
            .setEmail("joao@exemplo.com")
            .create();
        
        System.out.println("Cliente criado: " + cliente.getId());
        
        // Criar assinatura mensal
        Subscription assinatura = Subscription.creator()
            .setCustomer(cliente.getId())
            .setBillingType(BillingType.CREDIT_CARD)
            .setNextDueDate(new Date())
            .setValue(Money.create(new BigDecimal("99.90")))
            .setCycle(SubscriptionCycle.MONTHLY)
            .setDescription("Plano Premium")
            .create();
        
        System.out.println("Assinatura criada: " + assinatura.getId());
        System.out.println("Valor: R$ " + assinatura.getValue());
        System.out.println("Próximo vencimento: " + assinatura.getNextDueDate());
        
        // Listar assinaturas ativas do cliente
        ResourceSet<Subscription> assinaturas = Subscription.reader()
            .setCustomer(cliente.getId())
            .setStatus(SubscriptionStatus.ACTIVE)
            .read();
        
        System.out.println("\nAssinaturas ativas: " + assinaturas.getTotalCount());
        
        // Atualizar valor da assinatura
        Subscription atualizada = Subscription.updater(assinatura.getId())
            .setValue(Money.create(new BigDecimal("149.90")))
            .update();
        
        System.out.println("Valor atualizado para: R$ " + atualizada.getValue());
    }
}
```

## Boas Práticas

### 1. Notifique o Cliente

```java
// Criar assinatura e enviar email de confirmação
Subscription assinatura = Subscription.creator()
    .setCustomer(clienteId)
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .create();

// Enviar email personalizado ao cliente
enviarEmailConfirmacao(cliente.getEmail(), assinatura);
```

### 2. Configure Webhooks

```java
import io.github.jpdev.asaassdk.rest.webhook.Webhook;
import io.github.jpdev.asaassdk.enums.Event;

Webhook webhook = Webhook.creator()
    .setUrl("https://seusite.com/webhook/asaas")
    .addEvent(Event.PAYMENT_RECEIVED)
    .addEvent(Event.PAYMENT_OVERDUE)
    .create();
```

### 3. Trate Erros de Pagamento

```java
// Monitorar cobranças da assinatura
ResourceSet<Payment> cobrancas = Payment.reader()
    .setSubscription(assinaturaId)
    .setStatus(PaymentStatus.OVERDUE)
    .read();

if (cobrancas.getTotalCount() > 0) {
    // Notificar cliente sobre pagamento em atraso
    // Suspender acesso ao serviço
}
```

### 4. Ofereça Período de Teste

```java
import java.util.Calendar;

// Primeira cobrança daqui a 7 dias (trial de 7 dias)
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 7);

Subscription assinatura = Subscription.creator()
    .setCustomer(clienteId)
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(cal.getTime())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Plano Premium - Trial 7 dias")
    .create();
```

## Casos de Uso

### SaaS

```java
// Plano mensal de software
Subscription saas = Subscription.creator()
    .setCustomer(clienteId)
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("49.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Plano Básico")
    .create();
```

### Academia

```java
// Mensalidade de academia
Subscription academia = Subscription.creator()
    .setCustomer(clienteId)
    .setBillingType(BillingType.BOLETO)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("120.00")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Mensalidade Academia")
    .setFine(Money.create(new BigDecimal("10.00")))
    .setInterest(Money.create(new BigDecimal("1.00")))
    .create();
```

### Escola

```java
// Mensalidade escolar
Subscription escola = Subscription.creator()
    .setCustomer(clienteId)
    .setBillingType(BillingType.BOLETO)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("800.00")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Mensalidade Escolar")
    .setMaxPayments(12) // 12 meses letivos
    .create();
```

## Veja Também

- [Cobranças](payment.md) - Gerenciar cobranças individuais
- [Clientes](customeraccount.md) - Gerenciar clientes
- [Webhooks](webhook.md) - Notificações automáticas
- [Parcelamentos](installment.md) - Cobranças parceladas

## Referências

- [Documentação Oficial - Assinaturas](https://docs.asaas.com/reference/assinaturas)
