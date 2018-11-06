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

-- // sequences for ids generation
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE USERS_SEQ
!RUN!
CREATE SEQUENCE ACADEMIES_SEQ
!RUN!
CREATE SEQUENCE FILES_SEQ
!RUN!
CREATE SEQUENCE SEMESTERS_SEQ
!RUN!
CREATE SEQUENCE SUBJECTS_SEQ
!RUN!
CREATE SEQUENCE UNIVERSITY_SEMESTERS_SEQ
!RUN!
CREATE SEQUENCE UNIVERSITY_SUBJECTS_SEQ
!RUN!

-- //@UNDO
-- SQL to undo the change goes here.


DROP SEQUENCE USERS_SEQ
!RUN!
DROP SEQUENCE ACADEMIES_SEQ
!RUN!
DROP SEQUENCE FILES_SEQ
!RUN!
DROP SEQUENCE SEMESTERS_SEQ
!RUN!
DROP SEQUENCE SUBJECTS_SEQ
!RUN!
DROP SEQUENCE UNIVERSITY_SEMESTERS_SEQ
!RUN!
DROP SEQUENCE UNIVERSITY_SUBJECTS_SEQ
!RUN!
