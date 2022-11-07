CREATE TABLE exchange_rate
(id bigint auto_increment,
 currency varchar(20) NOT NULL,
 amount decimal(3,2) NULL,
 origin varchar(20) NOT NULL,
 target varchar(20) NOT NULL);
insert into exchange_rate(currency,amount,origin,target) values ('EUR / USD', 0.99, '€','$');
insert into exchange_rate(currency,amount,origin,target) values ('USD / EUR', 1.01, '$','€');
insert into exchange_rate(currency,amount,origin,target) values ('USD / PEN', 3.93, '$','S/.');
insert into exchange_rate(currency,amount,origin,target) values ('PEN / USD', 0.25, 'S/.','$');