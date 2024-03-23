/**
 * 初始化菜谱详情对话框
 */
var RecipesInfoDlg = {
    recipesInfoData : {}
};

/**
 * 清除数据
 */
RecipesInfoDlg.clearData = function() {
    this.recipesInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RecipesInfoDlg.set = function(key, val) {
    this.recipesInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RecipesInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RecipesInfoDlg.close = function() {
    parent.layer.close(window.parent.Recipes.layerIndex);
}

/**
 * 收集数据
 */
RecipesInfoDlg.collectData = function() {
    this
    .set('id')
    .set('sort')
    .set('type')
    .set('recipeName')
    .set('cookingTime')
    .set('cuisine')
    .set('ingredients')
    .set('steps');
}

/**
 * 提交添加
 */
RecipesInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/recipes/add", function(data){
        Feng.success("添加成功!");
        window.parent.Recipes.table.refresh();
        RecipesInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.recipesInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RecipesInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/recipes/update", function(data){
        Feng.success("修改成功!");
        window.parent.Recipes.table.refresh();
        RecipesInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.recipesInfoData);
    ajax.start();
}

$(function() {

});
