--Script Desbloqueo admin
--Se debe cambiar 'admin' por el username del administrador
update  user_attempts set attempts = 0 where username = 'admin';
update  users set ACCOUNTNONLOCKED = 1 where username = 'admin';
commit;