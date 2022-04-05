create table public.buildings
(
    id uuid not null
        constraint buildings_pkey
            primary key,
    address varchar(255),
    created_at timestamp,
    description varchar(255),
    modified_at timestamp,
    name varchar(255)
);

alter table public.buildings owner to postgres;

