
USE library;
-- Bài 1
select * from books b
where b.year >= 2020;

-- Bài 2
select author, COUNT(*) as numberOfBook 
from books b
group by b.author;

-- Bài 3
select b.id, b.title, b.author, b.year from books b
where b.year = (
SELECT MAX(b2.year)
FROM books b2
where b2.author = b.author )








