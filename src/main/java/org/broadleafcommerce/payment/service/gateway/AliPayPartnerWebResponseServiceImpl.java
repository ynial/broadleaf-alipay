package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.vendor.alipay.service.payment.AliPayMessageConstants;
import org.broadleafcommerce.vendor.paypal.service.payment.MessageConstants;
import org.broadleafcommerce.vendor.paypal.service.payment.PayPalExpressPaymentGatewayType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Mai on 2015/11/14.
 */
@Service("blAliPayWebResponseService")
public class AliPayPartnerWebResponseServiceImpl implements PaymentGatewayWebResponseService{


    public static final Logger logger = LoggerFactory.getLogger(AliPayPartnerWebResponseServiceImpl.class);

    @Override
    public PaymentResponseDTO translateWebResponse(HttpServletRequest request) throws PaymentException {
//        PaymentResponseDTO responseDTO = reportingService.findDetailsByTransaction(requestDTO);
//            reportingServer可以跳过。直接由这里生成，不过可以参考
//        responseDTO.responseMap(MessageConstants.HTTP_REQUEST, webResponsePrintService.printRequest(request));
        // 不用再调用 reportingService

        Map<String,String> parameterMap = request.getParameterMap();

        PaymentResponseDTO responseDTO = new PaymentResponseDTO(PaymentType.THIRD_PARTY_ACCOUNT,
                PayPalExpressPaymentGatewayType.PAYPAL_EXPRESS);
        // if the "is_success" is T or other.
        if (parameterMap.get(AliPayMessageConstants.ISSUCCESS).equalsIgnoreCase("T")) {
            logger.error("The Return/Notify from Payment Gateway is failure with Status" + parameterMap.get(AliPayMessageConstants.ISSUCCESS) );
            return responseDTO.successful(false);
        }

        // set orderId
        String orderId = request.getParameter(AliPayMessageConstants.OUT_TRADE_NO);
        System.out.println("orderId = " + orderId);

        if (orderId == null ) {
            logger.error("The OrderId of ResponseDTO is null");
            return responseDTO.successful(false);
        }


        // set base Transaction information
        responseDTO.successful(true).valid(true).orderId(parameterMap.get(AliPayMessageConstants.OUT_TRADE_NO))
                .amount(new Money(parameterMap.get(AliPayMessageConstants.TOTAL_FEE)))
                .rawResponse(request.getRequestURI());


        for(String key : parameterMap.keySet()) {
            responseDTO.responseMap(key, parameterMap.get(key));
        }

        return responseDTO;
    }
}
