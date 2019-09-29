package knowledge.accumulation.springcloud.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import knowledge.accumulation.springcloud.utils.EasypoiUtils;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Risk110551_F implements Serializable {

    @Excel(name = "age", orderNum = "1")
    private Integer age;

    @Excel(name = "year_70_5", orderNum = "2")
    private Double year_70_5;

    @Excel(name = "year_70_10", orderNum = "3")
    private Double year_70_10;

    @Excel(name = "year_70_15", orderNum = "4")
    private Double year_70_15;

    @Excel(name = "year_70_20", orderNum = "5")
    private Double year_70_20;

    @Excel(name = "year_70_30", orderNum = "6")
    private Double year_70_30;

    @Excel(name = "year_80_5", orderNum = "7")
    private Double year_80_5;

    @Excel(name = "year_80_10", orderNum = "8")
    private Double year_80_10;

    @Excel(name = "year_80_15", orderNum = "9")
    private Double year_80_15;

    @Excel(name = "year_80_20", orderNum = "10")
    private Double year_80_20;

    @Excel(name = "year_80_30", orderNum = "11")
    private Double year_80_30;

    @Excel(name = "year_999_5", orderNum = "12")
    private Double year_999_5;

    @Excel(name = "year_999_10", orderNum = "13")
    private Double year_999_10;

    @Excel(name = "year_999_15", orderNum = "14")
    private Double year_999_15;

    @Excel(name = "year_999_20", orderNum = "15")
    private Double year_999_20;

    @Excel(name = "year_999_30", orderNum = "16")
    private Double year_999_30;


    public static void main(String[] args) {
        String filePath = "C:\\Users\\wjian\\Desktop\\1.xlsx";
        List<Risk110551_F> lists = EasypoiUtils.importExcel(filePath, 1, 1, Risk110551_F.class);
        String sql = "INSERT INTO `insurance_plan_critical_illness` (\n" +
                "  `plan_no`,\n" +
                "  `ins_risk_code`,\n" +
                "  `age`,\n" +
                "  `max_age`,\n" +
                "  `sex`,\n" +
                "  `extend_json`\n" +
                ") \n" +
                "VALUES \n";
        String values = "";
        for (Risk110551_F risk110551 : lists) {
            values = values + "('110554','110554','" + risk110551.getAge() + "','999','0','" +
                    "[(\"payYears\":5,\"ensureTo\":70,\"rate\":" + new BigDecimal(risk110551.getYear_70_5()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":10,\"ensureTo\":70,\"rate\":" + new BigDecimal(risk110551.getYear_70_10()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":15,\"ensureTo\":70,\"rate\":" + new BigDecimal(risk110551.getYear_70_15()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":20,\"ensureTo\":70,\"rate\":" + new BigDecimal(risk110551.getYear_70_20()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":30,\"ensureTo\":70,\"rate\":" + new BigDecimal(risk110551.getYear_70_30()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":5,\"ensureTo\":80,\"rate\":" + new BigDecimal(risk110551.getYear_80_5()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":10,\"ensureTo\":80,\"rate\":" + new BigDecimal(risk110551.getYear_80_10()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":15,\"ensureTo\":80,\"rate\":" + new BigDecimal(risk110551.getYear_80_15()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":20,\"ensureTo\":80,\"rate\":" + new BigDecimal(risk110551.getYear_80_20()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":30,\"ensureTo\":80,\"rate\":" + new BigDecimal(risk110551.getYear_80_30()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":5,\"ensureTo\":999,\"rate\":" + new BigDecimal(risk110551.getYear_999_5()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":10,\"ensureTo\":999,\"rate\":" + new BigDecimal(risk110551.getYear_999_10()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":15,\"ensureTo\":999,\"rate\":" + new BigDecimal(risk110551.getYear_999_15()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":20,\"ensureTo\":999,\"rate\":" + new BigDecimal(risk110551.getYear_999_20()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")," +
                    "[(\"payYears\":30,\"ensureTo\":999,\"rate\":" + new BigDecimal(risk110551.getYear_999_30()).divide(new BigDecimal(1000), 5, BigDecimal.ROUND_HALF_UP) + ")]";

            values = values + "'),\n";
        }
        sql = sql + values;
        System.out.println(sql);
    }

}
