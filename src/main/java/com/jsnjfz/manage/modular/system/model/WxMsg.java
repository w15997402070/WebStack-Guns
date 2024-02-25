package com.jsnjfz.manage.modular.system.model;

import lombok.Data;

/**
 * @author WangZhengPeng
 * @date 2024/2/9 18:43
 */
@Data
public class WxMsg {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Content;
    private String MsgId;

}
