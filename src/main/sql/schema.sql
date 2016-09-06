CREATE DATABASE IF NOT EXISTS twt_push;

USE twt_push;

CREATE TABLE IF NOT EXISTS devices(
  device_id bigint NOT NULL AUTO_INCREMENT COMMENT 'device id',
  device_model varchar(32) COMMENT 'device model',
  device_createtime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (device_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='devices';

CREATE TABLE IF NOT EXISTS apps(
  app_id bigint NOT NULL AUTO_INCREMENT COMMENT 'app id',
  app_developer_id bigint NOT NULL COMMENT 'app developer id',
  app_key varchar(64) NOT NULL DEFAULT 'null' COMMENT 'app key',
  app_secret_key varchar(128) NOT NULL DEFAULT 'null' COMMENT 'app Secret key',
  app_name varchar(32) COMMENT 'app name',
  app_createtime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (app_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='apps';


CREATE TABLE IF NOT EXISTS developers(
  developer_id bigint NOT NULL AUTO_INCREMENT COMMENT 'developer id',
  developer_name varchar(32) COMMENT 'developer name',
  developer_email varchar(64) NOT NULL COMMENT 'developer email to login',
  developer_password varchar(64) NOT NULL COMMENT 'developer password',
  developer_token varchar(64) NOT NULL DEFAULT 'null' COMMENT 'developer token',
  developer_createtime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (developer_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='developers';


CREATE TABLE IF NOT EXISTS policies(
  policy_id bigint NOT NULL AUTO_INCREMENT COMMENT 'policy id',
  policy_name varchar(32) COMMENT 'policy name',
  app_id bigint NOT NULL COMMENT 'app id',
  policy_createtime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (policy_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='policy';


