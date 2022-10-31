CREATE TABLE yt_role (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   update_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   delete_by VARCHAR(255),
   name VARCHAR(255),
   CONSTRAINT pk_yt_role PRIMARY KEY (id)
);


CREATE TABLE yt_user (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   update_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   delete_by VARCHAR(255),
   active BOOLEAN,
   username VARCHAR(255),
   login VARCHAR(255),
   password VARCHAR(255),
   phone VARCHAR(255),
   email VARCHAR(255),
   role_id UUID,
   CONSTRAINT pk_yt_user PRIMARY KEY (id)
);

ALTER TABLE yt_user ADD CONSTRAINT FK_YT_USER_ON_ROLE FOREIGN KEY (role_id) REFERENCES yt_role (id);


CREATE TABLE yt_task (
  id UUID NOT NULL,
   parent_id UUID,
   level_ INT,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   update_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   delete_by VARCHAR(255),
   title VARCHAR(255),
   description VARCHAR(255),
   author_id UUID,
   task_status INT,
   CONSTRAINT pk_yt_task PRIMARY KEY (id)
);

ALTER TABLE yt_task ADD CONSTRAINT FK_YT_TASK_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES yt_user (id);


CREATE TABLE yt_provide_access_task (
  id UUID NOT NULL,
   create_ts TIMESTAMP,
   created_by VARCHAR(255),
   update_ts TIMESTAMP,
   update_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   delete_by VARCHAR(255),
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
   update_by VARCHAR(255),
   version INT,
   delete_ts TIMESTAMP,
   delete_by VARCHAR(255),
   begin_time TIMESTAMP,
   end_time TIMESTAMP,
   task_id UUID,
   CONSTRAINT pk_yt_timer PRIMARY KEY (id)
);

ALTER TABLE yt_timer ADD CONSTRAINT FK_YT_TIMER_ON_TASK FOREIGN KEY (task_id) REFERENCES yt_task (id);