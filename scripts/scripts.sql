#Extrae los libros que no hayan sido eliminados logicamente.#
select * from books as b where b.state = 'A';


