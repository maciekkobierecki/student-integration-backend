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

-- // university_degree_table
-- Migration SQL that makes the change goes here.

CREATE TABLE UNIVERSITY_DEGREES (
    ID NUMBER PRIMARY KEY,
    ACADEMY_ID NUMBER,
    NAME VARCHAR(55)
)
!RUN!

CREATE SEQUENCE DEGREES_PK_SEQ
!RUN!

CREATE OR REPLACE TRIGGER DEGREES_BIUR_TRG
  BEFORE INSERT OR UPDATE
  ON UNIVERSITY_DEGREES
  FOR EACH ROW
  BEGIN
    IF :NEW.ID IS NULL
    THEN
      SELECT DEGREES_PK_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
  END;
!RUN!

Alter table UNIVERSITY_SEMESTERS rename column SUBJECT_ID to DEGREE_ID
!RUN!

Alter table UNIVERSITY_SUBJECTS drop column ACADEMY_ID
!RUN!


CREATE SEQUENCE SEMESTER_GROUPS_PK_SEQ
!RUN!


CREATE OR REPLACE TRIGGER SEMESTER_GROUPS_BIUR_TRG
  BEFORE INSERT OR UPDATE
  ON SEMESTER_GROUPS
  FOR EACH ROW
  BEGIN
    IF :NEW.ID IS NULL
    THEN
      SELECT SEMESTER_GROUPS_PK_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
  END;
!RUN!

CREATE TABLE SEMESTERS_SUBJECTS(
    ID NUMBER PRIMARY KEY,
    SEMESTER_ID NUMBER,
    SUBJECT_ID NUMBER
)
!RUN!

CREATE SEQUENCE SEMESTERS_SUBJECTS_PK_SEQ
!RUN!

CREATE OR REPLACE TRIGGER SEMESTERS_SUBJECTS_BIUR_TRG
  BEFORE INSERT OR UPDATE
  ON SEMESTERS_SUBJECTS
  FOR EACH ROW
  BEGIN
    IF :NEW.ID IS NULL
    THEN
      SELECT SEMESTERS_SUBJECTS_PK_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
  END;
!RUN!


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE UNIVERSITY_DEGREES
!RUN!

DROP SEQUENCE DEGREES_PK_SEQ
!RUN!

Alter table UNIVERSITY_SEMESTERS rename column DEGREE_ID to SUBJECT_ID
!RUN!

Alter table UNIVERSITY_SUBJECTS ADD ACADEMY_ID NUMBER
!RUN!

DROP TABLE SEMESTERS_SUBJECTS
!RUN!

