package org.broadleafcommerce.vendor.alipay.service.payment.type;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mai on 2015/11/9.
 */
public class AliPayRefundStatusType implements Serializable, BroadleafEnumerationType {

    public static final long serialVersionUID = 1L;

    public static Map<String, AliPayRefundStatusType> TYPES = new HashMap<String, AliPayRefundStatusType>();

    public static final AliPayRefundStatusType WAIL_SELLER_AGREE = new AliPayRefundStatusType("WAIL_SELLER_AGREE", "Waiting seller to confirm refund");

    public static final AliPayRefundStatusType SELLER_REFUSE_BUYER = new AliPayRefundStatusType("SELLER_REFUSE_BUYER", "Seller refuse buyer suggestion");

    public static final AliPayRefundStatusType WAIT_BUYER_RETURN_GOODS = new AliPayRefundStatusType("WAIT_BUYER_RETURN_GOODS", "Seller waiting buyer return the goods");

    public static final AliPayRefundStatusType WAIT_SELLER_CONFIRM_GOODS = new AliPayRefundStatusType("WAIT_SELLER_CONFIRM_GOODS", "Seller Waiting collect goods");

    public static final AliPayRefundStatusType  REFUND_SUCCESS = new AliPayRefundStatusType("REFUND_SUCCESS", "Refund sucessfully");

    public static final AliPayRefundStatusType REFUND_CLOSED = new AliPayRefundStatusType("REFUND_CLOSED", "Refund closed");

    private String type;
    private String friendType;

    public AliPayRefundStatusType(){}

    public AliPayRefundStatusType(final String type, final String friendType){
        this.friendType = friendType;
        setType(type);
    }

    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type,this);
        }
    }

    public AliPayRefundStatusType getInstance(final String type) {
        return TYPES.get(type);
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
        AliPayRefundStatusType other = (AliPayRefundStatusType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
}
