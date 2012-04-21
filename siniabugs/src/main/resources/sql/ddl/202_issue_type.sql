drop table if exists ISSUE_TYPE;

create table ISSUE_TYPE (
	id BIGINT NOT NULL AUTO_INCREMENT, PRIMARY KEY(id),
	uid BIGINT NOT NULL,
	short_code text NOT NULL,
	name text NOT NULL,
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT NOT NULL, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT NOT NULL, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;

create table ISSUE_TYPE_HISTORY (
	uid BIGINT NOT NULL, PRIMARY KEY(uid),
	id BIGINT NOT NULL,
	short_code text NOT NULL,
	name text NOT NULL,
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT NOT NULL, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT NOT NULL, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;