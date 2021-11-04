/* ------------------------------------------------------------------------------------------------------ */
/* ¡¡¡¡IMPORTANTE !!! -> Ejecutar despues de iniciar el servicio de manera correcta por primera vez  */
/* ------------------------------------------------------------------------------------------------------ */
INSERT INTO st_status
(status_created, status_description, status_updated)
VALUES(now(), 'Activo', now());

INSERT INTO st_status
(status_created, status_description, status_updated)
VALUES(now(), 'Inactivo', now());

/* ------------------------------------------------------------------------------------------------------ */
INSERT INTO st_role
(role_created, role_description, role_updated, status_id)
VALUES(now(), 'Administrador', now(),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'));

INSERT INTO st_role
(role_created, role_description, role_updated, status_id)
VALUES(now(), 'Desarrollador', now(),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'));

/* ------------------------------------------------------------------------------------------------------ */
INSERT INTO st_state
(state_created, state_description, state_updated, status_id)
VALUES(now(), 'Nueva', now(),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'));


INSERT INTO st_state
(state_created, state_description, state_updated, status_id)
VALUES(now(), 'Activa', now(),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'));

INSERT INTO st_state
(state_created, state_description, state_updated, status_id)
VALUES(now(), 'Impedimento', now(),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'));

INSERT INTO st_state
(state_created, state_description, state_updated, status_id)
VALUES(now(), 'Cerrada', now(),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'));


/* ------------------------------------------------------------------------------------------------------ */
INSERT INTO dy_team
(team_created, team_description, team_updated, status_id)
VALUES(now(), 'administradores', now(),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'));

/* ------------------------------------------------------------------------------------------------------ */
INSERT INTO dy_user
(user_created, user_email, user_name, user_password, user_updated, role_id, status_id, team_id)
VALUES(now(), 'admin@admin.com', 'admin', '81dc9bdb52d04dc20036dbd8313ed055', now(),
	(SELECT sr.role_id FROM st_role sr WHERE sr.role_description = 'Administrador'),
	(SELECT ss.status_id FROM st_status ss WHERE ss.status_description = 'Activo'),
	(SELECT dt.team_id FROM dy_team dt WHERE dt.team_description = 'administradores'));

/* ------------------------------------------------------------------------------------------------------ */
