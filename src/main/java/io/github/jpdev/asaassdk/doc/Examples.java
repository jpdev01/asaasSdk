package io.github.jpdev.asaassdk.doc;

import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.rest.accounts.Account;
import io.github.jpdev.asaassdk.rest.accounts.AccountCreator;
import io.github.jpdev.asaassdk.rest.action.ResourceSet;
import io.github.jpdev.asaassdk.rest.bill.Bill;
import io.github.jpdev.asaassdk.rest.commons.DeletedResource;
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;
import io.github.jpdev.asaassdk.rest.finance.FinanceBalance;
import io.github.jpdev.asaassdk.rest.financialtransaction.FinancialTransaction;
import io.github.jpdev.asaassdk.rest.installment.Installment;
import io.github.jpdev.asaassdk.rest.invoice.Invoice;
import io.github.jpdev.asaassdk.rest.invoice.Taxes;
import io.github.jpdev.asaassdk.rest.myaccount.accountnumber.AccountNumber;
import io.github.jpdev.asaassdk.rest.myaccount.commercialinfo.CommercialInfo;
import io.github.jpdev.asaassdk.rest.myaccount.fee.AccountFee;
import io.github.jpdev.asaassdk.rest.myaccount.status.MyAccountStatus;
import io.github.jpdev.asaassdk.rest.notification.NotificationConfig;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.rest.payment.enums.PaymentLinkChargeType;
import io.github.jpdev.asaassdk.rest.payment.enums.PaymentStatus;
import io.github.jpdev.asaassdk.rest.payment.identificationfield.PaymentIdentificationField;
import io.github.jpdev.asaassdk.rest.payment.status.PaymentStatusData;
import io.github.jpdev.asaassdk.rest.paymentlink.PaymentLink;
import io.github.jpdev.asaassdk.rest.pix.addresskey.PixAddressKey;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyStatus;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyType;
import io.github.jpdev.asaassdk.rest.pix.enums.PixTransactionType;
import io.github.jpdev.asaassdk.rest.pix.qrcode.PixQrCode;
import io.github.jpdev.asaassdk.rest.pix.qrcode.decode.PixDecodedQrCode;
import io.github.jpdev.asaassdk.rest.pix.transaction.PixTransaction;
import io.github.jpdev.asaassdk.rest.pix.transaction.PixTransactionReader;
import io.github.jpdev.asaassdk.rest.subscription.Subscription;
import io.github.jpdev.asaassdk.rest.subscription.SubscriptionCycle;
import io.github.jpdev.asaassdk.rest.transfer.Transfer;
import io.github.jpdev.asaassdk.rest.transfer.children.*;
import io.github.jpdev.asaassdk.rest.webhook.Event;
import io.github.jpdev.asaassdk.rest.webhook.SendType;
import io.github.jpdev.asaassdk.rest.webhook.Webhook;
import io.github.jpdev.asaassdk.rest.webhook.WebhookReader;
import io.github.jpdev.asaassdk.utils.BillingType;
import io.github.jpdev.asaassdk.utils.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Examples {

    public static void main(String[] args) {
        Asaas.initSandbox(Secret.getAccessToken()); // Initialize the SDK with your access token
        paging();
    }

    private static void paging() {
        PixTransactionReader reader = PixTransaction.reader();
        ResourceSet<PixTransaction> page0 = reader.read();
        ResourceSet<PixTransaction> page1 = reader.nextPage().read();
    }

    private static void pixTransaction() {
        ResourceSet<PixTransaction> pixTransactionResourceSet = PixTransaction.reader().read();
        PixTransaction pixTransaction = PixTransaction.fetcher("bc515f74-d5c7-4bc2-93e5-3bafc0a9b15d").fetch();
        PixTransaction cancelledPixTransaction = PixTransaction.canceller("35363f6e-93e2-11ec-b9d9-96f4053b1bd4").create();
        ResourceSet<PixTransaction> pixTransactionDebitResourceSet = PixTransaction.reader()
                .setType(PixTransactionType.DEBIT)
                .read();
    }

    private static void pixAddressKey() {
        ResourceSet<PixAddressKey> pixAddressKeyResourceSet = PixAddressKey.reader()
                .setStatus(PixAddressKeyStatus.ACTIVE)
                .setLimit(1)
                .read();
        PixAddressKey.creator().setType(PixAddressKeyType.EVP).create();
        PixAddressKey.reader().read();
    }

    private static void decodePixQrCode() {
        PixDecodedQrCode decodedQrCode = PixDecodedQrCode.decoder()
                .setPayload("payload")
                .create();
    }

    private static void transfer() {
        Transfer transfer = Transfer.pixAddressKeyCreator()
                .setPixAddressKey("+5547999999999")
                .setValue(Money.create(0.01))
                .setDescription("teste")
                .setPixAddressKeyType(PixAddressKeyType.PHONE)
                .create();
        System.out.println(transfer.getValue().toString());

        ResourceSet<Transfer> transferList = Transfer.reader().read();

        Date birthDate = new Date();
        BankAccountSetting bankAccountSetting = new BankAccountSetting()
                .setBank(
                        new BankSetting().setCode("085")
                )
                .setAccountName("Paulo")
                .setOwnerName("Paulo")
                .setOwnerBirthDate(new Date())
                .setCpfCnpj("06928316000124")
                .setAgency("0108")
                .setAccount("10895")
                .setAccountDigit("5")
                .setBankAccountType(BankAccountType.CONTA_CORRENTE);
        Transfer pixManualTransfer = Transfer.pixManualCreator()
                .setBankAccount(bankAccountSetting)
                .setValue(Money.create(new BigDecimal(1.01)))
                .create();

        System.out.println(pixManualTransfer.getValue().toString());

        Transfer ted = Transfer.tedCreator()
                .setBankAccount(bankAccountSetting)
                .setValue(Money.create(new BigDecimal(1.01)))
                .create();

        Transfer internal = Transfer.internalCreator()
                .setValue(Money.create(new BigDecimal(10)))
                .setWalletId("0021c712-d963-4d86-a59d-031e7ac51a2e")
                .create();
    }

    private static void recurringTransfer() {
        PixRecurring recurring = new PixRecurring()
                .setFrequency(PixRecurringFrequency.MONTHLY)
                .setQuantity(2);

        Transfer transfer = Transfer.pixAddressKeyCreator()
                .setPixAddressKey("+5547999999999")
                .setValue(Money.create(0.01))
                .setDescription("teste")
                .setPixAddressKeyType(PixAddressKeyType.PHONE)
                .setRecurring(recurring)
                .create();
        System.out.println(transfer.getRecurring());
    }

    private static void bill() {
        Bill bill = Bill.creator()
                .setIdentificationField("25794150099003551916515000211407100000000000000")
                .create();
    }

    private static void pixStaticQrCode() {
        PixQrCode qrCode = PixQrCode
                .creator()
                .setAddressKey(PixAddressKey.reader().read().getData().get(0).key)
                .setDescription("teste")
                .setValue(Money.create(0.01))
                .create();
        System.out.printf(qrCode.payload);
    }

    private static void payment() {
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

        DeletedResource paymentDeleted = Payment.deleter(payment.getId()).delete();
        payment = Payment.restorer(payment.getId()).create();

        PaymentStatusData paymentStatusData = Payment.statusFetcher("pay_9087711026766517").fetch();
        PaymentIdentificationField linhaDigitavel = Payment.identificationFieldFetcher("pay_9087711026766517").fetch();
    }

    private static void customerAccount() {
        CustomerAccount.fetcher("cus_000072683044").fetch();
        CustomerAccount customerAccount = CustomerAccount.creator()
                .setName("criado via API")
                .setCpfCnpj("10030823005")
                .create();
    }

    private static void notification() {
        ResourceSet<NotificationConfig> notificationConfigList = NotificationConfig.customerAccountReader("cus_000072683044").read();
        NotificationConfig.updater(notificationConfigList.getData().get(0).getId()).setEnabled(false).update();
    }

    private static void paymentLink() {
        PaymentLink link = PaymentLink.fetcher("725104409743").fetch();
        ResourceSet<PaymentLink> paymentLinkResourceSet = PaymentLink
                .reader()
                .read();
        DeletedResource deletedPaymentLink = PaymentLink
                .deleter("725104409743")
                .delete();

        PaymentLink paymentLink = PaymentLink.creator()
                .setName("name")
                .setBillingType(BillingType.PIX)
                .setChargeType(PaymentLinkChargeType.INSTALLMENT)
                .setEndDate(new Date())
                .setDueDateLimitDays(10)
                .setMaxInstallmentCount(2)
                .create();

        PaymentLink updated = PaymentLink.updater(paymentLink.getId())
                .setName("name")
                .setBillingType(BillingType.PIX)
                .setChargeType(PaymentLinkChargeType.INSTALLMENT)
                .setEndDate(new Date())
                .setDueDateLimitDays(10)
                .setMaxInstallmentCount(2)
                .update();
    }

    private static void financialTransaction() {
        ResourceSet<FinancialTransaction> financialTransactionResourceSet = FinancialTransaction
                .reader()
                .setTransferId("transferId")
                .read();
    }

    private static void invoice() {
        Invoice invoice = Invoice.creator()
                .setServiceDescription("Nota fiscal da Fatura 101940. Descrição dos Serviços: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS")
                .setObservations("Mensal referente aos trabalhos de Junho.")
                .setValue(Money.create(300))
                .setDeductions(Money.create(2))
                .setEffectiveDate(new Date())
                .setMunicipalServiceName("Análise e Desenvolvimento de Sistemas")
                .setTaxes(
                        new Taxes()
                                .setRetainIss(true)
                                .setIss(Money.create(3))
                                .setCofins(Money.create(3))
                                .setCsll(Money.create(1))
                                .setInss(Money.create(3))
                                .setIr(Money.create(1.5))
                                .setPis(Money.create(0.65))
                )
                .create();
    }

    private static void finance() {
        FinanceBalance financeBalance = FinanceBalance.fetcher().fetch();
    }

    private static void installment() {
        ResourceSet<Installment> installmentResourceSet = Installment.reader().read();
        DeletedResource installmentDeleted = Installment.deleter(installmentResourceSet.getData().get(0).getId()).delete();
    }

    private static void commercialInfo() {
        CommercialInfo commercialInfo = CommercialInfo.fetcher().fetch();
        CommercialInfo updatedCommercialInfo = CommercialInfo.updater()
                .setSite("https://yourSite.com.br")
                .update();
    }

    private static void accountNumber() {
        AccountNumber accountNumber = AccountNumber.fetcher().fetch();
    }

    private static void fee() {
        AccountFee myFees = AccountFee.fetcher().fetch();
    }

    private static void myStatus() {
        MyAccountStatus myAccountStatus = MyAccountStatus.fetcher().fetch();
        System.out.println(myAccountStatus.getGeneral().toString());
    }

    private static void subAccount() {
        Account account = Account.creator()
                .setName("Teste sub conta")
                .setBirthDate(new Date())
                .setCompanyType("LIMITED")
                .setEmail("joaoexample2@gmail.com")
                .setPostalCode("36572122")
                .setCpfCnpj("87.326.705/0001-81")
                .create();
        System.out.println(account.getName());

        Account fetched = Account.fetcher(account.id).fetch();
        System.out.println(fetched.getEmail());
    }

    private static void subscription() {
        Subscription subscription = Subscription.creator()
                .setCustomer("cus_000072683044")
                .setCycle(SubscriptionCycle.MONTHLY)
                .setNextDueDate(new Date())
                .setValue(Money.create(100))
                .setDescription("Teste")
                .create();
    }
}
