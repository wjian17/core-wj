package knowledge.accumulation.springcloud.bean.validate;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class ValidateParam {

    @NotNull
    private String id;

    @Email
    private String email;

    private Date date;

//    @Pattern(regex=,flag=)
//    private String reg;

    @Valid
    @NotNull
    private List<Pojo> pojoList;
}