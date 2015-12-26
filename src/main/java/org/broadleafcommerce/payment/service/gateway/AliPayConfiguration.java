package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;

/**
 * Created by Mai on 2015/11/10.
 */
public interface AliPayConfiguration extends PaymentGatewayConfiguration {


    public String getServerUrl();

    public String getPartnerId();

    public String getSellerEmail();

    public String getAliPayKey();

    public String getInputCharset();

    public String getSignType();

    public String getNotifyUrl();

    public String getReturnUrl();

    // this default address is used to partner trade without actual address.

    public String getBuyerName();

    public String getShippingAddress();

    public String getShippingMobile();

}
