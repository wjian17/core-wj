配置：
spring:
  cache:
    ehcache:
      config: ehcache.xml

文件：ehcache.xml

@EnableCaching

@Cacheable(value="users",key="#page.pageSize")
#value值在ehcache.xml配置中定义，否则为默认【实体类需要序列化-磁盘缓存支持】  方法返回放入cache
#key做标识，缓存中查找key标识的缓存对象，值默认为方法传递的参数

@CacheEvict(value="users",allEntries=true)
#缓存清除注解
#value找配置ehcache.xml中对应，allEntries=true清除所有value标识的值