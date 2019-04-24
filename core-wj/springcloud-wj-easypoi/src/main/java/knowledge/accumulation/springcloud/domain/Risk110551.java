package knowledge.accumulation.springcloud.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Risk110551 implements Serializable {

    @Excel(name = "age", orderNum = "1")
    private Integer age;

    @Excel(name = "year_20_5", orderNum = "2")
    private Double year_20_5;

    @Excel(name = "year_20_10", orderNum = "3")
    private Double year_20_10;

    @Excel(name = "year_25_5", orderNum = "4")
    private Double year_25_5;

    @Excel(name = "year_25_10", orderNum = "5")
    private Double year_25_10;

    @Excel(name = "year_25_15", orderNum = "6")
    private Double year_25_15;

    @Excel(name = "year_30_5", orderNum = "7")
    private Double year_30_5;

    @Excel(name = "year_30_10", orderNum = "8")
    private Double year_30_10;

    @Excel(name = "year_30_15", orderNum = "9")
    private Double year_30_15;

    @Excel(name = "year_30_20", orderNum = "10")
    private Double year_30_20;

    public static void main(String[] args) {
        BigDecimal bdTest = new BigDecimal(1.745);
        BigDecimal bdTest1 = new BigDecimal(0.745);
        BigDecimal bdTest2 = BigDecimal.valueOf(1.745);
        BigDecimal bdTest3 = BigDecimal.valueOf(0.745);

        bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
        bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("bdTest:" + bdTest); // 1.75
        System.out.println("bdTest1:" + bdTest1); // 0.74
//
//        String filePath = "C:\\Users\\wjian\\Desktop\\1.xlsx";
//        List<Risk110551> lists = EasypoiUtils.importExcel(filePath, 1, 1, Risk110551.class);
//        String sql = "INSERT INTO `insurance_plan_critical_illness` (\n" +
//                "  `plan_no`,\n" +
//                "  `ins_risk_code`,\n" +
//                "  `age`,\n" +
//                "  `max_age`,\n" +
//                "  `sex`,\n" +
//                "  `extend_json`\n" +
//                ") \n" +
//                "VALUES \n";
//        String values = "";
//        for (Risk110551 risk110551 : lists) {
//            values = values + "('110554','110554','" + risk110551.getAge() + "','1','0','" +
//                    "[(\"payYears\":5,\"ensure\":20,\"rate\":" + new BigDecimal(risk110551.getYear_20_5()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":10,\"ensure\":20,\"rate\":" + new BigDecimal(risk110551.getYear_20_10()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":5,\"ensure\":25,\"rate\":" + new BigDecimal(risk110551.getYear_25_5()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":10,\"ensure\":25,\"rate\":" + new BigDecimal(risk110551.getYear_25_10()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":15,\"ensure\":25,\"rate\":" + new BigDecimal(risk110551.getYear_25_15()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":5,\"ensure\":30,\"rate\":" + new BigDecimal(risk110551.getYear_30_5()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":10,\"ensure\":30,\"rate\":" + new BigDecimal(risk110551.getYear_30_10()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":15,\"ensure\":30,\"rate\":" + new BigDecimal(risk110551.getYear_30_15()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
//                    "[(\"payYears\":20,\"ensure\":30,\"rate\":" + new BigDecimal(risk110551.getYear_30_20()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")]";
//
//            values = values + "'),\n";
//        }
//        sql = sql + values;
//        System.out.println(sql);
    }

}
