create table public.sportclub
(
    id uuid not null
        constraint sportclub_pkey
            primary key,
    created_at timestamp,
    creator varchar(255),
    description varchar(255),
    foundation_year varchar(255),
    modified_at timestamp,
    rating double precision not null
);

alter table public.sportclub owner to postgres;

