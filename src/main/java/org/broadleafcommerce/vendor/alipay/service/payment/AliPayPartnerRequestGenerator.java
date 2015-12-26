package org.broadleafcommerce.vendor.alipay.service.payment;

import org.apache.commons.httpclient.NameValuePair;
import org.broadleafcommerce.vendor.paypal.service.payment.message.AliPayRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by Mai on 2015/11/11.
 */
public interface AliPayPartnerRequestGenerator {

//    List<NameValuePair> buildRequest(AliPayRequest paymentRequst);
    String buildRequest(AliPayRequest paymentRequst);



}
