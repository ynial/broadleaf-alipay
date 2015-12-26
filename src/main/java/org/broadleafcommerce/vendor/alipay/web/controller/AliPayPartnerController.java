package org.broadleafcommerce.vendor.alipay.web.controller;

import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Mai on 2015/11/10.
 */

@Controller("blAliPayPartnerController")
@RequestMapping(value = "/alipay")
public class AliPayPartnerController extends PaymentGatewayAbstractController {

    protected static final Logger logger = LoggerFactory.getLogger(AliPayPartnerController.class);

    protected static final String GATEWAY_CONTEXT_KEY = "alipay-partner";

    @Resource(name = "blAliPayPartnerConfiguration")
    PaymentGatewayConfiguration paymentGatewayConfiguration;

    @Resource(name = "blAliPayWebResponseService")
    protected PaymentGatewayWebResponseService paymentGatewayWebResponseService;


    @Override
    public void handleProcessingException(Exception e, RedirectAttributes redirectAttributes) throws PaymentException {

    }

    @Override
    public void handleUnsuccessfulTransaction(Model model, RedirectAttributes redirectAttributes, PaymentResponseDTO responseDTO) throws PaymentException {

    }


    @Override
    public String getGatewayContextKey() {
        return GATEWAY_CONTEXT_KEY;
    }

    @Override
    public PaymentGatewayWebResponseService getWebResponseService() {
        return paymentGatewayWebResponseService;
    }

    @Override
    public PaymentGatewayConfiguration getConfiguration() {
        return paymentGatewayConfiguration;
    }

    @Override
    @RequestMapping(value = "/return")
    public String returnEndpoint(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes, Map<String, String> pathVars) throws PaymentException {

        return super.process(model,request,redirectAttributes);
    }

    @Override
    public String errorEndpoint(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes, Map<String, String> pathVars) throws PaymentException {
        return null;
    }


    @RequestMapping(value = "/notify")
    public String notifyEndpoint(Model model,HttpServletRequest request, RedirectAttributes redirectAttributes, Map<String,String> pathVars) throws PaymentException {
        return super.process(model, request, redirectAttributes);
    }




}
