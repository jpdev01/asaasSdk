## Update
```java
CommercialInfo updatedCommercialInfo = CommercialInfo.updater()
                .setSite("https://yourSite.com.br")
                .update();
```

## Recuperar informações comerciais
```java
CommercialInfo commercialInfo = CommercialInfo.fetcher().fetch();
```