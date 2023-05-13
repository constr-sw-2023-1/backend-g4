-- Insert type
INSERT INTO type VALUES ('a4b1f4b4-19b8-4cc1-b2e4-80c7d947dc24', 'Computer');
INSERT INTO type VALUES ('c8f34716-7f21-4c3d-a836-8e90520dc429', 'Monitors/Televisions');
INSERT INTO type VALUES ('8553345c-5e02-4f19-b362-f2c1844d0981', 'Sound Equipment');

-- Insert manufacturer
INSERT INTO manufacturer (id, name) VALUES ('b5371d70-d4f6-4e11-bfbb-aac4f00c2204', 'Dell');
INSERT INTO manufacturer (id, name) VALUES ('efdaecd7-4f9e-44d3-a00d-27f86c1e6fe6', 'Sony');
INSERT INTO manufacturer (id, name) VALUES ('5c5e89b1-2a32-44cd-a5be-671b49b596f9', 'Epson');
INSERT INTO manufacturer (id, name) VALUES ('e784d8b5-eede-4b00-858b-80035d32449c', 'HP');
INSERT INTO manufacturer (id, name) VALUES ('fa1497f7-0d2c-44f4-a9a3-16b6e9c16800', 'Samsung');
INSERT INTO manufacturer (id, name) VALUES ('1c77b4f4-2e0f-42d9-9948-4461c8065998', 'Samson');

-- Insert resource
INSERT INTO resource VALUES ('83d2b291-749e-4753-9653-305f371d9e39', 'Notebook Dell Vostro 3510', 'b5371d70-d4f6-4e11-bfbb-aac4f00c2204', 'a4b1f4b4-19b8-4cc1-b2e4-80c7d947dc24');
INSERT INTO resource VALUES ('a394939c-994f-4e32-bfa5-22c7e8d1d746', 'Resource 2', 'efdaecd7-4f9e-44d3-a00d-27f86c1e6fe6', 'c8f34716-7f21-4c3d-a836-8e90520dc429');
INSERT INTO resource VALUES ('9c4fac66-4575-4cbe-8909-a282b126fe57', 'Resource 3', '5c5e89b1-2a32-44cd-a5be-671b49b596f9', '8553345c-5e02-4f19-b362-f2c1844d0981');

-- Insert component
INSERT INTO component (id, component, description) VALUES ('67e679d4-01f8-4812-b1b9-6f5e6c5af6ab', 'Component A', 'Description A');
INSERT INTO component (id, component, description) VALUES ('84f3df3a-23a8-43f6-aa2a-2d1c98bb0268', 'Component B', 'Description B');
INSERT INTO component (id, component, description) VALUES ('8b02272d-0853-4c04-aa62-a24e6f08a69e', 'Component C', 'Description C');

-- Insert configuration component x resource
INSERT INTO configuration  VALUES ('31d20a72-b1a3-42c3-b1d3-fd7d2c633e31', '83d2b291-749e-4753-9653-305f371d9e39', '67e679d4-01f8-4812-b1b9-6f5e6c5af6ab');
INSERT INTO configuration  VALUES ('c436d66c-6f92-4f34-b6cb-1e0415261b07', '83d2b291-749e-4753-9653-305f371d9e39', '84f3df3a-23a8-43f6-aa2a-2d1c98bb0268');
INSERT INTO configuration  VALUES ('c8d8d036-cbda-4d28-aa71-11b9c4707c27', 'a394939c-994f-4e32-bfa5-22c7e8d1d746', '8b02272d-0853-4c04-aa62-a24e6f08a69e');
INSERT INTO configuration  VALUES ('bdf8c62e-2b03-44ba-9268-dd6ad1d7ea38', 'a394939c-994f-4e32-bfa5-22c7e8d1d746', '8b02272d-0853-4c04-aa62-a24e6f08a69e');
INSERT INTO configuration  VALUES ('2c57cd38-7b77-4b60-a3c5-5d6780a57afb', 'a394939c-994f-4e32-bfa5-22c7e8d1d746', '8b02272d-0853-4c04-aa62-a24e6f08a69e');
INSERT INTO configuration  VALUES ('63b9cca8-c244-489c-9cc6-f72dc75e12f6', '9c4fac66-4575-4cbe-8909-a282b126fe57', '8b02272d-0853-4c04-aa62-a24e6f08a69e');
