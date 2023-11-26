package br.com.jpdev01.asaassdk.teste;

import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.rest.action.ResourceSet;
import br.com.jpdev01.asaassdk.rest.financialtransaction.FinancialTransaction;
import br.com.jpdev01.asaassdk.rest.payment.Payment;
import br.com.jpdev01.asaassdk.rest.payment.identificationfield.PaymentIdentificationField;
import br.com.jpdev01.asaassdk.rest.payment.status.PaymentStatusData;

public class Teste {

    public static void main(String[] args) {
        Asaas.init("");
//        Transfer transfer = Transfer.pixAddressKeyCreator()
//                .setPixAddressKey("09414368965")
//                .setValue(Money.create(new BigDecimal(0.01)))
//                .setDescription("teste")
//                .setPixAddressKeyType(PixAddressKeyType.CPF)
//                .create();
//        System.out.println(transfer.getValue().toString());

//        Date birthDate = new Date();
////        birthDate.setYear(10);
//        BankAccountSetting bankAccountSetting = new BankAccountSetting()
//                .setBank(new BankSetting().setCode("085"))
//                .setAccountName("Paulo")
//                .setOwnerName("Paulo")
//                .setOwnerBirthDate(new Date())
//                .setCpfCnpj("06928316000124")
//                .setAgency("0108")
//                .setAccount("10895")
//                .setAccountDigit("5")
//                .setBankAccountType(BankAccountType.CONTA_CORRENTE);
//        Transfer transfer = Transfer.pixManualCreator()
//                .setBankAccount(bankAccountSetting)
//                .setValue(Money.create(new BigDecimal(1.01)))
//                .create();

//        System.out.println(transfer.getValue().toString());

//        Transfer ted = Transfer.tedCreator()
//                .setBankAccount(bankAccountSetting)
//                .setValue(Money.create(new BigDecimal(1.01)))
//                .create();
//
//        ResourceSet<Transfer> transferList = Transfer.reader().read();
      //  System.out.println(transfer.getValue().toString());

//        Payment payment = Payment.creator()
//                .setCustomer("cus_000072683114")
//                .setBillingType(BillingType.PIX)
//                .setDueDate(new Date())
//                .setInstallmentCount(2)
//                .setInstallmentValue(Money.create(50))
//                .setDescription("Teste")
//                .create();
//
//        ResourceSet<Payment> paymentResourceSet = Payment.reader()
//                .setStatus(PaymentStatus.RECEIVED)
//                .setStartPaymentDate(new Date())
//                .setFinishDueDate(new Date())
//                .read();
//
//        DeletedResource paymentDeleted = Payment.deleter(payment.getId()).delete();
//        payment = Payment.restorer(payment.getId()).create();
//
//        ResourceSet<Installment> installmentResourceSet = Installment.reader().read();
//        DeletedResource installmentDeleted = Installment.deleter(installmentResourceSet.getData().get(0).getId()).delete();
//        ResourceSet<PixTransaction> pixTransactionResourceSet = PixTransaction.reader().read();
//        ResourceSet<PixTransaction> pixTransactionResourceSet = PixTransaction.reader()
//                .setType(PixTransactionType.DEBIT)
//                .read();
//        PixTransaction cancelledPixTransaction = PixTransaction.canceller("35363f6e-93e2-11ec-b9d9-96f4053b1bd4").create();
//        FinanceBalance financeBalance = FinanceBalance.fetcher().fetch();
//
//        PaymentLink paymentLink = PaymentLink.creator()
//                .setName("name")
//                .setBillingType(BillingType.PIX)
//                .setChargeType(PaymentLinkChargeType.INSTALLMENT)
//                .setEndDate(new Date())
//                .setDueDateLimitDays(10)
//                .setMaxInstallmentCount(2)
//                .create();
//
//        PaymentLink updated = PaymentLink.updater(paymentLink.getId())
//                .setName("name")
//                .setBillingType(BillingType.PIX)
//                .setChargeType(PaymentLinkChargeType.INSTALLMENT)
//                .setEndDate(new Date())
//                .setDueDateLimitDays(10)
//                .setMaxInstallmentCount(2)
//                .update();

        ResourceSet<FinancialTransaction> financialTransactionResourceSet = FinancialTransaction
                .reader()
                .setTransferId("transferId")
                .read();
//        PaymentLink link = PaymentLink.fetcher("725104409743").fetch();
//        ResourceSet<PaymentLink> paymentLinkResourceSet = PaymentLink
//                .reader()
//                .read();
//        DeletedResource deletedPaymentLink = PaymentLink
//                .deleter("725104409743")
//                .delete();
//
//        Bill bill = Bill.creator()
//                .setIdentificationField("25794150099003551916515000211407100000000000000")
//                .create();

        // PixAddressKey.creator().setType(PixAddressKeyType.EVP).create();
        // PixAddressKey.reader().read();
//        PixQrCode qrCode = PixQrCode
//                .creator()
//                .setAddressKey(PixAddressKey.reader().read().getData().get(0).key)
//                .setDescription("teste")
//                .setValue(new BigDecimal("0.01")).create();
//        System.out.printf(qrCode.id);

//        ResourceSet<Transfer> transferList = Transfer.reader().read();
//        PixDecodedQrCode decodedQrCode = PixDecodedQrCode.decoder()
//                        .setPayload("payload")
//                        .create();
//        PixAddressKey.reader()
//                .setStatus(PixAddressKeyStatus.ACTIVE)
//                .setLimit(1)
//                .read();
//
//        PixTransaction.reader().read();
//        PixTransaction.fetcher("bc515f74-d5c7-4bc2-93e5-3bafc0a9b15d").fetch();
//
//        CustomerAccount customerAccount = CustomerAccount.creator()
//                .setName("criado via API")
//                .setCpfCnpj("10030823005")
//                .create();
//        ResourceSet<NotificationConfig> notificationConfigList = NotificationConfig.customerAccountReader(customerAccount.getId()).read();
//        NotificationConfig.updater(notificationConfigList.getData().get(0).getId()).setEnabled(false).update();
//        CustomerAccount.fetcher("cus_000072683044").fetch();
        PaymentStatusData paymentStatusData = Payment.statusFetcher("pay_9087711026766517").fetch();
        PaymentIdentificationField linhaDigitavel = Payment.identificationFieldFetcher("pay_9087711026766517").fetch();
    }

}
