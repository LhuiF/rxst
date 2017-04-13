package com.unionx.sys.push.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 推送类
 * @author abner
 */
@Data
@Document(collection = "Push")
public class Push implements Serializable{

    @Id
    private String id;//消息的ID
    private long dateTime;//服务端发送此消息的时间
    private Integer type;//消息的类型。1、纯文本；2、单张图片；3、html
    private String title;//消息标题。
    private String text;//消息内容。可以是纯文本，也可以包含html标签
    private String img;//图片URL。
    private String actionText;//动作到文字
    private String actionURL;//如果可以操作，此值必需符合uri规则
    @Indexed
    private String userId;//用户id
    private String pushSuccessful;//推送是否成功 0否 1是


}
