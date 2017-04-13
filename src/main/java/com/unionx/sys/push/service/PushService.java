package com.unionx.sys.push.service;

import com.gexin.rp.sdk.base.impl.Target;
import com.unionx.core.util.Identities;
import com.unionx.core.util.PushUtils;
import com.unionx.sys.account.dao.AccountMapper;
import com.unionx.sys.account.vo.Account;
import com.unionx.sys.push.vo.Push;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 推送service
 * @author abner
 */
@Slf4j
@Service
public class PushService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private PushUtils pushUtils;

    /**
     * 推送
     * @author abner
     */
    public void push(String userId, Push push) {
        try {
            Account account = accountMapper.getAccountByUserId(userId);
            List<Target> targets = new ArrayList<>();
            List<String> drvenTokenList = new ArrayList<>();
            push.setId(Identities.uuid());
            push.setUserId(userId);
            push.setDateTime(System.currentTimeMillis());
            push.setPushSuccessful("0");
            this.mongoTemplate.save(push);
            if (null != account && StringUtils.isNotBlank(account.getOsType()) && StringUtils.isNotBlank(account.getClientId())) {
                if ("android".equals(account.getOsType())) {
                    Target target = new Target();
                    if(account.getUserType().equals("3")){
                        target.setAppId(pushUtils.memberAPPID);
                    }
                    if (account.getUserType().equals("2")) {
                        target.setAppId(pushUtils.storeAPPID);
                    }
                    if (account.getUserType().equals("1")) {
                        target.setAppId(pushUtils.kefuAPPID);
                    }
                    target.setClientId(account.getClientId());
                    targets.add(target);
                }
                if ("ios".equals(account.getOsType())) {
                    drvenTokenList.add(account.getClientId());
                }
                Map<String, Object> body = new HashMap<>();
                if (account.getUserType().equals("3")) {
                    body = pushUtils.memberApnpush(drvenTokenList, targets, push.getText(), push);
                }
                if (account.getUserType().equals("2")) {
                    body = pushUtils.storeApnpush(drvenTokenList, targets, push.getText(), push);
                }
                if (account.getUserType().equals("1")) {
                    body = pushUtils.kefuApnpush(drvenTokenList, targets, push.getText(), push);
                }
                body.put("userId", userId);
                body.put("push", push);
                this.mongoTemplate.save(body, "pushMap");
            }else{

                Map<String, Object> client = new HashMap<>();
                client.put("userId", userId);
                client.put("data", new Date());
                client.put("account", account);
                this.mongoTemplate.save(client, "client");
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
