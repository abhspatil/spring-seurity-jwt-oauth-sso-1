
--drop table if exists employee;
--drop table if exists roles;
--drop table if exists userroles;

select * from employee;
--
--insert into employee(fullName,salary,designation,team,isActive,password) values
--        ("patil",20000,"dev","AA","1","patil"),
--        ("admin",10000,"it","AA","1","patil");
--
--insert into roles(role) values ("ROLES_ADMIN"),("ROLES_USER");
--
--insert into userroles (user_id,role_id) values (1,1),(2,2);