CREATE TABLE kursi (
    id SERIAL PRIMARY KEY,               -- auto-increment integer (auto-generate)
    emri_kursit VARCHAR(255) NOT NULL,  -- fushë që pranon string (tekst)
    kohezgjatja VARCHAR(100) NOT NULL,  -- kohezgjatja si string (p.sh. "6 muaj", "2 javë")
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- futet automatikisht data e krijimit
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP   -- data e fundit e modifikimit (mund ta ndryshosh me trigger)
);


insert into kursi values (1,'Java','1 muaj'), (2,'Python','2 muaj'),(3,'Java Script','1 muaj'),(4,'C#','3 muaj'),(5,'HTML','3 jave'),(6,'DJango','2 muaj'),(7,'Cyber Security','4 muaj'),(8,'AI','3 muaj'),(9,'Angular','1 muaj'),(10,'C','3 muaj')

ALTER TABLE kursi
add column programming_language VARCHAR(100);

update kursi set programming_language = 'Java' WHERE emri_kursit = 'Java';
update kursi set programming_language = 'Python' WHERE emri_kursit = 'Python';
update kursi set programming_language = 'JavaScript' WHERE emri_kursit = 'JavaScript';
update kursi set programming_language = 'C#' WHERE emri_kursit = 'C#';
update kursi set programming_language = 'SQL' WHERE emri_kursit = 'HTML';
update kursi set programming_language = 'Python' WHERE emri_kursit = 'DJango';
update kursi set programming_language = 'Security' WHERE emri_kursit = 'Cyber Security';
update kursi set programming_language = 'AI basics' WHERE emri_kursit = 'AI';
update kursi set programming_language = 'JavaScript' WHERE emri_kursit = 'Angular';
update kursi set programming_language = 'Kotlin' WHERE emri_kursit = 'C';

delete from kursi 
where emri_kursit = 'AI basics'

CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    emri VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    birth_date DATE NOT NULL,
    phone_number VARCHAR(20),
    pike INT,
    kursi_id INT,
    foreign key (kursi_id) references kursi(id)
);

insert into student (emri, email, birth_date, phone_number, pike, kursi_id)
values 
('Arben', 'arben@gmail.com', '1999-05-12', '0691111111', 90, 1),
('Ariana', 'ariana@gmail.com', '2001-03-22', '0692222222', 85, 2),
('Elton', 'elton@gmail.com', '1997-11-02', '0693333333', 70, 3),
('Mira', 'mira@gmail.com', '2004-07-14', '0694444444', 95, 4),
('Arlind', 'arlind@gmail.com', '1998-12-30', '0695555555', 88, 5);

alter table kursi
rename column emri_kursit to titulli_kursit;

select * from kursi

select 
from * student
where emri like '%A'

select
from * kursi
where extract(year from create_date) between 2023 and 2025;

select *,date_part('year', age(birth_date)) as mosha
from student
where date_part('year', age(birth_date)) > 25;
