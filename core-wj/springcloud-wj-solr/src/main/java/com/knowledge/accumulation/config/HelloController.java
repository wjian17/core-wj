package com.knowledge.accumulation.config;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Map;

public class HelloController {

    @Autowired
    private CloudSolrClient client;

    @Scheduled(fixedDelay = 4000)
    public void test1() {

        ModifiableSolrParams params = new ModifiableSolrParams();
        params.add("q", "*:*");
        params.add("ws", "json");
        params.add("start", "0");
        params.add("rows", "10");
        QueryResponse response = null;

        try {
            response = client.query(params);
            SolrDocumentList results = response.getResults();
            for (SolrDocument document : results) {
                System.out.println(document.getFieldValue("policy_no"));
                System.out.println(document.getFieldValue("id"));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println(response.toString());
    }

    @Scheduled(fixedDelay = 4000)
    public Map test() {
        try {
            SolrQuery params = new SolrQuery();
            //查询条件, 这里的 q 对应 下面图片标红的地方
            params.set("q", "手机");
            //过滤条件
            params.set("fq", "id:[1 TO 100000]");
            //排序
            params.addSort("product_price", SolrQuery.ORDER.asc);
            //分页
            params.setStart(0);
            params.setRows(20);
            //默认域
            params.set("df", "plan_no");
            //只查询指定域
//            params.set("fl", "id,product_title,product_price");
            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("plan_no");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");
//            ModifiableSolrParams params1 = new ModifiableSolrParams();
//            client.query(params1)
            QueryResponse queryResponse = client.query(params);
            SolrDocumentList results = queryResponse.getResults();
            long numFound = results.getNumFound();
            System.out.println(numFound);
            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            for (SolrDocument result : results) {

                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("plan_no");
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
}
