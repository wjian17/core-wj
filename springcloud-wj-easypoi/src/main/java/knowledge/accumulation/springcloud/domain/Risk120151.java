package knowledge.accumulation.springcloud.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class Risk120151 implements Serializable {

    @Excel(name="年龄",orderNum = "1")
    private Integer age;

    @Excel(name="3年交",orderNum = "2")
    private Double year_3;

    @Excel(name="4年交",orderNum = "3")
    private Double year_4;

    @Excel(name="8年交",orderNum = "4")
    private Double year_8;

    @Excel(name="9年交",orderNum = "5")
    private Double year_9;

    @Excel(name="13年交",orderNum = "6")
    private Double year_13;

    @Excel(name="14年交",orderNum = "7")
    private Double year_14;

    @Excel(name="18年交",orderNum = "8")
    private Double year_18;

    @Excel(name="19年交",orderNum = "9")
    private Double year_19;

    @Excel(name="28年交",orderNum = "10")
    private Double year_28;

    @Excel(name="29年交",orderNum = "19")
    private Double year_29;
}
