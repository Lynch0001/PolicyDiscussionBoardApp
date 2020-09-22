DROP TABLE IF EXISTS discussion_comments;

DROP TABLE IF EXISTS discussion_tags;

DROP TABLE IF EXISTS comment;

DROP TABLE IF EXISTS discussion;

DROP TABLE IF EXISTS messages;

DROP TABLE IF EXISTS tags;

DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS role;

CREATE TABLE comment (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    comment_content varchar(255) NOT NULL,
    comment_timestamp datetime DEFAULT NULL,
    contributor varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE discussion (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    contributor varchar(255) DEFAULT NULL,
    discuss_content longtext NOT NULL,
    discuss_subtitle varchar(255) DEFAULT NULL,
    discuss_timestamp datetime DEFAULT NULL,
    discuss_title varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE messages (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    message_content longtext NOT NULL,
    message_timestamp datetime DEFAULT NULL,
    name varchar(255) NOT NULL,
    message_is_read bit(1) DEFAULT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE tags (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    tag varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE user (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    date_activated datetime DEFAULT NULL,
    email varchar(254) DEFAULT NULL,
    first_name varchar(50) DEFAULT NULL,
    last_login datetime DEFAULT NULL,
    last_name varchar(50) DEFAULT NULL,
    password_hash varchar(60) NOT NULL,
    roles varchar(255) DEFAULT NULL,
    username varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE discussion_tags (
       discussion_id bigint(20) NOT NULL,
       tags_id bigint(20) NOT NULL,
       PRIMARY KEY (discussion_id,tags_id),
       UNIQUE KEY UK_9pwua0u9dcv90kp39kjhem3r3 (tags_id)
);

CREATE TABLE discussion_comments (
       discussion_id bigint(20) NOT NULL,
       comments_id bigint(20) NOT NULL,
       PRIMARY KEY (discussion_id,comments_id),
       UNIQUE KEY UK_f9dral2cx1l194um20kiidkcp (comments_id)
);

CREATE TABLE role (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    role varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);
