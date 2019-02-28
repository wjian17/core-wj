#数据源配置

#数据库配置
spring:
  datasource:
    dbType: mysql
    #    dbType: oracle
    #    dbType: db2
    maxLifetime: 1765000 #一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒以上
    maximumPoolSize: 15
    #连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
    idleTimeout: 600000
    #connectionTimeout: 30000 #等待来自池的连接的最大毫秒数。如果在没有可用连接的情况下超过此时间，则会抛出SQLException。最低可接受的连接超时时间为250 ms。 默认值：30000（30秒）
    #允许连接在池中闲置的最长时间。 此设置仅适用于minimumIdle定义为小于maximumPoolSize。一旦池达到连接，空闲连接将不会退出minimumIdle。连接是否因闲置而退出，最大变化量为+30秒
    #平均变化量为+15秒。在超时之前，连接永远不会退出。值为0意味着空闲连接永远不会从池中删除。允许的最小值是10000ms（10秒）。 默认值：600000（10分钟）
    #自动提交行为。它是一个布尔值。 默认值：true
    #autoCommit: true
    mysql:
      driverClassName: com.mysql.jdbc.Driver
      url: jdbc:mysql://47.95.224.207:3306/db_test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8
      username: root
      password: Slave_1234
    oracle:
      driverClassName: oracle.jdbc.driver.OracleDriver
      url: jdbc:oracle:thin:@192.168.1.113:1521:biom
      username: oracle
      password: oracle
      validationQuery: select 1 from dual
    db2:
      driverClassName: com.ibm.db2.jcc.DB2Driver
      url: jdbc:db2://192.168.1.117:50000/attend:currentSchema=BIODEV;
      username: db2inst
      password: db2inst
      validationQuery: select 1 from sysibm.sysdummy1
    log:
      driverClassName: com.mysql.jdbc.Driver
      url: jdbc:mysql://47.95.224.207:3306/db_test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8
      username: root
      password: Slave_1234



@Bean(name = "dataSource")
@Bean(name="sqlSessionFactory")
MapperScannerConfigurer  作用是扫描packages 注入sqlSessionFactory





主从复制
slave执行错误情况跳过错误
https://www.cnblogs.com/langdashu/p/5920436.html
方法1：跳过错误Event
先跳过这一条错误(event),让主从同步恢复正常。（或者N条event，一条一条跳过）

　　stop slave;

　　set global sql_slave_skip_counter=1;

　　start slave;

从库通过I/O线程复制主数据库日志文件，通过SQL线程执行日志文件
默认mysql未开启日志
需要配置
server_id  主数据库需小于从数据库

配置：
datadir=/var/lib/mysql   #data文件（数据）
socket=/var/lib/mysql/mysql.sock
# Disabling symbolic-links is recommended to prevent assorted security risks
symbolic-links=0
log-error=/var/log/mysqld.log
pid-file=/var/run/mysqld/mysqld.pid
log_bin=master_log   #二进制日志文件
server-id=1
# 不同步哪些数据库
binlog-ignore-db=mysql
binlog-ignore-db=test
binlog-ignore-db=information_schema
# 只同步哪些数据库，除此之外，其他不同步
binlog-do-db=game
binlog-do-db=db_test



主数据库配置：执行
CREATE USER 'slave'@'192.168.1.101' IDENTIFIED BY 'Slave_pass';#创建用户
GRANT REPLICATION SLAVE ON *.* TO 'slave'@'192.168.1.101' identified by 'Slave_1234';#分配权限
flush privileges;   #刷新权限

从数据库配置：执行
change master to master_host='47.95.224.207',master_user='slave',master_password='Slave_1234',master_log_file='mysql-bin.000001',master_log_pos=308;


show master status;查看主库状态【日志文件名】




mysql分区

ALTER TABLE td_sendmessagelog ADD PARTITION (
   PARTITION p20150210 VALUES LESS THAN (TO_DAYS('2015-02-10')),
   PARTITION p20150220 VALUES LESS THAN (TO_DAYS('2015-02-20')));

RANGE分区：基于属于一个给定连续区间的列值，把多行分配给分区。
VALUES LESS THAN
CREATE TABLE employees (
    id INT NOT NULL,
    fname VARCHAR(30),
    lname VARCHAR(30),
    hired DATE NOT NULL DEFAULT '1970-01-01',
    separated DATE NOT NULL DEFAULT '9999-12-31',
    job_code INT NOT NULL,
    store_id INT NOT NULL
)

partition BY RANGE (store_id) (
    partition p0 VALUES LESS THAN (6),
    partition p1 VALUES LESS THAN (11),
    partition p2 VALUES LESS THAN (16),
    partition p3 VALUES LESS THAN (21)
);
LIST分区：类似于按RANGE分区，区别在于LIST分区是基于列值匹配一个离散值集合中的某个值来进行选择。
VALUES IN (value_list)
CREATE TABLE employees (
    id INT NOT NULL,
    fname VARCHAR(30),
    lname VARCHAR(30),
    hired DATE NOT NULL DEFAULT '1970-01-01',
    separated DATE NOT NULL DEFAULT '9999-12-31',
    job_code INT,
    store_id INT
)

PARTITION BY LIST(store_id)
    PARTITION pNorth VALUES IN (3,5,6,9,17),
    PARTITION pEast VALUES IN (1,2,10,11,19,20),
    PARTITION pWest VALUES IN (4,12,13,14,18),
    PARTITION pCentral VALUES IN (7,8,15,16)
);
HASH分区：基于用户定义的表达式的返回值来进行选择的分区，该表达式使用将要插入到表中的这些行的列值进行计算。这个函数可以包含MySQL 中有效的、产生非负整数值的任何表达式。
要使用HASH分区来分割一个表，要在CREATE TABLE 语句上添加一个“PARTITION BY HASH (expr)”子句，其中“expr”是一个返回一个整数的表达式。
它可以仅仅是字段类型为MySQL整型的一列的名字。此外，你很可能需要在后面再添加一个“PARTITIONS num”子句，其中num是一个非负的整数，它表示表将要被分割成分区的数量
CREATE TABLE employees (
    id INT NOT NULL,
    fname VARCHAR(30),
    lname VARCHAR(30),
    hired DATE NOT NULL DEFAULT '1970-01-01',
    separated DATE NOT NULL DEFAULT '9999-12-31',
    job_code INT,
    store_id INT
)
PARTITION BY HASH(store_id)
PARTITIONS 4;


CREATE TABLE employees (
    id INT NOT NULL,
    fname VARCHAR(30),
    lname VARCHAR(30),
    hired DATE NOT NULL DEFAULT '1970-01-01',
    separated DATE NOT NULL DEFAULT '9999-12-31',
    job_code INT,
    store_id INT
)
PARTITION BY LINEAR HASH(YEAR(hired))
PARTITIONS 4;
KEY分区：类似于按HASH分区，区别在于KEY分区只支持计算一列或多列，且MySQL服务器提供其自身的哈希函数。必须有一列或多列包含整数值。
CREATE TABLE tk (
    col1 INT NOT NULL,
    col2 CHAR(5),
    col3 DATE
)
PARTITION BY LINEAR KEY (col1)
PARTITIONS 3;

select * from test partition(p0)



mycat配置
schema.xml
TESTDB 逻辑库
travelrecord 逻辑表
<schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100">
		<!-- auto sharding by id (long) -->
		<table name="travelrecord" dataNode="dn1,dn2,dn3" rule="auto-sharding-long" />

dn1,dn2数据节点
localhost1数据库连接池

	<dataNode name="dn1" dataHost="localhost1" database="db1" />
	<dataNode name="dn2" dataHost="localhost1" database="db2" />
	<dataNode name="dn3" dataHost="localhost1" database="db3" />
	<!--<dataNode name="dn4" dataHost="sequoiadb1" database="SAMPLE" />
	 <dataNode name="jdbc_dn1" dataHost="jdbchost" database="db1" />
	<dataNode	name="jdbc_dn2" dataHost="jdbchost" database="db2" />
	<dataNode name="jdbc_dn3" 	dataHost="jdbchost" database="db3" /> -->
	<dataHost name="localhost1" maxCon="1000" minCon="10" balance="0"
			  writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThreshold="100">
		<heartbeat>select user()</heartbeat>
		<!-- can have multi write hosts -->
		<writeHost host="hostM1" url="localhost:3306" user="root"
				   password="Slave_1234">
			<!-- can have multi read hosts -->
			<readHost host="hostS2" url="192.168.1.101:3307" user="root" password="Root_1234" />
		</writeHost>
		<writeHost host="hostS1" url="localhost:3316" user="root"
				   password="123456" />
		<!-- <writeHost host="hostM2" url="localhost:3316" user="root" password="123456"/> -->
	</dataHost>


server.xml

schemas配置逻辑库  user用户
<user name="root" defaultAccount="true">
		<property name="password">123456</property>
		<property name="schemas">TESTDB</property>

		<!-- 表级 DML 权限设置 -->
		<!--
		<privileges check="false">
			<schema name="TESTDB" dml="0110" >
				<table name="tb01" dml="0000"></table>
				<table name="tb02" dml="1111"></table>
			</schema>
		</privileges>
		 -->
	</user>

	<user name="user">
		<property name="password">user</property>
		<property name="schemas">TESTDB</property>
		<property name="readOnly">true</property>
	</user>
