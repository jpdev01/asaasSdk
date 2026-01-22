# Saldo (Balance)

Consulte o saldo disponível e bloqueado da sua conta Asaas em tempo real.

## 📋 Índice

- [Recuperar Saldo](#recuperar-saldo)
- [Tipos de Saldo](#tipos-de-saldo)
- [Monitoramento](#monitoramento)
- [Exemplos Práticos](#exemplos-práticos)

## Recuperar Saldo

```java
import io.github.jpdev.asaassdk.rest.balance.FinanceBalance;

FinanceBalance saldo = FinanceBalance.fetcher().fetch();

System.out.println("=== SALDO DA CONTA ===");
System.out.println("Saldo disponível: R$ " + saldo.getBalance());
System.out.println("Saldo bloqueado: R$ " + saldo.getBlockedBalance());
System.out.println("Saldo total: R$ " + (saldo.getBalance() + saldo.getBlockedBalance()));
```

## Tipos de Saldo

### Saldo Disponível

Valor que pode ser usado imediatamente para transferências e pagamentos:

```java
FinanceBalance saldo = FinanceBalance.fetcher().fetch();

double saldoDisponivel = saldo.getBalance();
System.out.println("Você pode transferir: R$ " + saldoDisponivel);

// Verificar se tem saldo suficiente
double valorTransferencia = 100.00;
if (saldoDisponivel >= valorTransferencia) {
    System.out.println("Saldo suficiente para transferência");
} else {
    System.out.println("Saldo insuficiente");
    System.out.println("Faltam: R$ " + (valorTransferencia - saldoDisponivel));
}
```

### Saldo Bloqueado

Valor retido temporariamente (aguardando compensação, análise, etc):

```java
FinanceBalance saldo = FinanceBalance.fetcher().fetch();

double saldoBloqueado = saldo.getBlockedBalance();
System.out.println("Saldo bloqueado: R$ " + saldoBloqueado);

if (saldoBloqueado > 0) {
    System.out.println("Você tem valores aguardando liberação");
}
```

### Saldo Total

Soma do saldo disponível e bloqueado:

```java
FinanceBalance saldo = FinanceBalance.fetcher().fetch();

double saldoTotal = saldo.getBalance() + saldo.getBlockedBalance();
System.out.println("Saldo total: R$ " + saldoTotal);
```

## Monitoramento

### Verificar Saldo Antes de Transferir

```java
import io.github.jpdev.asaassdk.rest.transfer.Transfer;
import io.github.jpdev.asaassdk.enums.PixAddressKeyType;
import io.github.jpdev.asaassdk.util.Money;
import java.math.BigDecimal;

public class TransferenciaSegura {
    
    public static boolean transferirComVerificacao(String chavePix, double valor) {
        // Verificar saldo
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        
        if (saldo.getBalance() < valor) {
            System.err.println("Saldo insuficiente!");
            System.err.println("Disponível: R$ " + saldo.getBalance());
            System.err.println("Necessário: R$ " + valor);
            return false;
        }
        
        // Realizar transferência
        try {
            Transfer transfer = Transfer.pixAddressKeyCreator()
                .setPixAddressKey(chavePix)
                .setPixAddressKeyType(PixAddressKeyType.CPF)
                .setValue(Money.create(new BigDecimal(valor)))
                .create();
            
            System.out.println("Transferência realizada: " + transfer.getId());
            
            // Verificar novo saldo
            FinanceBalance novoSaldo = FinanceBalance.fetcher().fetch();
            System.out.println("Novo saldo: R$ " + novoSaldo.getBalance());
            
            return true;
        } catch (Exception e) {
            System.err.println("Erro na transferência: " + e.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        transferirComVerificacao("12345678900", 100.00);
    }
}
```

### Alertas de Saldo Baixo

```java
public class MonitorSaldo {
    
    private static final double SALDO_MINIMO = 100.00;
    
    public static void verificarSaldoMinimo() {
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        
        if (saldo.getBalance() < SALDO_MINIMO) {
            System.out.println("⚠️ ALERTA: Saldo baixo!");
            System.out.println("Saldo atual: R$ " + saldo.getBalance());
            System.out.println("Saldo mínimo: R$ " + SALDO_MINIMO);
            
            // Enviar notificação por email/SMS
            enviarAlertaSaldoBaixo(saldo.getBalance());
        } else {
            System.out.println("✅ Saldo OK: R$ " + saldo.getBalance());
        }
    }
    
    private static void enviarAlertaSaldoBaixo(double saldoAtual) {
        // Implementar envio de email/SMS
        System.out.println("Notificação enviada sobre saldo baixo");
    }
}
```

### Dashboard de Saldo

```java
public class DashboardSaldo {
    
    public static void exibirDashboard() {
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        
        double disponivel = saldo.getBalance();
        double bloqueado = saldo.getBlockedBalance();
        double total = disponivel + bloqueado;
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║         DASHBOARD FINANCEIRO           ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║                                        ║");
        System.out.println("║  💰 Saldo Disponível                   ║");
        System.out.println("║     R$ " + String.format("%-30.2f", disponivel) + "║");
        System.out.println("║                                        ║");
        System.out.println("║  🔒 Saldo Bloqueado                    ║");
        System.out.println("║     R$ " + String.format("%-30.2f", bloqueado) + "║");
        System.out.println("║                                        ║");
        System.out.println("║  📊 Saldo Total                        ║");
        System.out.println("║     R$ " + String.format("%-30.2f", total) + "║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        // Percentual bloqueado
        if (total > 0) {
            double percentualBloqueado = (bloqueado / total) * 100;
            System.out.println("\n📈 " + String.format("%.1f%%", percentualBloqueado) + " do saldo está bloqueado");
        }
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        exibirDashboard();
    }
}
```

## Exemplos Práticos

### Validar Múltiplas Transferências

```java
import java.util.List;
import java.util.ArrayList;

public class ValidadorTransferencias {
    
    public static class Transferencia {
        String destino;
        double valor;
        
        public Transferencia(String destino, double valor) {
            this.destino = destino;
            this.valor = valor;
        }
    }
    
    public static boolean validarLote(List<Transferencia> transferencias) {
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        
        double totalNecessario = 0;
        for (Transferencia t : transferencias) {
            totalNecessario += t.valor;
        }
        
        System.out.println("Saldo disponível: R$ " + saldo.getBalance());
        System.out.println("Total necessário: R$ " + totalNecessario);
        
        if (saldo.getBalance() >= totalNecessario) {
            System.out.println("✅ Saldo suficiente para todas as transferências");
            return true;
        } else {
            double faltam = totalNecessario - saldo.getBalance();
            System.out.println("❌ Saldo insuficiente. Faltam: R$ " + faltam);
            return false;
        }
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        
        List<Transferencia> lote = new ArrayList<>();
        lote.add(new Transferencia("12345678900", 100.00));
        lote.add(new Transferencia("98765432100", 200.00));
        lote.add(new Transferencia("11122233344", 150.00));
        
        validarLote(lote);
    }
}
```

### Relatório de Saldo

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioSaldo {
    
    public static String gerarRelatorio() {
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = LocalDateTime.now().format(formatter);
        
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("═══════════════════════════════════════\n");
        relatorio.append("        RELATÓRIO DE SALDO             \n");
        relatorio.append("═══════════════════════════════════════\n\n");
        relatorio.append("Data/Hora: ").append(dataHora).append("\n\n");
        relatorio.append("Saldo Disponível: R$ ").append(String.format("%.2f", saldo.getBalance())).append("\n");
        relatorio.append("Saldo Bloqueado:  R$ ").append(String.format("%.2f", saldo.getBlockedBalance())).append("\n");
        relatorio.append("───────────────────────────────────────\n");
        relatorio.append("Saldo Total:      R$ ").append(String.format("%.2f", saldo.getBalance() + saldo.getBlockedBalance())).append("\n\n");
        relatorio.append("═══════════════════════════════════════\n");
        
        return relatorio.toString();
    }
    
    public static void main(String[] args) {
        Asaas.init("sua_api_key");
        System.out.println(gerarRelatorio());
    }
}
```

### Comparar Saldo ao Longo do Tempo

```java
import java.util.ArrayList;
import java.util.List;

public class HistoricoSaldo {
    
    public static class RegistroSaldo {
        LocalDateTime data;
        double saldo;
        
        public RegistroSaldo(LocalDateTime data, double saldo) {
            this.data = data;
            this.saldo = saldo;
        }
    }
    
    private static List<RegistroSaldo> historico = new ArrayList<>();
    
    public static void registrarSaldo() {
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        historico.add(new RegistroSaldo(LocalDateTime.now(), saldo.getBalance()));
    }
    
    public static void exibirVariacao() {
        if (historico.size() < 2) {
            System.out.println("Histórico insuficiente");
            return;
        }
        
        RegistroSaldo primeiro = historico.get(0);
        RegistroSaldo ultimo = historico.get(historico.size() - 1);
        
        double variacao = ultimo.saldo - primeiro.saldo;
        double percentual = (variacao / primeiro.saldo) * 100;
        
        System.out.println("Saldo inicial: R$ " + primeiro.saldo);
        System.out.println("Saldo atual: R$ " + ultimo.saldo);
        System.out.println("Variação: R$ " + variacao);
        System.out.println("Percentual: " + String.format("%.2f%%", percentual));
    }
}
```

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.balance.FinanceBalance;

public class ExemploSaldo {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Recuperar saldo
        FinanceBalance saldo = FinanceBalance.fetcher().fetch();
        
        // Exibir informações
        System.out.println("═══════════════════════════════════════");
        System.out.println("          SALDO DA CONTA               ");
        System.out.println("═══════════════════════════════════════\n");
        
        double disponivel = saldo.getBalance();
        double bloqueado = saldo.getBlockedBalance();
        double total = disponivel + bloqueado;
        
        System.out.println("💰 Saldo Disponível:");
        System.out.println("   R$ " + String.format("%.2f", disponivel));
        System.out.println();
        
        System.out.println("🔒 Saldo Bloqueado:");
        System.out.println("   R$ " + String.format("%.2f", bloqueado));
        System.out.println();
        
        System.out.println("📊 Saldo Total:");
        System.out.println("   R$ " + String.format("%.2f", total));
        System.out.println();
        
        System.out.println("═══════════════════════════════════════");
        
        // Análise
        if (disponivel < 100) {
            System.out.println("⚠️  Saldo baixo! Considere adicionar fundos.");
        } else if (disponivel < 500) {
            System.out.println("ℹ️  Saldo moderado.");
        } else {
            System.out.println("✅ Saldo saudável!");
        }
        
        if (bloqueado > 0) {
            double percentual = (bloqueado / total) * 100;
            System.out.println("📌 " + String.format("%.1f%%", percentual) + " do saldo está bloqueado");
        }
    }
}
```

## Boas Práticas

### 1. Cache com Atualização Periódica

```java
private static FinanceBalance saldoCache = null;
private static long ultimaAtualizacao = 0;
private static final long INTERVALO_CACHE = 60000; // 1 minuto

public static FinanceBalance getSaldo() {
    long agora = System.currentTimeMillis();
    
    if (saldoCache == null || (agora - ultimaAtualizacao) > INTERVALO_CACHE) {
        saldoCache = FinanceBalance.fetcher().fetch();
        ultimaAtualizacao = agora;
    }
    
    return saldoCache;
}
```

### 2. Sempre Verifique Antes de Transferir

```java
public static boolean podeTrans ferir(double valor) {
    FinanceBalance saldo = FinanceBalance.fetcher().fetch();
    return saldo.getBalance() >= valor;
}
```

### 3. Monitore Regularmente

```java
// Agendar verificação a cada hora
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
scheduler.scheduleAtFixedRate(() -> {
    FinanceBalance saldo = FinanceBalance.fetcher().fetch();
    if (saldo.getBalance() < 100) {
        enviarAlerta("Saldo baixo: R$ " + saldo.getBalance());
    }
}, 0, 1, TimeUnit.HOURS);
```

## Veja Também

- [Extrato](financial.md) - Ver movimentações detalhadas
- [Transferências](transfer.md) - Realizar transferências
- [Taxas](accountfee.md) - Consultar taxas aplicadas

## Referências

- [Documentação Oficial - Saldo](https://docs.asaas.com/reference/consultar-saldo)
