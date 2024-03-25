#Extrae los libros que no hayan sido eliminados logicamente.#
select * from books as b where b.state = 'A';

#Extrae los libros que no hayan sido eliminados logicamente.#
select b.title, b.stock, b.price, b.publication_date from books as b where b.state = 'A';

select * from books as b inner join books_authors as ba on b.book_id = ba.book_id inner join authors as a on ba.author_id = a.author_id where b.state = 'A'; 

#Total de libros#
select count(*) as total_libros from books as b where b.state = 'A';

#Total de autores#
select count(*) as total_autores from authors as a where a.state = 'A';

#Total de libros por author#
select * from books as b inner join books_authors as ba on b.book_id = ba.book_id inner join authors as a on ba.author_id = a.author_id inner join people as p on a.person_id = p.person_id where b.state = 'A'; 

##
select * from authors as a inner join books_authors as ba on a.author_id = ba.author_id inner join books as b on ba.book_id = b.book_id inner join people as p on a.person_id = p.person_id where a.state = 'A';

select p.name as name, p.last_name as lastName, (select count(ba.book_id) from books as b inner join books_authors as ba inner join authors as a on ba.author_id = a.author_id where b.state = 'A') as total_libros from authors as a inner join people as p on a.person_id = p.person_id where a.state = 'A';