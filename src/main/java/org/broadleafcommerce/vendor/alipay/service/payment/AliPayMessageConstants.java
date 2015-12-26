package org.broadleafcommerce.vendor.alipay.service.payment;

/**
 * Created by Mai on 2015/11/10.
 */
public class AliPayMessageConstants {


    //Common message constants
    public static final String SERVICE = "service";
    public static final String PARTNERTRADE_SERVICE = "create_partner_trade_by_buyer";

    public static final String PARTNER = "partner";
    public static final String INPUT_CHARSET = "_input_charset";
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "sign_type";

    public static final String ISSUCCESS = "is_success";


    // partner trade
    public static final String NOTIFY_URL = "notify_url";
    public static final String RETURN_URL = "return_url";
    public static final String OUT_TRADE_NO = "out_trade_no";
    public static final String GOODS_SUBJECT = "subject";
    public static final String PAYMENT_TPYE = "payment_type";
    public static final String LOGISTIC_TYPE = "logistics_type";
    public static final String LOGISTIC_FEE = "logistics_fee";
    public static final String LOGISTIC_PAYMENT = "logistics_payment";
    public static final String SINGLE_GOOD_PRICE = "price";
    public static final String GOOD_QUANTITY = "quantity";
    public static final String SELLER_EMAIL = "seller_email";
    public static final String BUYER_EMAIL = "buyer_email";
    public static final String SELLER_ID = "seller_id";
    public static final String BUYER_ID = "buyer_id";
    public static final String SELLER_ACCOUNT_ID = "seller_account_name";
    public static final String BUYER_ACCOUNT_NAME = "buyer_account_name";
    public static final String GOOD_BODY = "body";
    public static final String SHOW_URL = "show_url";
    public static final String TOTAL_FEE = "total_fee";
    public static final String DISCOUND = "discount";
    public static final String BUYER_RECEIVE_NAME = "receive_name";
    public static final String BUYER_RECEIVE_ADDRESS = "receive_address";
    public static final String BUYER_RECEIVE_ZIP = "receive_zip";
    public static final String BUYER_RECEIVE_PHONE = "receive_phone";
    public static final String BUYER_RECEIVE_MOBILE = "receive_mobile";
    public static final String LOGISTIC_TYPE1 = "logistics_type_1";
    public static final String LOGISTIC_FEE1 = "logistics_fee_1";
    public static final String LOGISTIC_PAYMENT1 = "logistics_payment_1";
    public static final String LOGISTIC_TPYE2 = "logistics_type_2";
    public static final String LOGISTIC_FEE2 = "logistics_fee_2";
    public static final String LOGISTIC_PAYMENT2 = "logistics_payment_2";

    public static final String DELIVERY_OVERDUE_ALLOW = "t_s_send_1";
    public static final String DELIVERY_OVERDUE_SUGGEST = "t_s_send_2";
    public static final String CONFIRM_OVERDUE_DAYS = "t_b_rec_post";
    public static final String PAYMENT_OVERDUE_AUTOCLOSE = "it_b_pay";
    public static final String TOKEN = "token";

    // Partner trade to confirm to goods was delivery.
    public static final String TRADE_NO = "trade_no";
    public static final String LOGISTIC_NAME = "logistics_name";
    public static final String LOGISTIC_INVOICE_NO = "invoice_no";
    public static final String TRANSPORT_TYPE = "transport_type";
    public static final String CREATE_TRANSPORT_TPYE = "create_transport_type";
    public static final String SELLER_IP = "seller_ip";

}
