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

select 
    student.emri as emri_studentit,
    student.email,
    kursi.titulli_kursit,
    kursi.programming_language
from student
join kursi on student.kursi_id = kursi.id;

CREATE TABLE instruktor (
    id SERIAL primary key,
    emri VARCHAR(100) not null,
    email VARCHAR(150),
    eksperienca_vjet INT
);
alter table kursi
add column instruktor_id INT;

alter table kursi
add column  fk_instruktor
foreign key (instruktor_id) references instruktor(id);

insert into instruktor (emri, email, eksperienca_vjet) values
('Genc Mema', 'genc@gmail.com', 8),
('Elira Tafa', 'elira@gmail.com', 5),
('Klodian Basha', 'klodian@gmail.com', 10);

update kursi set instruktor_id = 1 where id in (1,2);
update kursi set instruktor_id = 2 where id in (3,4,5);
update kursi set instruktor_id = 3 where id in (6,7,8,9,10);

create table student_kursi (
    id SERIAL primary key,
    student_id INT not null,
    kursi_id INT not null,
    foreign key (student_id) references student(id),
    foreign key (kursi_id) references kursi(id)
);

insert into student_kursi (student_id, kursi_id) values
(1, 1),  
(1, 3),  
(2, 2),  
(2, 5),  
(3, 3),
(4, 1),
(4, 4),
(5, 6),
(5, 7);

select
    s.emri as studenti,
    k.titulli_kursit as kursi,
    k.programming_language
from student_kursi sk
join student s on sk.student_id = s.id
join kursi k   on sk.kursi_id = k.id
order by s.emri;
