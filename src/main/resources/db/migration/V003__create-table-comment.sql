create table os.comment (
	id bigint not null auto_increment,
	service_order_id bigint not null,
	description text not null,
	send_date datetime not null,
	
	primary key (id),
	foreign key(service_order_id) references service_order(id)
);