create table utente(
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    foto varchar(100),
    email varchar(100),
    pw varchar(100),
    status varchar (100)
);

insert into utente values(default, 'Gianni', 'Bianchi', 'https://www.itsmarcopolo.it/wp-content/uploads/2017/08/sagoma-profilo.jpeg', 'gianni.bianchi@gmail.com','gianni', 'Organizzatore');
insert into utente values(default, 'Sara', 'Regali', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'sara98.regali@gmail.com','sara', 'Autore');
insert into utente values(default, 'Mario', 'Rossi', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'mario.rossi@gmail.com','mario', 'Autore');

create table articolo(
    pid serial primary key,
    titolo varchar(100),
    categorie varchar(250),
    data_creazione date,
    testo varchar(1000),
    stato varchar(15)
);

insert into articolo values(default, 'SQL injection', 'CSS HTML', '2019-04-10', 'inserire testo qui', 'APERTO');
insert into articolo values(default, 'Le Sevlet', 'CSS Servlet', '2019-01-08', 'inserire testo qui', 'APERTO');
insert into articolo values(default, 'Il DataBase', 'JSP', '2019-03-18', 'inserire testo qui', 'APERTO');
insert into articolo values(default, 'Le Classi Java', 'JSP HTML', '2019-05-24', 'inserire testo qui', 'RIFIUTATO');
insert into articolo values(default, 'Il tag brt', 'JSP HTML', '2019-05-01', 'inserire testo qui', 'IN VALUTAZIONE');
insert into articolo values(default, 'Il SevletContainer', 'Servlet', '2019-05-02', 'inserire testo qui', 'RIFIUTATO');
insert into articolo values(default, 'HTML 6', 'HTML', '2019-02-18', 'inserire testo qui', 'IN VALUTAZIONE');

create table valutazione(
    id_valutazione serial primary key,
    comm_autori varchar(250),
    comm_org varchar(250),
    voto int,
    decisione varchar(30),    
    id_utente bigint unsigned,
    id_articolo bigint unsigned 
);

alter table valutazione add foreign key id_utente(id_utente) 
 references utente(id) on update cascade on delete cascade;
alter table valutazione add foreign key id_articolo(id_articolo) 
 references articolo(pid) on update cascade on delete cascade;

insert into valutazione values(default, 'fatto bene', 'fatto male', 4, 'decidi', 2, 1);
insert into valutazione values(default, 'fatto bene', 'fatto male', 4, 'decidi', 3, 1);
insert into valutazione values(default, 'fatto male', 'fatto malissimo', 2, 'decidi', 2, 2);
insert into valutazione values(default, 'fatto bene', 'fatto benino', 3, 'accettato', 2, 5);
insert into valutazione values(default, 'fatto male', 'fatto malissimo', 0, 'rifiutato', 2, 6);
insert into valutazione values(default, 'fatto male', 'fatto malissimo', 2, 'rifiutato', 2, 7);
insert into valutazione values(default, default, default, default, 'non ancora valutato',1, 3);
insert into valutazione values(default, default, default, default, 'non ancora valutato',1, 4);

create table utenti_articoli(
    utente_id bigint unsigned, 
    articolo_id bigint unsigned,
    PRIMARY KEY(utente_id, articolo_id)
);

alter table utenti_articoli add foreign key utente_id(utente_id) 
 references utente(id) on update cascade on delete cascade;
alter table utenti_articoli add foreign key articolo_id(articolo_id) 
 references articolo(pid) on update cascade on delete cascade;
