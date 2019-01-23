eureka自我保护机制
开启心跳检测

eureka:
  instance:
    lease-renewal-interval-in-seconds: 30    #向服务端发送一次心跳，证明自己依然”存活“
    lease-expiration-duration-in-seconds: 2000     #如果我2s之内没有给你发心跳，就代表我“死”了，将我踢出掉
  server:
    # 测试时关闭自我保护机制，保证不可用服务及时踢出
    enable-self-preservation: false