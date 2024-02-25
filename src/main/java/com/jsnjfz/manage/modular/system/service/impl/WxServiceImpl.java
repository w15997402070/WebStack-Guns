package com.jsnjfz.manage.modular.system.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.jsnjfz.manage.core.common.constant.factory.PageFactory;
import com.jsnjfz.manage.core.util.Pager;
import com.jsnjfz.manage.modular.system.model.Site;
import com.jsnjfz.manage.modular.system.model.WxMsg;
import com.jsnjfz.manage.modular.system.service.WxService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangZhengPeng
 * @date 2024/2/9 18:30
 */
@Service
@Slf4j
public class WxServiceImpl implements WxService {

    @Autowired
    private SiteServiceImpl siteService;
    @Override
    public String event(String postData) {
        Document document = XmlUtil.parseXml(postData);
        Node firstChild = document.getFirstChild();
        WxMsg wxMsg = XmlUtil.xmlToBean(firstChild, WxMsg.class);
        String content = wxMsg.getContent();
        String siteList = getSiteList(content);
        WxMsg returnMsg = new WxMsg();
        returnMsg.setFromUserName(wxMsg.getToUserName());
        returnMsg.setToUserName(wxMsg.getFromUserName());
        returnMsg.setCreateTime(System.currentTimeMillis()/1000 + "");
        returnMsg.setContent(siteList);
        returnMsg.setMsgType(wxMsg.getMsgType());
        JSONObject jsonObject = JSONUtil.parseObj(returnMsg);
        Document xml = XmlUtil.mapToXml(jsonObject, "xml");
        String s = XmlUtil.toStr(xml, CharsetUtil.CHARSET_UTF_8.name(), false);
        String result = StringUtils.replace(s, "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>", "");
        return result;
    }

    private String getSiteList(String content) {
        Map map = new HashMap();
//        map.put("categoryTitle","软件");
        map.put("title",content);
        Pager<Site> pages = siteService.getPage(map, 1, 20);
        List<Site> list = pages.getList();
        if (CollectionUtils.isEmpty(list)){
            return "no site";
        }
        StringBuilder sb = new StringBuilder();
        for (Site site : list) {
            sb.append(site.getTitle()).append(" : ").append(site.getUrl()).append("\n");
        }
        return sb.toString();
    }
}
