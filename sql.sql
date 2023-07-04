 6_Создание диаграммы классов:
   - Родительский класс: class Animal
   - Дочерние классы домашних животных: class Dog extends Animal, class Cat extends Animal, class Hamster extends Animal
   - Дочерние классы вьючных животных: class Horse extends Animal, class Camel extends Animal, class Donkey extends Animal

7. Создание базы данных "Друзья человека":
   - Подключение к MySQL:
    mysql -u max_vert_linux -p
   - Создание базы данных: 
   CREATE DATABASE Друзья_человека;

8. Создание таблиц:
   - Создание таблицы для домашних животных: 
   CREATE TABLE Домашние_животные (animal_id INT PRIMARY KEY, name VARCHAR(50), command VARCHAR(50), birthdate DATE);
   - Создание таблицы для вьючных животных:
    CREATE TABLE Вьючные_животные (animal_id INT PRIMARY KEY, name VARCHAR(50), command VARCHAR(50), birthdate DATE);

9. Заполнение таблиц данными:
   - Вставка записей в таблицу домашних животных:
    INSERT INTO Домашние_животные (animal_id, name, command, birthdate) VALUES (1, 'собака', 'вуф', '2020-01-01'), (2, 'кошка', 'мяф', '2019-03-15'), (3, 'хомяк', 'втф?', '2022-06-10');
   - Вставка записей в таблицу вьючных животных: 
   INSERT INTO Вьючные_животные (animal_id, name, command, birthdate) VALUES (1, 'лошадь', 'цок', '2018-11-20'), (2, 'верблюд', 'noCom', '2020-05-05'), (3, 'осел', 'гаральд! шрек! осел!)', '2021-09-07');

10. Удаление верблюдов из таблицы и объединение таблиц:
    - Удаление записей о верблюдах:
     DELETE FROM Вьючные_животные WHERE name = 'верблюд';
    - Объединение таблиц лошадей и ослов: 
    CREATE TABLE Лошади_и_ослы SELECT * FROM Вьючные_животные WHERE name IN ('лошадь', 'осел');

11. Создание таблицы "молодые животные" и подсчёт возраста:
    - Создание таблицы: 
    CREATE TABLE Молодые_животные LIKE Домашние_животные;
    - Вставка записей в таблицу молодых животных с расчетом возраста: 
    INSERT INTO Молодые_животные SELECT *, TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) AS age FROM Домашние_животные WHERE birthdate > DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND birthdate <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

12. Объединение всех таблиц:
    - Создание объединенной таблицы: 
    CREATE TABLE Общая_таблица AS SELECT 'Домашние_животные' AS source_table, * FROM Домашние_животные UNION ALL SELECT 'Вьючные_животные' AS source_table, * FROM Вьючные_животные UNION ALL SELECT 'Молодые_животные' AS source_table, * FROM Молодые_животные;