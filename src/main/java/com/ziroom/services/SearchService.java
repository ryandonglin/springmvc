package com.ziroom.services;

import com.ziroom.utils.ClientHelper;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.Map;


/**
 * Created by homelink on 2016/9/19.
 */
public class SearchService {

    public String searchWithContent(String content) {
        String result = "";

        ClientHelper ch = ClientHelper.getInstance();
        Client client = ch.getClient();

        QueryBuilder qb = QueryBuilders.termQuery("content", content);
        SearchResponse response = client.prepareSearch().setIndices("db").setTypes("report").setQuery(qb).execute().actionGet();

        long totalHits = response.getHits().getTotalHits();
        System.out.println(totalHits);

        String json = "{";

        for (int i = 0; i < response.getHits().getHits().length; i++) {

            Map<String, Object> entry = response.getHits().getAt(i).getSource();

            /*for (String key: entry.keySet()) {
                System.out.println(key + ":" + entry.get(key).toString());
            }
            System.out.println();*/

            json += "\"" + entry.get("report_id").toString() + "\" : \"" + entry.get("creation_date").toString() + "\"";

            if (i != response.getHits().getHits().length - 1) {
                json += ", ";
            }
        }

        json += "}";

        System.out.println(json);

        return json;
    }
}
