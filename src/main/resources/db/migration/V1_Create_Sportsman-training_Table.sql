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

alter table public.sportsman_training owner to postgres;

