package com.jsnjfz.manage.modular.system.service.impl;

import com.jsnjfz.manage.core.common.enums.RecipesTypeEnum;
import com.jsnjfz.manage.modular.system.controller.request.RandomRecipesRequest;
import com.jsnjfz.manage.modular.system.dto.RandomRecipesDto;
import com.jsnjfz.manage.modular.system.model.Recipes;
import com.jsnjfz.manage.modular.system.dao.RecipesMapper;
import com.jsnjfz.manage.modular.system.service.IRecipesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2024-03-04
 */
@Service
public class RecipesServiceImpl extends ServiceImpl<RecipesMapper, Recipes> implements IRecipesService {

    @Autowired
    private RecipesMapper recipesMapper;
    @Override
    public List<Recipes> randomRecipes(Map<String,Integer> map) {
        Map<String,Integer> paramMap = new HashMap<>();
        map.forEach((k,v) -> {
            if (Objects.nonNull(v) && !Objects.equals(v, 0)){
                String key = RecipesTypeEnum.valueOfName(k).getValue();
                paramMap.put(key, v);
            }
        });
        return recipesMapper.randomQuery(paramMap);
    }
}
