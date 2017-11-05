package com.xiaomi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class GetPhoneNumberUtil {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		try {
//			GetPhoneNumberUtil smsUtils = new GetPhoneNumberUtil();
//			String telphoneString = "18719123749";
//			smsUtils.sendSms(telphoneString);
//
//			System.out.println(smsUtils.getID());
//		} catch (ClientException e) {
//			e.printStackTrace();
//		}
//
//	}

	// 随机验证码
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode() {
		code = (int) (Math.random() * 9999) + 1000; // 每次调用生成一次四位数的随机数
	}

	// 短信API产品名称
	static final String product = "Dysmsapi";
	// 短信API产品域名
	static final String domain = "dysmsapi.aliyuncs.com";

	static final String accessKeyId = "LTAIHPLL4UzOHqjf";
	static final String accessKeySecret = "QoWz4ZRJkrTZhJoDCZAVfO1Ew4cMVo";

	public String codetemp;
	
	
	public String successMessage = null;

	public SendSmsResponse sendSms(String telphone) throws ClientException {
		// 设置超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		// 初始化ascClient
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
				accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
				domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);

		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 待发送的手机号
		request.setPhoneNumbers(telphone);
		// 短信签名
		request.setSignName("关华钦");
		// 短信模板ID
		request.setTemplateCode("SMS_102210085");
		// 验证码
		GetPhoneNumberUtil sms = new GetPhoneNumberUtil();
		sms.setCode();
		codetemp = sms.getCode() + "";
		System.out.println("code:        " + codetemp);
		/*
		 * 可选:模板中的变量替换JSON串, 如模板内容为"亲爱的${name},您的验证码为${code}"时,
		 * 此处的值为{"name":"Tom","code":"1454"} \ 反斜杠为转义字符，使得输出双引号
		 */
		request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"" + codetemp
				+ "\"}");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		// request.setOutId("1454");
		SendSmsResponse response = acsClient.getAcsResponse(request);

		if (response.getCode() != null && response.getCode().equals("OK")) {
			// 请求成功
			
			successMessage = "发送成功！";
			
			System.out.println("发送成功！");
		} else {
			successMessage = "发送失败！";
			System.out.println("发送失败！");
		}
		return response;
	}

	public String getID() {
		return codetemp;
	}
	
	public String isSuccess(){
		return successMessage;
	}
	
}
