create table T_RACK
(
    id               bigint Primary key,
    serial_number    varchar(10) NOT NULL unique,
    team_id          bigint        NOT NULL,
    created_at       timestamp default now(),
    default_location VARCHAR(10)
);

alter table t_rack
    add column status varchar(20);
ALTER TABLE t_rack
    ADD CONSTRAINT check_status
        CHECK (status = 'AVAILABLE' OR status = 'BOOKED' or status = 'UNAVAILABLE');

create table T_RACK_ASSET
(
    id        bigint,
    asset_tag varchar(10) not null,
    rack_id   bigint        not null,
    unique (asset_tag),
    primary key (id),
    foreign key (rack_id) references t_rack (id)
);

create table t_team
(
    id               bigint Primary key,
    name             text NOT NULL unique,
    product          text NOT NULL,
    created_at       timestamp default now(),
    modified_at      timestamp default now(),
    default_location varchar(10)
);

create table t_team_member
(
    id          bigint Primary key,
    team_id     bigint not null,
    ctw_id      varchar(20),
    name        varchar(20),
    created_at  timestamp default now(),
    modified_at timestamp default now(),
    foreign key (team_id) references t_team (id)
);

alter table t_rack
    add foreign key (team_id) references t_team (id);
alter table t_rack_asset
    add foreign key (rack_id) references t_rack (id);

create table t_booking
(
    id           bigint Primary key,
    rack_id      bigint      not null references t_rack (id),
    requester_id bigint      not null references t_team_member (id),
    book_from    timestamp,
    book_to      timestamp,
    created_at   timestamp not null default now(),
    modified_at  timestamp not null default now()
);