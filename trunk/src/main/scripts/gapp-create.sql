
    create table additionalfields (
        additionalfields_id int4 not null,
        field_name varchar(255) not null,
        field_type varchar(255) not null,
        isrequired boolean not null,
        department_department_id int4,
        primary key (additionalfields_id)
    );

    create table additionalfieldsvaluestore (
        id int4 not null,
        value varchar(255),
        additionalFields_additionalfields_id int4,
        application_application_id int4,
        primary key (id)
    );

    create table application (
        application_id int4 not null,
        cin varchar(255),
        citizenship varchar(255),
        date date,
        email varchar(255),
        firstname varchar(255),
        gender varchar(255),
        GPA varchar(255),
        gre varchar(255),
        lastname varchar(255),
        phone varchar(255),
        TOEFL varchar(255),
        Transcript varchar(255),
        program_id int4,
        termstatus_id int4,
        user_id int4,
        primary key (application_id)
    );

    create table applicationstatus (
        applicationstatus_id int4 not null,
        comment varchar(255),
        create_date timestamp,
        revised_date timestamp,
        application_id int4,
        status_status_id int4,
        primary key (applicationstatus_id)
    );

    create table department (
        department_id int4 not null,
        department_name varchar(255),
        primary key (department_id)
    );

    create table educationalbackground (
        educationalbackground_id int4 not null,
        university_name varchar(255),
        degree_earned varchar(255),
        endDate varchar(255),
        major varchar(255),
        startDate varchar(255),
        application_id int4,
        primary key (educationalbackground_id)
    );

    create table programs (
        program_id int4 not null,
        program_name varchar(255),
        department_id int4,
        primary key (program_id)
    );

    create table roles (
        id int4 not null,
        role_name varchar(255),
        primary key (id)
    );

    create table status (
        status_id int4 not null,
        statusName varchar(255),
        primary key (status_id)
    );

    create table termstatus (
        termstatus_id int4 not null,
        term varchar(255),
        year varchar(255),
        primary key (termstatus_id)
    );

    create table users (
        id int4 not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        primary key (id)
    );

    create table users_roles (
        users_id int4 not null,
        role_id int4 not null
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table additionalfields 
        add constraint FK_bs4n0qw505bg3hyuw4s5v2hsl 
        foreign key (department_department_id) 
        references department;

    alter table additionalfieldsvaluestore 
        add constraint FK_rokppg25ah72hw9t00np7fuf9 
        foreign key (additionalFields_additionalfields_id) 
        references additionalfields;

    alter table additionalfieldsvaluestore 
        add constraint FK_qtjqv4n08kpebr3649w0be5d0 
        foreign key (application_application_id) 
        references application;

    alter table application 
        add constraint FK_ebwjyxl8e37r6fw1sq8xkj8jy 
        foreign key (program_id) 
        references programs;

    alter table application 
        add constraint FK_qdtc6miwbxxiyrh9aoefei2qn 
        foreign key (termstatus_id) 
        references termstatus;

    alter table application 
        add constraint FK_dkr6bo95o1seayk7xddr9g7n5 
        foreign key (user_id) 
        references users;

    alter table applicationstatus 
        add constraint FK_8l7hpmqnhee0i3d4ow7h2smwq 
        foreign key (application_id) 
        references application;

    alter table applicationstatus 
        add constraint FK_2jv1exn2xstctgu2yss4hhh5a 
        foreign key (status_status_id) 
        references status;

    alter table educationalbackground 
        add constraint FK_thdl6flxbsopwddrrcyiwpapn 
        foreign key (application_id) 
        references application;

    alter table programs 
        add constraint FK_t38cee5jtiwtw07papp2rjlca 
        foreign key (department_id) 
        references department;

    alter table users_roles 
        add constraint FK_k2mq1ee4ob6uw649wgaus1ate 
        foreign key (role_id) 
        references roles;

    alter table users_roles 
        add constraint FK_3b2cl2u4ck187o21r4uhp6psv 
        foreign key (users_id) 
        references users;

    create sequence hibernate_sequence start with 100 ;
    
    
    INSERT INTO users (id,email,first_name,last_name,password)
VALUES (1,'admin@localhost.localdomain','admin','adminlast','abcd');

INSERT INTO users (id,email,first_name,last_name,password)
VALUES (2,'staff1@localhost.localdomain','staff1first','staff1last','abcd');

INSERT INTO users (id,email,first_name,last_name,password)
VALUES (3,'staff2@localhost.localdomain','staff2first','staff2last','abcd');

INSERT INTO users (id,email,first_name,last_name,password)
VALUES (4,'student1@localhost.localdomain','student1first','student1last','abcd');

INSERT INTO users (id,email,first_name,last_name,password)
VALUES (5,'student2@localhost.localdomain','student2first','student2last','abcd');



INSERT INTO roles (id,role_name)
VALUES(1,'admin');

INSERT INTO roles (id,role_name)
VALUES(2,'staff');

INSERT INTO roles (id,role_name)
VALUES(3,'student');



INSERT INTO users_roles (users_id,role_id)
VALUES (1,1);
INSERT INTO users_roles (users_id,role_id)
VALUES (2,2);
INSERT INTO users_roles (users_id,role_id)
VALUES (3,2);
INSERT INTO users_roles (users_id,role_id)
VALUES (4,3);
INSERT INTO users_roles (users_id,role_id)
VALUES (5,3);




INSERT INTO department(department_id,department_name) VALUES(1,'Accounting');
INSERT INTO department(department_id,department_name) VALUES(2,'Computer Science');



INSERT INTO programs(program_id,program_name,department_id) VALUES(1,'MS',1);
INSERT INTO programs(program_id,program_name,department_id) VALUES(2,'MIS',1);
INSERT INTO programs(program_id,program_name,department_id) VALUES(3,'cs520',2);
INSERT INTO programs(program_id,program_name,department_id) VALUES(4,'cs470',2);
INSERT INTO programs(program_id,program_name,department_id) VALUES(5,'cs320',2);




INSERT INTO additionalfields(additionalfields_id,field_name,field_type,isrequired,department_department_id) values (1,'GMAT','Number','true','1');
insert into additionalFields values (2,'SOP','File','FALSE',1);
INSERT INTO additionalfields(additionalfields_id,field_name,field_type,isrequired,department_department_id) values (3,'GMAT_test','Number','true','1');
insert into additionalFields values (4,'LOR','File','FALSE',1);
INSERT INTO additionalfields(additionalfields_id,field_name,field_type,isrequired,department_department_id) values (5,'some text 1','Text','false','1');
insert into additionalFields values (6,'some text 2','Text','FALSE',1);

insert into additionalFields values (10,'Exctra curriculam','File','FALSE',2);
INSERT INTO additionalfields(additionalfields_id,field_name,field_type,isrequired,department_department_id) values (11,'Statement of purpose','Text','true','2');
insert into additionalFields values (12,'describe ypur self','Text','true',2);






insert into status values (1,'New');
insert into status values (2,'Pending Review');
insert into status values (3,'Denied');
insert into status values (4,'Rejected');
insert into status values (5,'Recommend Admit');
insert into status values (6,'Recommend Admit');
insert into status values (7,'Not Submitted');
insert into status values (8,'Submitted');


