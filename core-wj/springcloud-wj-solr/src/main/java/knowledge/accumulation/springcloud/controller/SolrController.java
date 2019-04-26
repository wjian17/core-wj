package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.bean.InsuranceContract;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@EnableScheduling
public class SolrController {
    @Autowired
    private SolrClient client;

    /**
     * 新增/修改 索引
     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
     * @return
     */
    public String add() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id", uuid);
            doc.setField("username", "我是中国人, 我爱中国");
            /* 如果spring.data.solr.host 里面配置到 core了, 那么这里就不需要传 collection1 这个参数
             * 下面都是一样的
             */
            client.add("collection1", doc);
            //client.commit();
            client.commit("collection1");
            return uuid;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 根据id删除索引
     * @param id
     * @return
     */
    public String delete(String id)  {
        try {
            client.deleteById("collection1",id);
            client.commit("collection1");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 删除所有的索引
     * @return
     */
    public String deleteAll(){
        try {
            client.deleteByQuery("collection1","*:*");
            client.commit("collection1");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 根据id查询索引
     * @return
     * @throws Exception
     */
    public String getById() throws Exception {
        SolrDocument document = client.getById("collection1", "139");
        System.out.println(document);
        return document.toString();
    }

    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    public Map<String, Map<String, List<String>>> search(){

        try {
            SolrQuery params = new SolrQuery();

            //查询条件, 这里的 q 对应 下面图片标红的地方
            //params.set("q", "手机");

            //过滤条件
          //  params.set("fq", "product_price:[100 TO 100000]");

            //排序
            params.addSort("id", SolrQuery.ORDER.asc);

            //分页
            params.setStart(0);
            params.setRows(20);

            //默认域
           // params.set("df", "product_title");

            //只查询指定域
            params.set("fl", "id,username,name");

            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("username");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");

            QueryResponse queryResponse = client.query(params);

            SolrDocumentList results = queryResponse.getResults();

            long numFound = results.getNumFound();

            System.out.println(numFound);

            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();

            for (SolrDocument result : results) {
                System.out.println(result.get("id"));
                System.out.println(result.get("username"));
                //System.out.println(result.get("product_num"));
                System.out.println(result.get("name"));
                //System.out.println(result.get("product_image"));

                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("username");
                System.out.println(list.get(0));

                System.out.println("------------------");
                System.out.println();
            }
            return highlight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Scheduled(fixedDelay = 4000)
    public void test1() {

        ModifiableSolrParams params = new ModifiableSolrParams();
        params.add("q", "*:*");
        params.add("ws", "json");
        params.add("start", "0");
        params.add("rows", "10");

        QueryResponse response = null;

        try {
            response = client.query("new_core",params);
            SolrTemplate solrTemplate=null;
//            InsuranceContract insuranceContract = new InsuranceContract();
//            solrTemplate.saveBean("",insuranceContract);
//            client.add("",insuranceContract);
            Query query = new SimpleQuery("*:*");
            solrTemplate.queryForPage("new_core",query, InsuranceContract.class);
            SolrDocumentList results = response.getResults();
            for (SolrDocument document : results) {
                System.out.println(document.getFieldValue("policy_no"));
                System.out.println(document.getFieldValue("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getStackTrace();
        }
        System.out.println(response.toString());
    }

}
