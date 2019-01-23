package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.service.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log,Integer> {

    List<Log> findByName(String name);
//
//    @Query("from log where name =?")
//    List<Log> queryByNameUseHQL(String name);
//
//    @Query(value = "select * from log where name = ?",nativeQuery=true)
//    List<Log> queryByNameUseSQL(String name);
//
//    @Query(value = "update log set name = ? where id = ?")
//    @Modifying//表示需要执行更新操作：需要添加事务才会生效，否则报错
//    int updateLogNameById(String name,Integer id);
//
//    JpaSpecificationExecutor
}
