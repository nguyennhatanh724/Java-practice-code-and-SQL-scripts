select * from employees;

select * from employees e1
where e1.salary = (
	select max (e2.salary)
    from employees e2
    where e1.department = e2.department
);

select max(salary), department
from employees
group by department

