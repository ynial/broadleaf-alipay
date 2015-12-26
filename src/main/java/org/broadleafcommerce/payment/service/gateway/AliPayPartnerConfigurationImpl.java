package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.util.BLCSystemProperty;
import org.springframework.stereotype.Service;

/**
 * Created by Mai on 2015/11/10.
 */
@Service("blAliPayPartnerConfiguration")
public class AliPayPartnerConfigurationImpl implements AliPayConfiguration {

    protected int failureReportingThreshold = 1;


    @Override
    public String getServerUrl() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.serverUrl");
    }

    @Override
    public String getPartnerId() {
        return  BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.partnerId");
    }

    @Override
    public String getSellerEmail() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.sellerEmail");
    }

    @Override
    public String getAliPayKey() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.alipayKey");
    }

    @Override
    public String getInputCharset() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.inputCharet");
    }

    @Override
    public String getSignType() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.signType");
    }

    @Override
    public String getNotifyUrl() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.notifyUrl");
    }

    @Override
    public String getReturnUrl() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.returnUrl");
    }

    @Override
    public String getBuyerName() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.defaultBuyerName");
    }

    @Override
    public String getShippingAddress() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.defaultShippingAddress");
    }

    @Override
    public String getShippingMobile() {
        return BLCSystemProperty.resolveSystemProperty("gateway.alipay.partnerTrade.defaultShippingMobile");
    }

    @Override
    public boolean isPerformAuthorizeAndCapture() {

        return false;
    }

    @Override
    public void setPerformAuthorizeAndCapture(boolean b) {

    }

    @Override
    public int getFailureReportingThreshold() {
        return failureReportingThreshold;
    }

    @Override
    public void setFailureReportingThreshold(int failureReportingThreshold) {
        this.failureReportingThreshold = failureReportingThreshold;
    }

    @Override
    public boolean handlesAuthorize() {
        return false;
    }

    @Override
    public boolean handlesCapture() {
        return false;
    }

    @Override
    public boolean handlesAuthorizeAndCapture() {
        return false;
    }

    @Override
    public boolean handlesReverseAuthorize() {
        return false;
    }

    @Override
    public boolean handlesVoid() {
        return false;
    }

    @Override
    public boolean handlesRefund() {
        return false;
    }

    @Override
    public boolean handlesPartialCapture() {
        return false;
    }

    @Override
    public boolean handlesMultipleShipment() {
        return false;
    }

    @Override
    public boolean handlesRecurringPayment() {
        return false;
    }

    @Override
    public boolean handlesSavedCustomerPayment() {
        return false;
    }

    @Override
    public boolean handlesMultiplePayments() {
        return false;
    }

    @Override
    public PaymentGatewayType getGatewayType() {
        return null;
    }


}
