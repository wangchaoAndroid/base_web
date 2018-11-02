package com.json.jdbcdemo.util;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class PayUity {
//	private final static Logger log = LoggerFactory.getLogger(PayUity.class);
//
//	static
//	{
//		Pingpp.apiKey = ThirdPartConfig.PINGPP_APP_KEY;
//		Pingpp.privateKey = ThirdPartConfig.RSA_PRIVATE_KEY;
//	}
//
//	/**
//	 * 创建支付对象
//	 * @param request
//	 * @param payType
//	 * @param order
//	 * @return
//	 */
//	public static Charge createCharge(HttpServletRequest request, PaymentVo paymentVo,Integer amount)
//	{
//		try
//		{
//			paymentVo.setAmount(amount);
//			Map<String, Object> params = Maps.newHashMap();
//			params.put("order_no", paymentVo.getProductNumber()+"R"+new Date().getTime());
//			params.put("channel", PayChannel.getChannel(paymentVo.getPayType()));
//			params.put("amount", amount);
//			params.put("client_ip", getIPAddress(request));
//			params.put("currency", "cny");
//			params.put("description",JsonUtils.toJson(paymentVo));
//			params.put("subject", "购买电池下单");
//			params.put("body", "购买电池下单详细信息");
//			Map<String, String> app = new HashMap<String, String>();
//			app.put("id",  ThirdPartConfig.PINGPP_SEL_APP_ID );
//			params.put("app", app);
//			return Charge.create(params);
//		}
//		catch (Exception e)
//		{
//			log.error("\n========支付发起失败========\n" + "订单编号\n错误信息"+e.getMessage()+"\n");
//			return null;
//		}
//	}
//
//	/**
//	 * 查询支付对象
//	 * @param chargeId
//	 */
//	public static Charge findCharge(String chargeId)
//	{
//		try
//		{
//			return Charge.retrieve(chargeId);
//		}
//		catch (Exception e)
//		{
//			log.error("\n========查询支付失败========\n" + "支付编号"+chargeId+"\n错误信息"+e.getMessage()+"\n");
//			return null;
//		}
//
//	}
//
//
//
//	/**
//	 * rsa验证返回结果
//	 * @param dataString
//	 * @param signatureString
//	 */
//	public static boolean checkAuth(String dataString, String signatureString)
//	{
//		try
//		{
//			String pubKeyString = ThirdPartConfig.RSA_PUBLIC_KEY;
//			pubKeyString = pubKeyString.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");
//			byte[] keyBytes = Base64.decodeBase64(pubKeyString);
//
//			// generate public key
//			X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
//			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//			PublicKey publicKey = keyFactory.generatePublic(spec);
//
//			byte[] signatureBytes = Base64.decodeBase64(signatureString);
//			Signature signature = Signature.getInstance("SHA256withRSA");
//			signature.initVerify(publicKey);
//			signature.update(dataString.getBytes("UTF-8"));
//			return signature.verify(signatureBytes);
//		}
//		catch (Exception e)
//		{
//			log.error(e.getMessage(), e);
//			return false;
//		}
//	}
//
//	/**
//	 * 获取请求方ip地址
//	 * @param request
//	 * @return
//	 */
//	private static String getIPAddress(HttpServletRequest request)
//	{
//		String ipAddresses = request.getHeader("X-Forwarded-For");
//
//		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
//			//Proxy-Client-IP：apache 服务代理
//			ipAddresses = request.getHeader("Proxy-Client-IP");
//		}
//
//		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
//			//WL-Proxy-Client-IP：weblogic 服务代理
//			ipAddresses = request.getHeader("WL-Proxy-Client-IP");
//		}
//
//		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
//			//HTTP_CLIENT_IP：有些代理服务器
//			ipAddresses = request.getHeader("HTTP_CLIENT_IP");
//		}
//
//		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
//			//X-Real-IP：nginx服务代理
//			ipAddresses = request.getHeader("X-Real-IP");
//		}
//
//		//有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
//		if (StringUtils.isNotBlank(ipAddresses)) {
//			return ipAddresses.split(",")[0];
//		}
//
//		//还是不能获取到，最后再通过request.getRemoteAddr();获取
//		return "120.0.0.1";
//	}

}
