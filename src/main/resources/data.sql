insert into customer_detail (customer_id, origin_channel, full_name, condition, segment, address, customer_category) values('00021244','BANCA SERFIN','IBARRA GONZALEZ ADOLFO', 'CLIENTE','PREMIER','REFORMA 65','FISICA');
insert into customer_detail (customer_id, origin_channel, full_name, condition, segment, address, customer_category) values('00021245','BANCA SERFIN','ACEVES GONZALEZ JOEL', 'EMPLEADO','PREMIER','ARKANSAS 22','MORAL');
insert into customer_detail (customer_id, origin_channel, full_name, condition, segment, address, customer_category) values('00021246','BANORTE','LEON GONZALEZ RAUL', 'CLIENTE','PREMIER','LOMA BONITA 1839','FISICA');
insert into customer_detail (customer_id, origin_channel, full_name, condition, segment, address, customer_category) values('00021247','IXE','CURIEL MANZ RODOLFO', 'EMPLEADO','PREMIER','VIRREYES 45','MORAL');
insert into customer_detail (customer_id, origin_channel, full_name, condition, segment, address, customer_category) values('00021248','BANAMEX','GUITIERREZ GONZALEZ MANUEL', 'CLIENTE','PREMIER','TLALPAN 12','FISICA');
insert into customer_detail (customer_id, origin_channel, full_name, condition, segment, address, customer_category) values('00021249','BANCOMER','SUAREZ RAMIREZ CLAUDIO', 'EMPLEADO','PREMIER','HIDALGO 432','MORAL');

/*
http://localhost:8080/v2/api-docs

http://localhost:8080/swagger-resources

http://localhost:8080/swagger-ui.html

http://localhost:8080/h2-console   jdbc:h2:mem:testdb */

/*
http://localhost:8080/customers?customerId=00021247&documentNumber=DOCDXN&companyName=Santan&accountNumber=accc&name=RODOLFO&paternalName=CURIEL&maternalName=MANZ

http://localhost:8080/customers?&documentNumber=DOCDXN&companyName=Santan&accountNumber=accc&name=RODOLFO&maternalName=GONZALEZ


http://localhost:8080/customers?customerId=&documentNumber=DOCDXN&companyName=Santan&accountNumber=accc&name=RODOLFO&paternalName=&maternalName=GONZALEZ

-Pendientes:
	-validar la doc de swagger.
		-validar los parametros
		-validar los codigos http y documentarlos.
	-documentar en el mail la url de la base de datos.
	-pruebas con los header requeridos
	-validar por que los parametros vacios o inexistentes no permiten regresar datos.
	-complementar el tipo de entrada y salida del endpoin (json/)
	-
	
	https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations#tag
	https://leaks.wanari.com/2018/01/23/awesome-spring-specification/
*/