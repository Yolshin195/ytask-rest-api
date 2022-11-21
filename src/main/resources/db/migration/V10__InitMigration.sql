CREATE TABLE yt_role (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   updated_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   deleted_by VARCHAR(255),
   name VARCHAR(255),
   CONSTRAINT pk_yt_role PRIMARY KEY (id)
);


CREATE TABLE yt_user (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   updated_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   deleted_by VARCHAR(255),
   active BOOLEAN,
   username VARCHAR(255),
   login VARCHAR(255),
   password VARCHAR(255),
   phone VARCHAR(255),
   email VARCHAR(255),

   CONSTRAINT pk_yt_user PRIMARY KEY (id)
);


CREATE TABLE yt_task (
  id UUID NOT NULL,
   parent_id UUID,
   level_ INT,
   children_ BOOLEAN,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   updated_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   deleted_by VARCHAR(255),
   title VARCHAR(255),
   description VARCHAR(255),
   author_id UUID,
   task_status INT,
   CONSTRAINT pk_yt_task PRIMARY KEY (id)
);


CREATE TABLE yt_provide_access_task (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   updated_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   deleted_by VARCHAR(255),
   user_id UUID,
   task_id UUID,
   CONSTRAINT pk_yt_provide_access_task PRIMARY KEY (id)
);

ALTER TABLE yt_provide_access_task ADD CONSTRAINT FK_YT_PROVIDE_ACCESS_TASK_ON_TASK FOREIGN KEY (task_id) REFERENCES yt_task (id);

ALTER TABLE yt_provide_access_task ADD CONSTRAINT FK_YT_PROVIDE_ACCESS_TASK_ON_USER FOREIGN KEY (user_id) REFERENCES yt_user (id);


CREATE TABLE yt_timer (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   updated_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   deleted_by VARCHAR(255),
   begin_time TIMESTAMP,
   end_time TIMESTAMP,
   task_id UUID,
   CONSTRAINT pk_yt_timer PRIMARY KEY (id)
);

ALTER TABLE yt_timer ADD CONSTRAINT FK_YT_TIMER_ON_TASK FOREIGN KEY (task_id) REFERENCES yt_task (id);

CREATE TABLE yt_app_user_role (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   updated_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   deleted_by VARCHAR(255),
   app_user_id UUID,
   app_role VARCHAR(255),
   CONSTRAINT pk_yt_app_user_role PRIMARY KEY (id)
);

ALTER TABLE yt_app_user_role ADD CONSTRAINT FK_YT_APP_USER_ROLE_ON_APP_USER FOREIGN KEY (app_user_id) REFERENCES yt_user (id);


insert into yt_user (id, create_ts, created_by, update_ts, updated_by, delete_ts, deleted_by, version, active, username, login, password, phone, email)
    values ('75e4fb2c-be55-4840-8e10-f5632b669d5e', current_timestamp, null, null, null, null, null, 1, true, 'alexey', 'alexey', '$2a$12$azzBGRnGFSray1x/H0kczOa9f9ca1kcCYpdqMsJ10UKZcN8.B7LV6', null, null);

insert into yt_app_user_role (id, create_ts, created_by, update_ts, updated_by, delete_ts, deleted_by, version, app_role, app_user_id)
    values ('c011c59e-a075-4e58-a070-3e66f14fa7d2', current_timestamp, null, null, null, null, null, 1, 'ROLE_ADMIN', '75e4fb2c-be55-4840-8e10-f5632b669d5e');

commit;