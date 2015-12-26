package org.broadleafcommerce.vendor.alipay.service.payment.type;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mai on 2015/11/16.
 */
public class AliPaySignatureType implements Serializable, BroadleafEnumerationType {

    private static final long serialVersionUID = 1L;

    private static final Map<String, AliPaySignatureType> TYPES = new HashMap<String, AliPaySignatureType>();

    public static final AliPaySignatureType MD5 = new AliPaySignatureType("MD5","MD5");
    public static final AliPaySignatureType DSA = new AliPaySignatureType("DSA","DSA");
    public static final AliPaySignatureType RSA = new AliPaySignatureType("RSA","RSA");


    private String type;
    private String friendType;

    public AliPaySignatureType() {}

    public AliPaySignatureType(final String type, final String friendType) {
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        AliPaySignatureType other = (AliPaySignatureType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

}
