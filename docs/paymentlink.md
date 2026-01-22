# Links de Pagamento (Payment Links)

Crie páginas de checkout personalizadas sem programação. Compartilhe links para receber pagamentos de forma simples.

## 📋 Índice

- [Criar Link](#criar-link)
- [Listar Links](#listar-links)
- [Atualizar Link](#atualizar-link)
- [Deletar Link](#deletar-link)
- [Tipos de Cobrança](#tipos-de-cobrança)

## Criar Link

### Link Básico

```java
import io.github.jpdev.asaassdk.rest.paymentlink.PaymentLink;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.enums.PaymentLinkChargeType;

PaymentLink link = PaymentLink.creator()
    .setName("Produto Digital")
    .setBillingType(BillingType.PIX)
    .setChargeType(PaymentLinkChargeType.DETACHED)
    .create();

System.out.println("Link criado: " + link.getId());
System.out.println("URL: " + link.getUrl());
```

### Link com Valor Fixo

```java
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;

PaymentLink link = PaymentLink.creator()
    .setName("Curso Online")
    .setDescription("Curso completo de programação")
    .setBillingType(BillingType.CREDIT_CARD)
    .setChargeType(PaymentLinkChargeType.DETACHED)
    .setValue(Money.create(new BigDecimal("297.00")))
    .create();

System.out.println("Link: " + link.getUrl());
System.out.println("Valor: R$ 297,00");
```

### Link com Parcelamento

```java
PaymentLink link = PaymentLink.creator()
    .setName("Notebook")
    .setDescription("Notebook Dell Inspiron")
    .setBillingType(BillingType.CREDIT_CARD)
    .setChargeType(PaymentLinkChargeType.INSTALLMENT)
    .setValue(Money.create(new BigDecimal("3000.00")))
    .setMaxInstallmentCount(12) // Até 12x
    .create();

System.out.println("Link criado com parcelamento em até 12x");
```

### Link com Data de Expiração

```java
import java.util.Calendar;

Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 30); // Expira em 30 dias
Date dataExpiracao = cal.getTime();

PaymentLink link = PaymentLink.creator()
    .setName("Promoção Limitada")
    .setBillingType(BillingType.PIX)
    .setChargeType(PaymentLinkChargeType.DETACHED)
    .setValue(Money.create(new BigDecimal("99.00")))
    .setEndDate(dataExpiracao)
    .create();

System.out.println("Link expira em: " + link.getEndDate());
```

### Link com Limite de Vencimento

```java
PaymentLink link = PaymentLink.creator()
    .setName("Mensalidade")
    .setBillingType(BillingType.BOLETO)
    .setChargeType(PaymentLinkChargeType.DETACHED)
    .setValue(Money.create(new BigDecimal("150.00")))
    .setDueDateLimitDays(5) // Cliente tem 5 dias para pagar
    .create();

System.out.println("Prazo de pagamento: 5 dias");
```

### Link com Múltiplas Formas de Pagamento

```java
PaymentLink link = PaymentLink.creator()
    .setName("Produto Versátil")
    .setBillingType(BillingType.UNDEFINED) // Cliente escolhe
    .setChargeType(PaymentLinkChargeType.DETACHED)
    .setValue(Money.create(new BigDecimal("500.00")))
    .create();

System.out.println("Cliente pode escolher: PIX, Boleto ou Cartão");
```

### Link com Assinatura

```java
import io.github.jpdev.asaassdk.enums.SubscriptionCycle;

PaymentLink link = PaymentLink.creator()
    .setName("Plano Premium")
    .setDescription("Acesso completo à plataforma")
    .setBillingType(BillingType.CREDIT_CARD)
    .setChargeType(PaymentLinkChargeType.RECURRENT)
    .setValue(Money.create(new BigDecimal("49.90")))
    .setSubscriptionCycle(SubscriptionCycle.MONTHLY)
    .create();

System.out.println("Link de assinatura mensal criado");
```

## Listar Links

### Listar Todos

```java
import io.github.jpdev.asaassdk.rest.paymentlink.ResourceSet;

ResourceSet<PaymentLink> links = PaymentLink.reader().read();

for (PaymentLink link : links.getData()) {
    System.out.println("Nome: " + link.getName());
    System.out.println("URL: " + link.getUrl());
    System.out.println("Valor: R$ " + link.getValue());
    System.out.println("Status: " + link.getActive());
    System.out.println("---");
}
```

### Filtrar por Status

```java
// Apenas links ativos
ResourceSet<PaymentLink> ativos = PaymentLink.reader()
    .setActive(true)
    .read();

// Apenas links inativos
ResourceSet<PaymentLink> inativos = PaymentLink.reader()
    .setActive(false)
    .read();
```

### Paginação

```java
ResourceSet<PaymentLink> links = PaymentLink.reader()
    .setLimit(50)
    .setOffset(0)
    .read();

System.out.println("Total: " + links.getTotalCount());
System.out.println("Tem mais: " + links.hasMore());
```

## Atualizar Link

### Atualizar Valor

```java
PaymentLink atualizado = PaymentLink.updater("725104409743")
    .setValue(Money.create(new BigDecimal("399.00")))
    .update();

System.out.println("Novo valor: R$ " + atualizado.getValue());
```

### Atualizar Nome e Descrição

```java
PaymentLink atualizado = PaymentLink.updater("725104409743")
    .setName("Novo Nome do Produto")
    .setDescription("Nova descrição detalhada")
    .update();
```

### Atualizar Data de Expiração

```java
Calendar cal = Calendar.getInstance();
cal.add(Calendar.MONTH, 1);
Date novaData = cal.getTime();

PaymentLink atualizado = PaymentLink.updater("725104409743")
    .setEndDate(novaData)
    .update();

System.out.println("Nova data de expiração: " + atualizado.getEndDate());
```

### Desativar Link

```java
PaymentLink atualizado = PaymentLink.updater("725104409743")
    .setActive(false)
    .update();

System.out.println("Link desativado");
```

## Recuperar Link

```java
PaymentLink link = PaymentLink.fetcher("725104409743").fetch();

System.out.println("=== DETALHES DO LINK ===");
System.out.println("ID: " + link.getId());
System.out.println("Nome: " + link.getName());
System.out.println("URL: " + link.getUrl());
System.out.println("Valor: R$ " + link.getValue());
System.out.println("Tipo: " + link.getChargeType());
System.out.println("Forma de pagamento: " + link.getBillingType());
System.out.println("Ativo: " + link.getActive());
System.out.println("Data de criação: " + link.getDateCreated());
```

## Deletar Link

```java
import io.github.jpdev.asaassdk.rest.paymentlink.DeletedResource;

DeletedResource deletado = PaymentLink.deleter("725104409743").delete();

if (deletado.isDeleted()) {
    System.out.println("Link deletado com sucesso");
}
```

## Tipos de Cobrança

| Tipo | Descrição | Uso |
|------|-----------|-----|
| `DETACHED` | Cobrança avulsa | Venda única |
| `INSTALLMENT` | Parcelamento | Venda parcelada |
| `RECURRENT` | Recorrente | Assinatura |

## Casos de Uso

### E-commerce

```java
public class LinkEcommerce {
    
    public static PaymentLink criarLinkProduto(
        String nomeProduto,
        String descricao,
        double preco,
        int maxParcelas
    ) {
        PaymentLink link = PaymentLink.creator()
            .setName(nomeProduto)
            .setDescription(descricao)
            .setBillingType(BillingType.CREDIT_CARD)
            .setChargeType(PaymentLinkChargeType.INSTALLMENT)
            .setValue(Money.create(new BigDecimal(preco)))
            .setMaxInstallmentCount(maxParcelas)
            .create();
        
        System.out.println("Link do produto criado:");
        System.out.println("URL: " + link.getUrl());
        System.out.println("Parcelamento: até " + maxParcelas + "x");
        
        return link;
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        criarLinkProduto("Smartphone XYZ", "Smartphone top de linha", 2500.00, 10);
    }
}
```

### Serviços Digitais

```java
public class LinkServicosDigitais {
    
    public static PaymentLink criarLinkCurso(
        String nomeCurso,
        double preco
    ) {
        PaymentLink link = PaymentLink.creator()
            .setName(nomeCurso)
            .setDescription("Acesso vitalício ao curso")
            .setBillingType(BillingType.PIX)
            .setChargeType(PaymentLinkChargeType.DETACHED)
            .setValue(Money.create(new BigDecimal(preco)))
            .create();
        
        System.out.println("Link do curso: " + link.getUrl());
        return link;
    }
}
```

### Assinaturas

```java
public class LinkAssinatura {
    
    public static PaymentLink criarPlano(
        String nomePlano,
        double valorMensal,
        SubscriptionCycle ciclo
    ) {
        PaymentLink link = PaymentLink.creator()
            .setName(nomePlano)
            .setDescription("Assinatura " + ciclo.toString().toLowerCase())
            .setBillingType(BillingType.CREDIT_CARD)
            .setChargeType(PaymentLinkChargeType.RECURRENT)
            .setValue(Money.create(new BigDecimal(valorMensal)))
            .setSubscriptionCycle(ciclo)
            .create();
        
        System.out.println("Plano criado: " + link.getUrl());
        return link;
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        
        // Plano mensal
        criarPlano("Plano Básico", 29.90, SubscriptionCycle.MONTHLY);
        
        // Plano anual
        criarPlano("Plano Anual", 299.00, SubscriptionCycle.YEARLY);
    }
}
```

### Doações

```java
public class LinkDoacao {
    
    public static PaymentLink criarLinkDoacao(String causa) {
        PaymentLink link = PaymentLink.creator()
            .setName("Doação - " + causa)
            .setDescription("Contribua com qualquer valor")
            .setBillingType(BillingType.PIX)
            .setChargeType(PaymentLinkChargeType.DETACHED)
            // Sem valor fixo - cliente define
            .create();
        
        System.out.println("Link de doação: " + link.getUrl());
        return link;
    }
}
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.paymentlink.PaymentLink;
import io.github.jpdev.asaassdk.enums.*;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class ExemploPaymentLink {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Criar link de pagamento
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date dataExpiracao = cal.getTime();
        
        PaymentLink link = PaymentLink.creator()
            .setName("Curso de Java Avançado")
            .setDescription("Curso completo com certificado")
            .setBillingType(BillingType.CREDIT_CARD)
            .setChargeType(PaymentLinkChargeType.INSTALLMENT)
            .setValue(Money.create(new BigDecimal("497.00")))
            .setMaxInstallmentCount(6)
            .setEndDate(dataExpiracao)
            .setDueDateLimitDays(7)
            .create();
        
        System.out.println("=== LINK DE PAGAMENTO CRIADO ===");
        System.out.println("ID: " + link.getId());
        System.out.println("Nome: " + link.getName());
        System.out.println("URL: " + link.getUrl());
        System.out.println("Valor: R$ " + link.getValue());
        System.out.println("Parcelamento: até 6x");
        System.out.println("Expira em: " + link.getEndDate());
        
        // Compartilhar URL
        System.out.println("\nCompartilhe este link:");
        System.out.println(link.getUrl());
        
        // Atualizar link
        PaymentLink atualizado = PaymentLink.updater(link.getId())
            .setDescription("Curso completo com certificado + bônus")
            .update();
        
        System.out.println("\nDescrição atualizada!");
        
        // Listar todos os links
        ResourceSet<PaymentLink> links = PaymentLink.reader().read();
        System.out.println("\nTotal de links: " + links.getTotalCount());
    }
}
```

## Gerenciamento de Links

### Dashboard de Links

```java
public class DashboardLinks {
    
    public static void exibirDashboard() {
        ResourceSet<PaymentLink> todos = PaymentLink.reader().read();
        ResourceSet<PaymentLink> ativos = PaymentLink.reader()
            .setActive(true)
            .read();
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     DASHBOARD DE LINKS                 ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Total de links: " + todos.getTotalCount());
        System.out.println("║ Links ativos: " + ativos.getTotalCount());
        System.out.println("║ Links inativos: " + (todos.getTotalCount() - ativos.getTotalCount()));
        System.out.println("╚════════════════════════════════════════╝");
    }
}
```

### Relatório de Vendas por Link

```java
public class RelatorioVendas {
    
    public static void gerarRelatorio(String linkId) {
        PaymentLink link = PaymentLink.fetcher(linkId).fetch();
        
        // Buscar pagamentos do link
        ResourceSet<Payment> pagamentos = Payment.reader()
            .setPaymentLink(linkId)
            .read();
        
        double totalVendas = 0;
        int totalPagamentos = 0;
        
        for (Payment p : pagamentos.getData()) {
            if (p.getStatus().equals("RECEIVED") || 
                p.getStatus().equals("CONFIRMED")) {
                totalVendas += p.getValue();
                totalPagamentos++;
            }
        }
        
        System.out.println("=== RELATÓRIO DE VENDAS ===");
        System.out.println("Link: " + link.getName());
        System.out.println("Total de pagamentos: " + totalPagamentos);
        System.out.println("Total vendido: R$ " + String.format("%.2f", totalVendas));
    }
}
```

## Boas Práticas

### 1. Use Nomes Descritivos

```java
PaymentLink link = PaymentLink.creator()
    .setName("Curso Java - Turma Janeiro 2024")
    .setDescription("Descrição completa do produto")
    .create();
```

### 2. Defina Data de Expiração

```java
Calendar cal = Calendar.getInstance();
cal.add(Calendar.MONTH, 3); // Expira em 3 meses

PaymentLink link = PaymentLink.creator()
    .setName("Promoção")
    .setEndDate(cal.getTime())
    .create();
```

### 3. Configure Parcelamento Adequado

```java
// Para produtos de alto valor
PaymentLink link = PaymentLink.creator()
    .setName("Produto Premium")
    .setValue(Money.create(new BigDecimal("5000.00")))
    .setMaxInstallmentCount(12)
    .create();
```

### 4. Monitore Links Ativos

```java
ResourceSet<PaymentLink> ativos = PaymentLink.reader()
    .setActive(true)
    .read();

if (ativos.getTotalCount() > 100) {
    System.out.println("⚠️ Muitos links ativos. Considere desativar os não utilizados.");
}
```

## Veja Também

- [Cobranças](payment.md) - Criar cobranças diretas
- [Assinaturas](subscription.md) - Pagamentos recorrentes
- [Clientes](customeraccount.md) - Gerenciar clientes

## Referências

- [Documentação Oficial - Links de Pagamento](https://docs.asaas.com/reference/criar-link-de-pagamento)
