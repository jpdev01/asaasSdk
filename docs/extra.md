## Sandbox
You can use the sandbox environment to test your integration. To do this, you need to call the `initSandbox` method before making any requests.
```java
Asaas.initSandbox("your_api_key");
```

## Timeout

The default timeout is 30000 milliseconds. You can change it by calling the `setTimeout` method.
```java
Asaas.setTimeout(10000);
```
