insert into students (id, surname, name, middleName)
values (1, 'Ivanov', 'Fyodor', 'Mikhailovich'), (2, 'Petrov', 'Stepan', 'Nikolayevich'),
       (3, 'Sidorov', 'Vecheslav', 'Grigoryevich'), (4, 'Romanov', 'Dmitriy', 'Konstantinovich'),
       (5, 'Gromov', 'Artyom', 'Stepanovich'), (6, 'Dmitriev', 'Maksim', 'Alekseevich'),
       (7, 'Maksimenko', 'Georgiy', 'Fyodorovich'), (8, 'Chernov', 'Nikita', 'Evgenievich'),
       (9, 'Tulikov', 'Nikita', 'Sergeevich');

insert into groups (id, number, entrance)
values (1, '9', '2018'), (2, '13', '2018'), (3, '6', '2018');

insert into courses (id, name)
values (1, 'economics'), (2, 'programming'), (3, 'english');

insert into grades (id, grade)
values (1, '1'), (2, '2'), (3, '3'), (4, '4'), (5, '5');

insert into student_courses_grade(student_id, course_id, grade_id)
values (1, 1, 5),   (1, 2, 4),   (1, 3, 5),
       (2, 1, 4),   (2, 2, 4),   (2, 3, 4),
       (3, 1, 5),   (3, 2, 3),   (3, 3, 5),
       (4, 1, 5),   (4, 2, 5),   (4, 3, 5),
       (5, 1, 4),   (5, 2, 5),   (5, 3, 5),
       (6, 1, 4),   (6, 2, 3),   (6, 3, 2),
       (7, 1, 2),   (7, 2, 3),   (7, 3, 4),
       (8, 1, 5),   (8, 2, 5),   (8, 3, 5),
       (9, 1, 3),   (9, 2, 4),   (9, 3, 3);

insert into group_students(group_id, student_id)
values (1, 1),   (1, 2),   (1, 3),
       (2, 4),   (2, 5),   (2, 6),
       (3, 7),   (3, 8),   (3, 9);