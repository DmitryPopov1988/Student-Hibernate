DROP TABLE IF EXISTS  users;
DROP TABLE IF EXISTS  authorities;
DROP TABLE IF EXISTS  student;
DROP TABLE IF EXISTS  subject;
DROP TABLE IF EXISTS  subject_student;

CREATE TABLE IF NOT EXISTS users (
  id BIGINT not null PRIMARY KEY,
	username varchar(500) not null,
	password varchar(500) not null,
	authority varchar(500) not null,
	enabled boolean not null,
	user_id BIGINT
);

CREATE TABLE IF NOT EXISTS student (
  id BIGINT not null PRIMARY KEY,
	first_name varchar(500) not null,
	last_name varchar(500) not null,
	student_group INT not null,
	faculty varchar(500) not null,
	age BIGINT not null,
	image BLOB
);

CREATE TABLE IF NOT EXISTS subject (
  id BIGINT not null PRIMARY KEY,
	name_subject varchar(500) not null,
);

CREATE TABLE IF NOT EXISTS subject_student (
  students_id BIGINT not null,
	subjects_id BIGINT not null
);



