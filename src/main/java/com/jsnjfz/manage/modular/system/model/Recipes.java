package com.jsnjfz.manage.modular.system.model;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wang
 * @since 2024-03-04
 */
@Data
public class Recipes extends Model<Recipes> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer sort;
    /**
     * 菜名
     */
    @TableField("recipe_name")
    private String recipeName;
    /**
     * 所需时间
     */
    @TableField("cooking_time")
    private String cookingTime;

    private String type;
    /**
     * 菜系
     */
    private String cuisine;
    /**
     * 食材，数量
     */
    private String ingredients;
    /**
     * 制作该菜谱的详细步骤
     */
    private String steps;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Recipes{" +
        ", id=" + id +
        ", sort=" + sort +
        ", recipeName=" + recipeName +
        ", cookingTime=" + cookingTime +
        ", cuisine=" + cuisine +
        ", ingredients=" + ingredients +
        ", steps=" + steps +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
