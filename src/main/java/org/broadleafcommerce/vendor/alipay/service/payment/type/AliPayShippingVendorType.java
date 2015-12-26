package org.broadleafcommerce.vendor.alipay.service.payment.type;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mai on 2015/11/8.
 */
public class AliPayShippingVendorType implements Serializable, BroadleafEnumerationType {

    private static final long serialVersionUID = 1L;

    private static final Map<String, AliPayShippingVendorType> TYPES = new HashMap<String, AliPayShippingVendorType>();

    public static final AliPayShippingVendorType POST = new AliPayShippingVendorType("POST", "China Post");
    public static final AliPayShippingVendorType EXPRESS = new AliPayShippingVendorType("EXPRESS", "Express way mail");
    public static final AliPayShippingVendorType EMS = new AliPayShippingVendorType("EMS", "EMS");

    private String type;
    private String friendType;


    public AliPayShippingVendorType() {
    }


    public AliPayShippingVendorType(final String type, final String friendType) {
        this.friendType = friendType;
        setType(type);
    }

    public AliPayShippingVendorType getInstance(final String type) {
        return TYPES.get(type);
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
    public int hashCode(){
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        AliPayShippingVendorType other = (AliPayShippingVendorType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
}
