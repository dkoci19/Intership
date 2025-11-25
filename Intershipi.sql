create table studentet (
    student_id int primary key,
    emri varchar(100)
);

create table regjistrimet (
regj_id int primary key,student_id int,lenda varchar(100),foreign key (student_id) references studentet(student_id)
);

select studentet.student_id,studentet.emri,regjistrimet.lenda
from studentet
join regjistrimeton studentet.student_id = regjistrimet.student_id;

create table notat (
nota_id int primary key,regj_id int,nota int,foreign key (regj_id) references regjistrimet(regj_id)
);

select s.emri,r.lenda,n.nota
from notat n
join regjistrimet r on n.regj_id = r.regj_id
join studentet s on r.student_id = s.student_id;

create table studentet (
    student_id int primary key,
    emri varchar(100)
);

create table lendet (
    lenda_id int primary key,
    emri_lendes varchar(100)
);

create table student_lendet (
    student_id int,
    lenda_id int,
    primary key (student_id, lenda_id),
    foreign key (student_id) references studentet(student_id),
    foreign key (lenda_id) references lendet(lenda_id)
);

select s.emri as emri_studentit,l.emri_lendes as lenda
from student_lendet sl
join studentet s on sl.student_id = s.student_id
join lendet l on sl.lenda_id = l.lenda_id;