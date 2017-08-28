DROP TABLE IF EXISTS `fiap`.`chamado`;
CREATE TABLE  `fiap`.`chamado` (
  `id` int(11) NOT NULL auto_increment,
  `descricao` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;