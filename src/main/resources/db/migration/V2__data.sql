-- Добавляем city
INSERT INTO city (name) values ('Moscow');
INSERT INTO city (name) values ('Ufa');
INSERT INTO city (name) values ('Sochi');

-- Добавляем департаменты
INSERT INTO department (name) values ('IT');
INSERT INTO department (name) values ('Managment');
INSERT INTO department (name) values ('HR');

-- Добавляем пользователей
INSERT INTO user_local (login, first_name, last_name, middle_name, date_of_birth, date_of_employment, department_id)
                        values ('ivan@mail.ru','Ivan','Ivanovich', 'Ivanov', '01-01-2022', '01-01-2022',  1);
INSERT INTO user_local (login, first_name, last_name, middle_name, date_of_birth, date_of_employment, department_id)
                        values ('fedor@mail.ru','Fedor','Fedorov', 'Fedorov', '01-01-2022', '06-07-2020', 2);
INSERT INTO user_local (login, first_name, last_name, middle_name, date_of_birth, date_of_employment, department_id)
                        values ('vasya@mail.ru','Vasiliy','Petr', 'Sergeevich', '01-01-2022', '02-04-2018', 2);
INSERT INTO user_local (login, first_name, last_name, middle_name, date_of_birth, date_of_employment, department_id)
                        values ('maksim@mail.ru','Maksim','Ivanovich', 'Andreevich','01-01-2022', '07-09-2021', 3);

