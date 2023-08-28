package com.example.demospacebravo.payment.constant;

public class AlipayConstants extends com.alipay.api.AlipayConstants {
    public enum TradeState {
        WAIT_BUYER_PAY("WAIT_BUYER_PAY", "交易创建，等待买家支付"),
        TRADE_FINISHED("TRADE_FINISHED", "交易结束，不可退款"),
        TRADE_SUCCESS("TRADE_SUCCESS", "交易支付成功"),
        TRADE_CLOSED("TRADE_CLOSED", "未付款交易超时关闭，或支付完成后全额退款");
        private final String code;
        private final String name;

        TradeState(String code, String name) {
            this.code = code;
            this.name = name;
        }
        public String getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
    }
    public final static String GATEWAYURL_VALUE = "https://openapi.alipay.com/gateway.do";
    public final static String GATEWAYURL_VALUE_DEV = "https://openapi.alipaydev.com/gateway.do";

    public final static String CHARSET_VALUE = "UTF-8";
    public final static String SIGN_TYPE_VALUE = "RSA2";
    public final static String FORMAT_VALUE = "json";
    public final static String VERSION_VALUE = "1.0";
    public final static String METHOD_VALUE = "alipay.trade.app.pay";;
    public static final String RETURN_URL_VALUE = "/occ-pay/alipay/return-callback";
    public static final String NOTIFY_URL_VALUE = "/occ-pay/alipay/notify-callback";
    public static final String SUBJECT_VALUE = "渠道云门户在线支付订单";

    public static final String ALIPAY_TRADE_APP_PAY_RESPONSE = "alipay_trade_app_pay_response"; // APP支付响应
    public static final String FAST_INSTANT_TRADE_PAY = "FAST_INSTANT_TRADE_PAY";

    public static final String OUT_TRADE_NO = "out_trade_no";// 业务订单号
    public static final String TRADE_NO = "trade_no";// 支付交易号
    public static final String TOTAL_AMOUNT = "total_amount";// 支付交易金额
    public static final String TRADE_STATUS = "trade_status"; // 支付交易状态

    public static final String RESULT_CODE = "result_code";
    public static final String RESULT_MSG = "result_msg";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    public static final String OK = "OK";
}
