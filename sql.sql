INSERT INTO `category` (`id`, `updated_time`, `description`, `image_url`, `name`) VALUES
(1, '2016-09-26 19:56:33', 'Sun Glasses Protects Eyes from Sun. We have the products from companies who has state of the Art Technology for makin sun glasses', '/resources/images/pic1.jpg', 'Sun Glasses');

INSERT INTO `role` (`id`, `updated_time`, `name`) VALUES
(1, '2016-09-26 19:54:48', 'Admin'),
(2, '2016-09-26 19:54:48', 'Customer');

INSERT INTO `user` (`id`, `updated_time`, `password`, `password_confirm`, `username`) VALUES
(1, '2016-09-26 20:02:36', '$2a$10$wmqJtzZYRDI7ozw2mWP1Iu5lnr6pSDr3zDxGephcfSZ17NDt7gtz2', 'genious123', 'sahib.zer@gmail.com');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2);

INSERT INTO `product` (`id`, `updated_time`, `description`, `image_url`, `name`, `price`, `category_id`) VALUES
(1, '2016-09-26 19:57:46', 'Raybon is Famous Brand for Sun Glasses and loved by its users.', '/resources/images/products/pic1.jpg', 'Raybon', 100, 1);
