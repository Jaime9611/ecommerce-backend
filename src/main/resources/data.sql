-- Inventory --
insert into product_inventory (id, quantity) values ('efb68b1a-4f15-4e04-89c6-f29900cef1e4', 30);
insert into product_inventory (id, quantity) values ('60c01f4e-2151-4594-ab8f-066ebf2fcd27', 18);
insert into product_inventory (id, quantity) values ('b5cf8f93-d5d8-47f0-ac2a-1a9acc354b1f', 20);
insert into product_inventory (id, quantity) values ('dabb6c4e-ad19-41e5-8588-158a8c56b8b2', 38);
insert into product_inventory (id, quantity) values ('e3d5c118-1406-4b0d-811a-da9bbde453a7', 70);
insert into product_inventory (id, quantity) values ('e3d5c118-1406-4b0d-823a-da9bbde453a7', 20);
insert into product_inventory (id, quantity) values ('e3d5c118-1406-4b0d-824b-da9bbde453a7', 70);
insert into product_inventory (id, quantity) values ('e3d5c118-1406-4b0d-834c-da9bbde453a7', 10);
insert into product_inventory (id, quantity) values ('e3d5c118-1406-4b0d-234d-da9bbde453a7', 4);
insert into product_inventory (id, quantity) values ('e3d5c118-1406-4b0d-235e-da9bbde453a7', 30);

-- Categories ---
insert into product_category (id, name) values ('ffd0ea19-c644-45d2-911d-0916acabbfa4', 'Shirt');
insert into product_category (id, name) values ('48f21556-01ab-496f-a1e1-2fe6580fa7e5', 'Jackets');
insert into product_category (id, name) values ('ff5c53e5-d7e9-4e8a-88f5-1b799d1e6416', 'Socks');
insert into product_category (id, name) values ('d8bfc15f-01e4-4be3-9439-da95799f4b42', 'Shoes');
insert into product_category (id, name) values ('548ce698-3eac-4bfe-ad05-f6aff90267c9', 'Pants');
insert into product_category (id, name) values ('06e6e098-dfb2-4624-b014-3531f6da7d2a', 'Suits');

-- Products --
insert into product (id, name, description, price, image_url, inventory_id) values ('d2e883f2-1de9-4317-822a-a90ea04064b8', 'Cool Shirt', 'quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie', 353.56, 'https://images.unsplash.com/photo-1576566588028-4147f3842f27?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fHNoaXJ0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60', 'efb68b1a-4f15-4e04-89c6-f29900cef1e4');
insert into product (id, name, description, price, image_url, inventory_id) values ('623dd52f-e91e-4ff3-bc4f-e10ccd1fe028', 'Eagle Shirt', 'sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim', 384.18, 'https://images.unsplash.com/photo-1636954935833-80bdb8d2fcb2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80', '60c01f4e-2151-4594-ab8f-066ebf2fcd27');
insert into product (id, name, description, price, image_url, inventory_id) values ('86227d68-3d99-4717-acdd-bbf05d930c45', 'Retro Shoes', 'nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius', 35.2, 'https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8c2hvZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60', 'b5cf8f93-d5d8-47f0-ac2a-1a9acc354b1f' );
insert into product (id, name, description, price, image_url, inventory_id) values ('16eba84b-3949-4771-92aa-edf0159f5316', 'Running Shoes', 'libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum', 39.86, 'https://images.unsplash.com/photo-1600185365926-3a2ce3cdb9eb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=725&q=80', 'dabb6c4e-ad19-41e5-8588-158a8c56b8b2');
insert into product (id, name, description, price, image_url, inventory_id) values ('53822de6-0410-452d-a768-d02063b0ee0b', 'Christmas Socks', 'faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus', 396.42, 'https://images.unsplash.com/photo-1582966772680-860e372bb558?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80', 'e3d5c118-1406-4b0d-811a-da9bbde453a7');
insert into product (id, name, description, price, image_url, inventory_id) values ('124fe7b7-9d7b-46a4-9311-1d64693c1390', 'Light Blue Jeans', 'eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse', 288.47, 'https://images.unsplash.com/photo-1584370848010-d7fe6bc767ec?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80', 'e3d5c118-1406-4b0d-823a-da9bbde453a7');
insert into product (id, name, description, price, image_url, inventory_id) values ('5ae927b2-dacf-4990-a7f4-92b072e373e1', 'Slim Jeans', 'luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa', 413.69, 'https://images.unsplash.com/photo-1473966968600-fa801b869a1a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8cGFudHN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60', 'e3d5c118-1406-4b0d-824b-da9bbde453a7');
insert into product (id, name, description, price, image_url, inventory_id) values ('42108f6e-3d74-4561-9858-451bcb742a61', 'Kingsman Suit', 'felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio', 353.18, 'https://images.unsplash.com/photo-1594938298603-c8148c4dae35?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8c3VpdHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60', 'e3d5c118-1406-4b0d-834c-da9bbde453a7');
insert into product (id, name, description, price, image_url, inventory_id) values ('ae0cf316-1091-467a-bf7d-03083c436aea', 'Elegant Green Suit', 'ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed', 306.39, 'https://images.unsplash.com/photo-1593032465175-481ac7f401a0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60', 'e3d5c118-1406-4b0d-234d-da9bbde453a7');
insert into product (id, name, description, price, image_url, inventory_id) values ('c57179b7-8db2-442a-afdd-737238625764', 'Jean Jacket', 'nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent', 203.18, 'https://images.unsplash.com/photo-1611312449408-fcece27cdbb7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=369&q=80', 'e3d5c118-1406-4b0d-235e-da9bbde453a7');

-- Product & Category --
insert into products_categories (category_id, product_id) values ('ffd0ea19-c644-45d2-911d-0916acabbfa4', 'd2e883f2-1de9-4317-822a-a90ea04064b8');
insert into products_categories (category_id, product_id) values ('ffd0ea19-c644-45d2-911d-0916acabbfa4', '623dd52f-e91e-4ff3-bc4f-e10ccd1fe028');
insert into products_categories (category_id, product_id) values ('d8bfc15f-01e4-4be3-9439-da95799f4b42', '86227d68-3d99-4717-acdd-bbf05d930c45');
insert into products_categories (category_id, product_id) values ('d8bfc15f-01e4-4be3-9439-da95799f4b42', '16eba84b-3949-4771-92aa-edf0159f5316');
insert into products_categories (category_id, product_id) values ('548ce698-3eac-4bfe-ad05-f6aff90267c9', '124fe7b7-9d7b-46a4-9311-1d64693c1390');
insert into products_categories (category_id, product_id) values ('548ce698-3eac-4bfe-ad05-f6aff90267c9', '5ae927b2-dacf-4990-a7f4-92b072e373e1');
insert into products_categories (category_id, product_id) values ('06e6e098-dfb2-4624-b014-3531f6da7d2a', '42108f6e-3d74-4561-9858-451bcb742a61');
insert into products_categories (category_id, product_id) values ('06e6e098-dfb2-4624-b014-3531f6da7d2a', 'ae0cf316-1091-467a-bf7d-03083c436aea');
insert into products_categories (category_id, product_id) values ('48f21556-01ab-496f-a1e1-2fe6580fa7e5', 'ae0cf316-1091-467a-bf7d-03083c436aea');
insert into products_categories (category_id, product_id) values ('48f21556-01ab-496f-a1e1-2fe6580fa7e5', 'c57179b7-8db2-442a-afdd-737238625764');