DROP TABLE IF EXISTS productItem;
CREATE TABLE productItem
(
    id INTEGER NOT NULL auto_increment,
    name VARCHAR(255) not null,
    price INTEGER not null,
    quantity INTEGER not null,
    primary key(id)
);
