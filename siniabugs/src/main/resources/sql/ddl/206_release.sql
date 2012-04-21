drop table if exists PROJECT_RELEASE;

create table PROJECT_RELEASE (
	id BIGINT NOT NULL AUTO_INCREMENT, PRIMARY KEY(id),
	uid BIGINT NOT NULL,
	name text NOT NULL,
	release_start TIMESTAMP NULL,
	release_end TIMESTAMP NULL,
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT NOT NULL, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT NOT NULL, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;

create table PROJECT_RELEASE_HISTORY (
	uid BIGINT NOT NULL, PRIMARY KEY(uid),
	id BIGINT NOT NULL,
	name text NOT NULL,
	release_start TIMESTAMP NULL,
	release_end TIMESTAMP NULL,
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT NOT NULL, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT NOT NULL, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;