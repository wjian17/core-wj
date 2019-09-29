spring:
  jpa:
    properties:
      hibernate:
        format_sql: true
        show_sql: true


extends JpaRepository<StudentDO, Integer> {

}



public interface StudentBaseInfo {

    String getName();
    Integer getAge();

}



public interface StudentRepository extends JpaRepository<StudentDO, Integer> {

    /**
     * 根据姓名和年龄
     * @param name 姓名
     * @param age 年龄
     * @return
     */
    List<StudentDO> findByNameAndAge(String name, Integer age);

    /**
     * 根据年龄段查询【PS: 开区间】
     * @param start 最小值
     * @param end 最大值
     * @return
     */
    List<StudentDO> findByAgeBetween(Integer start, Integer end);

    /**
     * 小于给定年龄【PS: 开区间】
     * @param age 年龄
     * @return
     */
    List<StudentDO> findByAgeLessThan(Integer age);

    /**
     * 小于给定年龄【PS: 闭区间】
     * @param age 年龄
     * @return
     */
    List<StudentDO> findByAgeLessThanEqual(Integer age);

    List<StudentDO> findByAgeGreaterThan(Integer age);

    List<StudentDO> findByAgeGreaterThanEqual(Integer age);

    List<StudentDO> findByName(String name);

    List<StudentDO> findByNameEquals(String name);

    List<StudentDO> findByNameIs(String name);

    List<StudentDO> findByAgeAfter(Integer age);

    List<StudentDO> findByAgeBefore(Integer age);

    List<StudentDO> findByAgeAfterOrAgeEquals(Integer age, Integer age2);

//    List<StudentDO> findByAddress(String address);

    List<StudentBaseInfo> findByAddress(String address);

}