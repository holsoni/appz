create table public.competition
(
    id uuid not null
        constraint competition_pkey
            primary key,
    competition_organizer varchar(255),
    created_at timestamp,
    description varchar(255),
    events integer not null,
    modified_at timestamp,
    name varchar(255),
    building_id uuid
        constraint fkl9n0shxtlxae84vwf71luinb9
            references public.buildings,
    sport_id uuid
        constraint fk9vshhg23ex09s6sy1allr75uf
            references public.sport
);

alter table public.competition owner to postgres;

