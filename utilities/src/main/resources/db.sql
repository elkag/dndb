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

create table if not exists merchant_types(
    id        int not null auto_Increment,
    type      varchar(45) not null,
    avatar    varchar(45) null,
    constraint pk_merchant_types primary key ( id )
);

create table if not exists item_types(
    id              bigint not null auto_Increment,
    name            varchar(45) not null,
    image           varchar(45) not null,
    constraint pk_itemtype primary key (id)
);

create table if not exists items(
    id              bigint not null auto_Increment,
    name            varchar(45) not null,
    cost            numeric not null,
    weight          numeric not null,
    itemtype        bigint not null,
    description     longtext not null,
    damagetype      varchar(45) null,
    damagevalue     varchar(45) null,
    itemrange       int null,
    armortype       varchar(45) null,
    armorvalue      varchar(45) null,
    potiontype      varchar(45) null,
    portionvalue    varchar(45) null,
    settlementsize  varchar(45) null,
    merchanttype    bigint not null,
    constraint pk_items primary key (id),
    constraint fk_merchanttype foreign key (merchanttype) references merchant_types(id) on delete cascade on update cascade,
    constraint fk_itemtype foreign key (itemtype) references item_types(id) on delete cascade on update cascade
);

create table if not exists settlement_types(
    id          int not null auto_Increment,
    type        varchar(45) not null,
    size        int not null,
    population  int not null,
    population_str  varchar(45) not null,
    image_path  varchar(255) not null,
    pricemod  numeric not null,
    maxitems  numeric not null,
    maxgold   numeric not null,
    constraint pk_settlement_types primary key ( id )
);

delete from settlement_types;

insert into settlement_types
    (type, size, population, population_str, image_path, pricemod, maxitems, maxgold)
values
    ( 'Capital', 1, 10000000, '10,000,000', 'capital.png', 1, 1000, 10000 ),
    ( 'Metropolis', 2, 10000000, '10,000,000', 'metropolic.png', 1, 700, 7000 ),
    ( 'Large City', 3, 1000000, '1,000,000', 'megapolis.png', 1, 600, 6000 ),
    ( 'Small City Town', 4, 100000, '100,000', 'big_town.png', 1, 500, 5000 ),
    ( 'Large Town', 5, 10000, '10,000', 'small_town.png', 1, 400, 4000 ),
    ( 'Small Town', 6, 10000, '10,000', 'small_town.png', 1, 100, 1000 ),
    ( 'Village', 7, 1000, '1,000', 'village.png', 1, 15, 150 ),
    ( 'Hamlet', 8, 100, '100', 'small-village.png', 1, 10, 100 ),
    ( 'Thorp',9, 100, '100', 'small-village.png', 1, 2, 20 );


delete from items;


delete from merchant_types;
insert into merchant_types
    (type, avatar)
values
    ( 'Hammersmith', 'hammersmith.png'),
    ( 'Baker', 'baker.png'),
    ( 'Leather', 'leather.png'),
    ( 'Pastry Cooker', 'cooker.png'),
    ( 'Butcher', 'butcher.png' ),
    ( 'Goldsmith', 'goldsmith.png' ),
    ( 'Stock Breeder', 'breeder.png');

delete from item_types;

insert into item_types
    (name, image)
values
    ( 'weapon', 'weapon.png' ),
    ( 'food', 'food.png' ),
    ( 'resource', 'resource.png' ),
    ( 'service', 'service' );


insert into items
    (name,
    cost,
    weight,
    itemtype,
    description,
    damagetype,
    damagevalue,
    itemrange,
    armortype,
    armorvalue,
    potiontype,
    portionvalue,
    settlementsize,
    merchanttype )
values
    ( 'pistol', 1000, 2000, (select id from item_types where name='weapon'), 'cool and accurate', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Hammersmith') ),
    ( 'ax', 500, 1000, (select id from item_types where name='food'), 'sharp, sharp and sharp ..', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Hammersmith') ),
    ( 'pasta', 100, 300, (select id from item_types where name='food'), 'tasty ...', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Pastry Cooker') ),
    ( 'pasta', 100, 300, (select id from item_types where name='food'), 'tasty ...', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Baker') ),
    ( 'bread', 50, 500, (select id from item_types where name='food'), 'satisfying ...', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Pastry Cooker') ),
    ( 'bread', 50, 500, (select id from item_types where name='food'), 'satisfying ...', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Baker') ),
    ( 'cartridges', 500, 500, (select id from item_types where name='resource'), 'sharp ..', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Hammersmith') ),
    ( 'cartridges', 500, 500, (select id from item_types where name='resource'), 'sharp ..', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Hammersmith') ),
    ( 'bricks', 500, 0, (select id from item_types where name='resource'), 'the strongest bricks ever', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Hammersmith') ),
    ( 'bricks', 500, 0, (select id from item_types where name='resource'), 'the cheapest bricks ever', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Baker') ),
    ( 'bricks', 500, 0, (select id from item_types where name='resource'), 'I can''t make bricks, but I''ll come up with something', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Butcher') ),
    ( 'bricks', 500, 0, (select id from item_types where name='resource'), 'just breaks', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Pastry Cooker') ),
    ( 'bricks', 500, 0, (select id from item_types where name='resource'), 'just breaks ..', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Butcher') ),
    ( 'bricks', 500, 0, (select id from item_types where name='resource'), 'just breaks ..', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Goldsmith') ),
    ( 'bricks', 500, 0, (select id from item_types where name='resource'), 'just breaks ..', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Butcher') ),
    ( 'armor repair', 500, 0, (select id from item_types where name='service'), 'Not fast, but perfect ..', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Stock Breeder') ),
    ( 'laundry', 500, 0, (select id from item_types where name='food'), 'I wash everything in no time', null, null, null, null, null, null, null, null, (select id from merchant_types where type='Stock Breeder') ) ;

commit;