
CREATE TABLE `recipes` (
       `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
       `sort` INT NULL ,
       `recipe_name` VARCHAR(255) NOT NULL COMMENT '菜名',
       `cooking_time` VARCHAR(50)  NULL COMMENT '所需时间',
       `cuisine` VARCHAR(50)  NULL COMMENT '菜系',
       `ingredients` TEXT DEFAULT NULL COMMENT '食材，数量',
       `steps` TEXT DEFAULT NULL COMMENT '制作该菜谱的详细步骤',
       `create_time` TIMESTAMP NULL DEFAULT NULL,
       `update_time` TIMESTAMP NULL DEFAULT NULL,
       PRIMARY KEY (`id`) USING BTREE
);


INSERT INTO `sys_menu` (`code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'recipes', 'system', '[0],[system],', '菜谱', '', '/recipes', '99', '2', '1', NULL, '1', '0');
INSERT INTO `sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('recipes_list', 'recipes', '[0],[system],[recipes],', '菜谱列表', '', '/recipes/list', '99', '3', '0', NULL, '1', '0');
INSERT INTO `sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'recipes_add', 'recipes', '[0],[system],[recipes],', '菜谱添加', '', '/recipes/add', '99', '3', '0', NULL, '1', '0');
INSERT INTO `sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'recipes_update', 'recipes', '[0],[system],[recipes],', '菜谱更新', '', '/recipes/update', '99', '3', '0', NULL, '1', '0');
INSERT INTO `sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'recipes_delete', 'recipes', '[0],[system],[recipes],', '菜谱删除', '', '/recipes/delete', '99', '3', '0', NULL, '1', '0');
INSERT INTO `sys_menu` (`code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'recipes_detail', 'recipes', '[0],[system],[recipes],', '菜谱详情', '', '/recipes/detail', '99', '3', '0', NULL, '1', '0');

