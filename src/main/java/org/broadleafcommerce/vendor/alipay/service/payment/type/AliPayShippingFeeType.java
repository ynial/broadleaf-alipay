package org.broadleafcommerce.vendor.alipay.service.payment.type;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mai on 2015/11/8.
 */
public class AliPayShippingFeeType implements Serializable, BroadleafEnumerationType{

    public static final Long serialVersionID = 1L;

    public static final Map<String, AliPayShippingFeeType> types = new HashMap<String, AliPayShippingFeeType>();

    public static final AliPayShippingFeeType BUYER_PAY = new AliPayShippingFeeType("BUYER_PAY", "Buyer pay shipping fee");

    public static final AliPayShippingFeeType SELLER_PAY = new AliPayShippingFeeType("SELLER_PAY", "Seller pay shipping fee");

    public static final AliPayShippingFeeType BUYER_PAY_AFTER_RECEIVE = new AliPayShippingFeeType("BUYER_PAY_AFTER_RECEIVE", "Buyer pay shipping fee after receive goods");

    private String type;

    private String friendType;

    public AliPayShippingFeeType() {
    }

    public AliPayShippingFeeType(final String type, final String friendType) {
        this.friendType = friendType;
        setType(type);
    }

    public AliPayShippingFeeType getInstance(final String type) {
        return types.get(type);
    }

    private void setType(final String type) {
        this.type = type;
        if (!types.containsKey(type)) {
            types.put(type, this);
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

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        AliPayShippingFeeType other = (AliPayShippingFeeType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

}
