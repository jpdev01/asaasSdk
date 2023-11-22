package br.com.jpdev01.asaassdk.teste;

import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.rest.customeraccount.CustomerAccount;
import br.com.jpdev01.asaassdk.rest.pix.transaction.PixTransaction;
import br.com.jpdev01.asaassdk.rest.pix.addresskey.PixAddressKey;
import br.com.jpdev01.asaassdk.utils.pix.PixAddressKeyStatus;

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
//                .setCustomer("cus_000050606806")
//                .setBillingType(BillingType.PIX)
//                .setDueDate(new Date())
//                .setValue(Money.create(new BigDecimal(10.01)))
//                .setDescription("Teste")
//                .create();

        // PixAddressKey.creator().setType(PixAddressKeyType.EVP).create();
        // PixAddressKey.reader().read();
//        PixQrCode qrCode = PixQrCode
//                .creator()
//                .setAddressKey(PixAddressKey.reader().read().getData().get(0).key)
//                .setDescription("teste")
//                .setValue(new BigDecimal("0.01")).create();
//        System.out.printf(qrCode.id);

        PixAddressKey.reader()
                .setStatus(PixAddressKeyStatus.ACTIVE)
                .setLimit(1)
                .read();

        PixTransaction.reader().read();
        PixTransaction.fetcher("bc515f74-d5c7-4bc2-93e5-3bafc0a9b15d").fetch();

//        CustomerAccount customerAccount = CustomerAccount.creator()
//                .setName("criado via API")
//                .setCpfCnpj("10030823005")
//                .create();
    }

}
