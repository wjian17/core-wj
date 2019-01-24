文件需要配置在bootstrap.yml中，否则加载不了[springcloud-config-client]

spring:
  cloud:
    config:
      uri: http://localhost:8757
      profile: dev
      discovery:
        service-id: springcloud-wj-configServer
        enabled: true



@RefreshScope 使用人工手动刷新【配置中在bootstrap.yml中】
#开启所有端点
management:
  endpoints:
    web:
      exposure:
        include: "*"