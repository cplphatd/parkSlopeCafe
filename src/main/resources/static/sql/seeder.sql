INSERT INTO users(username, password) VALUES ('admin', /*'paste hashed password here'*/);

INSERT INTO user_roles(role, user_id) VALUES ('ROLE_ADMIN', 1);

INSERT INTO store_status(store_is_open, decoration, message) VALUES (true, 'none', null);
