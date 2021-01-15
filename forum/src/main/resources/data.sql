INSERT INTO usuarios(id, email, nome, senha) values('d6b0e450-fcb8-4191-a2e0-c28a588ad92a','usuario@email.com', 'Usuario', '123456');

insert into cursos(id, nome, categoria) values('39a5bd55-4fa4-4ab0-9182-29d83de3ea83','Spring Boot', 'Backend');
insert into cursos(id, nome, categoria) values('8ac0c13f-acba-4f44-b075-953cbc58a70d','ReactJs', 'FED');

insert into topicos(id, data_criacao, mensagem, status, titulo, autor_id, curso_id) values('6140dc7d-39d4-446a-b535-d2bdad6b9a1c', '2020-01-15', 'Erro ao subir o projeto', 'NAO_RESPONDIDO', 'Erro', 'd6b0e450-fcb8-4191-a2e0-c28a588ad92a', '39a5bd55-4fa4-4ab0-9182-29d83de3ea83');
insert into topicos(id, data_criacao, mensagem, status, titulo, autor_id, curso_id) values('5c7dbc8d-a58e-4202-925c-6d03dfe7e910', '2020-01-15', 'JS não funciona', 'NAO_RESPONDIDO', 'Erro', 'd6b0e450-fcb8-4191-a2e0-c28a588ad92a', '8ac0c13f-acba-4f44-b075-953cbc58a70d');



