23种设计模式

创建
===========创建型模式============
===========创建型模式============
1.单例模式
懒汉，恶汉，静态内部类，枚举
静态内部类和恶汉模式结合  懒加载

2.工厂模式
简单工厂，类方法工厂，抽象工厂
抽象工厂类似于创造者模式，区别由工厂创建实体对象

3.创造者模式
builder,director(领导装配)
builder用户创建实体对象元素
director用户构建实体对象【通过builder创建的元素填充实体】

4.克隆模式（浅克隆，深克隆）
new 产生一个对象繁琐情况
反序列化克隆对象，深克隆
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(cloneDomain);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);


组织结构
===========结构型模式============
===========结构型模式============
5.适配器模式  对象适配器-类适配器
典型运用【流对象】
//        InputStreamReader
//        OutputStreamWriter
将一个类的接口转换成客户希望的另一个接口。适配器模式让那些接口不兼容的类可以一起工作
1：Target(目标抽象类)：目标抽象类定义客户所需的接口，可以是一个抽象类或接口，也可以是具体类。在类适配器中，由于C#语言不支持多重继承，所以它只能是接口。
2：Adapter(适配器类)：它可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配。它是适配器模式的核心。
3：Adaptee(适配者类)：适配者即被适配的角色，它定义了一个已经存在的接口，这个接口需要适配，适配者类包好了客户希望的业务方法。

6.代理模式
抽象角色 == 代理对外提供接口
真实角色 == 实现功能
代理角色 == 实现抽象角色，代理真实角色，附加自己功能对外提供真实角色功能

==应用场景
安全代理：屏蔽真实角色，安全
远程代理：代理类处理远程方法调用RMI
延迟加载: 先加载轻量级代理对象，需要时加载真实对象

静态代理：程序中定义代理
动态代理：动态生成代理类
    JDK自带
    javaassist字节码
    CGLB
    ASM
  VisualRole visualRole = new RealRole();
  InvocationHandler roleHanlder = new RoleHandler(visualRole);//InvocationHandler  传入需要代理的对象【jdk代理代理对象需要有实现的接口】
  VisualRole proxy = (VisualRole)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{VisualRole.class},roleHanlder);//创建接口自类

7.桥接模式
    应用层级数量级增长
    提取公共，分类 层叠
8.装饰模式
    替代继承的技术，无需通过继承增加子类就扩展功能，避免类型体系膨胀 【对象关联关系】

9.组合模式
    处理树形结构，描述将容器和叶子递归组合，使用户一致性对待容器和叶子
    容器对象指定方法被调用时，遍历整个树形结构，递归执行容器和叶子节点的指定方法
    Junit单元测试  TestCase叶子 TestUnite容器 Test接口（抽象）
    XML解析
    GUI容器层次
    OA系统，组织结构
10.外观模式
    功能集合，避免分散调用
11.享元模式
    内部状态 享元
    外部状态 不可共享


相互交互,通信合作
===========行为型模式============
===========行为型模式============
12.责任链模式
    链式结构==
    Handler 抽象处理者
    异常机制，Servlet过滤器
13.命令模式【了解】
14.解释器模式【了解即可】
    el表达式
    正则表达式
    sql语法解释器
15.迭代器模式
    遍历聚合对象的模式【游标模式 指针指向】
    聚合对象：存储数据
    迭代器：遍历数据 Iterator(内部类用)
16.中介者模式
    MVC
    反射invoke()
17.策略模式
    CRM
    Resource接口
    service()
18.模板方法模式【常用】
    多态类似【钩子方法】
    Junit单元测试
    数据库封装
    JDBCTemplate,HibernateTemplate
19.状态模式
    修改状态触发某种操作，扩展状态
20.观察者模式
    订阅发布
    Servlet 监听器
    邮件订阅
    JDK AWT事件处理
    基本结构:notify通知
            register注册观察者
            remove删除观察者
    java提供  Observable和Observer

21.备忘录模式
    保存某个对象内部状态copy
    源发器类Originator
    备忘录类Memento
    负责人类CareTaker
    事务回滚场景，撤销操作