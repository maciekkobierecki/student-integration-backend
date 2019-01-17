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

-- // hashtags_feature
-- Migration SQL that makes the change goes here.

create table SUBJECT_COMMENTS (
    ID NUMBER PRIMARY KEY,
    SUBJECT_ID NUMBER,
    CONTENT VARCHAR(512),
    CREATE_USER_ID NUMBER,
    IS_ANONYMOUS NUMBER,
    CREATE_DATE DATE
)
!RUN!


CREATE SEQUENCE SUBJECT_COMMENTS_PK_SEQ
!RUN!

CREATE OR REPLACE TRIGGER SUBJECT_COMMENTS_BIUR_TRG
  BEFORE INSERT OR UPDATE
  ON SUBJECT_COMMENTS
  FOR EACH ROW
  BEGIN
    IF :NEW.ID IS NULL
    THEN
      SELECT SUBJECT_COMMENTS_PK_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
  END;
!RUN!


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE SUBJECT_COMMENTS
!RUN!

DROP SEQUENCE SUBJECT_COMMENTS_PK_SEQ
!RUN!
