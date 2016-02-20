
    create table academicrecords (
        academicrecords_id int4 not null,
        GPA varchar(255),
        TOEFL varchar(255),
        Transcript varchar(255),
        application_application_id int4,
        primary key (academicrecords_id)
    );

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
        date timestamp,
        gender varchar(255),
        phone varchar(255),
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
        university_name varchar(255) not null,
        degree varchar(255),
        degree_earned varchar(255) not null,
        endDate timestamp not null,
        major varchar(255) not null,
        startDate timestamp not null,
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
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        primary key (id)
    );

    create table users_roles (
        users_id int4 not null,
        role_id int4 not null
    );

    alter table application 
        add constraint UK_jwe4yjwogktj1q4hallbbl97c unique (cin);

    alter table application 
        add constraint UK_cltix5pp115r3sgybjbu2emev unique (phone);

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table academicrecords 
        add constraint FK_8tw1rjnrllmpu3o976db9fukk 
        foreign key (application_application_id) 
        references application;

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

    create sequence hibernate_sequence;
    
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

insert into termstatus(termstatus_id,term,year) 
values(1,'fall','2016');


INSERT INTO application(application_id,cin,citizenship,date,gender,phone,program_id,termstatus_id,user_id)
values(1,'304360906','American','2012-12-31 11:30:45','male','6266324408',1,1,4);

INSERT INTO additionalfields(additionalfields_id,field_name,field_type,isrequired,department_department_id) values (1,'GMAT','Number','true','1');

insert into additionalfieldsvaluestore(id,value,additionalfields_additionalfields_id,application_application_id) 
values(1,310,1,1);
