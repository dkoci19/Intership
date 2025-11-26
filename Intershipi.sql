CREATE TABLE studentet (
    student_id INT PRIMARY KEY,
    emri VARCHAR(100)
);

CREATE TABLE regjistrimet (
    regj_id INT PRIMARY KEY,
    student_id INT,
    lenda VARCHAR(100),
    FOREIGN KEY (student_id) REFERENCES studentet(student_id)
);

CREATE TABLE notat (
    nota_id INT PRIMARY KEY,
    regj_id INT,
    nota INT,
    FOREIGN KEY (regj_id) REFERENCES regjistrimet(regj_id)
);

CREATE TABLE lendet (
    lenda_id INT PRIMARY KEY,
    emri_lendes VARCHAR(100)
);

CREATE TABLE student_lendet (
    student_id INT,
    lenda_id INT,
    PRIMARY KEY (student_id, lenda_id),
    FOREIGN KEY (student_id) REFERENCES studentet(student_id),
    FOREIGN KEY (lenda_id) REFERENCES lendet(lenda_id)
);

INSERT INTO studentet VALUES
(1, 'Ardit'),
(2, 'Deni'),
(3, 'Sara');

INSERT INTO regjistrimet VALUES
(1, 1, 'Matematike'),
(2, 2, 'Java'),
(3, 3, 'Fizike');

INSERT INTO notat VALUES
(1, 1, 18),
(2, 2, 15),
(3, 3, 12);

INSERT INTO lendet VALUES
(1, 'Java'),
(2, 'Matematike'),
(3, 'Fizike');

INSERT INTO student_lendet VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT s.student_id, s.emri, r.lenda
FROM studentet s
JOIN regjistrimet r ON s.student_id = r.student_id;

SELECT s.emri, r.lenda, n.nota
FROM notat n
JOIN regjistrimet r ON n.regj_id = r.regj_id
JOIN studentet s ON r.student_id = s.student_id;

SELECT s.emri AS emri_studentit,
       l.emri_lendes AS lenda
FROM student_lendet sl
JOIN studentet s ON sl.student_id = s.student_id
JOIN lendet l ON sl.lenda_id = l.lenda_id;

