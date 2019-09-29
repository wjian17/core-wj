package knowledge.accumulation.springcloud.hystrix;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import knowledge.accumulation.springcloud.bean.validate.Pojo;
import knowledge.accumulation.springcloud.bean.validate.ValidateParam;
import knowledge.accumulation.springcloud.mapper.TestMapper;
import knowledge.accumulation.springcloud.utils.SpringBeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public void test() {
        testMapper = (TestMapper) SpringBeanFactoryUtils.getBean(TestMapper.class);
        PageHelper.startPage(2, 1);
        List<Integer> list = testMapper.getIdList();
        PageInfo<Integer> pageInfo = new PageInfo<Integer>(list);//封装结果集到PageInfo bean
        System.out.println(testMapper.selectTest());
    }

    /**
     * 校验实体类
     *
     * @param t
     * @return
     */
    public static <T> List<Map<String, String>> validate(T t) {
        //定义返回错误List
        List<Map<String, String>> errList = new ArrayList<Map<String, String>>();

        Map<String, String> errorMap;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> errorSet = validator.validate(t);

        for (ConstraintViolation<T> c : errorSet) {
            errorMap = new HashMap<>();
            errorMap.put("field", c.getPropertyPath().toString()); //获取发生错误的字典名称
            errorMap.put("msg", c.getMessage()); //获取校验信息
            errList.add(errorMap);
        }

        return errList;
    }
    public static void main(String[] args) {
        ValidateParam validateParam = new ValidateParam();
        validateParam.setId("10");
        validateParam.setEmail("sf");
        Pojo pojo = new Pojo();
        List<Pojo> pojoList = new ArrayList<>();
        pojoList.add(pojo);
        validateParam.setPojoList(pojoList);
        List<Map<String, String>> errorList = (List<Map<String, String>>)validate(validateParam);
        System.out.println("11");
    }
}
