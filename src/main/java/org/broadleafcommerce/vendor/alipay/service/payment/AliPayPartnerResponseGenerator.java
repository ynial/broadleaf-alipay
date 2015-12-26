package org.broadleafcommerce.vendor.alipay.service.payment;

import org.broadleafcommerce.vendor.paypal.service.payment.message.AliPayRequest;
import org.broadleafcommerce.vendor.paypal.service.payment.message.AliPayResponse;

/**
 * Created by Mai on 2015/11/16.
 */
public interface AliPayPartnerResponseGenerator {

    public AliPayResponse buildResponse(String response, AliPayRequest paymentRequest);
}
