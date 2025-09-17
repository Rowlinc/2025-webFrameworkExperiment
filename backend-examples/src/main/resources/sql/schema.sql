use `2023211454`;
create table if not exists user_backend_examples(
    id char(19) primary key ,
    account varchar(20) not null unique ,
    password char(60) not null ,
    role varchar(5) check ( role in ('USER','ADMIN')) not null,
    create_time datetime not null default CURRENT_TIMESTAMP,
    update_time datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    index (account)
);
