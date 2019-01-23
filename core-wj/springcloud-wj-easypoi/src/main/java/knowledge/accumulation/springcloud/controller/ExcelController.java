package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.domain.ParyMember;
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
}
