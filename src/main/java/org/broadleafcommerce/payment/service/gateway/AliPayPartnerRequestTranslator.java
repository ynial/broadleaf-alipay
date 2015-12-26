package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.vendor.paypal.service.payment.message.payment.AliPayPaymentRequest;

/**
 * Created by Mai on 2015/11/29.
 */
public interface AliPayPartnerRequestTranslator {

    public AliPayPaymentRequest translate(PaymentRequestDTO requestDTO);
}
