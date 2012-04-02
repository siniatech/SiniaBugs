
drop table if exists ISSUE;

create table ISSUE (
	id BIGINT NOT NULL AUTO_INCREMENT, PRIMARY KEY(id),
	title text,
	description text
) ENGINE=InnoDB;