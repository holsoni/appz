create table public.degree
(
    id uuid not null
        constraint degree_pkey
            primary key,
    degree varchar(255)
);

alter table public.degree owner to postgres;

