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

-- // semester_groups_tables
-- Migration SQL that makes the change goes here.

CREATE TABLE SEMESTER_GROUPS(
ID NUMBER PRIMARY KEY,
NAME VARCHAR(55),
SEMESTER_ID NUMBER
)
!RUN!

CREATE TABLE USERS_GROUPS(
USER_ID NUMBER,
GROUP_ID NUMBER
)
!RUN!


-- //@UNDO
-- SQL to undo the change goes here.


DROP TABLE SEMESTER_GROUPS
!RUN!

DROP TABLE USERS_GROUPS
!RUN!