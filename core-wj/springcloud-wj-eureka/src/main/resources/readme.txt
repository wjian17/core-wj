springcloud注册中心



#Eureka 相关配置
eureka:
  instance:
    hostname: localhost
  # 关闭自我保护，及时剔除无用服务
  server:
    enableSelfPreservation: true
  client:
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
    # 是否从其他的服务中心同步服务列表
    fetch-registry: false
    # 是否把自己作为服务注册到其他服务注册中心
    register-with-eureka: false