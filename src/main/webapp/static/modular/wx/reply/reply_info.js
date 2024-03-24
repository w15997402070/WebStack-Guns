/**
 * 初始化公众号回复详情对话框
 */
var ReplyInfoDlg = {
    replyInfoData : {}
};

/**
 * 清除数据
 */
ReplyInfoDlg.clearData = function() {
    this.replyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReplyInfoDlg.set = function(key, val) {
    this.replyInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReplyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ReplyInfoDlg.close = function() {
    parent.layer.close(window.parent.Reply.layerIndex);
}

/**
 * 收集数据
 */
ReplyInfoDlg.collectData = function() {
    this
    .set('id')
    .set('keyword')
    .set('type')
    .set('link')
    .set('content')
    .set('sort')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
ReplyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reply/add", function(data){
        Feng.success("添加成功!");
        window.parent.Reply.table.refresh();
        ReplyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.replyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ReplyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reply/update", function(data){
        Feng.success("修改成功!");
        window.parent.Reply.table.refresh();
        ReplyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.replyInfoData);
    ajax.start();
}

$(function() {

});
