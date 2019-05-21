package knowledge.accumulation.springcloud.bean.validate;
import lombok.Data;
import javax.validation.constraints.NotNull;
@Data
public class Pojo {

    @NotNull
    private String phone;
}
