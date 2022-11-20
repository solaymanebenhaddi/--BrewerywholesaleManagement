INSERT INTO `brewerie` (`id_brewerie`, `adresse`, `name`) VALUES 
(1, 'adresse 1 n33', 'brewerie 1'),
(2, 'adresse 2 n34', 'brewerie 2'),
(3, 'adresse 3 35', 'brewerie 3');

INSERT INTO `beer` (`id_beer`, `alcohol`, `name`, `price`, `id_brewerie`) VALUES
 (1, '9.7%', 'beer 3', '12.90', '1'),
 (2, '9.7%', 'beer 3', '12.90', '1'),
 (3, '9.7%', 'beer 3', '12.90', '2'),
 (4, '9.7%', 'beer 3', '12.90', '2'),
 (5, '9.7%', 'beer 3', '12.90', '3'),
 (6, '9.7%', 'beer 3', '12.90', '3'),
 (7, '9.7%', 'beer 3', '12.90', '3')
 ;

INSERT INTO `wholesaler` (`id_wholesale`, `adresse`, `name`) VALUES
 (1, 'la casa de teekila', 'delecious taste'),
 (2, 'la casa de falama', 'guru drinks'),
 (3, 'la casa de mahia', 'solaymane house');

INSERT INTO `warehouse` (`id_warehouse`, `adresse`, `wholesaler_id_wholesale`) VALUES
 (1, 'la villa de aljandro', '1'),
 (2, 'la casa d nothing', '1'),
 (3, 'la cita 345', '2'),
 (4, 'street 5 n45', '2'),
 (5, 'roma de emperor', '3'),
 (6, 'la villa solaymane', '3');



