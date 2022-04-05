create table public.sportsmen
(
    id uuid not null
        constraint sportsmen_pkey
            primary key,
    created_at timestamp,
    description varchar(255),
    modified_at timestamp,
    name varchar(255),
    year integer not null,
    degree_id uuid
        constraint fkmdspwv3li5tu7g324rvu50hmk
            references public.degree,
    sport_id uuid
        constraint fk8yda1qi0saql0wgjcptdl19nr
            references public.sport,
    sportclub_id uuid
        constraint fkgnt2t4pvnn47csg86w86ldhac
            references public.sportclub
);

alter table public.sportsmen owner to postgres;

