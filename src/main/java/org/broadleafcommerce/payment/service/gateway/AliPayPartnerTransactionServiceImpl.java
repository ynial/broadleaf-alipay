package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.vendor.alipay.service.payment.type.AliPayTransactionType;
import org.broadleafcommerce.vendor.paypal.service.payment.message.payment.AliPayPaymentRequest;
import org.broadleafcommerce.vendor.paypal.service.payment.message.payment.AliPaySummaryRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


/**
 * Created by Mai on 2015/11/14.
 */
@Service("blAliPayPartnerTransactionService")
public class AliPayPartnerTransactionServiceImpl implements PaymentGatewayTransactionService {



    protected AliPayPaymentRequest bulidBasicRequest(PaymentRequestDTO requestDTO, AliPayTransactionType transactionType) {

        Assert.isTrue(requestDTO.getOrderId() != null, "The Order ID for the alipay request cannot be null");
        Assert.isTrue(requestDTO.getTransactionTotal() != null, "The Transaction Total for the alipay request cannot be null");

        if (requestDTO.getOrderId() != null) {
            Assert.isTrue(requestDTO.getOrderId().length() <= 127, "The reference number for the paypal request cannot be greater than 127 characters");
        }

        AliPayPaymentRequest request = new AliPayPaymentRequest();
        request.setTransactionType(transactionType);
        request.setOrderId(requestDTO.getOrderId());
        request.setCurrency(requestDTO.getOrderCurrencyCode());
//        request.setCompleteCheckoutOnCallback(requestDTO.isCompleteCheckoutOnCallback());
        AliPaySummaryRequest summaryRequest = new AliPaySummaryRequest();
        summaryRequest.setGrandTotal(new Money(requestDTO.getTransactionTotal(),requestDTO.getOrderCurrencyCode()));
        request.setSummaryRequest(summaryRequest);
        return request;

    }

    @Override
    public PaymentResponseDTO authorize(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        return null;
    }

    @Override
    public PaymentResponseDTO capture(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        return null;
    }

    @Override
    public PaymentResponseDTO authorizeAndCapture(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        return null;
    }

    @Override
    public PaymentResponseDTO reverseAuthorize(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        return null;
    }

    @Override
    public PaymentResponseDTO refund(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        return null;
    }

    @Override
    public PaymentResponseDTO voidPayment(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        return null;
    }
}
