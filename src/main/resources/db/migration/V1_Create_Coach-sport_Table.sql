create table public.sport
(
    id uuid not null
        constraint sport_pkey
            primary key,
    created_at timestamp,
    description varchar(255),
    modified_at timestamp,
    sport varchar(255)
);

alter table public.sport owner to postgres;

