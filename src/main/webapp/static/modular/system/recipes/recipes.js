/**
 * 菜谱管理初始化
 */
var Recipes = {
    id: "RecipesTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Recipes.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'sort', visible: true, align: 'center', valign: 'middle'},
            {title: '菜名', field: 'recipeName', visible: true, align: 'center', valign: 'middle'},
            {title: '所需时间', field: 'cookingTime', visible: true, align: 'center', valign: 'middle'},
            {title: '菜系', field: 'cuisine', visible: true, align: 'center', valign: 'middle'},
            {title: '食材，数量', field: 'ingredients', visible: true, align: 'center', valign: 'middle'},
            {title: '制作该菜谱的详细步骤', field: 'steps', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Recipes.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Recipes.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加菜谱
 */
Recipes.openAddRecipes = function () {
    var index = layer.open({
        type: 2,
        title: '添加菜谱',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/recipes/recipes_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看菜谱详情
 */
Recipes.openRecipesDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '菜谱详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/recipes/recipes_update/' + Recipes.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除菜谱
 */
Recipes.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/recipes/delete", function (data) {
            Feng.success("删除成功!");
            Recipes.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("recipesId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询菜谱列表
 */
Recipes.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Recipes.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Recipes.initColumn();
    var table = new BSTable(Recipes.id, "/recipes/list", defaultColunms);
    table.setPaginationType("client");
    Recipes.table = table.init();
});
