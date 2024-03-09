package com.jsnjfz.manage.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wang
 * @since 2024-03-04
 */
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
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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
