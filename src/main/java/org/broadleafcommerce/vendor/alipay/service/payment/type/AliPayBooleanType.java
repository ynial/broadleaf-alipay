package org.broadleafcommerce.vendor.alipay.service.payment.type;

/**
 * Created by Mai on 2015/11/16.
 */
public class AliPayBooleanType {

    public static boolean getBoolean(final String bool) {
            if (bool.toUpperCase().equals("T")) {
                return true;
            }
            return false;
    }
}
