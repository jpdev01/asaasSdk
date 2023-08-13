# JAsaas [EM DESENVOLVIMENTO]

Asaas.com JAVA-SDK
=================

SDK não-oficial de integração à API do serviço www.asaas.com

Instalação
----------

Adicione o jar no classhpath da aplicação.

Endpoint
--------

Caso queira usar a API em modo teste basta especificar o `ambiente` no momento em que o cliente é instanciado.

```java
Asaas asaas = new Asaas(new ApacheHttpClientAdapter(acessToken), Asaas.AMBIENTE_HOMOLOGACAO);
ou
Asaas asaas = new Asaas(new ApacheHttpClientAdapter(acessToken), Asaas.AMBIENTE_PRODUCAO);
```


Clientes
--------

```java
// Retorna a listagem de clientes
CustomerConnection conn = asaas.customer();
List<Customer> customers = conn.getAll();

// Usando o Filter para consultar os dados do cliente
CustomerConnection conn = asaas.customer();
CustomerFilter filter = new CustomerFilter();
filter.setName("Bosco Filho");
List<Customer> customerList = conn.getAll(filter);

// Retorna os dados do cliente de acordo com o Id
CustomerConnection conn = asaas.customer();
Customer customer = conn.getById("cus_wFkaUbylBKNd");

// Retorna os dados do cliente de acordo com o Email
CustomerConnection conn = asaas.customer();
Customer customer = conn.getByEmail("bos@liamg.moc.rb");

// Insere um novo cliente
CustomerConnection conn = asaas.customer();

Customer customer = new Customer();
customer.setName("Bosco Filho");
customer.setEmail("bos@liamg.moc.rb");
customer.setMobilePhone("8488888888");
customer.setCpfCnpj("31890545929");
customer.setPostalCode("59875-400");
customer.setAddress("Av. paulista");
customer.setAddressNumber("858");
customer.setProvince("Pitimbu");
customer.setCity("3550308");

Customer cCreated = conn.createCustomer(customer);

// Atualiza os dados do cliente
CustomerConnection conn = asaas.customer();
customer.setEmail("bosc@liamg.moc.rb");
Customer cUpdated = conn.updateCustomer(customer);

// Deleta uma cliente
CustomerConnection conn = asaas.customer();
Boolean deleted = conn.deleteCustomer("cus_uiqd7mD1OFE0");

```


Cobranças
------------

```java
// Retorna a listagem de cobranças
PaymentConnection conn = asaas.payment();
List<Payment> listaPay = conn.getAll();

// Retorna os dados da cobrança de acordo com o Id
PaymentConnection conn = asaas.payment();
Payment payment = conn.getById("pay_495842931739");

// Retorna a listagem de cobranças de acordo com o Id do Cliente
PaymentConnection conn = asaas.payment();
List<Payment> payments = conn.getByCustomer("cus_wFkaUbylBKNd");

// Retorna a listagem de cobranças de acordo com o Id da Assinaturas
PaymentConnection conn = asaas.payment();
List<Payment> payments = conn.getBySubscriptions("sub_1cqNggmuHEnE");

// Insere uma nova cobrança
PaymentConnection conn = asaas.payment();

Payment p = new Payment();
p.setCustomer("cus_wFkaUbylBKNd");
p.setBillingType(Payment.BILLINGTYPE_BOLETO);
p.setValue(new BigDecimal(100));
p.setDueDate(new Date());
p.setDescription("Cobrança INTERPLACAS");        
p.setExternalReference("15");        
Payment pCreated = conn.createPayment(p);

// Atualiza os dados da cobrança
PaymentConnection conn = asaas.payment();
p.setValue(new BigDecimal(150));
Payment pUpdated = conn.updatePayment(p);

// Deleta uma cobrança
PaymentConnection conn = asaas.payment();
Boolean deleted = conn.deletePayment("pay_495842931739");

```


Assinaturas
------------

```java
// Retorna a listagem de assinaturas

// Retorna os dados da assinatura de acordo com o Id

// Retorna a listagem de assinaturas de acordo com o Id do Cliente

// Insere uma nova assinatura

// Atualiza os dados da assinatura

// Deleta uma assinatura
```


Notificações
------------

```java
// Retorna a listagem de notificações

// Retorna os dados da notificação de acordo com o Id

// Retorna a listagem de notificações de acordo com o Id do Cliente

// Insere uma nova notificação

// Atualiza os dados da notificação

// Deleta uma notificação
```


Cidades
------

```java
// Retorna a listagem de cidades
CityConnection conn = asaas.city();
List<City> cities = conn.getAll();
        
// Retorna os dados da cidade de acordo com o Id
CityConnection conn = asaas.city();
List<City> cities = conn.getyId(7637);

```


Webhook para cobranças  
------

```java
// Busca a configuração de webhook para notificações de cobranças.
WebhookConfigConnection connWH = asaas.webhookConfig();
WebhookConfig webhookConfig = connWH.get();
        
// Cria ou atualiza a configuração de webhook para notificações de cobranças.
WebhookConfigConnection connWH = asaas.webhookConfig();
WebhookConfig webhookConfig = connWH.get();
webhookConfig.setInterrupted(Boolean.FALSE);
webhookConfig.setEnabled(Boolean.TRUE);
webhookConfig.setApiVersion(3);
webhookConfig.setUrl("https://www.exemplo.com/webhook/asaas");
connWH.updateWebhookConfig(webhookConfig);

```

Documentação Oficial
--------------------

Obs.: Esta é uma API não oficial. Foi feita com base na documentação disponibilizada  [neste link](https://docs.google.com/document/d/1XUJRHY_0nd45CzFK5EmjDK92qgaQJGMxT0rjZriTk-g).

V3: https://asaasv3.docs.apiary.io

Créditos
--------


#### [Intersistemas Serviços em Tecnologia LTDA - EPP](http://intersistemas.com.br/ "Intersistemas Serviços em Tecnologia LTDA - EPP")



##### Desenvolvedores:

* João Bosco C M Filho
* Jefferson Willian da C Lucena
* Marcio Davi M M
* João Pedro F S Araújo


Licença
-------
Copyright &copy; 2016 Intersistemas Serviços em Tecnologia LTDA - EPP

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
