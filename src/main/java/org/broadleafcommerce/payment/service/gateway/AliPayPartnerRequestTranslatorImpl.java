package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.payment.dto.LineItemDTO;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.vendor.alipay.service.payment.type.AliPayTransactionType;
import org.broadleafcommerce.vendor.paypal.service.payment.message.payment.AliPayItemRequest;
import org.broadleafcommerce.vendor.paypal.service.payment.message.payment.AliPayPaymentRequest;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Line;

/**
 * Created by Mai on 2015/11/29.
 */
@Component("blAliPayPartnerRequestTranslator")
public class AliPayPartnerRequestTranslatorImpl implements AliPayPartnerRequestTranslator {



    @Override
    public AliPayPaymentRequest translate(PaymentRequestDTO requestDTO) {

        AliPayPaymentRequest paymentRequest = baseTranslate(requestDTO, AliPayTransactionType.AUTHORIZE);
        AliPayItemRequest itemRequest = null;
        if (requestDTO.getLineItems() != null && requestDTO.getLineItems().size() > 0) {
            itemRequest = itemTranslate(requestDTO.getLineItems().get(0));
        }
        paymentRequest.setItemRequest(itemRequest);
        return paymentRequest;
    }


    AliPayPaymentRequest baseTranslate(PaymentRequestDTO requestDTO, AliPayTransactionType transactionType){

        AliPayPaymentRequest paymentRequest = new AliPayPaymentRequest();
        paymentRequest.setOrderId(requestDTO.getOrderId());
        paymentRequest.setMethodType(transactionType);
        return paymentRequest;
    }


    AliPayItemRequest itemTranslate(LineItemDTO lineItemDTO) {

        AliPayItemRequest itemRequest = new AliPayItemRequest();

        itemRequest.setSystemId(lineItemDTO.getSystemId());
        itemRequest.setShortDescription(lineItemDTO.getShortDescription());
        itemRequest.setDescription(lineItemDTO.getDescription());
        itemRequest.setUnitPrice(lineItemDTO.getAmount());
        itemRequest.setQuantity(lineItemDTO.getQuantity());
        // need to add more to complete
        return itemRequest;
    }
    // need to complete the shipping settting

}
