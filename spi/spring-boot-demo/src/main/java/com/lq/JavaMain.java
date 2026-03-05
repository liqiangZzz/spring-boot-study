package com.lq;

import com.lq.database.BaseData;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName JavaMain
 * @Description
 * @Author liqiang
 * @Date 2025/11/6 09:13
 */
public class JavaMain {

    public static void main(String[] args) {
        ServiceLoader<BaseData> providers = ServiceLoader.load(BaseData.class);

        for (BaseData baseData : providers) {
            baseData.baseURL();
        }
    }
}
