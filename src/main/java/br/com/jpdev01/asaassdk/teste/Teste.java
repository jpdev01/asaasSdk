package br.com.jpdev01.asaassdk.teste;

import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.rest.action.ResourceSet;
import br.com.jpdev01.asaassdk.rest.payment.Payment;
import br.com.jpdev01.asaassdk.rest.pix.addresskey.PixAddressKey;
import br.com.jpdev01.asaassdk.rest.pix.addresskey.PixAddressKeyCreator;
import br.com.jpdev01.asaassdk.rest.pix.addresskey.PixAddressKeyReader;
import br.com.jpdev01.asaassdk.rest.pix.qrcode.PixQrCode;
import br.com.jpdev01.asaassdk.rest.transfer.Transfer;
import br.com.jpdev01.asaassdk.rest.transfer.TransferReader;
import br.com.jpdev01.asaassdk.rest.transfer.TransferTedCreator;
import br.com.jpdev01.asaassdk.rest.transfer.children.BankAccountType;
import br.com.jpdev01.asaassdk.rest.transfer.children.BankSetting;
import br.com.jpdev01.asaassdk.rest.transfer.children.BankAccountSetting;
import br.com.jpdev01.asaassdk.utils.BillingType;
import br.com.jpdev01.asaassdk.utils.Money;
import br.com.jpdev01.asaassdk.utils.pix.PixAddressKeyStatus;
import br.com.jpdev01.asaassdk.utils.pix.PixAddressKeyType;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    }

}
