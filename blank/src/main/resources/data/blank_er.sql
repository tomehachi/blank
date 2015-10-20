SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS login_history;
DROP TABLE IF EXISTS onetime_key;
DROP TABLE IF EXISTS user_auth_sec;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS user_auth;




/* Create Tables */

-- ログイン試行履歴
CREATE TABLE login_history
(
	login_history_id int unsigned NOT NULL AUTO_INCREMENT COMMENT '履歴ID',
	try_date timestamp NOT NULL COMMENT '試行日時',
	user_id int unsigned COMMENT 'ユーザID',
	input_mail_addr varchar(128) COMMENT '入力されたメールアドレス',
	ip_addr varchar(64) NOT NULL COMMENT 'IPアドレス',
	login_success boolean DEFAULT '1' NOT NULL COMMENT 'ログイン成功',
	PRIMARY KEY (login_history_id)
) COMMENT = 'ログイン試行履歴';


-- ワンタイム認証キー情報
CREATE TABLE onetime_key
(
	user_id int unsigned NOT NULL COMMENT 'ユーザID',
	onetime_key varchar(128) NOT NULL COMMENT 'ワンタイム認証キー',
	expiration_date timestamp NOT NULL COMMENT 'ワンタイム認証キー有効期限',
	del_flag boolean DEFAULT '0' NOT NULL COMMENT '削除フラグ',
	PRIMARY KEY (user_id),
	UNIQUE (onetime_key)
) COMMENT = 'ワンタイム認証キー情報';


-- ユーザ認証情報
CREATE TABLE user_auth
(
	user_id int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ユーザID',
	mail_addr varchar(128) NOT NULL COMMENT 'メールアドレス',
	password varchar(256) NOT NULL COMMENT 'パスワード',
	del_flag boolean DEFAULT '0' NOT NULL COMMENT '削除フラグ',
	PRIMARY KEY (user_id),
	UNIQUE (mail_addr)
) COMMENT = 'ユーザ認証情報';


-- 認証セキュリティ情報
CREATE TABLE user_auth_sec
(
	user_id int unsigned NOT NULL COMMENT 'ユーザID',
	last_login_date timestamp COMMENT '最終ログイン日時',
	login_failure_count int unsigned DEFAULT 0 COMMENT 'ログイン失敗回数',
	PRIMARY KEY (user_id)
) COMMENT = '認証セキュリティ情報';


-- ユーザロール
CREATE TABLE user_role
(
	user_id int unsigned NOT NULL COMMENT 'ユーザID',
	role enum('admin', 'user') NOT NULL COMMENT 'ロール',
	PRIMARY KEY (user_id, role)
) COMMENT = 'ユーザロール';



/* Create Foreign Keys */

ALTER TABLE onetime_key
	ADD FOREIGN KEY (user_id)
	REFERENCES user_auth (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_auth_sec
	ADD FOREIGN KEY (user_id)
	REFERENCES user_auth (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE login_history
	ADD FOREIGN KEY (user_id)
	REFERENCES user_auth (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_role
	ADD FOREIGN KEY (user_id)
	REFERENCES user_auth (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



