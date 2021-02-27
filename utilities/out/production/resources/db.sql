create table if not exists settlements (
    id        bigint not null auto_Increment,
    name      varchar(45) not null,
    size      varchar(45) not null,
    merchant  varchar(45) not null,
    constraint pk_settlements primary key ( id )
);

create table if not exists merchants(
    id        bigint not null auto_Increment,
    type      varchar(45) not null,
    pricemod  numeric not null,
    gold      varchar(45) not null,
    maxitems  varchar(45) not null,
    maxgold   varchar(45) not null,
    itemslist varchar(45) null,
    avatar    varchar(45) null,
    constraint pk_merchants primary key ( id )
);

create table if not exists items(
    id              bigint not null auto_Increment,
    itemname        varchar(45) not null,
    cost            numeric not null,
    weight          numeric not null,
    itemtype        varchar(45) not null,
    description     longtext not null,
    damagetype      varchar(45) null,
    damagevalue     varchar(45) null,
    itemrange       int null,
    armortype       varchar(45) null,
    armorvalue      varchar(45) null,
    potiontype      varchar(45) null,
    portionvalue    varchar(45) null,
    settlementsize  varchar(45) null,
    merchanttype    varchar(45) not null,
    constraint pk_items primary key (id)
);

create table if not exists settlements_type(
    id          int not null auto_Increment,
    type        varchar(45) not null,
    population  int not null,
    constraint pk_settlements_type primary key ( id )
);

delete from settlements_type;

insert into settlements_type
    (type, population)
values
    ( 'Capital', 10000000 ),
    ( 'Megapolis', 1000000 ),
    ( 'Big Town', 100000 ),
    ( 'Small Town', 10000 ),
    ( 'Village', 1000 ),
    ( 'Small Village', 100 );

commit;