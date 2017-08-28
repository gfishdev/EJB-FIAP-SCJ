DROP TABLE IF EXISTS `chamado`;
CREATE TABLE  `chamado` (
  `id` int(11) NOT NULL auto_increment,
  `descricao` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;