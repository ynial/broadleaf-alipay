package org.broadleafcommerce.payment.service.gateway;

import org.broadleafcommerce.common.payment.service.*;
import org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionHandler;
import org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionHandler;
import org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Mai on 2015/11/14.
 */
@Component("blAliPayPartnerConfigurationService")
public class AliPayPartnerConfigurationServiceImpl implements PaymentGatewayConfigurationService {

    @Resource(name = "blAliPayPartnerConfiguration")
    protected AliPayConfiguration configuration;

    @Resource(name = "blAliPayPartnerTransactionService")
    protected PaymentGatewayTransactionService transactionService;

    @Resource(name = "blAliPayPartnerTransactionConfirmationService")
    protected PaymentGatewayTransactionConfirmationService transactionConfirmationService;

    @Resource(name = "blAliPayPartnerRollbackService")
    protected PaymentGatewayRollbackService rollbackService;

    @Resource(name = "blAliPayWebResponseService")
    protected PaymentGatewayWebResponseService webResponseService;


    @Override
    public PaymentGatewayConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public PaymentGatewayTransactionService getTransactionService() {
        return transactionService;
    }

    @Override
    public PaymentGatewayTransactionConfirmationService getTransactionConfirmationService() {
        return transactionConfirmationService;
    }

    @Override
    public PaymentGatewayReportingService getReportingService() {
        return null;
    }

    @Override
    public PaymentGatewayCreditCardService getCreditCardService() {
        return null;
    }

    @Override
    public PaymentGatewayCustomerService getCustomerService() {
        return null;
    }

    @Override
    public PaymentGatewaySubscriptionService getSubscriptionService() {
        return null;
    }

    @Override
    public PaymentGatewayFraudService getFraudService() {
        return null;
    }

    @Override
    public PaymentGatewayHostedService getHostedService() {
        return null;
    }

    @Override
    public PaymentGatewayRollbackService getRollbackService() {
        return rollbackService;
    }

    @Override
    public PaymentGatewayWebResponseService getWebResponseService() {
        return webResponseService;
    }

    @Override
    public PaymentGatewayTransparentRedirectService getTransparentRedirectService() {
        return null;
    }

    @Override
    public TRCreditCardExtensionHandler getCreditCardExtensionHandler() {
        return null;
    }

    @Override
    public PaymentGatewayFieldExtensionHandler getFieldExtensionHandler() {
        return null;
    }

    @Override
    public CreditCardTypesExtensionHandler getCreditCardTypesExtensionHandler() {
        return null;
    }
}
