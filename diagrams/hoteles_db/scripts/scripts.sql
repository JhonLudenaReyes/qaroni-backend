/*
Mostrar el nombre y apellidos de los empleados que tienen algún proyecto en su
ciudad. No debe haber duplicados. La salida debe estar ordenada por apellido, y en
caso de mismo apellido, por nombre.
*/

select e.nombre as nombre, e.apellido as apellido from asignaciones as a inner join empleados as e on a.id_empleado = e.id_empleado inner join proyectos as p on a.id_proyecto = p.id_proyecto where e.ciudad = p.ciudad order by e.apellido, e.nombre;

/*
Mostrar el nombre y apellidos de los empleados que ganan más que algún
supervisor suyo que viva en su ciudad.
*/

select e.nombre as nombre, e.apellido as apellido from asignaciones as a inner join empleados as e on a.id_empleado = e.id_empleado inner join supervisores as s on a.id_supervisor = s.id_supervisor where (e.salario > s.salario) and (e.ciudad = s.ciudad);

/*
Listar el nombre y apellido de todos los empleados cuyo nombre empieza por ‘A’
con el número de proyectos asignados y suma total de horas asignadas a proyectos.
*/

select e.nombre as nombre, e.apellido as apellido,
(select count(a.id_proyecto) from asignaciones as a where a.id_empleado = e.id_empleado) as proyectos,
(select sum(a.horas_destinadas) from asignaciones as a where a.id_empleado = e.id_empleado) as horas_asignadas
from empleados as e where e.nombre like 'a%';

/*
Mostrar las ciudades que sólo tienen un proyecto y ciudades de empleados con
fecha de nacimiento desconocida
*/

SELECT ciudad
FROM proyectos
GROUP BY ciudad
HAVING COUNT(*) = 1;

SELECT ciudad
FROM empleados
WHERE fecha_nacimiento IS NULL;