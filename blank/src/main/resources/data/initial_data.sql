INSERT INTO blank.user_auth( mail_addr, password ) VALUES ( 'admin', 'fb65cca6ac4cbff0f2c36ce93366297eb4c9e6b6992819d92b51553abcd4184d4f58aee7713a4f1a49dbc51424341c79f856cbedc59849cf9b6c12bc' );
INSERT INTO blank.user_role( user_id, role ) VALUES (1, 'admin' );
INSERT INTO blank.user_auth_sec( user_id, last_login_date ,login_failure_count ) VALUES ( 1, '1970-01-01 09:00:01', 0 );
INSERT INTO blank.onetime_key ( user_id, onetime_key, expiration_date, del_flag ) VALUES (1, '', '1970-01-01 09:00:01',1);
