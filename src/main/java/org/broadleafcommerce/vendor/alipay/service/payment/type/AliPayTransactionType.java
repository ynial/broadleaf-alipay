package org.broadleafcommerce.vendor.alipay.service.payment.type;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mai on 2015/11/18.
 */
public class AliPayTransactionType implements Serializable, BroadleafEnumerationType {

    private static final long serialVersionUID = 1L;

    private static final Map<String, AliPayTransactionType> TYPES = new HashMap<String, AliPayTransactionType>();

    public static final AliPayTransactionType AUTHORIZE  = new AliPayTransactionType("AUTHORIZE","Authorize");
    public static final AliPayTransactionType CAPTURE = new AliPayTransactionType("CAPTURE","Capture");
    public static final AliPayTransactionType AUTHORIZEANDCAPTURE = new AliPayTransactionType("AUTHORIZEANDCAPTURE","Authorize and Capture");

    private String type;
    private String friendType;

    public AliPayTransactionType(){}

    public AliPayTransactionType(final String type, final String friendType) {
        this.friendType = friendType;
        setType(type);
    }

    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type,this);
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getFriendlyType() {
        return friendType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AliPayTransactionType other = (AliPayTransactionType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }


}
