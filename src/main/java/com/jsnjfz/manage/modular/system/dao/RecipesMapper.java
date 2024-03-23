package com.jsnjfz.manage.modular.system.dao;

import com.jsnjfz.manage.core.common.annotion.Permission;
import com.jsnjfz.manage.modular.system.model.Recipes;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wang
 * @since 2024-03-04
 */
public interface RecipesMapper extends BaseMapper<Recipes> {

    /**
     * 随机查询菜单
     * @param map 查询参数
     * @return
     */
    List<Recipes> randomQuery(@Param("map") Map<String, Integer> map);
}
