--tb_user
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('f04f684a-797b-4d82-8805-c8887a4eface', 'Alex','Brown', '1977-07-26', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('d1e2c857-2005-4d66-a0a3-b964cc5912ed', 'Maria','Green', '1977-07-26', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('e574e274-c95c-40de-b4c3-40cd11cb7f41', 'João','Silva', '1977-07-26','joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('5ae7e6f7-99f3-48b4-9988-473acd1d2039', 'Ana','Pereira', '1977-07-26','ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES('5dc2689d-0200-4c87-8afe-9e70e89b7a37', 'Joaquim', 'Ferreira', '1977-07-26','joaquim@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);

--tb_role
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('90b81fe6-0a57-4d36-8bd5-482ec042f9cd', 'ROLE_OPERATOR', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('e5827bd6-4b5d-4e95-a416-0532601bc595', 'ROLE_STUDENT', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('ed16fe0e-b015-451d-a094-279b162ba145', 'ROLE_INSTRUCTOR', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('5de37742-540c-4751-a2c8-d6675d25ed9f', 'ROLE_ADMIN', now(), 0);

--tb_user_role_association
INSERT INTO tb_user_role_association (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role_association (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role_association (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role_association (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role_association (user_id, role_id) VALUES (2, 3);
INSERT INTO tb_user_role_association (user_id, role_id) VALUES (2, 4);

--Insert tb_category
INSERT INTO tb_product_category (code, name, created_at, status) VALUES ('442b6f9c-2d17-4657-818c-4a6597c72d31', 'Books', NOW(), 0);
INSERT INTO tb_product_category (code, name, created_at, status) VALUES ('54b84f80-b186-46a7-8689-25be6959a197', 'Eletronics', NOW(), 0);
INSERT INTO tb_product_category (code, name, created_at, status) VALUES ('d002ccbc-de3d-4025-beb4-d2ea5ae6e3c8', 'Computers', NOW(), 0);

--Insert tb_category
INSERT INTO tb_product_image (code, name, created_at, status) VALUES ('442b6f9c-2d17-4657-818c-4a6597c72d31', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg', NOW(), 0);
INSERT INTO tb_product_image (code, name, created_at, status) VALUES ('54b84f80-b186-46a7-8689-25be6959a197', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg', NOW(), 0);
INSERT INTO tb_product_image (code, name, created_at, status) VALUES ('d002ccbc-de3d-4025-beb4-d2ea5ae6e3c8', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_portuguesa.jpg', NOW(), 0);

--tb_product
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('3a973c8f-d5a5-4a0a-950f-b4e79a35a895', 'Pizza Bacon', 49.9, 'Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.', NOW(), 0);
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Pizza Moda da Casa', 59.9, 'Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.', NOW(), 0);
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('7a384618-b209-4978-b611-85e0026102e8', 'Pizza Portuguesa', 45.0, 'Pizza Portuguesa com molho especial, mussarela, presunto, ovos e especiarias.', NOW(), 0);
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('40b302b2-31ff-451f-85c2-c7a163bf41af', 'Risoto de Carne', 52.0, 'Risoto de carne com especiarias e um delicioso molho de acompanhamento.', NOW(), 0);
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('51db1297-5173-4f3d-a327-478c0101aee4', 'Risoto Funghi', 59.95, 'Risoto Funghi feito com ingredientes finos e o toque especial do chef.', NOW(), 0);
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('185eefbd-97b7-467f-8cc5-708551a70de3', 'Macarrão Espaguete',35.9, 'Macarrão fresco espaguete com molho especial e tempero da casa.', NOW(), 0);
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('9f6ccaed-9e01-43cc-8baf-9343fcd3ccb8', 'Macarrão Fusili', 38.0, 'Macarrão fusili com toque do chef e especiarias.', NOW(), 0);
INSERT INTO tb_product (code, name, price, description, created_at, status) VALUES ('946e72ea-7f99-47e3-9e9f-02cc39d09b89', 'Macarrão Penne', 37.9, 'Macarrão penne fresco ao dente com tempero especial.', NOW(), 0);

--tb_product_category_association
INSERT INTO tb_product_category_association (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category_association (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category_association (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category_association (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category_association (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category_association (product_id, category_id) VALUES (5, 2);

--tb_product_image_association
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (1, 1);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (1, 2);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (2, 1);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (3, 3);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (4, 2);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (5, 2);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (6, 3);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (7, 1);
INSERT INTO tb_product_image_association (product_id, image_id) VALUES (7, 3);

--tb_address
INSERT INTO tb_address (code, cep, street, number, district, city, uf, phone, created_at, status) VALUES('946e72ea-7f99-47e3-9e9f-02cc39d09b89', '58255-000', 'Rua Fávio Ribeiro', '192', 'Centro', 'Belém', 'PB', '83999126797', NOW(), 0);
INSERT INTO tb_address (code, cep, street, number, district, city, uf, phone, created_at, status) VALUES('946e72e5-7f99-47e3-9e9f-02cc39d09b89', '58255-000', 'Rua Fávio Ribeiro', '192', 'Centro', 'Belém', 'PB', '83999126797', NOW(), 0);

--tb_user_address_association
INSERT INTO tb_user_address_association (user_id, address_id) VALUES (1, 1);
INSERT INTO tb_user_address_association (user_id, address_id) VALUES (1, 2);


--tb_notification
INSERT INTO tb_notification (code, text, read, route, user_id, created_at, status) VALUES ('946d72ea-7f99-47e3-9e9f-02cc59d09b89', 'Primeiro feedback de tarefa: favor revisar', 'true', '/offers/1/resource/1/sections/1', 1, NOW(), 0);
INSERT INTO tb_notification (code, text, read, route, user_id, created_at, status) VALUES ('946e72ea-7f99-47e3-9e9f-02cc39d09b85', 'Segundo feedback: favor revisar', 'true', '/offers/1/resource/1/sections/1', 2, NOW(), 0);
INSERT INTO tb_notification (code, text, read, route, user_id, created_at, status) VALUES ('966e72ea-7f99-47e3-9e9f-02cc39d09b89', 'Terceiro feedback: favor revisar', 'true', '/offers/1/resource/1/sections/1', 1, NOW(), 0);


--tb_course
INSERT INTO tb_course (code, name, img_url, img_gray_url, created_at, status) VALUES('946e72ea-7f99-47e3-9e9f-02cc39d09b89', 'Bootcamp HTML', 'https://img.youtube.com/vi/yWE4L1Oa1AU/0.jpg', 'http://coursestock.com/assets/frontend/default/img/course_thumbnail_placeholder.jpg', NOW(), 0);

--tb_offer
INSERT INTO tb_offer (code, edition, start_moment, end_moment, created_at, status, course_id) VALUES('946e72ea-7f99-47e3-9e9f-02cc39d09b89', '1.0', '2020-07-14T10:00:00Z', '2020-07-14T10:00:00Z', NOW(), 0, 1);
INSERT INTO tb_offer (code, edition, start_moment, end_moment, created_at, status, course_id) VALUES('946e72ea-7f99-47e3-9e9f-02cc39d09b89', '2.0', '2020-07-14T10:00:00Z', '2020-07-14T10:00:00Z', NOW(), 0, 1);

--tb_resource
INSERT INTO tb_resource (code, title, description, position, img_url, type, offer_id, created_at, status) VALUES ('946e72ea-7f99-47e3-9e9f-02cc39d09bw9', 'Trilha HTML', 'Trilha principal do curso', 1, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 1, 1, NOW(), 0);
INSERT INTO tb_resource (code, title, description, position, img_url, type, offer_id, created_at, status) VALUES ('946e72ua-7f99-47e3-9e9f-02cc39d09b89', 'Forum', 'Tire suas dúvidas', 2, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 2, 1, NOW(), 0);
INSERT INTO tb_resource (code, title, description, position, img_url, type, offer_id, created_at, status) VALUES ('946e72ea-7f99-47e8-9e9f-02cc39d09b89', 'Lives', 'Lives exclusivas para a turma', 3, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 0, 1, NOW(), 0);

--tb_section
INSERT INTO tb_section (code, title, description, position, img_url, resource_id, prerequisite_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc39d09bw9', 'Capítulo 1','Neste capítulo vamos começar', 1, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 1, null, NOW(), 0);
INSERT INTO tb_section (code, title, description, position, img_url, resource_id, prerequisite_id, created_at, status) VALUES ('946e72ea-7f99-47e3-9e9f-02cc39d79bw9', 'Capítulo 2', 'Neste capítulo vamos continuar', 2, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 1, 1, NOW(), 0);
INSERT INTO tb_section (code, title, description, position, img_url, resource_id, prerequisite_id, created_at, status) VALUES ('946e72ea-7f99-48e3-9e9f-02cc39d09bw9', 'Capítulo 3', 'Neste capítulo vamos finalizar', 3, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 1, 2, NOW(), 0);

--tb_enrolment
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update, created_at, status) VALUES (1, 1, '2020-11-20T13:00:00Z', null, 'true', 'false', NOW(), 0);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update, created_at, status) VALUES (2, 1, '2020-11-20T13:00:00Z', null, 'true', 'false', NOW(), 0);

--tb_lesson
INSERT INTO tb_lesson (code, title, position, section_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc39d09bw9', 'Aula 1 do capítulo 1', 1, 1, NOW(), 0);
INSERT INTO tb_lesson (code, title, position, section_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc39d09bw9', 'Aula 2 do capítulo 1', 2, 1, NOW(), 0);
INSERT INTO tb_lesson (code, title, position, section_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc39d09bw9', 'Aula 3 do capítulo 1', 3, 1, NOW(), 0);
INSERT INTO tb_lesson (code, title, position, section_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc39d09bw9', 'Tarefa do capítulo 1', 4, 1, NOW(), 0);
--tb_content
INSERT INTO tb_content (id, text_content, video_url) VALUES (1, 'Material de apoio: abc', 'https://www.youtube.com/watch?v=sqbqoR-lMf8');
INSERT INTO tb_content (id, text_content, video_url) VALUES (2, 'Material de apoio: abc', 'https://www.youtube.com/watch?v=sqbqoR-lMf8');
INSERT INTO tb_content (id, text_content, video_url) VALUES (3, 'Material de apoio: abc', 'https://www.youtube.com/watch?v=sqbqoR-lMf8');
--tb_task
INSERT INTO tb_task (id, description, question_count, approval_count, weight, due_date) VALUES (4, 'Fazer um trabalho legal', 5, 4, 1.0, '2020-11-25T13:00:00Z');

--tb_lessons_done_association
INSERT INTO tb_lessons_done_association (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO tb_lessons_done_association (lesson_id, user_id, offer_id) VALUES (2, 1, 1);

--tb_deliver
INSERT INTO tb_deliver (code, url, feedback, correct_Count, lesson_id, user_id, offer_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc39d09bw9', 'https://github.com/devsuperior/bds-dslearn', 0, null, 4, 1, 1, NOW(), 0);

--tb_topic
INSERT INTO tb_topic (code, title, body, author_id, offer_id, lesson_id, created_at, status) VALUES ('946e72ea-7v99-47e3-9e9f-02cc39d09bw9','Título do tópico 1', 'Corpo do tópico 1', 1, 1, 1, NOW(), 0);
INSERT INTO tb_topic (code, title, body, author_id, offer_id, lesson_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc39d59bw9','Título do tópico 2', 'Corpo do tópico 2', 2, 1, 1, NOW(), 0);
INSERT INTO tb_topic (code, title, body, author_id, offer_id, lesson_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cc3wd09bw9','Título do tópico 3', 'Corpo do tópico 3', 2, 1, 1, NOW(), 0);
INSERT INTO tb_topic (code, title, body, author_id, offer_id, lesson_id, created_at, status) VALUES ('946e72ea-7s99-47e3-9e9f-02cq39d09bw9','Título do tópico 4', 'Corpo do tópico 4', 1, 1, 2, NOW(), 0);
INSERT INTO tb_topic (code, title, body, author_id, offer_id, lesson_id, created_at, status) VALUES ('946e72et-7s99-47e3-9e9f-02cc39d09bw9','Título do tópico 5', 'Corpo do tópico 5', 1, 1, 2, NOW(), 0);
INSERT INTO tb_topic (code, title, body, author_id, offer_id, lesson_id, created_at, status) VALUES ('986e72ea-7s99-47e3-9e9f-02cc39d09bw9','Título do tópico 6', 'Corpo do tópico 6', 2, 1, 3, NOW(), 0);

--tb_topic_likes_association
INSERT INTO tb_topic_likes_association (topic_id, user_id) VALUES (1, 2);
INSERT INTO tb_topic_likes_association (topic_id, user_id) VALUES (2, 1);

--tb_reply
INSERT INTO tb_reply (code, body, topic_id, author_id, created_at, status) VALUES ('946e72ea-7y99-47e3-9e9f-02cc39d09bw9','Tente reiniciar o computador', 1, 2, NOW(), 0);
INSERT INTO tb_reply (code, body, topic_id, author_id, created_at, status) VALUES ('946e72ea-7s99-87e3-9e9f-02cc39d09bw9','Deu certo, valeu!', 1, 1, NOW(), 0);

--tb_reply_likes_association
INSERT INTO tb_reply_likes_association (reply_id, user_id) VALUES (1, 1);

--tb_aset
INSERT INTO tb_seat (name) VALUES ('C4');
INSERT INTO tb_seat (name) VALUES ('G4');
INSERT INTO tb_seat (name) VALUES ('K9');
INSERT INTO tb_seat (name) VALUES ('K8');

--tb_client
INSERT INTO tb_client (name, seat_id) VALUES ('Claudio Cadoso', 1);
INSERT INTO tb_client (name, seat_id) VALUES ('Gorete Cadoso', 2);
INSERT INTO tb_client (name, seat_id) VALUES ('Kaike Cadoso', 3);
INSERT INTO tb_client (name, seat_id) VALUES ('Kevin Cadoso', 4);
