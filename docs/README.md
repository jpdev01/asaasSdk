# Asaas SDK para Java

[![SonarQube](https://sonarcloud.io/api/project_badges/measure?project=jpdev01_asaasSdk&metric=alert_status)](https://sonarcloud.io/summary/overall?id=jpdev01_asaasSdk)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.jpdev01/asaassdk.svg)](https://repo1.maven.org/maven2/io/github/jpdev01/asaassdk/)

SDK Java oficial para integração com a API do [Asaas](https://asaas.com.br), desenvolvido por [@jpdev01](https://github.com/jpdev01) para facilitar o desenvolvimento de aplicações que utilizam os serviços de pagamento do Asaas.

## 📋 Índice

- [Instalação](#-instalação)
- [Início Rápido](#-início-rápido)
- [Configuração](#-configuração)
- [Recursos](#-recursos)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Documentação Completa](#-documentação-completa)
- [Suporte e Contribuição](#-suporte-e-contribuição)

## 🚀 Começando

Novo no SDK? Comece pelo [Guia de Início Rápido](quickstart.md) para estar operacional em minutos!

## 🚀 Instalação

### Maven

Adicione a dependência no seu `pom.xml`:

```xml
<dependency>
    <groupId>io.github.jpdev01</groupId>
    <artifactId>asaassdk</artifactId>
    <version>4</version>
</dependency>
```

### Gradle

```gradle
implementation 'io.github.jpdev01:asaassdk:1.4'
```

## ⚡ Início Rápido

### 1. Inicialização

Antes de realizar qualquer requisição, inicialize o SDK com sua chave de API:

```java
import io.github.jpdev.asaassdk.Asaas;

public class Main {
    public static void main(String[] args) {
        // Ambiente de produção
        Asaas.init("sua_chave_api");

        // Ou ambiente sandbox para testes
        Asaas.initSandbox("sua_chave_api_sandbox");
    }
}
```

## ⚙️ Configurações adicionais

[Configurações adicionais](./extra.md)

## 🎯 Recursos

O SDK oferece suporte completo para todos os recursos da API Asaas:

### Pagamentos e Cobranças
- ✅ Cobranças (Boleto, PIX, Cartão de Crédito)
- ✅ Cobranças Parceladas
- ✅ Split de Pagamentos
- ✅ Links de Pagamento
- ✅ Assinaturas Recorrentes
- ✅ Estornos

### PIX
- ✅ QR Code Estático e Dinâmico
- ✅ Chaves PIX (Criar, Listar, Deletar)
- ✅ Transações PIX
- ✅ PIX Automático (Débito Recorrente)
- ✅ Pagamento via QR Code

### Transferências
- ✅ TED
- ✅ PIX
- ✅ Transferências Internas (entre contas Asaas)
- ✅ Transferências Recorrentes

### Gestão de Conta
- ✅ Clientes
- ✅ Subcontas
- ✅ Saldo e Extrato
- ✅ Dados Comerciais
- ✅ Taxas da Conta
- ✅ Status da Conta

### Outros
- ✅ Webhooks
- ✅ Notificações
- ✅ Notas Fiscais
- ✅ Pagamento de Contas (Boletos)


## 📖 Documentação Completa

### Guias por Funcionalidade

#### 🚀 Começando
- [Guia de Início Rápido](quickstart.md) - Primeiros passos com o SDK

#### Pagamentos
- [Cobranças](payment.md) - Criar, listar, estornar cobranças
- [Cobranças com Split](payment_split.md) - Divisão de pagamentos
- [Links de Pagamento](paymentlink.md) - Criar links de checkout
- [Assinaturas](subscription.md) - Pagamentos recorrentes
- [Parcelamentos](installment.md) - Gestão de parcelas

#### PIX
- [PIX - QR Code e Chaves](pix_dict.md) - Gerenciar chaves e QR codes
- [PIX - Transações](pix_transaction.md) - Enviar e receber PIX
- [PIX Automático](pix_automatic.md) - Débito recorrente via PIX

#### Transferências e Pagamentos
- [Transferências](transfer.md) - TED, PIX e transferências internas
- [Pagar Contas](bill.md) - Pagamento de boletos

#### Gestão
- [Clientes](customeraccount.md) - CRUD de clientes
- [Subcontas](account.md) - Gerenciar subcontas
- [Saldo](balance.md) - Consultar saldo
- [Extrato](financial.md) - Transações financeiras
- [Dados Comerciais](commercialinfo.md) - Informações da empresa
- [Status da Conta](myaccount.md) - Situação da conta
- [Taxas](accountfee.md) - Consultar taxas
- [Número de Conta](accountnumber.md) - Dados bancários

#### Notificações e Integrações
- [Webhooks](webhook.md) - Configurar notificações automáticas
- [Notificações](notification.md) - Gerenciar notificações
- [Notas Fiscais](invoice.md) - Emitir NF-e

#### Configurações
- [Configurações Extras](extra.md) - Sandbox, timeout, rate limit
- [Rate Limit](ratelimit.md) - Limites de requisição

### Recursos Adicionais

- [Exemplos Completos](https://github.com/jpdev01/asaasSdk/blob/master/src/main/java/io/github/jpdev/asaassdk/doc/Examples.java)
- [Documentação Oficial da API Asaas](https://docs.asaas.com/docs/visao-geral)
- [Repositório Maven](https://repo1.maven.org/maven2/io/github/jpdev01/asaassdk/)

## 🔒 Segurança

- Nunca exponha suas chaves de API em código público
- Use variáveis de ambiente para armazenar credenciais
- Utilize o ambiente sandbox para testes
- Implemente validação de webhooks para garantir autenticidade

```java
// Exemplo usando variável de ambiente
String apiKey = System.getenv("ASAAS_API_KEY");
Asaas.init(apiKey);
```

## 🐛 Tratamento de Erros

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
    // Trate o erro apropriadamente
}
```

## 📊 Análise de Qualidade

O projeto é continuamente analisado pelo SonarQube. Confira o relatório completo:
- [SonarCloud - Análise de Código](https://sonarcloud.io/summary/overall?id=jpdev01_asaasSdk)

## 🤝 Suporte e Contribuição

### Reportar Problemas

Encontrou um bug ou tem uma sugestão? Abra uma [issue no GitHub](https://github.com/jpdev01/asaasSdk/issues).

### Contribuir

Contribuições são bem-vindas! Sinta-se à vontade para abrir Pull Requests com as alterações

### Comunidade

- [GitHub](https://github.com/jpdev01/asaasSdk)
- [Documentação Asaas](https://docs.asaas.com)

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 🙏 Agradecimentos

Desenvolvido com ❤️ por [@jpdev01](https://github.com/jpdev01)

---

**Nota**: Este SDK não é oficial e não possui vínculo direto com o Asaas. Para suporte oficial da API, consulte a [documentação do Asaas](https://docs.asaas.com).
