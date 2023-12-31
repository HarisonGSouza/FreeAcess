

FREEACESS:

O software foi pensando para ser uma plataforma de cursos completa que atualmente está na sua versão 1.0, porém a ideia e que com o passar do tempo possa ir sendo adicionada novas funcionalidades para o seu crescimento. O software desenvolvido foi desenvolvido na linguagem Java, na versão (11.0.17). O banco de dados utilizado foi o Postgresql, na versão (14.7). E por fim o framework utilizado foi o VLCJ, na versão (4.7.1) para a reprodução das video aulas.

-----------------------------------------------------------------------------------------------------------------------------------------------

COMO DAR UM START E RESTART NO SERVIDOR POSTGRES

Tente isso:

$ pg_lsclusters

Se você tiver essa resposta ou semelhante:

Ver Cluster Port Status Owner Data directory Log file
10 main 5432 down postgres /var/lib/postgresql/10/main /var/log/postgresql/postgresql-10-main.log

Mude as permissoes de acesso para /var/lib/postgresql/10/main:

$ sudo chmod 700 -R /var/lib/postgresql/10/main

Restart:

$ sudo -i -u postgres
$ /usr/lib/postgresql/10/bin/pg_ctl restart -D /var/lib/postgresql/10/main

Então, check isso:

$ pg_lsclusters
Ver Cluster Port Status Owner Data directory Log file
10 main 5432 online postgres /var/lib/postgresql/10/main /var/log/postgresql/postgresql-10-main.log

Agora é só criar o banco de dados no servidor.

*IMPORTANTE*

O banco de dados tem que ser criado como abaixo:

psql -h 127.0.0.1 -p 5432 -d freeacessdb -U harison -W
pass=freeacess

Porque a classe que vai fazer a coneção com o banco de dados e que está em: freeacess\src\main\java\com\freeacess\dao\DB.java, precisa que o banco seja criado daquela forma com aqueles dados. Ou se preferir pode criar o banco da sua forma e só alterar no codigo dessa classe citada acima (DB.java).

----------------------------------------------------------------------------------------------------------------------------------------------

CRIAÇÃO DAS TABELAS NO BANCO DE DADOS:


Tabela de employer:
CREATE TABLE employer(id serial primary key not null, 
                      full_name varchar not null, 
                      date_birth varchar not null, 
                      cell_phone integer not null, 
                      cpf varchar UNIQUE not null, 
                      rg varchar not null, 
                      adress varchar not null, 
                      email varchar not null, 
                      user_id integer references users(id)
                      );

Tabela de users:
CREATE TABLE users(id smallserial primary key not null, 
                   user_name varchar, 
                   password varchar
                   );


Tabela de videospath:
CREATE TABLE videospath(id smallserial primary key not null, 
                        course varchar, 
                        path varchar
                        );




INSERTS PARA TESTE DAS FUNCIONALIDADES DAS TELAS:

Inserts na para testar a tela do curso de hardware:
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\10-Aula-oque-sao-memorias.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\9-Aula-o-que-e-o-processador.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\8-Aula-como-funciona-o-monitor.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\7-Aula-oque-sao-coolers.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\6-Aula-tipos-de-gabinete.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\5-Aula-o-que-e-hardware.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\4-Aula-eletrica-basica.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\3-Aula-manutecao-de-computadores.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\2-Aula-como-sera-o-curso-parte-2.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\1-Aula-como-sera-o-curso.mp4');

Inserts na para testar a tela do curso de redes:
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\10-Aula-proximos-passos.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\9-Aula-redes-empresarial.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\8-Aula-como-funciona-redes-globais.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\7-Aula-oque-e-o-http.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\6-Aula-oque-e-fibra-optica.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\5-o-que-sao-swits.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\4-protocolos-de-redes.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\3-redes-domestica.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\2-Aula-como-sera-o-curso.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\\Music\\1-Aula-o-que-sao-redes.mp4');

Inserts na para testar a tela do curso de linguagem de programação:
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\10-Aula-Javascript.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\9-Aula-Go.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\8-Aula-Scala.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\7-Aula-Ruby.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\6-Aula-Python.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\5-Aula-Java.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\4-Aula-C#.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\3-Aula-C++.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\2-Aula-C.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\\Music\\1-Aula-Introducao-linguages.mp4');

-----------------------------------------------------------------------------------------------------------------------------------------------