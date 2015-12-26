package org.broadleafcommerce.vendor.alipay.service.payment.type;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mai on 2015/11/9.
 */
public class AliPayPaymentStatusType implements Serializable, BroadleafEnumerationType {

    private static final long serialVersionUID = 1L;

    private static final Map<String, AliPayPaymentStatusType> TYPES = new HashMap<String, AliPayPaymentStatusType>();

    public static final AliPayPaymentStatusType WAIT_BUYER_PAY = new AliPayPaymentStatusType("WAIT_BUYER_PAY", "Waiting buyer to pay");

    public static final AliPayPaymentStatusType WAIT_SELLER_SEND_GOODS = new AliPayPaymentStatusType("WAIT_SELLER_SEND_GOODS", "Waiting seller to send goods");

    public static final AliPayPaymentStatusType WAIT_BUYER_CONFIRM_GOODS = new AliPayPaymentStatusType("WAITING_BUYER_CONFIRM_GOODS", "Waiting the buyer confirm good was received");

    public static final AliPayPaymentStatusType TRADE_FINISHED = new AliPayPaymentStatusType("TRADE_FINISHED", "The trade is finished");

    public static final AliPayPaymentStatusType TRADE_CLOSED = new AliPayPaymentStatusType("TRADE_CLOSED", "The trade is closed");

    private String type;

    private String friendType;

    public AliPayPaymentStatusType(){}

    public AliPayPaymentStatusType(final String type, final String friendType) {
        this.friendType = friendType;
        setType(type);
    }

    public  AliPayPaymentStatusType getInstance(final String type) {
        return TYPES.get(type);
    }


    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type, this);
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
        AliPayPaymentStatusType other = (AliPayPaymentStatusType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

}
