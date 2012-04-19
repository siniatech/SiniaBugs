drop table if exists SEVERITY;

create table SEVERITY (
	id BIGINT NOT NULL AUTO_INCREMENT, PRIMARY KEY(id),
	name text NOT NULL,
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT NOT NULL, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT NOT NULL, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;