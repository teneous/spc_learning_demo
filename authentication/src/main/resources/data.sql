/** Oauth - populate the oauth_client_details table */
INSERT INTO `oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `access_token_validity`, `additional_information`)
VALUES
('trifail', '$2a$10$HkkTyrtT52ZQf5FsrX4p4OF4Yhp52TZbLeFqmTk/P5r9Gbz.WzsNO', 'webclient', 'authorization_code,password,refresh_token,implicit', '900', '{}')
ON DUPLICATE key UPDATE
client_secret = VALUES(`client_secret`),
scope = VALUES(`scope`),
authorized_grant_types = VALUES(`authorized_grant_types`),
access_token_validity = VALUES(`access_token_validity`),
additional_information = VALUES(`additional_information`);


INSERT INTO sys_user (id, username, password,email)
 VALUES (1, 'syoka', '$2a$10$HkkTyrtT52ZQf5FsrX4p4OF4Yhp52TZbLeFqmTk/P5r9Gbz.WzsNO','kevinto@foxmail.com');