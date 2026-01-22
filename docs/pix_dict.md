# PIX - QR Code e Chaves

Gerencie chaves PIX, crie QR Codes estáticos e dinâmicos, e decodifique QR Codes de terceiros.

## 📋 Índice

- [QR Code PIX](#qr-code-pix)
- [Chaves PIX](#chaves-pix)
- [Decodificar QR Code](#decodificar-qr-code)

## QR Code PIX

### Criar QR Code Estático

QR Code estático permite receber pagamentos com valor fixo:

```java
import io.github.jpdev.asaassdk.rest.pix.PixQrCode;
import java.math.BigDecimal;

PixQrCode qrCode = PixQrCode.creator()
    .setAddressKey("sua_chave_pix@email.com")
    .setDescription("Pagamento de produto")
    .setValue(new BigDecimal("50.00"))
    .create();

System.out.println("Payload: " + qrCode.getPayload());
System.out.println("Imagem Base64: " + qrCode.getEncodedImage());
```

### QR Code com Diferentes Chaves

#### Email

```java
PixQrCode qrCode = PixQrCode.creator()
    .setAddressKey("pagamento@empresa.com")
    .setDescription("Pagamento")
    .setValue(new BigDecimal("100.00"))
    .create();
```

#### CPF/CNPJ

```java
PixQrCode qrCode = PixQrCode.creator()
    .setAddressKey("12345678900")
    .setDescription("Pagamento")
    .setValue(new BigDecimal("75.50"))
    .create();
```

#### Telefone

```java
PixQrCode qrCode = PixQrCode.creator()
    .setAddressKey("+5547999999999")
    .setDescription("Pagamento")
    .setValue(new BigDecimal("25.00"))
    .create();
```

#### Chave Aleatória (EVP)

```java
PixQrCode qrCode = PixQrCode.creator()
    .setAddressKey("123e4567-e89b-12d3-a456-426614174000")
    .setDescription("Pagamento")
    .setValue(new BigDecimal("150.00"))
    .create();
```

### QR Code Dinâmico (via Cobrança)

Para criar um QR Code dinâmico, crie uma cobrança PIX:

```java
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.enums.BillingType;
import io.github.jpdev.asaassdk.util.Money;
import java.util.Date;

Payment payment = Payment.creator()
    .setCustomer("cus_000050606806")
    .setBillingType(BillingType.PIX)
    .setDueDate(new Date())
    .setValue(Money.create(new BigDecimal("100.00")))
    .setDescription("Pagamento de serviço")
    .create();

// QR Code disponível na cobrança
String qrCodePayload = payment.getPixQrCode();
String qrCodeImage = payment.getPixQrCodeImage();

System.out.println("QR Code Payload: " + qrCodePayload);
```

### Exibir QR Code

O campo `encodedImage` retorna a imagem em Base64:

```java
PixQrCode qrCode = PixQrCode.creator()
    .setAddressKey("sua_chave@email.com")
    .setValue(new BigDecimal("50.00"))
    .create();

// Imagem em Base64 (pode ser usada diretamente em HTML)
String imagemBase64 = qrCode.getEncodedImage();

// Exemplo de uso em HTML:
// <img src="data:image/png;base64,{imagemBase64}" />
```

## Chaves PIX

### Criar Chave Aleatória (EVP)

Crie uma chave PIX aleatória vinculada à sua conta:

```java
import io.github.jpdev.asaassdk.rest.pix.PixAddressKey;
import io.github.jpdev.asaassdk.enums.PixAddressKeyType;

PixAddressKey chave = PixAddressKey.creator()
    .setType(PixAddressKeyType.EVP)
    .create();

System.out.println("Chave criada: " + chave.getKey());
System.out.println("ID: " + chave.getId());
System.out.println("Status: " + chave.getStatus());
```

### Listar Chaves PIX

#### Listar Todas

```java
import io.github.jpdev.asaassdk.rest.pix.ResourceSet;

ResourceSet<PixAddressKey> chaves = PixAddressKey.reader().read();

for (PixAddressKey chave : chaves.getData()) {
    System.out.println("Chave: " + chave.getKey());
    System.out.println("Tipo: " + chave.getType());
    System.out.println("Status: " + chave.getStatus());
    System.out.println("---");
}
```

#### Filtrar por Status

```java
import io.github.jpdev.asaassdk.enums.PixAddressKeyStatus;

// Apenas chaves ativas
ResourceSet<PixAddressKey> chavesAtivas = PixAddressKey.reader()
    .setStatus(PixAddressKeyStatus.ACTIVE)
    .read();

// Apenas chaves aguardando ativação
ResourceSet<PixAddressKey> chavesAguardando = PixAddressKey.reader()
    .setStatus(PixAddressKeyStatus.AWAITING_ACTIVATION)
    .read();
```

#### Filtrar por Tipo

```java
// Apenas chaves EVP (aleatórias)
ResourceSet<PixAddressKey> chavesEVP = PixAddressKey.reader()
    .setType(PixAddressKeyType.EVP)
    .read();

// Apenas chaves de email
ResourceSet<PixAddressKey> chavesEmail = PixAddressKey.reader()
    .setType(PixAddressKeyType.EMAIL)
    .read();
```

### Recuperar Chave Específica

```java
PixAddressKey chave = PixAddressKey.fetcher("chave_id").fetch();

System.out.println("Chave: " + chave.getKey());
System.out.println("Tipo: " + chave.getType());
System.out.println("Status: " + chave.getStatus());
System.out.println("Data de criação: " + chave.getDateCreated());
```

### Deletar Chave PIX

```java
import io.github.jpdev.asaassdk.rest.pix.PixAddressKeyDeleted;

PixAddressKeyDeleted deleted = PixAddressKey.deleter("chave_id").delete();

if (deleted.isDeleted()) {
    System.out.println("Chave deletada com sucesso");
}
```

**Nota**: A exclusão de chaves PIX pode levar até 7 dias para ser processada pelo Banco Central.

## Decodificar QR Code

Decodifique um QR Code PIX para visualizar as informações antes de pagar:

```java
import io.github.jpdev.asaassdk.rest.pix.PixDecodedQrCode;

String payload = "00020101021226770014br.gov.bcb.pix...";

PixDecodedQrCode decoded = PixDecodedQrCode.decoder()
    .setPayload(payload)
    .create();

System.out.println("Valor: " + decoded.getValue());
System.out.println("Beneficiário: " + decoded.getName());
System.out.println("Cidade: " + decoded.getCity());
System.out.println("Chave: " + decoded.getAddressKey());
System.out.println("Descrição: " + decoded.getDescription());
```

### Validar QR Code Antes de Pagar

```java
try {
    PixDecodedQrCode decoded = PixDecodedQrCode.decoder()
        .setPayload(qrCodePayload)
        .create();
    
    // Validar informações
    if (decoded.getValue().compareTo(new BigDecimal("1000.00")) > 0) {
        System.out.println("ATENÇÃO: Valor alto - R$ " + decoded.getValue());
    }
    
    System.out.println("Você está pagando para: " + decoded.getName());
    System.out.println("Valor: R$ " + decoded.getValue());
    
    // Confirmar antes de pagar
    // ... lógica de confirmação
    
} catch (AsaasException e) {
    System.err.println("QR Code inválido: " + e.getMessage());
}
```

## Tipos de Chave PIX

| Tipo | Descrição | Exemplo |
|------|-----------|---------|
| `EVP` | Chave aleatória | `123e4567-e89b-12d3-a456-426614174000` |
| `CPF` | CPF | `12345678900` |
| `CNPJ` | CNPJ | `12345678000190` |
| `EMAIL` | Email | `pagamento@empresa.com` |
| `PHONE` | Telefone | `+5547999999999` |

## Status de Chaves PIX

| Status | Descrição |
|--------|-----------|
| `ACTIVE` | Chave ativa e funcional |
| `AWAITING_ACTIVATION` | Aguardando ativação |
| `AWAITING_ACCOUNT_ACTIVATION` | Aguardando ativação da conta |
| `ERROR` | Erro no processamento |
| `DELETED` | Chave deletada |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.pix.*;
import io.github.jpdev.asaassdk.enums.*;
import java.math.BigDecimal;

public class ExemploPix {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // 1. Criar chave PIX aleatória
        PixAddressKey minhaChave = PixAddressKey.creator()
            .setType(PixAddressKeyType.EVP)
            .create();
        
        System.out.println("Chave PIX criada: " + minhaChave.getKey());
        
        // 2. Criar QR Code estático
        PixQrCode qrCode = PixQrCode.creator()
            .setAddressKey(minhaChave.getKey())
            .setDescription("Pagamento de produto")
            .setValue(new BigDecimal("50.00"))
            .create();
        
        System.out.println("QR Code gerado!");
        System.out.println("Payload: " + qrCode.getPayload());
        
        // 3. Listar todas as chaves ativas
        ResourceSet<PixAddressKey> chaves = PixAddressKey.reader()
            .setStatus(PixAddressKeyStatus.ACTIVE)
            .read();
        
        System.out.println("\nChaves PIX ativas:");
        for (PixAddressKey chave : chaves.getData()) {
            System.out.println("- " + chave.getKey() + " (" + chave.getType() + ")");
        }
        
        // 4. Decodificar um QR Code
        String qrCodeExterno = "00020101021226770014br.gov.bcb.pix...";
        
        try {
            PixDecodedQrCode decoded = PixDecodedQrCode.decoder()
                .setPayload(qrCodeExterno)
                .create();
            
            System.out.println("\nQR Code decodificado:");
            System.out.println("Beneficiário: " + decoded.getName());
            System.out.println("Valor: R$ " + decoded.getValue());
        } catch (Exception e) {
            System.err.println("Erro ao decodificar: " + e.getMessage());
        }
    }
}
```

## Boas Práticas

### 1. Use Chaves EVP para Maior Segurança

```java
// Chaves aleatórias são mais seguras
PixAddressKey chave = PixAddressKey.creator()
    .setType(PixAddressKeyType.EVP)
    .create();
```

### 2. Valide QR Codes Antes de Processar

```java
try {
    PixDecodedQrCode decoded = PixDecodedQrCode.decoder()
        .setPayload(payload)
        .create();
    
    // Validar antes de prosseguir
    if (decoded.getValue() != null && decoded.getName() != null) {
        // QR Code válido
    }
} catch (AsaasException e) {
    // QR Code inválido
}
```

### 3. Armazene o ID da Chave

```java
PixAddressKey chave = PixAddressKey.creator()
    .setType(PixAddressKeyType.EVP)
    .create();

// Salvar no banco de dados
String chaveId = chave.getId();
String chaveValor = chave.getKey();
```

### 4. Monitore o Status das Chaves

```java
PixAddressKey chave = PixAddressKey.fetcher(chaveId).fetch();

if (chave.getStatus() == PixAddressKeyStatus.ACTIVE) {
    // Chave pronta para uso
} else if (chave.getStatus() == PixAddressKeyStatus.AWAITING_ACTIVATION) {
    // Aguardar ativação
}
```

## Limitações

- Cada conta pode ter até 20 chaves PIX
- Chaves EVP são geradas automaticamente pelo sistema
- A exclusão de chaves pode levar até 7 dias
- QR Codes estáticos não expiram
- QR Codes dinâmicos (via cobrança) expiram conforme a data de vencimento

## Veja Também

- [PIX - Transações](pix_transaction.md) - Enviar e receber pagamentos PIX
- [PIX Automático](pix_automatic.md) - Débito recorrente via PIX
- [Cobranças](payment.md) - Criar cobranças com PIX

## Referências

- [Documentação Oficial - PIX](https://docs.asaas.com/reference/pix)
- [Banco Central - PIX](https://www.bcb.gov.br/estabilidadefinanceira/pix)
