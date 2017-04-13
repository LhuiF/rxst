package com.unionx.core.message;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.unionx.core.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 功能：发送短信
 * Author:Yang yanli
 */
@Component
public class SendMessage {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 发送消息
     *
     * @param smsParam json字符串
     * @param phoneNum 电话号码
     * @param smsCode  模板名称，模板地址 svn://192.168.1.240/一龄博士/2.需求分析/一龄博士V3.0/文档/短信消息模版.xlsx
     *                 SMS_14191639 会所邀请消息
     *                 SMS_14241666 主店审核不通过
     *                 SMS_14241667 会所审核通过
     *                 SMS_14186613 会员邀请消息
     *                 SMS_14261624 会员审核通过
     *                 SMS_13395300 注册验证码
     *                 SMS_14206655 密码找回
     *                 SMS_14410024 分店审核不通过
     * @return
     */
    public Boolean sendMessage(String smsParam, String phoneNum, String smsCode) {
        String url = "http://gw.api.taobao.com/router/rest";
        String appkey = "23440504";
        String secret = "ca4e97217b999e7fa3453af7c112cae1";
        String smsTemplate = smsCode;
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("一龄博士");
        req.setSmsParamString(smsParam);
        req.setRecNum(phoneNum);
        req.setSmsTemplateCode(smsTemplate);
        AlibabaAliqinFcSmsNumSendResponse response = new AlibabaAliqinFcSmsNumSendResponse();
        try {
            response = client.execute(req);
            String responseBody = response.getBody();
            Map<String, Map<String, Map>> valueMap = JsonUtils.readValue(responseBody, Map.class);
            this.mongoTemplate.save(valueMap, "MessageResData");
            Boolean status = (Boolean) valueMap.get("alibaba_aliqin_fc_sms_num_send_response").get("result").get("success");
            return status;
        } catch (ApiException e) {
            e.printStackTrace();
            return false;
        }
    }

}
