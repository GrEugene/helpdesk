create table helpdesk.markets (
	id bigint not null,
	created_at timestamp with time zone,
	changed_at timestamp with time zone,
	is_active boolean default true,
	name text not null,
	phone text,
	address text not null,
	contact_name text,
	contact_phone text,
	contact_email text
);

create sequence helpdesk.markets_id_seq
	start with 1
	increment by 1
	no minvalue
	no maxvalue
	cache 1;

alter sequence helpdesk.markets_id_seq owned
    by helpdesk.markets.id;

alter table only helpdesk.markets
	alter column id set default nextval('helpdesk.markets_id_seq' :: regclass);

alter table only helpdesk.markets
	add constraint markets_pkey primary key (id);

-------------------------------------------------------------------------------

create table helpdesk.workers (
	id bigint not null,
	created_at timestamp with time zone,
	changed_at timestamp with time zone,
	is_active boolean default true,
	name text not null,
	phone text not null,
	email text not null
);

create sequence helpdesk.workers_id_seq owned
	by helpdesk.workers.id;

alter table only helpdesk.workers
	alter column id set default nextval('helpdesk.workers_id_seq' :: regclass);

alter table only helpdesk.workers
	add constraint workers_pkey primary key (id);

--------------------------------------------------------------------------------

create table helpdesk.managers (
	id bigint not null,
	created_at timestamp with time zone,
	changed_at timestamp with time zone,
	is_active boolean default true,
	name text not null,
	phone text not null,
	email text not null
);

create sequence helpdesk.managers_id_seq owned
	by helpdesk.managers.id;

alter table only helpdesk.managers
	alter column id set default nextval('helpdesk.managers_id_seq' :: regclass);

alter table only helpdesk.managers
	add constraint managers_pkey primary key (id);

-------------------------------------------------------------------------------

create table helpdesk.customers (
	id bigint not null,
	created_at timestamp with time zone,
	changed_at timestamp with time zone,
	is_active boolean default true,
	name text not null,
	phone text not null,
	email text not null,
	market_id bigint not null
);

create sequence helpdesk.customers_id_seq owned
	by helpdesk.customers.id;

alter table only helpdesk.customers
	alter column id set default nextval('helpdesk.customers_id_seq' :: regclass);

alter table only helpdesk.customers
	add constraint customers_pkey primary key (id);

alter table only helpdesk.customers
    add constraint customers_to_markets_fk FOREIGN KEY (market_id) REFERENCES helpdesk.markets(id);

-------------------------------------------------------------------------------

create table helpdesk.schedule (
	id bigint not null,
	created_at timestamp with time zone,
	changed_at timestamp with time zone,
	is_active boolean default true,
	name text,
	date_from timestamp with time zone,
	date_to timestamp with time zone,
	worker_id bigint not null,
	manager_id bigint not null
);

create sequence helpdesk.schedule_id_seq owned
	by helpdesk.schedule.id;

alter table only helpdesk.schedule
	alter column id set default nextval('helpdesk.schedule_id_seq' :: regclass);

alter table only helpdesk.schedule
	add constraint schedule_pkey primary key (id);

alter table only helpdesk.schedule
    add constraint schedule_to_workers_fk FOREIGN KEY (worker_id) REFERENCES helpdesk.workers(id);

alter table only helpdesk.schedule
    add constraint schedule_to_managers_fk FOREIGN KEY (manager_id) REFERENCES helpdesk.managers(id);

-------------------------------------------------------------------------------

create table helpdesk.orders (
	id bigint not null,
	created_at timestamp with time zone,
	changed_at timestamp with time zone,
	is_active boolean default true,
	name text not null,
	description text not null,
	status text not null,
	customer_id bigint not null,
	worker_id bigint
);

create sequence helpdesk.orders_id_seq owned
	by helpdesk.orders.id;

alter table only helpdesk.orders
	alter column id set default nextval('helpdesk.orders_id_seq' :: regclass);

alter table only helpdesk.orders
	add constraint orders_pkey primary key (id);

alter table only helpdesk.orders
    add constraint orders_to_workers_fk FOREIGN KEY (worker_id) REFERENCES helpdesk.workers(id);

alter table only helpdesk.orders
    add constraint orders_to_customers_fk FOREIGN KEY (customer_id) REFERENCES helpdesk.customers(id);
