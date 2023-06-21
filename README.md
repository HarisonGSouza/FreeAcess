

CRIACAO DE TABELAS NO BANCAO

CREATE TABLE employer(id serial primary key not null, full_name varchar not null, date_birth varchar not null, 
cell_phone integer not null, cpf varchar UNIQUE not null, rg varchar not null, adress varchar not null, email varchar not null, user_id integer references users(id));


CREATE TABLE users(id smallserial primary key not null, user_name varchar, password varchar);


CREATE TABLE videospath(id smallserial primary key not null, course varchar, path varchar);

CREATE TABLE bookspath(id smallserial primary key not null, category varchar, path varchar);



INSERT INTO bookspath(category, path) VALUES('hardware','C:\Users\MEU COMPUTADOR\OneDrive\Documentos\FreeAcess\freeacess\src\resources\books\hardwares.pdf');







INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\10-Aula-oque-sao-memorias.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\9-Aula-o-que-e-o-processador.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\8-Aula-como-funciona-o-monitor.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\7-Aula-oque-sao-coolers.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\6-Aula-tipos-de-gabinete.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\5-Aula-o-que-e-hardware.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\4-Aula-eletrica-basica.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\3-Aula-manutecao-de-computadores.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\Music\\2-Aula-como-sera-o-curso-parte-2.mp4');
INSERT INTO videospath(course_name, path) VALUES('hardware','C:\\Users\\MEU COMPUTADOR\\Music\\1-Aula-como-sera-o-curso.mp4');




INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\10-Aula-proximos-passos.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\9-Aula-redes-empresarial.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\8-Aula-como-funciona-redes-globais.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\7-Aula-oque-e-o-http.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\6-Aula-oque-e-fibra-optica.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\5-o-que-sao-swits.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\4-protocolos-de-redes.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\3-redes-domestica.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\2-Aula-como-sera-o-curso.mp4');
INSERT INTO videospath(course_name, path) VALUES('network','C:\\Users\\MEU COMPUTADOR\Music\\1-Aula-o-que-sao-redes.mp4');




INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\10-Aula-Javascript.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\9-Aula-Go.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\8-Aula-Scala.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\7-Aula-Ruby.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\6-Aula-Python.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\5-Aula-Java.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\4-Aula-C#.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\3-Aula-C++.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\2-Aula-C.mp4');
INSERT INTO videospath(course_name, path) VALUES('programming','C:\\Users\\MEU COMPUTADOR\Music\\1-Aula-Introducao-linguages.mp4');




C:\\Users\\MEU COMPUTADOR\\Downloads\\CRIOLO & Tropkillaz - CLEANE.mp4");


C:\Users\MEU COMPUTADOR\Downloads\CRIOLO - Não Existe Amor Em SP.mp4
_____________________________________________________
 
COMO DAR UM START E RESTART NO SERVIDOR POSTGRES

Try this:

$ pg_lsclusters

If you have this response:

Ver Cluster Port Status Owner Data directory Log file
10 main 5432 down postgres /var/lib/postgresql/10/main /var/log/postgresql/postgresql-10-main.log

Change access permissions to /var/lib/postgresql/10/main

$ sudo chmod 700 -R /var/lib/postgresql/10/main

Restart

$ sudo -i -u postgres
$ /usr/lib/postgresql/10/bin/pg_ctl restart -D /var/lib/postgresql/10/main

Then, check it

$ pg_lsclusters
Ver Cluster Port Status Owner Data directory Log file
10 main 5432 online postgres /var/lib/postgresql/10/main /var/log/postgresql/postgresql-10-main.log
________________________________________________________________


psql -h 127.0.0.1 -p 5432 -d freeacessdb -U harison -W
pass=freeacess





*Os videos tem que ser mp4, senao ira tentar o arquivo como pdf