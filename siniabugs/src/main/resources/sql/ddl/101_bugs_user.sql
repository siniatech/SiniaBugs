drop table if exists BUGS_USER;

create table BUGS_USER (
	id BIGINT NOT NULL AUTO_INCREMENT, PRIMARY KEY(id),
	uid BIGINT NOT NULL,  
	first_name text NOT NULL,
	surname text NOT NULL,
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT NOT NULL, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT NOT NULL, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;

drop table if exists BUGS_USER_HISTORY;

create table BUGS_USER_HISTORY (
	uid BIGINT NOT NULL, PRIMARY KEY(uid),
	id BIGINT NOT NULL,
	first_name text NOT NULL,
	surname text NOT NULL,
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NOT NULL,
	created_by_id BIGINT NOT NULL, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT NOT NULL, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;