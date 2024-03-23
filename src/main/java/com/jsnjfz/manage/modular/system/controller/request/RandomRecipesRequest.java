package com.jsnjfz.manage.modular.system.controller.request;

import com.jsnjfz.manage.modular.system.dto.RandomRecipesDto;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author wang
 * @date 2024/3/15 21:48
 */
@Data
public class RandomRecipesRequest {

    private Integer meat;
    private Integer fish;
    private Integer vegetables;
    private Integer soup;
    private Integer complexSoup;


    public RandomRecipesDto convert(){
        RandomRecipesDto randomRecipesDto = new RandomRecipesDto();
        BeanUtils.copyProperties(this,randomRecipesDto);
        return randomRecipesDto;
    }
}
