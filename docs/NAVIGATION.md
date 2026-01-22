# 🗺️ Mapa de Navegação - Asaas SDK

Guia visual para encontrar rapidamente o que você precisa na documentação.

## 🎯 Comece Aqui

```
┌─────────────────────────────────────────────────────────────┐
│                                                             │
│  👋 NOVO NO SDK?                                            │
│                                                             │
│  1. Leia o README.md                                        │
│  2. Siga o quickstart.md                                    │
│  3. Explore os exemplos práticos                            │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

## 📚 Estrutura da Documentação

```
📁 Asaas SDK Documentation
│
├── 📄 README.md ⭐ COMECE AQUI
│   └── Visão geral completa do SDK
│
├── 📄 quickstart.md ⚡ INÍCIO RÁPIDO
│   └── Seu primeiro código em minutos
│
├── 📄 INDEX.md 🗂️ ÍNDICE COMPLETO
│   └── Navegação por categoria
│
├── 📄 IMPROVEMENTS.md 📝 NOVIDADES
│   └── O que foi melhorado
│
├── 💰 PAGAMENTOS
│   ├── payment.md ⭐ PRINCIPAL
│   │   ├── Criar cobranças (PIX, Boleto, Cartão)
│   │   ├── Listar e filtrar
│   │   ├── Estornar
│   │   └── Gerenciar status
│   │
│   ├── subscription.md 🔄 RECORRENTE
│   │   ├── Assinaturas mensais/anuais
│   │   ├── Todos os ciclos
│   │   └── Casos de uso (SaaS, Academia, etc)
│   │
│   ├── payment_split.md 🔀 MARKETPLACE
│   │   └── Dividir pagamentos
│   │
│   ├── paymentlink.md 🔗 CHECKOUT
│   │   └── Links de pagamento
│   │
│   └── installment.md 📊 PARCELAS
│       └── Gerenciar parcelamentos
│
├── 🔷 PIX
│   ├── pix_dict.md ⭐ QR CODE E CHAVES
│   │   ├── Criar QR Codes
│   │   ├── Gerenciar chaves
│   │   └── Decodificar QR Codes
│   │
│   ├── pix_transaction.md 💸 TRANSAÇÕES
│   │   ├── Enviar PIX
│   │   ├── Pagar QR Code
│   │   ├── PIX recorrente
│   │   └── Agendamento
│   │
│   └── pix_automatic.md 🤖 AUTOMÁTICO
│       └── Débito recorrente via PIX
│
├── 👥 CLIENTES
│   ├── customeraccount.md ⭐ PRINCIPAL
│   │   ├── Criar clientes (PF/PJ)
│   │   ├── Listar e filtrar
│   │   ├── Atualizar dados
│   │   └── Validações
│   │
│   └── notification.md 🔔 NOTIFICAÇÕES
│       └── Gerenciar notificações
│
├── 💸 TRANSFERÊNCIAS
│   ├── transfer.md ⭐ PRINCIPAL
│   │   ├── TED
│   │   ├── PIX
│   │   └── Transferências internas
│   │
│   └── bill.md 📄 PAGAR CONTAS
│       └── Pagamento de boletos
│
├── 🏢 GESTÃO DE CONTA
│   ├── balance.md 💰 SALDO
│   ├── financial.md 📊 EXTRATO
│   ├── account.md 🏦 SUBCONTAS
│   ├── accountfee.md 💵 TAXAS
│   ├── accountnumber.md 🔢 DADOS BANCÁRIOS
│   ├── myaccount.md ✅ STATUS
│   └── commercialinfo.md 🏢 DADOS COMERCIAIS
│
├── 🔗 INTEGRAÇÕES
│   ├── webhook.md ⭐ WEBHOOKS
│   │   └── Notificações automáticas
│   │
│   └── invoice.md 📑 NOTAS FISCAIS
│       └── Emitir NF-e
│
└── ⚙️ CONFIGURAÇÕES
    ├── extra.md 🔧 EXTRAS
    │   ├── Sandbox
    │   ├── Timeout
    │   └── Rate limit
    │
    └── ratelimit.md 📈 LIMITES
        └── Entender rate limits
```

## 🎯 Fluxos Comuns

### 💳 Receber um Pagamento

```
1. customeraccount.md → Criar cliente
2. payment.md → Criar cobrança
3. webhook.md → Configurar notificações
4. payment.md → Verificar status
```

### 🔄 Criar Assinatura Recorrente

```
1. customeraccount.md → Criar cliente
2. subscription.md → Criar assinatura
3. webhook.md → Configurar notificações
4. payment.md → Monitorar cobranças
```

### 💸 Enviar um PIX

```
1. pix_dict.md → Criar/verificar chave PIX
2. pix_transaction.md → Enviar PIX
3. balance.md → Verificar saldo
```

### 🛒 E-commerce Completo

```
1. customeraccount.md → Criar cliente
2. payment.md → Criar cobrança
3. webhook.md → Receber notificações
4. payment.md → Confirmar pagamento
5. invoice.md → Emitir nota fiscal (opcional)
```

### 🏪 Marketplace com Split

```
1. account.md → Criar subcontas para vendedores
2. customeraccount.md → Criar cliente comprador
3. payment_split.md → Criar cobrança com split
4. webhook.md → Notificar vendedores
5. transfer.md → Gerenciar repasses
```

### 💼 SaaS com Assinatura

```
1. customeraccount.md → Criar cliente
2. subscription.md → Criar assinatura mensal
3. webhook.md → Monitorar pagamentos
4. payment.md → Tratar inadimplência
5. invoice.md → Emitir NF-e mensal
```

## 🔍 Busca Rápida por Palavra-Chave

| Procurando por... | Vá para... |
|-------------------|------------|
| **Cobrança** | [payment.md](payment.md) |
| **PIX** | [pix_dict.md](pix_dict.md), [pix_transaction.md](pix_transaction.md) |
| **Boleto** | [payment.md](payment.md) |
| **Cartão** | [payment.md](payment.md) |
| **Assinatura** | [subscription.md](subscription.md) |
| **Recorrente** | [subscription.md](subscription.md) |
| **Cliente** | [customeraccount.md](customeraccount.md) |
| **QR Code** | [pix_dict.md](pix_dict.md) |
| **Transferência** | [transfer.md](transfer.md) |
| **TED** | [transfer.md](transfer.md) |
| **Saldo** | [balance.md](balance.md) |
| **Extrato** | [financial.md](financial.md) |
| **Webhook** | [webhook.md](webhook.md) |
| **Notificação** | [notification.md](notification.md), [webhook.md](webhook.md) |
| **Split** | [payment_split.md](payment_split.md) |
| **Marketplace** | [payment_split.md](payment_split.md) |
| **Subconta** | [account.md](account.md) |
| **Nota Fiscal** | [invoice.md](invoice.md) |
| **Sandbox** | [extra.md](extra.md) |
| **Rate Limit** | [ratelimit.md](ratelimit.md) |
| **Link de Pagamento** | [paymentlink.md](paymentlink.md) |
| **Parcelamento** | [installment.md](installment.md) |

## 📊 Por Nível de Experiência

### 🌱 Iniciante

**Comece por aqui:**
1. [README.md](README.md) - Visão geral
2. [quickstart.md](quickstart.md) - Primeiro código
3. [customeraccount.md](customeraccount.md) - Criar clientes
4. [payment.md](payment.md) - Criar cobranças

**Depois explore:**
- [pix_dict.md](pix_dict.md) - PIX básico
- [webhook.md](webhook.md) - Notificações

### 🌿 Intermediário

**Você já sabe o básico, agora:**
1. [subscription.md](subscription.md) - Assinaturas
2. [pix_transaction.md](pix_transaction.md) - Transações PIX
3. [transfer.md](transfer.md) - Transferências
4. [paymentlink.md](paymentlink.md) - Links de pagamento

**Explore também:**
- [balance.md](balance.md) - Gestão financeira
- [financial.md](financial.md) - Extrato
- [invoice.md](invoice.md) - Notas fiscais

### 🌳 Avançado

**Recursos avançados:**
1. [payment_split.md](payment_split.md) - Split de pagamentos
2. [pix_automatic.md](pix_automatic.md) - PIX automático
3. [account.md](account.md) - Subcontas
4. [extra.md](extra.md) - Configurações avançadas

**Otimização:**
- [ratelimit.md](ratelimit.md) - Gerenciar limites
- Todos os filtros e paginação

## 🎨 Legenda

- ⭐ **Documentação principal** - Comece por aqui
- ⚡ **Início rápido** - Para começar rapidamente
- 🔄 **Recorrente** - Pagamentos automáticos
- 🔀 **Split** - Divisão de pagamentos
- 🤖 **Automático** - Processos automatizados
- 💸 **Transações** - Movimentações financeiras
- 🔔 **Notificações** - Alertas e webhooks
- 🔧 **Configurações** - Setup e ajustes

## 💡 Dicas de Navegação

1. **Use o INDEX.md** para visão geral por categoria
2. **Use este mapa** para fluxos específicos
3. **Cada documento tem** um índice no topo
4. **Links "Veja Também"** no final de cada documento
5. **Busque por palavra-chave** na tabela acima

## 🆘 Precisa de Ajuda?

- 📖 Não encontrou o que procura? Veja o [INDEX.md](INDEX.md)
- 🚀 Primeiro uso? Comece pelo [quickstart.md](quickstart.md)
- 💬 Dúvidas? [Abra uma issue](https://github.com/jpdev01/asaasSdk/issues)
- 📚 Documentação oficial: [docs.asaas.com](https://docs.asaas.com)

---

**Navegação feliz! 🎉**
