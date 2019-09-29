package knowledge.accumulation.springcloud.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.IOException;

//@Configuration
//@EnableConfigurationProperties(SolrConfig.class)
public class SolrClientConfig {
    @Autowired
    private SolrConfig solrConfig;

    @Resource
    private SolrClient solrClient;

    @PreDestroy
    public void close() {
        if (this.solrClient != null) {
            try {
                this.solrClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
