INSERT INTO users(username, password) VALUES ('admin', /*'paste hashed password here'*/);

INSERT INTO user_roles(role, user_id) VALUES ('ROLE_ADMIN', 1);

INSERT INTO store_status(store_is_open, decoration, message) VALUES (true, 'none', null);

INSERT INTO beers(category, description, is_in_stock, name, picture) VALUES
  ('Ale', 'Strong dark ale', true, 'Patrasche', 'https://cdn.filestackcontent.com/f4MsJxXrReSxIolK0Lpp'),
  ('Lambic', 'Red Ale', true, 'Duchesse de Bourgogne', 'https://cdn.filestackcontent.com/ESXcpLa4RgG9h4PQiAgE'),
  ('Fruit Beer', 'Bitter and lightly sweet', true, 'Framboise Boon', 'https://cdn.filestackcontent.com/b99UGNwcQj2BHpaq2xzB');
