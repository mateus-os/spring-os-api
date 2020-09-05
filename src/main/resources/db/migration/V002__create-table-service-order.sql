create table os.service_order (
	id bigint not null auto_increment,
	client_id bigint not null,
	description text not null,
	price decimal(10,2) not null,
	status varchar(20) not null,
	open_date datetime not null,
	close_date datetime,
	
	primary key (id),
	foreign key(client_id) references client(id)
);