package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.domain.ParyMember;
import knowledge.accumulation.springcloud.domain.Risk110551;
import knowledge.accumulation.springcloud.domain.Risk110551_F;
import knowledge.accumulation.springcloud.domain.Risk120151;
import knowledge.accumulation.springcloud.utils.EasypoiUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ExcelController {

    @RequestMapping("/test")
    public void downLoad(HttpServletResponse response){

        String filePath1 = "C:\\Users\\wjian\\Desktop\\4.xls";
        List<ParyMember> list = new ArrayList<>();
        ParyMember paryMember1 = new ParyMember();
        paryMember1.setName("nn");
        paryMember1.setPartyBranch("partbranch");
        paryMember1.setState(1);
        paryMember1.setName("=CHOOSE(1,Sheet1!A1,2222,3333,4444)");
        paryMember1.setJoinPartyTime(new Date());
        list.add(paryMember1);
        EasypoiUtils.exportExcel(list,"title","sheetName", ParyMember.class,"excel汉.xls",response);
    }
    @RequestMapping("/test1")
    public void downLoad1(HttpServletResponse response){

        List<Risk120151> list2 = new ArrayList<>();
        Risk120151 risk120151 = new Risk120151();
        risk120151.setAge(1);
        String filePath = "C:\\Users\\wjian\\Desktop\\2.xlsx";
        list2.add(risk120151);
        EasypoiUtils.exportExcel(list2,"1","sheet2",Risk120151.class,filePath,response);
        System.out.println("test");
    }
    @RequestMapping("/test2")
    public void downLoad2(HttpServletResponse response){

        List<Risk110551> list2 = new ArrayList<>();
        Risk110551 risk110551 = new Risk110551();
        risk110551.setAge(1);
        risk110551.setYear_20_5(5.0);
        String filePath = "C:\\Users\\wjian\\Desktop\\2.xlsx";
        list2.add(risk110551);
        EasypoiUtils.exportExcel(list2,"1","sheet2",Risk110551.class,filePath,response);
        System.out.println("test");
    }
    @RequestMapping("/test3")
    public void downLoad3(HttpServletResponse response){

        List<Risk110551_F> list2 = new ArrayList<>();
        Risk110551_F risk110551_F = new Risk110551_F();
        risk110551_F.setAge(1);
        risk110551_F.setYear_70_5(5.0);
        String filePath = "C:\\Users\\wjian\\Desktop\\2.xlsx";
        list2.add(risk110551_F);
        EasypoiUtils.exportExcel(list2,"1","sheet2",Risk110551_F.class,filePath,response);
        System.out.println("test");
    }
}
