package org.broadleafcommerce.vendor.alipay.web.processor;

import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.payment.service.gateway.AliPayConfiguration;
import org.broadleafcommerce.payment.service.gateway.AliPayPartnerRequestTranslator;
import org.broadleafcommerce.vendor.alipay.service.payment.AliPayPartnerRequestGenerator;
import org.broadleafcommerce.vendor.paypal.service.payment.message.payment.AliPayPaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractAttributeModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Mai on 2015/11/10.
 */
@Component("blAliPayPartnerCheckoutLinkProcessor")
public class AliPayPartnerCheckoutLinkProcessor extends AbstractAttributeModifierAttrProcessor {

    private static final Logger logger = LoggerFactory.getLogger(AliPayPartnerCheckoutLinkProcessor.class);

    @Resource(name = "blAliPayPartnerRequestGenerator")
    AliPayPartnerRequestGenerator requestGenerator;

    @Resource(name = "blAliPayPartnerRequestTranslator")
    AliPayPartnerRequestTranslator requestTranslator;

    @Resource(name = "blAliPayPartnerConfiguration")
    AliPayConfiguration aliPayConfiguration;

    protected AliPayPartnerCheckoutLinkProcessor() {
        super("alipay_partner_trade_link");
    }

    private String getServerUrl() {
        return aliPayConfiguration.getServerUrl();
    }

    @Override
    protected Map<String, String> getModifiedAttributeValues(final Arguments arguments, final Element element, final String attributeName) {




        final Map<String,String> attrs = new HashMap<String, String>();

        final Configuration configuration = arguments.getConfiguration();

        final String attributeValue = element.getAttributeValue(attributeName);

        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);

        final IStandardExpression expression = parser.parseExpression(configuration,arguments,attributeValue);

        final PaymentRequestDTO requestDTO = (PaymentRequestDTO) expression.execute(configuration,arguments);

        String url = "";

        AliPayPaymentRequest paymentRequest = requestTranslator.translate(requestDTO);

        String signedQueryString = requestGenerator.buildRequest(paymentRequest);

        url = aliPayConfiguration.getServerUrl() + signedQueryString;

        System.out.println("The Query String: " + url);

        attrs.put("href", url);
        return attrs;
    }

    @Override
    protected ModificationType getModificationType(Arguments arguments, Element element, String s, String s1) {
        return ModificationType.SUBSTITUTION;
    }

    @Override
    protected boolean removeAttributeIfEmpty(Arguments arguments, Element element, String s, String s1) {
        return true;
    }

    @Override
    protected boolean recomputeProcessorsAfterExecution(Arguments arguments, Element element, String s) {
        return false;
    }

    @Override
    public int getPrecedence() {
        return 10000;
    }
}
