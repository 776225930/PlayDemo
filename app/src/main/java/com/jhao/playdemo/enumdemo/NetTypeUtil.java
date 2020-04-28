package com.jhao.playdemo.enumdemo;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author JiangHao
 * @date 2020/4/3
 * @describe
 */
public class NetTypeUtil {

    public static final int STRING_4G = 0;
    public static final int STRING_3G = 1;
    public static final int STRING_2G = 2;
    public static final int STRING_WIFI = 3;
    public static final int STRING_UNKNOW = 4;

    /**
     * SOURCE 告诉编辑器在生存.class文件时不保留枚举注解数据，
     * CLASS 告诉编辑器在生成.class文件时保留注解数据，但在vm运行时不保留；
     * RUNTIME 告诉编辑器生成.class文件时保留注解数据，vm运行时一直存在
     */
    @IntDef({STRING_2G, STRING_3G, STRING_4G, STRING_WIFI, STRING_UNKNOW})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetWorkStatus {
    }

    public static String getNetWorkString(@NetWorkStatus int type) {
        if (type == STRING_4G) {
            return "NETWORK_4G";
        } else if (type == STRING_3G) {
            return "NETWORK_3G";
        } else if (type == STRING_2G) {
            return "NETWORK_2G";
        } else if (type == STRING_WIFI) {
            return "NETWORK_wifi";
        } else {
            return "unknown";
        }
    }
}
