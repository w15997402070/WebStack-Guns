package com.jsnjfz.manage.modular.wx.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.jsnjfz.manage.core.log.LogObjectHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.jsnjfz.manage.modular.system.model.WxReply;
import com.jsnjfz.manage.modular.system.service.IWxReplyService;

/**
 * 公众号回复控制器
 *
 * @author fengshuonan
 * @Date 2024-03-24 20:42:43
 */
@Controller
@RequestMapping("/reply")
public class WxReplyController extends BaseController {

    private String PREFIX = "/wx/reply/";

    @Autowired
    private IWxReplyService replyService;

    /**
     * 跳转到公众号回复首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "reply.html";
    }

    /**
     * 跳转到添加公众号回复
     */
    @RequestMapping("/reply_add")
    public String replyAdd() {
        return PREFIX + "reply_add.html";
    }

    /**
     * 跳转到修改公众号回复
     */
    @RequestMapping("/reply_update/{replyId}")
    public String replyUpdate(@PathVariable Integer replyId, Model model) {
        WxReply reply = replyService.selectById(replyId);
        model.addAttribute("item",reply);
        LogObjectHolder.me().set(reply);
        return PREFIX + "reply_edit.html";
    }

    /**
     * 获取公众号回复列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return replyService.selectList(null);
    }

    /**
     * 新增公众号回复
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WxReply reply) {
        replyService.insert(reply);
        return SUCCESS_TIP;
    }

    /**
     * 删除公众号回复
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer replyId) {
        replyService.deleteById(replyId);
        return SUCCESS_TIP;
    }

    /**
     * 修改公众号回复
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WxReply reply) {
        replyService.updateById(reply);
        return SUCCESS_TIP;
    }

    /**
     * 公众号回复详情
     */
    @RequestMapping(value = "/detail/{replyId}")
    @ResponseBody
    public Object detail(@PathVariable("replyId") Integer replyId) {
        return replyService.selectById(replyId);
    }
}
