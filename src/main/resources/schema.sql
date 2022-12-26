create table if not exists event (
    id identity,
    name varchar(255) not null,
    type varchar(255) not null,
    release_date varchar(10) not null,
    is_active bool not null,
    description varchar(255),
    duration varchar(12) not null,
    CONSTRAINT UC_EVENT UNIQUE (name,release_date,type)
);

create table if not exists event_place (
    id identity,
    name varchar(255) not null,
    type varchar(255) not null,  
    is_active bool not null,
    address varchar(255),
    city varchar(255) not null,
    state varchar(255) not null,
    country varchar(255) not null,
    zip bigint not null,
    description varchar(255),
    map_location varchar(255) not null,
    phone_number bigint,
    CONSTRAINT UC_EVENT_PLACE UNIQUE (name,type,city,state,country,zip)
);

create table if not exists show_timing (
    id identity,
    show_date varchar(10) not null,
    is_active bool not null,
    screen_name varchar(255) not null,
    start_time varchar(12) not null,
    event_id bigint not null,
    event_place_id bigint not null,
    CONSTRAINT UC_SHOW_TIMING UNIQUE (show_date,start_time,event_id,event_place_id)
);

alter table show_timing
    add foreign key(event_id) references event(id);
    
alter table show_timing
    add foreign key(event_place_id) references event_place(id);
    
create table if not exists user_info (
    id identity,
    name varchar(255) not null,
    email varchar(255) not null,
    dob varchar(255),
    is_active bool not null,
    
    CONSTRAINT UC_USER_INFO UNIQUE (email)
);

create table if not exists booking (
    id identity,
    user_info_id bigint not null,
    show_timing_id bigint not null,
    seat_number varchar(255) not null,
    is_active bool not null,
    
    CONSTRAINT UC_BOOKING UNIQUE (show_timing_id,seat_number),
    CONSTRAINT FK_BOOKING_USER FOREIGN KEY(user_info_id) REFERENCES user_info(id),
    CONSTRAINT FK_BOOKING_SHOW_TIMING FOREIGN KEY(show_timing_id) REFERENCES show_timing(id)
);