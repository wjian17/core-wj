==============================#mybatis================================
==============================#mybatis================================
==============================#mybatis================================
==============================#mybatis================================

我们知道，在不考虑与Spring集成的情况下,使用MyBatis执行数据库操作的代码如下
String resource = "org/mybatis/example/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
SqlSession session = sqlSessionFactory.openSession();
try {
  Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
} finally {
  session.close();
}


原理：
Resources 加载配置文件
SqlSessionFactoryBuilder() 构建器，创建SqlSessionFactory接口实现类
XMLConfigBuilder 全局配置文件内容构建器类，读取文件配置内容转换为java代码，
Configuration 封装全局配置文件配置信息
DefaultSqlSessionFactory  SqlSessionFactory接口实现类

openSession 创建
Transaction  事务，
TransactionFactory 事务工厂，environment数据库连接信息中创建

Executor 执行器 mybatis 执行sql命令，相当于statement，preparedStatement,CallableStatement   [默认为SimpleExecutor,批量：BatchExcutor,通过openSession控制]

DefaultSqlSession sqlSession实现类
ExceptionFactory 异常工厂
ErrorContext 错误容器


标签：association  装配对象时使用，property 对象中属性名  select mapper查询  column 值传递【做参数】
<resultMap>
<result property="tid" column="tid"/> 需要多配置一个属性
association property="" select="mapper.selectById" column="tid"
</resultMap>



标签：collection
<resultMap>
<collection property="" select="" column="" ofType="">
</resultMap>







==============================#spring================================
==============================#spring================================
==============================#spring================================
==============================#spring================================
==============================#spring================================
web整合
WebApplicationContext
ContextLoadListener
WebApplicationContextUtils.getRequireWebApplicationContext(getServletContext())
ApplicationContext ac = new ClassPathApplicationContext("classpath:application.xml");
ac.getBean();

实例模式
构造器注入：

静态工厂：调用静态方法创建bean
<bean id="beanName" class="" factory-method=""/>

实例工厂：实例化工厂，调用创建实例bean方法
<bean id="beanFactory" class=""/>
<bean id="beanName" factory-bean="beanFactory" factory-method=""/>

属性值注入：
构造器注入：
property标签注入：
<property name='sets'>
<set>
<value>1</value>
<value>2</value>
</set>
</property>






==============================#springMVC================================
==============================#springMVC================================
==============================#springMVC================================
==============================#springMVC================================
==============================#springMVC================================
==============================#springMVC================================
==============================#springMVC================================
//路径占位符  demo8/abc/1  注意路径问题【返回页面相对于demo8.abc】 return main.jsp;  /main.jsp
//produces 设置响应头中的head属性
application/json;charset=utf-8   Contexnt-Type
MediaType.APPLICATION_JSON_VALUE
设置


DisPatcherServlet
配置servlet
init-param
<param-name>contextConfigLocation</
<param-value>classpath:springmvc.xml</


ConfigurableApplicationContext   springmvc容器初始化
<mvc:annotation-driven>注解驱动
<mvc:resources location="/WEB-INF/js/" mapping="/js/**"> js文件下所有文件
ConfigurableWebApplicationContext



HandlerMapping[SimpleHandlerMapping]    urlMap映射handler ，
设置
urlMap
<property>
<map>
<entry key="handlerkey" value-ref="handler">
注解时候自动使用DefaultAnnotationHandlerMapping



HandlerAdapter[SimpleControllerHandlerAdapter]
注解时候自动使用AnnotationHandlerAdapter

ViewResolver[InternalResourceViewResolver]
视图解析器
默认为
REDIRECT_URL_PREFIX
FORWARD_URL_PREFIX
prefix
suffix









