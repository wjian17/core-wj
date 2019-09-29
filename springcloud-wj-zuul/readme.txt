动态网关配置需要配合configServer使用,在github中动态配置，刷新


zuul:
  routes:
    api-menber1:
      path: /test
      serviceId: springcloud-wj-rest
    api-menber2:
      path: /test1
      serviceId: springcloud-wj-configServer