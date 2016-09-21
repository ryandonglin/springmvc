package com.ziroom.utils;

/**
 * Created by homelink on 2016/9/20.
 */
public class Setting {
    private static String ips;
    private static String ports;
    private static String indices;
    private static String type;
    private static String[] fields;

    public static String getIndices() {
        return indices;
    }

    public static void setIndices(String indices) {
        Setting.indices = indices;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Setting.type = type;
    }

    public static String[] getFields() {
        return fields;
    }

    public static void setFields(String[] fields) {
        Setting.fields = fields;
    }

    public static String getIps() {

        return ips;
    }

    public static void setIps(String ips) {
        Setting.ips = ips;
    }
}
