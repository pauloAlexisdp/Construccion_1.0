
create table empresa(
	duns integer  primary key,
	nombre text not null,
	responsable text not null,
	contacto integer not null	
);

create table venta(
	id integer primary key,
	refEmpresa integer not null,
	fechaventa date not null,
	precio integer not null,
	producto text not null,
	estado text ,
	cantidadProducto integer not null,
	FOREIGN KEY(refEmpresa) REFERENCES empresa(duns) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table cuenta(
	nombre text  primary key,
	contrasena text not null,
	tipo text not null
);

create table proveedor(
	id integer  primary key,
	recordario text not null,
	contacto integer not null
);

create table producto(
	id integer primary key,
	nombre text not null,
	refproveedor integer not null,
	FOREIGN KEY(refproveedor) REFERENCES proveedor(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table contrato(
	folio integer primary key,
	fechainicio date not null,
	fechatermino date
);

create table trabajadorInterno(
	rut integer primary key, 
	nombre text not null,
	telefono integer not null,
	estado text,
	refcontrato integer not null,
	FOREIGN KEY(refcontrato) REFERENCES contrato(folio) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table temporero(
	rutpersona integer PRIMARY KEY REFERENCES trabajadorInterno(rut) ON DELETE RESTRICT ON UPDATE CASCADE,
	cantidadrecolectada integer,
	cantidadlimpiada integer
);

create table supervisor(
	rutpersona integer PRIMARY KEY REFERENCES trabajadorInterno(rut) ON DELETE RESTRICT ON UPDATE CASCADE,
	horastrabajadas integer
);

create table subcontrato(
	folio integer primary key,
	nombreempresa text not null,
	rolsocial text not null
);

create table trabajadorExterno(
	id integer primary key,
	nombre text not null,
	rol text not null,
	foliosubcontrato integer not null,
	FOREIGN KEY(foliosubcontrato) REFERENCES subcontrato(folio) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table instanciatemporada(
	id integer primary key,
	fecha date not null,
	refventa integer not null,
	FOREIGN KEY(refventa) REFERENCES venta(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table trabajadorExternoInstancia(
	refInstanciaTemporada integer not null,
	reftrabajadorexterno integer not null,
	FOREIGN KEY(refInstanciaTemporada) REFERENCES instanciatemporada(id) ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY(reftrabajadorexterno) REFERENCES trabajadorExterno(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table cuentaInstancia(
	refcuenta text not null,
	refInstanciaTemporada integer not null,
	FOREIGN KEY(refcuenta) REFERENCES cuenta(nombre) ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY(refInstanciaTemporada) REFERENCES instanciatemporada(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table proveedorInstancia(
	refproveedor integer  not null,
	refInstanciaTemporada integer not null,
	FOREIGN KEY(refproveedor) REFERENCES proveedor(id) ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY(refInstanciaTemporada) REFERENCES  instanciatemporada(id) ON DELETE RESTRICT ON UPDATE CASCADE
);
