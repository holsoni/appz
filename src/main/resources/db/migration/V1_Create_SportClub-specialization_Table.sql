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

alter table public.sportclub_specializations owner to postgres;

