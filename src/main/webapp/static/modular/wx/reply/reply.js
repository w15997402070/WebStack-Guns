/**
 * 公众号回复管理初始化
 */
var Reply = {
    id: "ReplyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Reply.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '关键词', field: 'keyword', visible: true, align: 'center', valign: 'middle'},
            {title: '链接', field: 'link', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'sort', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Reply.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Reply.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加公众号回复
 */
Reply.openAddReply = function () {
    var index = layer.open({
        type: 2,
        title: '添加公众号回复',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/reply/reply_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看公众号回复详情
 */
Reply.openReplyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '公众号回复详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/reply/reply_update/' + Reply.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除公众号回复
 */
Reply.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/reply/delete", function (data) {
            Feng.success("删除成功!");
            Reply.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("replyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询公众号回复列表
 */
Reply.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Reply.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Reply.initColumn();
    var table = new BSTable(Reply.id, "/reply/list", defaultColunms);
    table.setPaginationType("client");
    Reply.table = table.init();
});
