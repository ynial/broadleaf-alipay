package org.broadleafcommerce.vendor.alipay.service.payment;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.broadleafcommerce.payment.service.gateway.AliPayConfiguration;
import org.broadleafcommerce.vendor.alipay.Utils.AliPayQueryPairsMap;
import org.broadleafcommerce.vendor.alipay.Utils.Md5SignUtil;
import org.broadleafcommerce.vendor.alipay.service.payment.type.AliPayTransactionType;
import org.broadleafcommerce.vendor.paypal.service.payment.message.AliPayRequest;
import org.broadleafcommerce.vendor.paypal.service.payment.message.payment.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mai on 2015/11/16.
 */

@Service(value = "blAliPayPartnerRequestGenerator")
public class AliPayPartnerRequestGeneratorImpl implements AliPayPartnerRequestGenerator {


    private static final Logger logger = LoggerFactory.getLogger(AliPayPartnerRequestGeneratorImpl.class);


    @Resource(name = "blAliPayPartnerConfiguration")
    AliPayConfiguration configuration;

//    protected void setBaseNvps(ArrayList<NameValuePair> nvps) {
//        nvps.add(new NameValuePair(AliPayMessageConstants.SERVICE, AliPayMessageConstants.PARTNERTRADE_SERVICE));
//        nvps.add(new NameValuePair(AliPayMessageConstants.PARTNER,configuration.getPartnerId()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.INPUT_CHARSET,configuration.getInputCharset()));
////        nvps.add(new NameValuePair(AliPayMessageConstants.SIGN_TYPE,configuration.getSignType()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.RETURN_URL,configuration.returnUrl()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.NOTIFY_URL,configuration.notifyUrl()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.SELLER_EMAIL,configuration.getSellerEmail()));
//    }

    protected void setBaseMaps(AliPayQueryPairsMap maps) {
        maps.add(AliPayMessageConstants.SERVICE, AliPayMessageConstants.PARTNERTRADE_SERVICE);
        maps.add(AliPayMessageConstants.PARTNER,configuration.getPartnerId());
        maps.add(AliPayMessageConstants.INPUT_CHARSET, configuration.getInputCharset());
        maps.add(AliPayMessageConstants.RETURN_URL, configuration.getReturnUrl());
        maps.add(AliPayMessageConstants.NOTIFY_URL, configuration.getNotifyUrl());
        maps.add(AliPayMessageConstants.SELLER_EMAIL, configuration.getSellerEmail());
    }



//    protected void setNvpsForCheckoutOrAuth(List<NameValuePair> nvps, AliPayPaymentRequest payPaymentRequest) {
//        nvps.add(new NameValuePair(AliPayMessageConstants.OUT_TRADE_NO, payPaymentRequest.getOrderId()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.GOODS_SUBJECT, payPaymentRequest.getItemRequest().getShortDescription()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.PAYMENT_TPYE, "1"));
//    }

    protected void setMapsForCheckOutOrAuth(AliPayQueryPairsMap maps, AliPayPaymentRequest paymentRequest) {
        maps.add(AliPayMessageConstants.OUT_TRADE_NO, paymentRequest.getOrderId());
        maps.add(AliPayMessageConstants.GOODS_SUBJECT, paymentRequest.getItemRequest().getShortDescription());
        maps.add(AliPayMessageConstants.PAYMENT_TPYE,"1");
    }

//    protected void setNvpsForShippingType(List<NameValuePair> nvps, AliPayShippingTypeRequest shippingTypeRequest) {
//
//        nvps.add(new NameValuePair(AliPayMessageConstants.LOGISTIC_TYPE, shippingTypeRequest.getLogistic_type()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.LOGISTIC_FEE,shippingTypeRequest.getLogistic_fee()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.LOGISTIC_PAYMENT,shippingTypeRequest.getFeepay_type().getType()));
//    }


    protected void setMapsForShippingType(AliPayQueryPairsMap maps, AliPayShippingTypeRequest shippingTypeRequest) {
        maps.add(AliPayMessageConstants.LOGISTIC_TYPE, shippingTypeRequest.getLogistic_type());
        maps.add(AliPayMessageConstants.LOGISTIC_FEE, shippingTypeRequest.getLogistic_fee());
        maps.add(AliPayMessageConstants.LOGISTIC_PAYMENT,shippingTypeRequest.getFeepay_type().getType());
    }


    protected void setMapsForShippingInfo(AliPayQueryPairsMap maps, AliPayShippingInfo shippingInfo) {

        if (shippingInfo.getShipToName() != null) {
            maps.add(AliPayMessageConstants.BUYER_RECEIVE_NAME, shippingInfo.getShipToName());
        }

        if(shippingInfo.getShipToMobileNumber() != null) {
            maps.add(AliPayMessageConstants.BUYER_RECEIVE_MOBILE,shippingInfo.getShipToMobileNumber());
        }

        String shippingAddress = " " ;

        shippingAddress += shippingInfo.getShipToState() != null ? shippingInfo.getShipToState() + " ": "";
        shippingAddress += shippingInfo.getShipToCity() != null ? shippingInfo.getShipToCity() + " " : "" ;
        shippingAddress += shippingInfo.getShipToStreet() != null ? shippingInfo.getShipToStreet() + " ": "";
        shippingAddress += shippingInfo.getShipToStreet2() != null ? shippingInfo.getShipToStreet2() + " ": "";
        maps.add(AliPayMessageConstants.BUYER_RECEIVE_ADDRESS, shippingAddress);

        if (shippingInfo.getShipToZip() != null) {
            maps.add(AliPayMessageConstants.BUYER_RECEIVE_ZIP, shippingInfo.getShipToZip());
        }

        if (shippingInfo.getShipToPhoneNumber() != null) {
            maps.add(AliPayMessageConstants.BUYER_RECEIVE_PHONE, shippingInfo.getShipToPhoneNumber());
        }

    }

//    protected void  setNvpsForItemDetail(List<NameValuePair> nvps, AliPayItemRequest itemRequest) {
//        // in case the iteRequest is null. The itemRequest is NOT be null.
//        if (itemRequest == null) {
//            nvps.add(new NameValuePair(AliPayMessageConstants.SINGLE_GOOD_PRICE,"1"));
//            nvps.add(new NameValuePair(AliPayMessageConstants.GOOD_QUANTITY,"1"));
//            return;
//        }
//        nvps.add(new NameValuePair(AliPayMessageConstants.SINGLE_GOOD_PRICE, itemRequest.getUnitPrice()));
//        nvps.add(new NameValuePair(AliPayMessageConstants.GOOD_QUANTITY,itemRequest.getQuantity().toString()));
//
//    }
    protected void setMapsForItemDetail(AliPayQueryPairsMap maps, AliPayItemRequest itemRequest) {
        if (itemRequest == null) {
            maps.add(AliPayMessageConstants.SINGLE_GOOD_PRICE, "1");
            maps.add(AliPayMessageConstants.GOOD_QUANTITY, "1");
            return;
        }

        maps.add(AliPayMessageConstants.SINGLE_GOOD_PRICE, itemRequest.getUnitPrice());
        maps.add(AliPayMessageConstants.GOOD_QUANTITY, itemRequest.getQuantity());
    }

    protected void setNvpsForDueAction(List<NameValuePair> nvps, AliPayDueActionRequest dueActionRequest) {
        if (dueActionRequest == null) return;
    }

    protected void setNvpsForShippingType1(List<NameValuePair> nvps, AliPayShippingTypeRequest shippingTypeRequest1) {
        if (shippingTypeRequest1 == null)  return;
    }

    protected void setNvpsForShippingType2(List<NameValuePair> nvps, AliPayShippingTypeRequest shippingTypeRequest2) {
        if (shippingTypeRequest2 == null) return;
    }

    protected void setNvpsForShippingInfo(List<NameValuePair> nvps, AliPayShippingInfo shippingRequest) {
            if (shippingRequest == null) return;
    }




    AliPayQueryPairsMap buildRequestPairBeforeSign(AliPayPaymentRequest paymentRequest) {


        AliPayQueryPairsMap queryPairsMap  = new AliPayQueryPairsMap();
        //        if (AliPayTransactionType.AUTHORIZE.equals(paymentRequst.getMethodType()))
        setBaseMaps(queryPairsMap);
        setMapsForCheckOutOrAuth(queryPairsMap, paymentRequest);
        setMapsForShippingType(queryPairsMap, paymentRequest.getShippingTypeRequest());
        setMapsForItemDetail(queryPairsMap, paymentRequest.getItemRequest());

        AliPayShippingInfo shippingInfo;
        if ((shippingInfo = paymentRequest.getShippingRequest()) == null) {
            shippingInfo = new AliPayShippingInfo(configuration.getBuyerName(),null,null,
                                                    null,configuration.getShippingAddress(),null,
                                                    configuration.getShippingMobile(),null,null);
        }
        setMapsForShippingInfo(queryPairsMap,shippingInfo);
        return queryPairsMap;
    }



    AliPayQueryPairsMap doSignature(AliPayQueryPairsMap toSignMaps) {
        String signature = "";
        if (configuration.getSignType().equalsIgnoreCase("MD5")) {
           signature =  Md5SignUtil.doSign(toSignMaps.buildQueryString(),configuration.getAliPayKey(), configuration.getInputCharset());
        } else if(configuration.getSignType().equals("RSA")) {
            // need to complete later
        } else if(configuration.getSignType().equalsIgnoreCase("DSA")) {
            // need to completed to later.
        } else {
            throw  new RuntimeException("The signature type in configuration isn't correct");
        }
        toSignMaps.add(AliPayMessageConstants.SIGN_TYPE, configuration.getSignType());
        toSignMaps.add(AliPayMessageConstants.SIGN,signature);
        return toSignMaps;
    }


    @Override
    public String buildRequest(AliPayRequest aliPayRequest) {

        AliPayPaymentRequest paymentRequest = (AliPayPaymentRequest) aliPayRequest;
        AliPayQueryPairsMap maps = buildRequestPairBeforeSign(paymentRequest);
        AliPayQueryPairsMap signedMaps = doSignature(maps);

        String endPointQuery = signedMaps.buildQueryString();

        return endPointQuery;
    }

}
