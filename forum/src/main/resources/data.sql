INSERT INTO usuario(email, nome, senha) values('usuario@email.com', 'Usuario', '123456');

insert into curso(nome, categoria) values('Spring Boot', 'Backend');
insert into curso(nome, categoria) values('ReactJs', 'FED');

insert into topico(data_criacao, mensagem, status, titulo, autor_id, curso_id) values('2020-01-15', 'Erro ao subir o projeto', 'NAO_RESPONDIDO', 'Erro', 1, 1);
insert into topico(data_criacao, mensagem, status, titulo, autor_id, curso_id) values('2020-01-15', 'JS não funciona', 'NAO_RESPONDIDO', 'Erro',1, 2);