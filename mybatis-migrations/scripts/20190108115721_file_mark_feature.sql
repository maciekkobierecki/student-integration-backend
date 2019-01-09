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

-- // file_mark_feature
-- Migration SQL that makes the change goes here.
create table FILES_MARKS(
ID NUMBER PRIMARY KEY,
FILE_ID NUMBER,
USER_ID NUMBER,
CONSTRAINT constraint_name UNIQUE (FILE_ID, USER_ID)
)
!RUN!

CREATE SEQUENCE FILES_MARKS_PK_SEQ
!RUN!

CREATE OR REPLACE TRIGGER FILES_MARKS_BIUR_TRG
  BEFORE INSERT OR UPDATE
  ON FILES_MARKS
  FOR EACH ROW
  BEGIN
    IF :NEW.ID IS NULL
    THEN
      SELECT FILES_MARKS_PK_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
  END;
!RUN!
-- //@UNDO
-- SQL to undo the change goes here.
drop table FILES_MARKS
!RUN!


