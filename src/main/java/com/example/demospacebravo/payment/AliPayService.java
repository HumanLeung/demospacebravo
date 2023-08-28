package com.example.demospacebravo.payment;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.demospacebravo.payment.constant.AlipayConstants;
import com.example.demospacebravo.payment.dto.EnterprisePaySettingDto;

import javax.servlet.http.HttpServletRequest;

public class AliPayService {

    public String goToPay(HttpServletRequest request){
        String financialOrgId = request.getParameter("financialOrgId");

        EnterprisePaySettingDto config = new EnterprisePaySettingDto();
        //获取gateway地址
        String gateWay = "1".equals(request.getParameter("dev"))
                ? AlipayConstants.GATEWAYURL_VALUE_DEV : AlipayConstants.GATEWAYURL_VALUE;

        //创建 alipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(gateWay, config.getAlipayMerchantNumber(), config.getAlipayMerchantSecretKey(),
                AlipayConstants.FORMAT_VALUE, AlipayConstants.CHARSET_VALUE, config.getAlipayRsaPublicKey(), AlipayConstants.SIGN_TYPE_VALUE);

        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        return null;

    }

}
