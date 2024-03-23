package com.jsnjfz.manage.modular.system.service;

import com.jsnjfz.manage.modular.system.controller.request.RandomRecipesRequest;
import com.jsnjfz.manage.modular.system.dto.RandomRecipesDto;
import com.jsnjfz.manage.modular.system.model.Recipes;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wang
 * @since 2024-03-04
 */
public interface IRecipesService extends IService<Recipes> {

    List<Recipes> randomRecipes(Map<String,Integer> map);

}
