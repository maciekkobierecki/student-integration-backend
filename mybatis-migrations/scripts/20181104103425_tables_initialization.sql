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

-- // tables initialization
-- Migration SQL that makes the change goes here.

CREATE TABLE USERS(
  ID NUMBER PRIMARY KEY,
  EMAIL VARCHAR(55),
  DISPLAY_NAME VARCHAR(55)
)
!RUN!


CREATE TABLE UNIVERSITY_SUBJECTS(
  ID NUMBER PRIMARY KEY,
  SUBJECT_NAME VARCHAR(55),
  DISPLAY_NAME VARCHAR(55),
  SUBJECT_NAME_SHORT VARCHAR(55),
  ACADEMY_ID NUMBER
)
!RUN!

CREATE TABLE ACADEMIES(
  ID NUMBER PRIMARY KEY,
  ACADEMY_NAME VARCHAR(55),
  ACADEMY_NAME_SHORT VARCHAR(55)
)
!RUN!

CREATE TABLE FILES(
  ID NUMBER PRIMARY KEY,
  CREATE_USER_ID NUMBER,
  RATING NUMBER,
  RATING_COUNT NUMBER
)
!RUN!

CREATE TABLE UNIVERSITY_SEMESTERS(
  ID NUMBER PRIMARY KEY,
  SEMESTER_NAME VARCHAR(55)
)
!RUN!

CREATE TABLE SEMESTERS_FILES(
  ID NUMBER PRIMARY KEY,
  SEMESTER_ID NUMBER,
  FILE_ID NUMBER
)
!RUN!

CREATE TABLE SUBJECTS_FILES(
  ID NUMBER PRIMARY KEY,
  SUBJECT_ID NUMBER,
  FILE_ID NUMBER
)
!RUN!


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE USERS
!RUN!

DROP TABLE UNIVERSITY_SUBJECTS
!RUN!

DROP TABLE ACADEMIES
!RUN!

DROP TABLE FILES
!RUN!

DROP TABLE UNIVERSITY_SEMESTERS
!RUN!

DROP TABLE SEMESTERS_FILES
!RUN!

DROP TABLE SUBJECTS_FILES
!RUN!