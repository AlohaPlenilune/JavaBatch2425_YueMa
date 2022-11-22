CREATE TABLE IF NOT EXISTS productItem
(
    id INTEGER NOT NULL auto_increment,
    name VARCHAR(255) not null,
    price DECIMAL(10,2) not null,
    quantity INTEGER not null,
    primary key(id)
);
