package br.com.jpdev01.asaassdk.teste;

import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.rest.action.ResourceSet;
import br.com.jpdev01.asaassdk.rest.customeraccount.CustomerAccount;
import br.com.jpdev01.asaassdk.rest.notification.NotificationConfig;
import br.com.jpdev01.asaassdk.rest.payment.Payment;
import br.com.jpdev01.asaassdk.rest.payment.delete.PaymentDeleted;
import br.com.jpdev01.asaassdk.rest.payment.delete.PaymentDeleter;
import br.com.jpdev01.asaassdk.rest.payment.identificationfield.PaymentIdentificationField;
import br.com.jpdev01.asaassdk.rest.payment.restore.PaymentRestorer;
import br.com.jpdev01.asaassdk.rest.payment.status.PaymentStatusData;
import br.com.jpdev01.asaassdk.rest.pix.qrcode.decode.PixDecodedQrCode;
import br.com.jpdev01.asaassdk.rest.pix.transaction.PixTransaction;
import br.com.jpdev01.asaassdk.rest.pix.addresskey.PixAddressKey;
import br.com.jpdev01.asaassdk.rest.transfer.Transfer;
import br.com.jpdev01.asaassdk.utils.BillingType;
import br.com.jpdev01.asaassdk.utils.Money;
import br.com.jpdev01.asaassdk.utils.PaymentStatus;
import br.com.jpdev01.asaassdk.utils.pix.PixAddressKeyStatus;

import java.math.BigDecimal;
import java.util.Date;

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

        Payment payment = Payment.creator()
                .setCustomer("cus_000072683114")
                .setBillingType(BillingType.PIX)
                .setDueDate(new Date())
                .setInstallmentCount(2)
                .setInstallmentValue(Money.create(50))
                .setDescription("Teste")
                .create();

        ResourceSet<Payment> paymentResourceSet = Payment.reader()
                .setStatus(PaymentStatus.RECEIVED)
                .setStartPaymentDate(new Date())
                .setFinishDueDate(new Date())
                .read();

        PaymentDeleted paymentDeleted = Payment.deleter(payment.getId()).delete();
        payment = Payment.restorer(payment.getId()).create();

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
