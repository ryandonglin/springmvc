package com.ziroom.utils;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.util.logging.Logger;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by homelink on 2016/9/19.
 */
public class ElasticSearchFactory {

    private static Client client;
    private String ips;
    private String clusternName;

    private static List<Map> servers=new ArrayList();

    static{
        Settings settings= Settings.settingsBuilder()
                .put("cluster.name","test")
                .put("client.transport.sniff",true).build();
        String lstIp="localhost";
        String lstPort="9300";
        String[] arrayIp=lstIp.split(",");
        String[] arrayPort=lstPort.split(",");
        InetSocketTransportAddress[] inetSocketTransportAddresses=new InetSocketTransportAddress[arrayIp.length];
//        for(int i=0;i<inetSocketTransportAddresses.length;i++){
//            inetSocketTransportAddresses[i]=new InetSocketTransportAddress(arrayIp[i],Integer.parseInt(arrayPort[i]));
//        }
//        client = TransportClient.builder().settings(settings).addTransportAddresses(inetSocketTransportAddresses);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        ElasticSearchFactory.client = client;
    }
}
