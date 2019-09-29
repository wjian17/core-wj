tomcat 部署solr
https://www.cnblogs.com/chenpi/p/6047909.html#_label4


managed-schema 添加
<requestHandler name="/dataimport" class="org.apache.solr.handler.dataimport.DataImportHandler">
        <lst name="defaults">
            <str name="config">data-config.xml</str>
        </lst>
</requestHandler>


data-config.xml
<dataConfig>
<dataSource name="solrdemo" type="JdbcDataSource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://192.168.229.1:3306/solrdemo" user="root" password="root"/>
  <document>
    <entity dataSource="solrdemo"
            name="user"
            query="select id, name, address from user where valid=1 "
            deltaImportQuery="select  id,name,address  from user where ID='${dataimporter.delta.id}'"
            deltaQuery="select id  from user where updatetime > '${dataimporter.last_index_time}'"
            deletedPkQuery="select id  from user where valid=0">
        <field  column="id"  name="id"/>
        <field  column="name"  name="name"/>
        <field  column="address"  name="address"/>
     </entity>
  </document>
</dataConfig>