package com.json.jdbcdemo.util;

import core.com.eryansky.common.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
;

public class PushNotiUtil {
//	public static Integer MsgTypeNoti = 1;
//
//	public static Integer MsgTypeCmd = 2;
//
//	private final static Logger log = LoggerFactory.getLogger(PushNotiUtil.class);
//
//
//	/**
//	 * @param  推送的账号
//	 * @param content 内存
//	 * @param ext
//	 * @param msgType 消息类型
//	 * @return
//	 */
//	public static Result pushSingleMsg(String token, String content, Map<String, Object> ext, Integer msgType)
//	{
////		Message msg = new Message();
////
////		msg.setTitle("电池");
////		msg.setContent(content);
////		msg.setType(msgType);
////		msg.setCustom(ext);
//		return sendSingleMsg(token, "");
//	}
//
//	/**
//	 * @param account  推送的账号
//	 * @param msg      推送消息
//	 * @return
//	 */
//	private static <T> Result sendSingleMsg(String token, T msg)
//	{
////
////		XingeApp xinge = null; JSONObject result = null;
////		xinge = new XingeApp(ThirdPartConfig.PUSH_APPID, ThirdPartConfig.PUSH_SECRE_KEY);
////		result=xinge.pushSingleDevice(token, (Message) msg);
////
////
////		log.error("ThirdPartConfig.PUSH_APPID："+ThirdPartConfig.PUSH_APPID);
////		log.error("ThirdPartConfig.PUSH_SECRE_KEY："+ThirdPartConfig.PUSH_SECRE_KEY);
////		log.error("token："+token);
////		if (result.getInt("ret_code") == 0)
////		{
////			log.info("已成功发送消息"  );
////			return Result.successResult().setMsg("已成功发送消息至");
////		}
////		else
////		{
////			log.error(result.toString());
////			log.error(result.getString("err_msg"));
////			return Result.errorResult().setMsg(result.getString("err_msg"));
////		}
//		return  null;
//	}
//
//	public static void main(String[] args) {
//		 Map<String, Object> ext=new HashMap<String, Object>();
//		 ext.put("key1", "吃饭了没");
//		Message msg = new Message();
//		msg.setTitle("电池");
//		msg.setContent("tsttewstete2222");
//		msg.setType(2);
//		msg.setCustom(ext);
//		XingeApp xinge = null; JSONObject result = null;
//		xinge = new XingeApp(2100307158, "8761070ff05b2fc451ebf606b3ae1f30");
//		result=xinge.pushSingleDevice("68b3fbb14407f48f4484bba039c6dfbaa906f4fb", msg);
//		if (result.getInt("ret_code") == 0)
//		{
//			log.info("已成功发送消息"  );
//		}
//		else
//		{
//			log.error(result.toString());
//		}
//	}
//

}
