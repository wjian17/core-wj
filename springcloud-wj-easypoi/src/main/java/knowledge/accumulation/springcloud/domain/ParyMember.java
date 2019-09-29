package knowledge.accumulation.springcloud.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class ParyMember implements Serializable {

    @Excel(name="姓名",orderNum = "1")
    @NotNull(message = "name不为空")
    private String name;

    @Excel(name="idCard",orderNum = "2")
    @NotNull(message = "idCard不为空")
    private String idCard;

    @Excel(name="时间",orderNum = "3",format = "yyyy-MM-dd",isColumnHidden=true)
    @NotNull(message = "joinPartyTime不为空")
    private Date joinPartyTime;

    @Excel(name="type",orderNum = "4")
    @NotNull(message = "partyBranch不为空")
    private String partyBranch;

    @Excel(name="state",orderNum = "5",replace = {"type1_1","type2_2"},isImportField = "true")
    private Integer state;

}
