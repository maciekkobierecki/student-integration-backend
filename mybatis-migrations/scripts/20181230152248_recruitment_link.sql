--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // action link
-- Migration SQL that makes the change goes here.

create table GROUP_ACTIONS(
    ID NUMBER PRIMARY KEY,
    GROUP_ID NUMBER,
    ACTIVE_FLAG NUMBER,
    VALID_FROM DATE,
    ACTION_HASH VARCHAR(512)
)
!RUN!

CREATE SEQUENCE GROUP_ACTIONS_PK_SEQ START WITH 1132521
!RUN!

CREATE OR REPLACE TRIGGER GROUP_ACTIONS_BIUR_TRG
  BEFORE INSERT OR UPDATE
  ON GROUP_ACTIONS
  FOR EACH ROW
  BEGIN
    IF :NEW.ID IS NULL
    THEN
      SELECT GROUP_ACTIONS_PK_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
  END;
!RUN!

ALTER TABLE SEMESTER_GROUPS ADD RECRUITMENT_ACTION_ID NUMBER
!RUN!

CREATE SEQUENCE USERS_GROUPS_PK_SEQ START WITH 10000
!RUN!

CREATE OR REPLACE TRIGGER USERS_GROUPS_BIUR_TRG
  BEFORE INSERT OR UPDATE
  ON USERS_GROUPS
  FOR EACH ROW
  BEGIN
    IF :NEW.ID IS NULL
    THEN
      SELECT USERS_GROUPS_PK_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
  END;
!RUN!


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE GROUP_ACTIONS
!RUN!

DROP SEQUENCE GROUP_ACTIONS_PK_SEQ
!RUN!

ALTER TABLE SEMSETER_GROUPS DROP COLUMN RECRUITMENT_ACTION_ID
!RUN!

DROP SEQUENCE USERS_GROUPS_PK_SEQ
!RUN!

