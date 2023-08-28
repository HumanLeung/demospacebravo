package com.example.demospacebravo.payment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;
import javax.validation.constraints.Size;

/**
 * 企业第三方支付设置的数据传输对象类
 *
 * @author wangruiv
 * @date 2018-09-25 14:06:27
 */
@Getter
@Setter
@ToString
@Generated(value = "com.yonyou.ocm.util.codegenerator.CodeGenerator")
public class EnterprisePaySettingDto {
    /**
     * 财务组织
     */
    @Size(max = 40)
    private String legalPersonCorpId;
    private String legalPersonCorpCode;
    private String legalPersonCorpName;

    /**
     * 畅捷支付商户账号
     */
    @Size(max = 200)
    private String chanpayMerchantAccount;

    /**
     * 畅捷支付商户私钥
     */
    @Size(max = 2000)
    private String chanpayMerchantPrivateKey;

    /**
     * 畅捷支付商户公钥
     */
    @Size(max = 2000)
    private String chanpayMerchantPublicKey;

    /**
     * 支付宝商户号
     */
    @Size(max = 200)
    private String alipayMerchantNumber;

    /**
     * 支付宝商户密钥
     */

    @Size(max = 2000)
    private String alipayMerchantSecretKey;

    /**
     * 支付宝合作者身份ID
     */
//    @Display("支付宝合作者身份ID")
//    @Size(max = 200)
//    private String alipayMerchantCooperatorId;

    /**
     * RSA密钥
     */
//    @Display("RSA密钥")
//    @Size(max = 2000)
//    private String alipayRsaSecretKey;

    /**
     * RSA公钥
     */
    @Size(max = 2000)
    private String alipayRsaPublicKey;

    /**
     * 微信APPID
     */
    @Size(max = 200)
    private String wechatAppId;

    /**
     * 微信扫码支付商户密钥
     */
    @Size(max = 2000)
    private String wechatMerchantSecretKey;

    /**
     * 微信支付商户号
     */
    @Size(max = 200)
    private String wechatMerchantNumber;

    /**
     * 微信应用密钥
     */
    @Size(max = 2000)
    private String wechatAppSecret;
}
