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

alter table public.training owner to postgres;

