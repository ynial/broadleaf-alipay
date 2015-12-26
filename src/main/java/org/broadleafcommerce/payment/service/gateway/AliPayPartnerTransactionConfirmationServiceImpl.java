package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionConfirmationService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.springframework.stereotype.Service;

/**
 * Created by Mai on 2015/11/14.
 */
@Service("blAliPayPartnerTransactionConfirmationService")
public class AliPayPartnerTransactionConfirmationServiceImpl implements PaymentGatewayTransactionConfirmationService {
    @Override
    public PaymentResponseDTO confirmTransaction(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        return null;
    }
}
