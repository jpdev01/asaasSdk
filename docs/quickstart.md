# Guia de Início Rápido

Comece a usar o Asaas SDK em minutos! Este guia mostra os passos essenciais para integrar pagamentos na sua aplicação.

## 📦 Instalação

### Maven

Adicione ao seu `pom.xml`:

```xml
<dependency>
    <groupId>io.github.jpdev01</groupId>
    <artifactId>asaassdk</artifactId>
    <version>1.4</version>
</dependency>
```

### Gradle

Adicione ao seu `build.gradle`:

```gradle
implementation 'io.github.jpdev01:asaassdk:1.4'
```

## 🔑 Obter Chave de API

1. Acesse [Asaas](https://www.asaas.com)
2. Faça login na sua conta
3. Vá em **Configurações** → **Integrações** → **API**
4. Copie sua chave de API

**Importante**: Use a chave de produção apenas em ambiente de produção!

## ⚡ Primeiro Código

### 1. Inicializar o SDK

```java
import io.github.jpdev.asaassdk.Asaas;

public class Main {
    public static void main(String[] args) {
        // Ambiente de produção
        Asaas.init("sua_chave_api_producao");
        
        // OU ambiente sandbox (para testes)
        // Asaas.initSandbox("sua_chave_api_sandbox");
    }
}
```

### 2. Criar um Cliente

```java
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;

CustomerAccount cliente = CustomerAccount.creator()
    .setName("João Silva")
    .setCpfCnpj("12345678900")
    .setEmail("joao@exemplo.com")
    .setPhone("47999999999")
    .create();

System.out.println("✅ Cliente criado: " + cliente.getId());
```

### 3. Criar uma Cobrança PIX

```java
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

Payment cobranca = Payment.creator()
    .setCustomer(cliente.getId())
    .setBillingType(BillingType.PIX)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Pagamento de serviço")
    .create();

System.out.println("✅ Cobrança criada: " + cobranca.getId());
System.out.println("📱 QR Code PIX: " + cobranca.getPixQrCode());
```

## 🎯 Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;
import java.util.Date;

public class ExemploCompleto {
    public static void main(String[] args) {
        try {
            // 1. Inicializar SDK
            Asaas.init("sua_chave_api");
            System.out.println("✅ SDK inicializado");
            
            // 2. Criar cliente
            CustomerAccount cliente = CustomerAccount.creator()
                .setName("Maria Santos")
                .setCpfCnpj("12345678900")
                .setEmail("maria@exemplo.com")
                .setPhone("47999999999")
                .create();
            
            System.out.println("✅ Cliente criado: " + cliente.getId());
            
            // 3. Criar cobrança PIX
            Payment cobranca = Payment.creator()
                .setCustomer(cliente.getId())
                .setBillingType(BillingType.PIX)
                .setDueDate(new Date())
                .setValue(Money.create(new BigDecimal("150.00")))
                .setDescription("Pagamento de produto")
                .create();
            
            System.out.println("✅ Cobrança criada: " + cobranca.getId());
            System.out.println("💰 Valor: R$ " + cobranca.getValue());
            System.out.println("📱 QR Code: " + cobranca.getPixQrCode());
            
            // 4. Verificar status
            System.out.println("📊 Status: " + cobranca.getStatus());
            
        } catch (Exception e) {
            System.err.println("❌ Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

## 🚀 Casos de Uso Comuns

### Cobrança com Boleto

```java
Payment boleto = Payment.creator()
    .setCustomer(cliente.getId())
    .setBillingType(BillingType.BOLETO)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("250.00")))
    .setDescription("Mensalidade")
    .create();

System.out.println("Link do boleto: " + boleto.getBankSlipUrl());
```

### Assinatura Mensal

```java
import io.github.jpdev.asaassdk.rest.subscription.Subscription;
import io.github.jpdev.asaassdk.enums.SubscriptionCycle;

Subscription assinatura = Subscription.creator()
    .setCustomer(cliente.getId())
    .setBillingType(BillingType.CREDIT_CARD)
    .setNextDueDate(new Date())
    .setValue(Money.create(new BigDecimal("99.90")))
    .setCycle(SubscriptionCycle.MONTHLY)
    .setDescription("Plano Premium")
    .create();

System.out.println("Assinatura criada: " + assinatura.getId());
```

### Transferência PIX

```java
import io.github.jpdev.asaassdk.rest.transfer.Transfer;
import io.github.jpdev.asaassdk.enums.PixAddressKeyType;

Transfer transfer = Transfer.pixAddressKeyCreator()
    .setPixAddressKey("12345678900")
    .setPixAddressKeyType(PixAddressKeyType.CPF)
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Pagamento fornecedor")
    .create();

System.out.println("PIX enviado: " + transfer.getId());
```

### Webhook para Notificações

```java
import io.github.jpdev.asaassdk.rest.webhook.Webhook;
import io.github.jpdev.asaassdk.enums.Event;
import io.github.jpdev.asaassdk.enums.SendType;

Webhook webhook = Webhook.creator()
    .setName("Notificações de Pagamento")
    .setUrl("https://seusite.com/webhook/asaas")
    .setEmail("notificacoes@seusite.com")
    .setSendType(SendType.SEQUENTIALLY)
    .addEvent(Event.PAYMENT_RECEIVED)
    .addEvent(Event.PAYMENT_CONFIRMED)
    .create();

System.out.println("Webhook configurado: " + webhook.getId());
```

## 🔧 Configurações Úteis

### Ambiente Sandbox

Para testes, use o ambiente sandbox:

```java
Asaas.initSandbox("sua_chave_api_sandbox");
```

### Timeout Personalizado

Ajuste o timeout das requisições (padrão: 30 segundos):

```java
Asaas.setTimeout(10000); // 10 segundos
```

### Verificar Rate Limit

```java
Payment payment = Payment.creator()
    .setCustomer(cliente.getId())
    .setBillingType(BillingType.PIX)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .create();

RateLimit rateLimit = payment.getRateLimit();
System.out.println("Requisições restantes: " + rateLimit.getRemaining());
System.out.println("Limite total: " + rateLimit.getLimit());
System.out.println("Reseta em: " + rateLimit.getReset());
```

## 🛡️ Boas Práticas

### 1. Use Variáveis de Ambiente

Nunca exponha suas chaves de API no código:

```java
String apiKey = System.getenv("ASAAS_API_KEY");
Asaas.init(apiKey);
```

### 2. Trate Erros Adequadamente

```java
try {
    Payment payment = Payment.creator()
        .setCustomer("cus_invalid")
        .setBillingType(BillingType.PIX)
        .setDueDate(new Date())
        .setValue(Money.create(new BigDecimal("100.00")))
        .create();
} catch (AsaasException e) {
    System.err.println("Erro ao criar cobrança: " + e.getMessage());
    // Registrar erro, notificar equipe, etc.
}
```

### 3. Valide Dados de Entrada

```java
String cpf = "123.456.789-00";
String cpfLimpo = cpf.replaceAll("[^0-9]", "");

if (cpfLimpo.length() == 11) {
    CustomerAccount cliente = CustomerAccount.creator()
        .setCpfCnpj(cpfLimpo)
        .setName("Cliente")
        .create();
}
```

### 4. Use Referências Externas

Mantenha sincronização com seu sistema:

```java
CustomerAccount cliente = CustomerAccount.creator()
    .setName("João Silva")
    .setCpfCnpj("12345678900")
    .setExternalReference("CLIENTE_ID_123") // ID do seu sistema
    .create();
```

## 📚 Próximos Passos

Agora que você já sabe o básico, explore mais recursos:

### Pagamentos
- [Cobranças Detalhadas](payment.md)
- [Cobranças com Split](payment_split.md)
- [Links de Pagamento](paymentlink.md)
- [Assinaturas](subscription.md)

### PIX
- [PIX - QR Code e Chaves](pix_dict.md)
- [PIX - Transações](pix_transaction.md)
- [PIX Automático](pix_automatic.md)

### Gestão
- [Clientes](customeraccount.md)
- [Saldo e Extrato](balance.md)
- [Transferências](transfer.md)

### Integrações
- [Webhooks](webhook.md)
- [Notificações](notification.md)

## 🆘 Precisa de Ajuda?

- 📖 [Documentação Completa](README.md)
- 💻 [Exemplos de Código](https://github.com/jpdev01/asaasSdk/blob/master/src/main/java/io/github/jpdev/asaassdk/doc/Examples.java)
- 🌐 [Documentação Oficial Asaas](https://docs.asaas.com)
- 🐛 [Reportar Problemas](https://github.com/jpdev01/asaasSdk/issues)

## ⚠️ Importante

- **Sandbox**: Use para testes, não processa pagamentos reais
- **Produção**: Use apenas com chave de produção válida
- **Segurança**: Nunca exponha suas chaves de API
- **Validação**: Sempre valide dados antes de enviar

---

**Pronto!** Você já está apto para integrar pagamentos com Asaas! 🎉
