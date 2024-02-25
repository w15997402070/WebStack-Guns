package com.jsnjfz.manage.modular.system.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.google.common.collect.Lists;
import com.jsnjfz.manage.modular.system.service.WxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author WangZhengPeng
 * @date 2024/2/9 17:07
 */
@Controller
@RequestMapping("/wx")
@Slf4j
public class WxController {

    @Autowired
    private WxService wxService;
    @RequestMapping("/hook")
    public void msg(@RequestParam("signature") String signature,
                    @RequestParam("timestamp") String timestamp,
                    @RequestParam("nonce") String nonce,
                    @RequestParam(name = "echostr", required = false) String echostr,
                    @RequestParam(name = "encrypt_type", required = false) String encryptType,
                    @RequestParam(name = "msg_signature", required = false) String msgSignature,
                    @RequestParam(name = "openid", required = false) String openid,
                    @RequestBody(required = false) String postData,
                      HttpServletResponse response){
        log.info("signature : {}",signature);
        log.info("timestamp : {}",timestamp);
        log.info("nonce : {}",nonce);
        String token = "zxcvbnm";
        String sign = getSign(token, timestamp, nonce);
//        if (!sign.equals(signature)){
//            return;
//        }
        log.info("echostr : {}",echostr);
        log.info("encryptType : {}",encryptType);
        log.info("msgSignature : {}",msgSignature);
        log.info("postData : {}",postData);
        PrintWriter out = null;
        String event = "success";
        try {
            event = wxService.event(postData);
            response.setHeader("Content-Type","text/html;charset=utf-8");
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //原养返回echostr参数
        out.print(event);
        out.flush();
        out.close();
    }

    public  String getSign(String token,String timestamp,String nonce){
        String[] array = new String[]{token, timestamp, nonce};
        StringBuffer sb = new StringBuffer();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < 3; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        return DigestUtil.sha1Hex(str);
    }
}
