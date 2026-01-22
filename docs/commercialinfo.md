# Dados Comerciais (Commercial Info)

Gerencie as informações comerciais da sua conta Asaas. Mantenha seus dados atualizados para melhor experiência com clientes.

## 📋 Índice

- [Recuperar Dados](#recuperar-dados)
- [Atualizar Dados](#atualizar-dados)
- [Campos Disponíveis](#campos-disponíveis)

## Recuperar Dados

```java
import io.github.jpdev.asaassdk.rest.commercialinfo.CommercialInfo;

CommercialInfo dados = CommercialInfo.fetcher().fetch();

System.out.println("=== DADOS COMERCIAIS ===");
System.out.println("Nome: " + dados.getName());
System.out.println("Site: " + dados.getSite());
System.out.println("Email: " + dados.getEmail());
System.out.println("Telefone: " + dados.getPhone());
System.out.println("Endereço: " + dados.getAddress());
System.out.println("Cidade: " + dados.getCity());
System.out.println("Estado: " + dados.getState());
```

## Atualizar Dados

### Atualizar Site

```java
CommercialInfo atualizado = CommercialInfo.updater()
    .setSite("https://www.minhaempresa.com.br")
    .update();

System.out.println("Site atualizado: " + atualizado.getSite());
```

### Atualizar Múltiplos Campos

```java
CommercialInfo atualizado = CommercialInfo.updater()
    .setSite("https://www.minhaempresa.com.br")
    .setEmail("contato@minhaempresa.com.br")
    .setPhone("4733334444")
    .setMobilePhone("47999999999")
    .update();

System.out.println("Dados atualizados com sucesso!");
```

### Atualizar Endereço

```java
CommercialInfo atualizado = CommercialInfo.updater()
    .setAddress("Rua Principal")
    .setAddressNumber("100")
    .setComplement("Sala 201")
    .setProvince("Centro")
    .setPostalCode("89010-000")
    .setCity("Blumenau")
    .setState("SC")
    .update();

System.out.println("Endereço atualizado!");
```

### Atualizar Informações de Contato

```java
CommercialInfo atualizado = CommercialInfo.updater()
    .setEmail("contato@empresa.com")
    .setPhone("4733334444")
    .setMobilePhone("47999999999")
    .setWhatsapp("47999999999")
    .update();

System.out.println("Contatos atualizados!");
```

### Atualizar Redes Sociais

```java
CommercialInfo atualizado = CommercialInfo.updater()
    .setFacebook("https://facebook.com/minhaempresa")
    .setInstagram("@minhaempresa")
    .setLinkedin("https://linkedin.com/company/minhaempresa")
    .update();

System.out.println("Redes sociais atualizadas!");
```

## Campos Disponíveis

### Informações Básicas

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `name` | String | Nome da empresa |
| `site` | String | Site da empresa |
| `email` | String | Email de contato |
| `phone` | String | Telefone fixo |
| `mobilePhone` | String | Telefone celular |
| `whatsapp` | String | WhatsApp |

### Endereço

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `address` | String | Logradouro |
| `addressNumber` | String | Número |
| `complement` | String | Complemento |
| `province` | String | Bairro |
| `postalCode` | String | CEP |
| `city` | String | Cidade |
| `state` | String | Estado (UF) |

### Redes Sociais

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `facebook` | String | URL do Facebook |
| `instagram` | String | @ do Instagram |
| `linkedin` | String | URL do LinkedIn |
| `twitter` | String | @ do Twitter |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.commercialinfo.CommercialInfo;

public class ExemploDadosComerciais {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Recuperar dados atuais
        CommercialInfo dadosAtuais = CommercialInfo.fetcher().fetch();
        
        System.out.println("=== DADOS ATUAIS ===");
        System.out.println("Nome: " + dadosAtuais.getName());
        System.out.println("Site: " + dadosAtuais.getSite());
        System.out.println("Email: " + dadosAtuais.getEmail());
        
        // Atualizar dados
        CommercialInfo dadosAtualizados = CommercialInfo.updater()
            .setSite("https://www.novosite.com.br")
            .setEmail("contato@novosite.com.br")
            .setPhone("4733334444")
            .setMobilePhone("47999999999")
            .setWhatsapp("47999999999")
            .setAddress("Rua Nova")
            .setAddressNumber("200")
            .setProvince("Centro")
            .setPostalCode("89010-000")
            .setCity("Blumenau")
            .setState("SC")
            .setFacebook("https://facebook.com/empresa")
            .setInstagram("@empresa")
            .update();
        
        System.out.println("\n=== DADOS ATUALIZADOS ===");
        System.out.println("Site: " + dadosAtualizados.getSite());
        System.out.println("Email: " + dadosAtualizados.getEmail());
        System.out.println("Telefone: " + dadosAtualizados.getPhone());
        System.out.println("WhatsApp: " + dadosAtualizados.getWhatsapp());
    }
}
```

## Casos de Uso

### Atualização Após Mudança de Endereço

```java
public class AtualizacaoEndereco {
    
    public static void mudarEndereco(
        String novoEndereco,
        String numero,
        String bairro,
        String cep,
        String cidade,
        String estado
    ) {
        CommercialInfo atualizado = CommercialInfo.updater()
            .setAddress(novoEndereco)
            .setAddressNumber(numero)
            .setProvince(bairro)
            .setPostalCode(cep)
            .setCity(cidade)
            .setState(estado)
            .update();
        
        System.out.println("Endereço atualizado com sucesso!");
        System.out.println("Novo endereço: " + atualizado.getAddress() + ", " + 
                          atualizado.getAddressNumber());
    }
}
```

### Configuração Inicial

```java
public class ConfiguracaoInicial {
    
    public static void configurarDadosComerciais() {
        CommercialInfo dados = CommercialInfo.updater()
            .setSite("https://www.minhaempresa.com.br")
            .setEmail("contato@minhaempresa.com.br")
            .setPhone("4733334444")
            .setMobilePhone("47999999999")
            .setWhatsapp("47999999999")
            .setAddress("Rua Principal")
            .setAddressNumber("100")
            .setProvince("Centro")
            .setPostalCode("89010-000")
            .setCity("Blumenau")
            .setState("SC")
            .setFacebook("https://facebook.com/minhaempresa")
            .setInstagram("@minhaempresa")
            .update();
        
        System.out.println("✅ Dados comerciais configurados!");
    }
}
```

### Sincronização com Sistema

```java
public class SincronizacaoDados {
    
    public static void sincronizarComSistema() {
        // Buscar dados do sistema local
        DadosEmpresa dadosLocal = buscarDadosDoSistema();
        
        // Atualizar no Asaas
        CommercialInfo atualizado = CommercialInfo.updater()
            .setSite(dadosLocal.getSite())
            .setEmail(dadosLocal.getEmail())
            .setPhone(dadosLocal.getTelefone())
            .setAddress(dadosLocal.getEndereco())
            .setCity(dadosLocal.getCidade())
            .setState(dadosLocal.getEstado())
            .update();
        
        System.out.println("Dados sincronizados com sucesso!");
    }
    
    private static DadosEmpresa buscarDadosDoSistema() {
        // Implementar busca no banco de dados
        return new DadosEmpresa();
    }
}
```

## Boas Práticas

### 1. Mantenha Dados Atualizados

```java
// Atualizar dados regularmente
public static void verificarDados() {
    CommercialInfo dados = CommercialInfo.fetcher().fetch();
    
    if (dados.getSite() == null || dados.getSite().isEmpty()) {
        System.out.println("⚠️ Site não configurado");
    }
    
    if (dados.getEmail() == null || dados.getEmail().isEmpty()) {
        System.out.println("⚠️ Email não configurado");
    }
    
    if (dados.getPhone() == null || dados.getPhone().isEmpty()) {
        System.out.println("⚠️ Telefone não configurado");
    }
}
```

### 2. Valide URLs

```java
public static boolean validarUrl(String url) {
    return url != null && 
           (url.startsWith("http://") || url.startsWith("https://"));
}

public static void atualizarSite(String novoSite) {
    if (validarUrl(novoSite)) {
        CommercialInfo.updater()
            .setSite(novoSite)
            .update();
    } else {
        System.err.println("URL inválida");
    }
}
```

### 3. Formate Telefones

```java
public static String formatarTelefone(String telefone) {
    // Remover caracteres especiais
    return telefone.replaceAll("[^0-9]", "");
}

public static void atualizarTelefone(String telefone) {
    String telefoneLimpo = formatarTelefone(telefone);
    
    CommercialInfo.updater()
        .setPhone(telefoneLimpo)
        .update();
}
```

### 4. Cache de Dados

```java
private static CommercialInfo dadosCache = null;
private static long ultimaAtualizacao = 0;

public static CommercialInfo getDadosComerciais() {
    long agora = System.currentTimeMillis();
    
    // Atualizar cache a cada 1 hora
    if (dadosCache == null || (agora - ultimaAtualizacao) > 3600000) {
        dadosCache = CommercialInfo.fetcher().fetch();
        ultimaAtualizacao = agora;
    }
    
    return dadosCache;
}
```

## Exibição de Dados

### Formato para Impressão

```java
public static void imprimirDadosComerciais() {
    CommercialInfo dados = CommercialInfo.fetcher().fetch();
    
    System.out.println("╔════════════════════════════════════════╗");
    System.out.println("║       DADOS COMERCIAIS                 ║");
    System.out.println("╠════════════════════════════════════════╣");
    System.out.println("║ Nome: " + dados.getName());
    System.out.println("║ Site: " + dados.getSite());
    System.out.println("║ Email: " + dados.getEmail());
    System.out.println("║ Telefone: " + dados.getPhone());
    System.out.println("║ Celular: " + dados.getMobilePhone());
    System.out.println("║ WhatsApp: " + dados.getWhatsapp());
    System.out.println("║");
    System.out.println("║ Endereço: " + dados.getAddress() + ", " + dados.getAddressNumber());
    System.out.println("║ Bairro: " + dados.getProvince());
    System.out.println("║ CEP: " + dados.getPostalCode());
    System.out.println("║ Cidade: " + dados.getCity() + " - " + dados.getState());
    System.out.println("╚════════════════════════════════════════╝");
}
```

## Veja Também

- [Status da Conta](myaccount.md) - Verificar situação da conta
- [Dados Bancários](accountnumber.md) - Informações bancárias
- [Subcontas](account.md) - Gerenciar subcontas

## Referências

- [Documentação Oficial - Dados Comerciais](https://docs.asaas.com/reference/atualizar-dados-comerciais)
