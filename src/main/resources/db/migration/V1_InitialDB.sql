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
create table public.degree
(
    id uuid not null
        constraint degree_pkey
            primary key,
    degree varchar(255)
);
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

create table public.sportclub_specializations
(
    sportclub_id uuid not null
        constraint fkofgecafd78p4nncs36i4ro2a5
            references public.sportclub,
    specialization_id uuid not null
        constraint fkiw5o81fs9lv9cluntuqllfy10
            references public.sport,
    constraint sportclub_specializations_pkey
        primary key (sportclub_id, specialization_id)
);

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

create table public.training
(
    id uuid not null
        constraint training_pkey
            primary key,
    created_at timestamp,
    description varchar(255),
    modified_at timestamp,
    coach_id uuid
        constraint fke00hj3snley9f46qjq09wibe4
            references public.coach,
    sport_id uuid
        constraint fksg5qw6xp9pdwq774bebmnq0gj
            references public.sport,
    building_id uuid
        constraint fkpfnnagpkpgg3nr4ws1mmycry5
            references public.buildings
);

create table public.sportsman_training
(
    training_id uuid not null
        constraint fki2rx2vfybdl8en7gim7y89rt0
            references public.training,
    sportsman_id uuid not null
        constraint fksk8xcld6s3x3kok1bqek32rqm
            references public.sportsmen,
    constraint sportsman_training_pkey
        primary key (training_id, sportsman_id)
);

