# Parcelamentos (Installments)

Gerencie cobranças parceladas. Visualize e controle parcelas de pagamentos divididos.

## 📋 Índice

- [Listar Parcelamentos](#listar-parcelamentos)
- [Recuperar Parcelamento](#recuperar-parcelamento)
- [Deletar Parcelamento](#deletar-parcelamento)
- [Gerenciar Parcelas](#gerenciar-parcelas)

## Listar Parcelamentos

### Listar Todos

```java
import io.github.jpdev.asaassdk.rest.installment.Installment;
import io.github.jpdev.asaassdk.rest.installment.ResourceSet;

ResourceSet<Installment> parcelamentos = Installment.reader().read();

for (Installment parcelamento : parcelamentos.getData()) {
    System.out.println("ID: " + parcelamento.getId());
    System.out.println("Cliente: " + parcelamento.getCustomer());
    System.out.println("Valor total: R$ " + parcelamento.getValue());
    System.out.println("Número de parcelas: " + parcelamento.getInstallmentCount());
    System.out.println("Valor da parcela: R$ " + parcelamento.getInstallmentValue());
    System.out.println("Status: " + parcelamento.getStatus());
    System.out.println("---");
}
```

### Filtrar por Cliente

```java
ResourceSet<Installment> parcelamentos = Installment.reader()
    .setCustomer("cus_000050606806")
    .read();

System.out.println("Parcelamentos do cliente: " + parcelamentos.getTotalCount());
```

### Filtrar por Status

```java
import io.github.jpdev.asaassdk.enums.InstallmentStatus;

// Apenas parcelamentos ativos
ResourceSet<Installment> ativos = Installment.reader()
    .setStatus(InstallmentStatus.ACTIVE)
    .read();

// Apenas parcelamentos concluídos
ResourceSet<Installment> concluidos = Installment.reader()
    .setStatus(InstallmentStatus.COMPLETED)
    .read();
```

### Paginação

```java
ResourceSet<Installment> parcelamentos = Installment.reader()
    .setLimit(50)
    .setOffset(0)
    .read();

System.out.println("Total: " + parcelamentos.getTotalCount());
System.out.println("Tem mais: " + parcelamentos.hasMore());
```

## Recuperar Parcelamento

```java
Installment parcelamento = Installment.fetcher("5a2c890b-dd63-4b5a-9169-96c8d7828f4c").fetch();

System.out.println("ID: " + parcelamento.getId());
System.out.println("Cliente: " + parcelamento.getCustomer());
System.out.println("Valor total: R$ " + parcelamento.getValue());
System.out.println("Parcelas: " + parcelamento.getInstallmentCount() + "x de R$ " + parcelamento.getInstallmentValue());
System.out.println("Status: " + parcelamento.getStatus());
```

## Deletar Parcelamento

Delete um parcelamento e suas parcelas pendentes:

```java
import io.github.jpdev.asaassdk.rest.installment.DeletedResource;

DeletedResource deletado = Installment.deleter("5a2c890b-dd63-4b5a-9169-96c8d7828f4c").delete();

if (deletado.isDeleted()) {
    System.out.println("Parcelamento deletado com sucesso");
}
```

**Nota**: Apenas parcelas pendentes serão deletadas. Parcelas já pagas não são afetadas.

## Gerenciar Parcelas

### Listar Parcelas de um Parcelamento

```java
import io.github.jpdev.asaassdk.rest.payment.Payment;

Installment parcelamento = Installment.fetcher("installment_id").fetch();

// Buscar todas as cobranças do parcelamento
ResourceSet<Payment> parcelas = Payment.reader()
    .setInstallment(parcelamento.getId())
    .read();

System.out.println("=== PARCELAS ===");
int numeroParcela = 1;
for (Payment parcela : parcelas.getData()) {
    System.out.println("Parcela " + numeroParcela + ":");
    System.out.println("  ID: " + parcela.getId());
    System.out.println("  Valor: R$ " + parcela.getValue());
    System.out.println("  Vencimento: " + parcela.getDueDate());
    System.out.println("  Status: " + parcela.getStatus());
    System.out.println();
    numeroParcela++;
}
```

### Verificar Status das Parcelas

```java
public class StatusParcelas {
    
    public static void verificarStatus(String installmentId) {
        ResourceSet<Payment> parcelas = Payment.reader()
            .setInstallment(installmentId)
            .read();
        
        int pagas = 0;
        int pendentes = 0;
        int vencidas = 0;
        
        for (Payment parcela : parcelas.getData()) {
            switch (parcela.getStatus()) {
                case "RECEIVED":
                case "CONFIRMED":
                    pagas++;
                    break;
                case "PENDING":
                    pendentes++;
                    break;
                case "OVERDUE":
                    vencidas++;
                    break;
            }
        }
        
        System.out.println("=== STATUS DAS PARCELAS ===");
        System.out.println("Total: " + parcelas.getTotalCount());
        System.out.println("Pagas: " + pagas);
        System.out.println("Pendentes: " + pendentes);
        System.out.println("Vencidas: " + vencidas);
    }
}
```

### Calcular Valor Restante

```java
public class CalculadoraParcelas {
    
    public static void calcularRestante(String installmentId) {
        Installment parcelamento = Installment.fetcher(installmentId).fetch();
        
        ResourceSet<Payment> parcelas = Payment.reader()
            .setInstallment(installmentId)
            .read();
        
        double valorPago = 0;
        double valorPendente = 0;
        
        for (Payment parcela : parcelas.getData()) {
            if (parcela.getStatus().equals("RECEIVED") || 
                parcela.getStatus().equals("CONFIRMED")) {
                valorPago += parcela.getValue();
            } else {
                valorPendente += parcela.getValue();
            }
        }
        
        System.out.println("=== RESUMO FINANCEIRO ===");
        System.out.println("Valor total: R$ " + parcelamento.getValue());
        System.out.println("Valor pago: R$ " + String.format("%.2f", valorPago));
        System.out.println("Valor pendente: R$ " + String.format("%.2f", valorPendente));
        
        double percentualPago = (valorPago / parcelamento.getValue()) * 100;
        System.out.println("Percentual pago: " + String.format("%.1f%%", percentualPago));
    }
}
```

## Status de Parcelamentos

| Status | Descrição |
|--------|-----------|
| `ACTIVE` | Parcelamento ativo |
| `COMPLETED` | Todas as parcelas pagas |
| `CANCELLED` | Parcelamento cancelado |

## Exemplo Completo

```java
import io.github.jpdev.asaassdk.Asaas;
import io.github.jpdev.asaassdk.rest.installment.Installment;
import io.github.jpdev.asaassdk.rest.installment.ResourceSet;
import io.github.jpdev.asaassdk.rest.payment.Payment;

public class ExemploParcelamento {
    public static void main(String[] args) {
        // Inicializar SDK
        Asaas.init("sua_api_key");
        
        // Listar todos os parcelamentos
        ResourceSet<Installment> parcelamentos = Installment.reader().read();
        
        System.out.println("=== PARCELAMENTOS ===");
        System.out.println("Total: " + parcelamentos.getTotalCount());
        System.out.println();
        
        // Detalhar cada parcelamento
        for (Installment p : parcelamentos.getData()) {
            System.out.println("ID: " + p.getId());
            System.out.println("Cliente: " + p.getCustomer());
            System.out.println("Valor: " + p.getInstallmentCount() + "x de R$ " + p.getInstallmentValue());
            System.out.println("Total: R$ " + p.getValue());
            System.out.println("Status: " + p.getStatus());
            
            // Buscar parcelas
            ResourceSet<Payment> parcelas = Payment.reader()
                .setInstallment(p.getId())
                .read();
            
            System.out.println("Parcelas:");
            int num = 1;
            for (Payment parcela : parcelas.getData()) {
                System.out.println("  " + num + "/" + p.getInstallmentCount() + 
                                 " - R$ " + parcela.getValue() + 
                                 " - " + parcela.getStatus());
                num++;
            }
            
            System.out.println("---\n");
        }
    }
}
```

## Relatórios

### Relatório de Inadimplência

```java
public class RelatorioInadimplencia {
    
    public static void gerarRelatorio() {
        ResourceSet<Installment> parcelamentos = Installment.reader()
            .setStatus(InstallmentStatus.ACTIVE)
            .read();
        
        System.out.println("=== RELATÓRIO DE INADIMPLÊNCIA ===\n");
        
        for (Installment p : parcelamentos.getData()) {
            ResourceSet<Payment> parcelas = Payment.reader()
                .setInstallment(p.getId())
                .setStatus(PaymentStatus.OVERDUE)
                .read();
            
            if (parcelas.getTotalCount() > 0) {
                System.out.println("Cliente: " + p.getCustomer());
                System.out.println("Parcelamento: " + p.getId());
                System.out.println("Parcelas vencidas: " + parcelas.getTotalCount());
                
                double valorVencido = 0;
                for (Payment parcela : parcelas.getData()) {
                    valorVencido += parcela.getValue();
                }
                
                System.out.println("Valor vencido: R$ " + String.format("%.2f", valorVencido));
                System.out.println("---");
            }
        }
    }
}
```

### Dashboard de Parcelamentos

```java
public class DashboardParcelamentos {
    
    public static void exibirDashboard() {
        ResourceSet<Installment> todos = Installment.reader().read();
        ResourceSet<Installment> ativos = Installment.reader()
            .setStatus(InstallmentStatus.ACTIVE)
            .read();
        ResourceSet<Installment> concluidos = Installment.reader()
            .setStatus(InstallmentStatus.COMPLETED)
            .read();
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     DASHBOARD DE PARCELAMENTOS         ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║                                        ║");
        System.out.println("║  📊 Total de Parcelamentos             ║");
        System.out.println("║     " + todos.getTotalCount() + " parcelamentos");
        System.out.println("║                                        ║");
        System.out.println("║  ✅ Ativos                             ║");
        System.out.println("║     " + ativos.getTotalCount() + " parcelamentos");
        System.out.println("║                                        ║");
        System.out.println("║  🎉 Concluídos                         ║");
        System.out.println("║     " + concluidos.getTotalCount() + " parcelamentos");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}
```

## Boas Práticas

### 1. Monitore Parcelas Vencidas

```java
public static void monitorarVencidas() {
    ResourceSet<Installment> ativos = Installment.reader()
        .setStatus(InstallmentStatus.ACTIVE)
        .read();
    
    for (Installment p : ativos.getData()) {
        ResourceSet<Payment> vencidas = Payment.reader()
            .setInstallment(p.getId())
            .setStatus(PaymentStatus.OVERDUE)
            .read();
        
        if (vencidas.getTotalCount() > 0) {
            // Enviar notificação ao cliente
            notificarCliente(p.getCustomer(), vencidas.getTotalCount());
        }
    }
}
```

### 2. Valide Antes de Deletar

```java
public static boolean podeDeletar(String installmentId) {
    ResourceSet<Payment> parcelas = Payment.reader()
        .setInstallment(installmentId)
        .read();
    
    for (Payment parcela : parcelas.getData()) {
        if (parcela.getStatus().equals("RECEIVED") || 
            parcela.getStatus().equals("CONFIRMED")) {
            System.err.println("Não é possível deletar: existem parcelas pagas");
            return false;
        }
    }
    
    return true;
}
```

### 3. Cache de Dados

```java
private static Map<String, Installment> cache = new HashMap<>();

public static Installment getParcelamento(String id) {
    if (!cache.containsKey(id)) {
        cache.put(id, Installment.fetcher(id).fetch());
    }
    return cache.get(id);
}
```

## Veja Também

- [Cobranças](payment.md) - Criar cobranças parceladas
- [Clientes](customeraccount.md) - Gerenciar clientes
- [Extrato](financial.md) - Ver movimentações

## Referências

- [Documentação Oficial - Parcelamentos](https://docs.asaas.com/reference/listar-parcelamentos)
