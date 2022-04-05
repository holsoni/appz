create table public.coach
(
    id uuid not null
        constraint coach_pkey
            primary key,
    created_at timestamp,
    description varchar(255),
    modified_at timestamp,
    name varchar(255),
    year integer not null,
    sport_club_id uuid
        constraint fkquunjo5hljq71sbum8wceshpb
            references public.sportclub
);

alter table public.coach owner to postgres;

