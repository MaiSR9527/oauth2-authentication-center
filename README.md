# oauth2-authentication-center
基于OAuth2的统一认证中心

前端：frontend-vue-admin，基于[vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)

后端：unified-auth-center

Spring Boot 2.6.8

JDK11

**TODO**

# JWS、JWK、JWE

对JWT进行签名，在头部声明签名算法，然后在尾部拼接签名，保证JWT是不能被随意修改，这个签名：JWT Signature也叫JWS。

如果对JWT的签名算法使用非对称加密算法进行非对称加密，这时候就需要密钥对（公钥和私钥），统称JSON Web Key，也就是JWK。

JWS中私钥加密Token，公钥解密Token，而JWE中私钥是唯一能够解密Token的一方。

* 在JWS方案中，公钥持有方不能加入新的数据到Token，只能验证数据
* 在JWE方案中，公钥持有放可以加入新的数据到Token，然后私钥加密得到数据

JWS的Token组成：

```
eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6IjRmMWcyM2ExMmFhIn0.eyJpc3MiOiJodHRwOi8vc2hhb2Jhb2Jhb2VyLmNuIiwiYXVkIjoiaHR0cDovL3NoYW9iYW9iYW9lci5jbi93ZWJ0ZXN0L2p3dF9hdXRoLyIsImp0aSI6IjRmMWcyM2ExMmFhIiwiaWF0IjoxNTM0MDcwNTQ3LCJuYmYiOjE1MzQwNzA2MDcsImV4cCI6MTUzNDA3NDE0NywidWlkIjoxLCJkYXRhIjp7InVuYW1lIjoic2hhb2JhbyIsInVFbWFpbCI6InNoYW9iYW9iYW9lckAxMjYuY29tIiwidUlEIjoiMHhBMCIsInVHcm91cCI6Imd1ZXN0In19.GQPGEpixjPZSZ7CmqXB-KIGNzNl4Y86d3XOaRsfiXmQ
```

* header
* payload
* signature

JWE的Token组成：

```shell
eyJhbGciOiJSU0ExXzUiLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0.
UGhIOguC7IuEvf_NPVaXsGMoLOmwvc1GyqlIKOK1nN94nHPoltGRhWhw7Zx0-kFm1NJn8LE9XShH59_
i8J0PH5ZZyNfGy2xGdULU7sHNF6Gp2vPLgNZ__deLKxGHZ7PcHALUzoOegEI-8E66jX2E4zyJKxYxzZIItRzC5hlRirb6Y5Cl_p-ko3YvkkysZIFNPccxRU7qve1WYPxqbb2Yw8kZqa2rMWI5ng8Otv
zlV7elprCbuPhcCdZ6XDP0_F8rkXds2vE4X-ncOIM8hAYHHi29NX0mcKiRaD0-D-ljQTPcFPgwCp6X-nZZd9OHBv-B3oWh2TbqmScqXMR4gp_A.
AxY8DCtDaGlsbGljb3RoZQ.
KDlTtXchhZTGufMYmOYGS4HffxPSUrfmqCHXaI9wOGY.
9hH0vgRfYgPnAHOd8stkvw
```

* protect header：头部
* encrypted key：密钥
* initialization vector：初始IV值，有些加密方式需要额外的或者随机的数据
* encrypted data：密文数据
* authentication tag：算法产生的附加数据，防止密文被篡改
