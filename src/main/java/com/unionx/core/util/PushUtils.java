package com.unionx.core.util;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.APNTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.unionx.sys.push.vo.Push;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推送工具类
 * @author abner
 */
@Data
@Slf4j
@Component
public class PushUtils {

    @Value("${push.memberAPPID}")
    public String memberAPPID;
    @Value("${push.memberAPPKEY}")
    public String memberAPPKEY;
    @Value("${push.memberMASTER}")
    public String memberMASTER;
    public String memberHOST = "http://sdk.open.api.igexin.com/apiex.htm";

    @Value("${push.storeAPPID}")
    public String storeAPPID;
    @Value("${push.storeAPPKEY}")
    public String storeAPPKEY;
    @Value("${push.storeMASTER}")
    public String storeMASTER;
    public String storeHOST = "http://sdk.open.api.igexin.com/apiex.htm";

    @Value("${push.kefuAPPID}")
    public String kefuAPPID;
    @Value("${push.kefuAPPKEY}")
    public String kefuAPPKEY;
    @Value("${push.kefuMASTER}")
    public String kefuMASTER;
    public String kefuHOST = "http://sdk.open.api.igexin.com/apiex.htm";

    /**
     * 推送（群推）
     * @param drvenTokenList ios用户集合
     * @param targets        android用户集合
     * @param body           内容
     * @throws Exception
     * @author abner
     */
    public Map<String, Object> memberApnpush(List<String> drvenTokenList, List<Target> targets, String body, Push pushVo) throws Exception {
        IGtPush push = new IGtPush(memberHOST, memberAPPKEY, memberMASTER);
        System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
        if (drvenTokenList.size() > 0) {//ios
            APNTemplate t = new APNTemplate();
            APNPayload apnpayload = new APNPayload();
            apnpayload.setSound("");//声音
            APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
            alertMsg.setTitle("");//标题
            alertMsg.setBody(body);//内容
            alertMsg.setTitleLocKey("");//标题
            alertMsg.setActionLocKey("");//来自
            apnpayload.setAlertMsg(alertMsg);
//        apnpayload.setBadge(badge);
            apnpayload.addCustomMsg("payload", pushVo);
            t.setAPNInfo(apnpayload);
            ListMessage message = new ListMessage();
            message.setData(t);
            String contentId = push.getAPNContentId(memberAPPID, message);
            IPushResult iosPush = push.pushAPNMessageToList(memberAPPID, contentId, drvenTokenList);
            return iosPush.getResponse();
        }
        if (targets.size() > 0) {//android
//            NotificationTemplate template = new NotificationTemplate();//通知透传模板
//            template.setAppId(APPID);// 设置APPID与APPKEY
//            template.setAppkey(APPKEY);
//            template.setTitle(body);// 设置通知栏标题与内容
//            template.setText(body);//请输入通知栏内容
//            template.setLogo("");// 配置通知栏图标
//            template.setLogoUrl("");// 配置通知栏网络图标
//            template.setIsRing(true); // 设置通知是否响铃，震动，或者可清除
//            template.setIsVibrate(true);
//            template.setIsClearable(true);
////            template.setTransmissionType(2);// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//            template.setTransmissionContent(payload);
            TransmissionTemplate template = new TransmissionTemplate();
            template.setAppId(memberAPPID);
            template.setAppkey(memberAPPKEY);
            template.setTransmissionType(2);
            template.setTransmissionContent(JsonUtils.writeValueAsString(pushVo));
            ListMessage message = new ListMessage();
            message.setData(template);
//            message.setOffline(false);//设置消息离线，并设置离线时间
//            message.setOfflineExpireTime(20 * 1000 * 3600);//离线有效时间，单位为毫秒，可选
            String taskId = push.getContentId(message);//获取taskID
            IPushResult androidPush = push.pushMessageToList(taskId, targets);
            return androidPush.getResponse();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("message","无推送帐号");
        return map;
    }

    public Map<String, Object> storeApnpush(List<String> drvenTokenList, List<Target> targets, String body, Push pushVo) throws Exception {
        IGtPush push = new IGtPush(storeHOST, storeAPPKEY, storeMASTER);
        System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
        if (drvenTokenList.size() > 0) {//ios
            APNTemplate t = new APNTemplate();
            APNPayload apnpayload = new APNPayload();
            apnpayload.setSound("");//声音
            APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
            alertMsg.setTitle("");//标题
            alertMsg.setBody(body);//内容
            alertMsg.setTitleLocKey("");//标题
            alertMsg.setActionLocKey("");//来自
            apnpayload.setAlertMsg(alertMsg);
//        apnpayload.setBadge(badge);
            apnpayload.addCustomMsg("payload", pushVo);
            t.setAPNInfo(apnpayload);
            ListMessage message = new ListMessage();
            message.setData(t);
            String contentId = push.getAPNContentId(storeAPPID, message);
            IPushResult iosPush = push.pushAPNMessageToList(storeAPPID, contentId, drvenTokenList);
            return iosPush.getResponse();
        }
        if (targets.size() > 0) {//android
//            NotificationTemplate template = new NotificationTemplate();//通知透传模板
//            template.setAppId(APPID);// 设置APPID与APPKEY
//            template.setAppkey(APPKEY);
//            template.setTitle(body);// 设置通知栏标题与内容
//            template.setText(body);//请输入通知栏内容
//            template.setLogo("");// 配置通知栏图标
//            template.setLogoUrl("");// 配置通知栏网络图标
//            template.setIsRing(true); // 设置通知是否响铃，震动，或者可清除
//            template.setIsVibrate(true);
//            template.setIsClearable(true);
////            template.setTransmissionType(2);// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//            template.setTransmissionContent(payload);
            TransmissionTemplate template = new TransmissionTemplate();
            template.setAppId(storeAPPID);
            template.setAppkey(storeAPPKEY);
            template.setTransmissionType(2);
            template.setTransmissionContent(JsonUtils.writeValueAsString(pushVo));
            ListMessage message = new ListMessage();
            message.setData(template);
//            message.setOffline(false);//设置消息离线，并设置离线时间
//            message.setOfflineExpireTime(20 * 1000 * 3600);//离线有效时间，单位为毫秒，可选
            String taskId = push.getContentId(message);//获取taskID
            IPushResult androidPush = push.pushMessageToList(taskId, targets);
            return androidPush.getResponse();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "无推送帐号");
        return map;
    }

    public Map<String, Object> kefuApnpush(List<String> drvenTokenList, List<Target> targets, String body, Push pushVo) throws Exception {
        IGtPush push = new IGtPush(kefuHOST, kefuAPPKEY, kefuMASTER);
        System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
        if (drvenTokenList.size() > 0) {//ios
            APNTemplate t = new APNTemplate();
            APNPayload apnpayload = new APNPayload();
            apnpayload.setSound("");//声音
            APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
            alertMsg.setTitle("");//标题
            alertMsg.setBody(body);//内容
            alertMsg.setTitleLocKey("");//标题
            alertMsg.setActionLocKey("");//来自
            apnpayload.setAlertMsg(alertMsg);
//        apnpayload.setBadge(badge);
            apnpayload.addCustomMsg("payload", pushVo);
            t.setAPNInfo(apnpayload);
            ListMessage message = new ListMessage();
            message.setData(t);
            String contentId = push.getAPNContentId(kefuAPPID, message);
            IPushResult iosPush = push.pushAPNMessageToList(kefuAPPID, contentId, drvenTokenList);
            return iosPush.getResponse();
        }
        if (targets.size() > 0) {//android
//            NotificationTemplate template = new NotificationTemplate();//通知透传模板
//            template.setAppId(APPID);// 设置APPID与APPKEY
//            template.setAppkey(APPKEY);
//            template.setTitle(body);// 设置通知栏标题与内容
//            template.setText(body);//请输入通知栏内容
//            template.setLogo("");// 配置通知栏图标
//            template.setLogoUrl("");// 配置通知栏网络图标
//            template.setIsRing(true); // 设置通知是否响铃，震动，或者可清除
//            template.setIsVibrate(true);
//            template.setIsClearable(true);
////            template.setTransmissionType(2);// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//            template.setTransmissionContent(payload);
            TransmissionTemplate template = new TransmissionTemplate();
            template.setAppId(kefuAPPID);
            template.setAppkey(kefuAPPKEY);
            template.setTransmissionType(2);
            template.setTransmissionContent(JsonUtils.writeValueAsString(pushVo));
            ListMessage message = new ListMessage();
            message.setData(template);
//            message.setOffline(false);//设置消息离线，并设置离线时间
//            message.setOfflineExpireTime(20 * 1000 * 3600);//离线有效时间，单位为毫秒，可选
            String taskId = push.getContentId(message);//获取taskID
            IPushResult androidPush = push.pushMessageToList(taskId, targets);
            return androidPush.getResponse();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "无推送帐号");
        return map;
    }

//    public static void main(String args[]) {
//        try {
//            List<Target> targets = new ArrayList<>();
//            List<String> drvenTokenList = new ArrayList<>();
//            Target target = new Target();
////            target.setAppId(PushUtils.APPID);
////            target.setClientId("3b57ba328f37cfac24672ed2b6d71345");
////            targets.add(target);
//            HashMap<Object, Object> map = new HashMap<>();
//            map.put("dateTime", System.currentTimeMillis());
//            map.put("type", 1);
//            map.put("text", "测试");
//            map.put("img", "http://modao.cc/uploads/avatars/33224/profile_user-avatar.png");
//            map.put("action", "");
//            drvenTokenList.add("417cfda708347ad13a992e8ca09bf5c4626f0e2a9223def1013d448caeb92d71");
//            apnpush(drvenTokenList, targets, "body", map);
//        } catch (Exception e) {
//        }
//    }
}
