create schema if not exists job;
use job;

create schema if not exists job_test;
use job_test;

create table if not exists job (
	  job_id int not null auto_increment primary key,
    job_title varchar(50) not null,
    job_description varchar(50) not null,
    posted_date date not null,
    status varchar(20) not null
);