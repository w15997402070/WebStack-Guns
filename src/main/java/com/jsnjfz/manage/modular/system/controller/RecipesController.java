package com.jsnjfz.manage.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.jsnjfz.manage.core.log.LogObjectHolder;
import com.jsnjfz.manage.modular.system.controller.request.RandomRecipesRequest;
import com.jsnjfz.manage.modular.system.dto.RandomRecipesDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.jsnjfz.manage.modular.system.model.Recipes;
import com.jsnjfz.manage.modular.system.service.IRecipesService;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 菜谱控制器
 *
 * @author fengshuonan
 * @Date 2024-03-04 21:45:23
 */
@Controller
@RequestMapping("/recipes")
public class RecipesController extends BaseController {

    private String PREFIX = "/system/recipes/";

    @Autowired
    private IRecipesService recipesService;

    /**
     * 跳转到菜谱首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "recipes.html";
    }

    /**
     * 跳转到添加菜谱
     */
    @RequestMapping("/recipes_add")
    public String recipesAdd() {
        return PREFIX + "recipes_add.html";
    }

    /**
     * 跳转到修改菜谱
     */
    @RequestMapping("/recipes_update/{recipesId}")
    public String recipesUpdate(@PathVariable Integer recipesId, Model model) {
        Recipes recipes = recipesService.selectById(recipesId);
        model.addAttribute("item",recipes);
        LogObjectHolder.me().set(recipes);
        return PREFIX + "recipes_edit.html";
    }

    /**
     * 获取菜谱列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return recipesService.selectList(null);
    }

    /**
     * 新增菜谱
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Recipes recipes) {
        recipesService.insert(recipes);
        return SUCCESS_TIP;
    }

    /**
     * 删除菜谱
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer recipesId) {
        recipesService.deleteById(recipesId);
        return SUCCESS_TIP;
    }

    /**
     * 修改菜谱
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Recipes recipes) {
        recipesService.updateById(recipes);
        return SUCCESS_TIP;
    }

    /**
     * 菜谱详情
     */
    @RequestMapping(value = "/detail/{recipesId}")
    @ResponseBody
    public Object detail(@PathVariable("recipesId") Integer recipesId) {
        return recipesService.selectById(recipesId);
    }

    /**
     * 随机菜单页
     */
    @RequestMapping(value = "/random")
    public Object random(Recipes recipes) {
        return PREFIX + "random.html";
    }

    /**
     * 菜单详情
     */
    @RequestMapping(value = "/randomDetail")
    @ResponseBody
    public Object randomDetail(@RequestBody Map<String,Integer> map) {
        return recipesService.randomRecipes(map);
    }
}
