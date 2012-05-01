
drop table if exists ISSUE;

create table ISSUE (
	id BIGINT NOT NULL AUTO_INCREMENT, PRIMARY KEY(id),
	uid BIGINT NOT NULL,
	name text,
	assigned_to_id BIGINT, FOREIGN KEY (assigned_to_id) REFERENCES BUGS_USER(id),
	project_id BIGINT, FOREIGN KEY (project_id) REFERENCES PROJECT(id),
	release_id BIGINT, FOREIGN KEY (release_id) REFERENCES RELEASE_RELEASE(id),
	estimate DOUBLE,
	done DOUBLE,
	description blob,
	priority_id BIGINT, FOREIGN KEY (priority_id) REFERENCES PRIORITY(id),
	severity_id BIGINT, FOREIGN KEY (severity_id) REFERENCES SEVERITY(id),
	issue_type_id BIGINT, FOREIGN KEY (issue_type_id) REFERENCES ISSUE_TYPE(id),
	issue_status_id BIGINT, FOREIGN KEY (issue_status_id) REFERENCES ISSUE_STATUS(id),
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;

create table ISSUE_HISTORY (
	uid BIGINT NOT NULL, PRIMARY KEY(uid),
	id BIGINT NOT NULL,
	name text,
	assigned_to_id BIGINT, FOREIGN KEY (assigned_to_id) REFERENCES BUGS_USER(id),
	project_id BIGINT, FOREIGN KEY (project_id) REFERENCES PROJECT(id),
	release_id BIGINT, FOREIGN KEY (release_id) REFERENCES RELEASE_RELEASE(id),
	estimate DOUBLE,
	done DOUBLE,
	description blob,
	priority_id BIGINT, FOREIGN KEY (priority_id) REFERENCES PRIORITY(id),
	severity_id BIGINT, FOREIGN KEY (severity_id) REFERENCES SEVERITY(id),
	issue_type_id BIGINT, FOREIGN KEY (issue_type_id) REFERENCES ISSUE_TYPE(id),
	issue_status_id BIGINT, FOREIGN KEY (issue_status_id) REFERENCES ISSUE_STATUS(id),
	start TIMESTAMP NOT NULL,
	end TIMESTAMP NULL DEFAULT NULL,
	created_by_id BIGINT, FOREIGN KEY (created_by_id) REFERENCES BUGS_USER(id),
	edited_by_id BIGINT, FOREIGN KEY (edited_by_id) REFERENCES BUGS_USER(id)
) ENGINE=InnoDB;