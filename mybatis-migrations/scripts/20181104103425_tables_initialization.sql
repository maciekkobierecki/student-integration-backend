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

CREATE TABLE ACADEMIES(
  ID NUMBER PRIMARY KEY,
  ACADEMY_NAME VARCHAR(55),
  ACADEMY_NAME_SHORT VARCHAR(55)
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

CREATE TABLE UNIVERSITY_SEMESTERS(
  ID NUMBER PRIMARY KEY,
  SUBJECT_ID NUMBER,
  SEMESTER_NUMBER NUMBER
)
!RUN!

CREATE TABLE SEMESTER_GROUPS(
  ID NUMBER PRIMARY KEY,
  GROUP_NAME VARCHAR(55),
  CREATE_USER_ID NUMBER,
  SEMESTER_ID VARCHAR(55)
)
!RUN!

CREATE TABLE USERS_GROUPS(
  ID NUMBER PRIMARY KEY,
  USER_ID NUMBER,
  GROUP_ID NUMBER
)
!RUN!

CREATE TABLE USERS(
  ID NUMBER PRIMARY KEY,
  EMAIL VARCHAR(55),
  DISPLAY_NAME VARCHAR(55)
)
!RUN!

CREATE TABLE FILES(
  ID NUMBER PRIMARY KEY,
  FILENAME VARCHAR(55),
  DESCRIPTION VARCHAR(255),
  URL VARCHAR(255),
  RATING NUMBER,
  RATING_COUNT NUMBER,
  CREATE_USER_ID NUMBER,
  CREATE_DATE DATE
)
!RUN!


CREATE TABLE SEMESTERS_FILES(
  ID NUMBER PRIMARY KEY,
  SEMESTER_ID NUMBER,
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

DROP TABLE SEMESTER_GROUPS
!RUN!

DROP TABLE USERS_GROUPS
!RUN!