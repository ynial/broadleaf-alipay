package org.broadleafcommerce.vendor.alipay.service.payment;

import org.broadleafcommerce.common.payment.PaymentGatewayType;

/**
 * Created by Mai on 2015/11/8.
 */
public class AliPayPaymentGatewayType  extends PaymentGatewayType {

    public static final PaymentGatewayType ALIPAY_PARTNER_TRADE = new PaymentGatewayType("Alipay_Partner_Trade","Alipay Partner Trade");

    public static final PaymentGatewayType ALIPAY_DIRECT_PAY = new PaymentGatewayType("Alipay_Direct_Pay", "Alipay Direct Trade");
}
