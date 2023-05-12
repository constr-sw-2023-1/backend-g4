INSERT INTO type VALUES ('a4b1f4b4-19b8-4cc1-b2e4-80c7d947dc24', 'Type A');
INSERT INTO type VALUES ('c8f34716-7f21-4c3d-a836-8e90520dc429', 'Type B');

-- Inserir alguns componentes
INSERT INTO component VALUES ('67e679d4-01f8-4812-b1b9-6f5e6c5af6ab', 'Component A', 'Description A');
INSERT INTO component VALUES ('84f3df3a-23a8-43f6-aa2a-2d1c98bb0268', 'Component B', 'Description B');

-- Inserir alguns recursos
INSERT INTO fabricante VALUES ('b5371d70-d4f6-4e11-bfbb-aac4f00c2204', 'Fabricante 1');
INSERT INTO fabricante VALUES ('efdaecd7-4f9e-44d3-a00d-27f86c1e6fe6', 'Fabricante 2');

-- Inserir alguns recursos
INSERT INTO resource VALUES ('83d2b291-749e-4753-9653-305f371d9e39', 'Resource 1', 'b5371d70-d4f6-4e11-bfbb-aac4f00c2204', 'a4b1f4b4-19b8-4cc1-b2e4-80c7d947dc24');
INSERT INTO resource VALUES ('a394939c-994f-4e32-bfa5-22c7e8d1d746', 'Resource 2', 'efdaecd7-4f9e-44d3-a00d-27f86c1e6fe6', 'c8f34716-7f21-4c3d-a836-8e90520dc429');

-- Inserir algumas configurações relacionadas aos componentes e recursos
INSERT INTO configuracao VALUES ('31d20a72-b1a3-42c3-b1d3-fd7d2c633e31', '83d2b291-749e-4753-9653-305f371d9e39', '67e679d4-01f8-4812-b1b9-6f5e6c5af6ab');
INSERT INTO configuracao VALUES ('c436d66c-6f92-4f34-b6cb-1e0415261b07', '83d2b291-749e-4753-9653-305f371d9e39', '84f3df3a-23a8-43f6-aa2a-2d1c98bb0268');
INSERT INTO configuracao VALUES ('c8d8d036-cbda-4d28-aa71-11b9c4707c27', 'a394939c-994f-4e32-bfa5-22c7e8d1d746', '67e679d4-01f8-4812-b1b9-6f5e6c5af6ab');