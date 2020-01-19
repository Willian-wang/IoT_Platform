create table if not exists iot_product_inf
(
	product_id bigint not null,
	product_inf_user_id bigint not null,
	product_inf_name varchar(30) not null,
	product_inf_secret varchar(30) not null,
	product_inf_key varchar(30) null,
	product_inf_data_format tinyint default 0 not null,
	product_inf_network tinyint default 1 null,
	product_inf_status tinyint default 0 not null,
	product_inf_auto_register tinyint default 0 not null,
	product_inf_node_type tinyint not null,
	product_inf_gmt_create timestamp null,
	product_inf_gmt_update timestamp null,
	product_inf_is_remove tinyint default 0 null,
	product_inf_category_name varchar(30) not null,
	constraint iot_product_inf_product_id_uindex
		unique (product_id)
);

alter table iot_product_inf
	add primary key (product_id);

