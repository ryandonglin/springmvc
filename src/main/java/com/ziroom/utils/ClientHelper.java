package com.ziroom.utils;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by homelink on 2016/9/20.
 */
public class ClientHelper {

    private Settings settings;
    private Map<String, Client> clientMap = new ConcurrentHashMap<String, Client>();
    private Map<String, Integer> ips = new HashMap<String, Integer>();

    private String clusterName = "test";

    private ClientHelper() {
        init();
        // TO-DO
    }

    public static final ClientHelper getInstance() {
        return ClientHolder.INSTANCE;
    }

    private static class ClientHolder {
        private static final ClientHelper INSTANCE = new ClientHelper();
    }

    /**
     * 初始化默认的client
     */
    public void init() {
        ips.put("localhost", 9300);
        settings = Settings
                .settingsBuilder()
                .put("client.transport.sniff",true)
                .put("cluster.name","test").build();
        addClient(settings, getAllAddress(ips));
    }

    /**
     * 初始化默认的client
     */
    public List<InetSocketTransportAddress> getAllAddress(Map<String, Integer> ips) {

        List<InetSocketTransportAddress> addressList = new ArrayList();

        try {
            for (String ip : ips.keySet()) {
                addressList.add(new InetSocketTransportAddress(InetAddress.getByName(ip), ips.get(ip)));
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

        return addressList;
    }

    public Client getClient() {
        return getClient(clusterName);
    }

    public Client getClient(String clusterName) {
        return clientMap.get(clusterName);
    }

    public void addClient(Settings setting, List<InetSocketTransportAddress> transportAddress) {
        Client client = TransportClient.builder().settings(setting).build().addTransportAddresses(transportAddress.toArray(new InetSocketTransportAddress[transportAddress.size()]));
        clientMap.put(setting.get("cluster.name"), client);
    }

}
