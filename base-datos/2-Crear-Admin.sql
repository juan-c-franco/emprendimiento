--Crear Usuario Admin
--Cambiar el parámetro del campo USERNAME en los siguientes registros si se desea utilizar una dirección de correo
--Password:12345
INSERT INTO "USERS" (USERNAME, PASSWORD, ENABLED, FECHAREGISTRO, ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED) VALUES ('admin', '{bcrypt}$2a$10$sh86TLpnfTLZb3A2YKWZsu/Pp5/AougW8YfGAf2HiQGS6OQi8o9OW', '1', sysdate,1,1);
INSERT INTO "GROUP_MEMBERS" (ID, USERNAME, GROUP_ID) VALUES (null, 'admin', '1');
commit;