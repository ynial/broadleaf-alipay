package org.broadleafcommerce.vendor.alipay.Utils;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Mai on 2015/12/6.
 */
public class AliPayQueryPairsMap implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String,String> queryMap = new HashMap<String, String>();

    public void add(String key, String value) {
            queryMap.put(key,value);
    }

    public String getValue(String key) {
        return queryMap.get(key);
    }

    public String buildQueryString() {
        List<String> keys = new ArrayList<String>(queryMap.keySet());
        Collections.sort(keys);

        String queryString = "";

        for (int i = 0; i < keys.size() ; i++) {
            String key = keys.get(i);
            String value = queryMap.get(key);

            if (i == keys.size() -1 ) {
                queryString = queryString + key + "=" + value;
            } else {
                queryString = queryString + key + "=" + value + "&";
            }
        }

        return queryString;
    }


}
