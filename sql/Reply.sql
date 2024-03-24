DROP TABLE `wx_reply` if exists;

CREATE TABLE `wx_reply` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `keyword` VARCHAR(255) NOT NULL COMMENT '菜名',
    `type` VARCHAR(50)  NULL COMMENT '类型',
    `link` VARCHAR(255)  NULL COMMENT '链接',
    `content` TEXT DEFAULT NULL COMMENT '内容',
    `sort` INT NULL ,
    `create_time` TIMESTAMP NULL DEFAULT NULL,
    `update_time` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
);

INSERT INTO `guns`.`sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'reply', 'wxreply', '[0],[wx],[wxreply],', '公众号回复', '', '/reply', '99', '2', '1', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'reply_list', 'reply', '[0],[wx],[wxreply],[reply],', '公众号回复列表', '', '/reply/list', '99', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'reply_add', 'reply', '[0],[wx],[wxreply],[reply],', '公众号回复添加', '', '/reply/add', '99', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'reply_update', 'reply', '[0],[wx],[wxreply],[reply],', '公众号回复更新', '', '/reply/update', '99', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'reply_delete', 'reply', '[0],[wx],[wxreply],[reply],', '公众号回复删除', '', '/reply/delete', '99', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` ( `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ( 'reply_detail', 'reply', '[0],[wx],[wxreply],[reply],', '公众号回复详情', '', '/reply/detail', '99', '3', '0', NULL, '1', '0');
