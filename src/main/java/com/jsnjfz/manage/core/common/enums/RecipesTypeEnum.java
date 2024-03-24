package com.jsnjfz.manage.core.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author wang
 * @date 2024/3/22 19:55
 */
@AllArgsConstructor
public enum RecipesTypeEnum {
    MEAT("meat","肉类"),
    FISH("fish","鱼类"),
    VEGETABLES("vegetables","蔬菜"),
    SOUP("soup","简易汤"),
    COMPLEX_SOUP("complexSoup","复杂汤"),
    ;
    @Getter
    private String value;
    @Getter
    private String name;


    public static RecipesTypeEnum valueOfName(String value){
        return Arrays.stream(RecipesTypeEnum.values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }

}
