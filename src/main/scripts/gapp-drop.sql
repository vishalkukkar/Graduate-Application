
    alter table additionalfields 
        drop constraint FK_bs4n0qw505bg3hyuw4s5v2hsl;

    alter table additionalfieldsvaluestore 
        drop constraint FK_rokppg25ah72hw9t00np7fuf9;

    alter table additionalfieldsvaluestore 
        drop constraint FK_qtjqv4n08kpebr3649w0be5d0;

    alter table application 
        drop constraint FK_ebwjyxl8e37r6fw1sq8xkj8jy;

    alter table application 
        drop constraint FK_qdtc6miwbxxiyrh9aoefei2qn;

    alter table application 
        drop constraint FK_dkr6bo95o1seayk7xddr9g7n5;

    alter table applicationstatus 
        drop constraint FK_8l7hpmqnhee0i3d4ow7h2smwq;

    alter table applicationstatus 
        drop constraint FK_2jv1exn2xstctgu2yss4hhh5a;

    alter table educationalbackground 
        drop constraint FK_thdl6flxbsopwddrrcyiwpapn;

    alter table programs 
        drop constraint FK_t38cee5jtiwtw07papp2rjlca;

    alter table users_roles 
        drop constraint FK_k2mq1ee4ob6uw649wgaus1ate;

    alter table users_roles 
        drop constraint FK_3b2cl2u4ck187o21r4uhp6psv;

    drop table if exists additionalfields cascade;

    drop table if exists additionalfieldsvaluestore cascade;

    drop table if exists application cascade;

    drop table if exists applicationstatus cascade;

    drop table if exists department cascade;

    drop table if exists educationalbackground cascade;

    drop table if exists programs cascade;

    drop table if exists roles cascade;

    drop table if exists status cascade;

    drop table if exists termstatus cascade;

    drop table if exists users cascade;

    drop table if exists users_roles cascade;

    drop sequence hibernate_sequence;
