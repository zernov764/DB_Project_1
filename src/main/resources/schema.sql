DROP TABLE IF EXISTS STUDENTS;
CREATE TABLE STUDENTS(ID BIGINT PRIMARY KEY, SURNAME VARCHAR(255), NAME VARCHAR(255), MIDDLENAME VARCHAR(255));

DROP TABLE IF EXISTS GROUPS;
CREATE TABLE GROUPS(ID BIGINT PRIMARY KEY, NUMBER VARCHAR(255), ENTRANCE VARCHAR(255));

DROP TABLE IF EXISTS COURSES;
CREATE TABLE COURSES(ID BIGINT PRIMARY KEY, NAME VARCHAR(255));

DROP TABLE IF EXISTS GRADES;
CREATE TABLE GRADES(ID BIGINT PRIMARY KEY, GRADE VARCHAR(255));

create table student_courses_grade(
    student_id bigint references students(id) on delete cascade,
    course_id bigint references courses(id),
    grade_id bigint references  grades(id),
    primary key (student_id, course_id, grade_id)
);

create table group_students(
    group_id bigint references groups(id) on delete cascade,
    student_id bigint references students(id),
    primary key (group_id, student_id)
);