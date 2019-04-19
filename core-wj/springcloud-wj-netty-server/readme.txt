NettyServerListener
创建监听器
/**
     * 通道适配器
     */
    @Resource
    private ServerChannelHandlerAdapter channelHandlerAdapter;
    /**
     * NETT服务器配置类
     */
    @Resource
    private NettyConfig nettyConfig;


Client端：
Client我感觉要比Server端要麻烦一点。这里还是先给出核心类吧。

NettyClient ： netty客户端
ClientChannelHandlerAdapter ： 客户端通道适配器
CustomChannelInitalizer：自定义通道初始化工具
RPCProxyFactoryBean：RPC通信代理工厂



#不能用localhost,否则启动报异常:Unresolved address
#tcp监听的端口
tcp:
  port: 8090
# bossGroup的线程数
boss:
  thread:
    count: 2
# worker的线程数
worker:
  thread:
    count: 2
#是否使用长连接
so:
  keepalive:  true
  backlog: 100
