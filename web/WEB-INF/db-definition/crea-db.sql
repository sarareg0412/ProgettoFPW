create table utente(
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    foto varchar(100),
    ente varchar(150),
    email varchar(100),
    pw varchar(100),
    status varchar (100)
);

insert into utente values(default, 'Gianni', 'Bianchi', 'https://www.itsmarcopolo.it/wp-content/uploads/2017/08/sagoma-profilo.jpeg', 'https://www.unica.it/unica/','gianni.bianchi@gmail.com','gianni', 'Organizzatore');
insert into utente values(default, 'Sara', 'Regali', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'https://www.unica.it/unica/', 'sara98.regali@gmail.com','sara', 'Autore');
insert into utente values(default, 'Mario', 'Rossi', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'https://www.unica.it/unica/','mario.rossi@gmail.com','mario', 'Autore');
insert into utente values(default, 'Anna', 'Maria', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'https://www.unica.it/unica/','anna.maria@gmail.com','anna', 'Autore');

create table articolo(
    pid serial primary key,
    titolo varchar(100),
    categorie varchar(250),
    immagine varchar(250),
    data_creazione date,
    testo varchar(1000),
    stato varchar(15)
);

insert into articolo values(default, 'SQL injection', 'CSS HTML', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg' ,'2019-04-10', 'inserire testo qui', 'APERTO');
insert into articolo values(default, 'Le Sevlet', 'CSS Servlet', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg','2019-01-08', 'inserire testo qui', 'APERTO');
insert into articolo values(default, 'Il DataBase', 'JSP', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg','2019-03-18', 'inserire testo qui', 'APERTO');
insert into articolo values(default, 'Le Classi Java', 'JSP HTML','https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-05-24', 'inserire testo qui', 'RIFIUTATO');
insert into articolo values(default, 'Il tag brt', 'JSP HTML', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg', '2019-05-01', 'inserire testo qui', 'IN VALUTAZIONE');
insert into articolo values(default, 'Il SevletContainer', 'Servlet', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg' , '2019-05-02', 'inserire testo qui', 'RIFIUTATO');
insert into articolo values(default, 'HTML 6', 'HTML', 'https://studio99.sm/wp-content/uploads/2018/03/informatica-1030x580.jpg' ,'2019-02-18', 'inserire testo qui', 'IN VALUTAZIONE');

create table valutazioni(
    id_valutazione serial primary key,
    comm_autori varchar(250),
    comm_org varchar(250),
    voto int,
    decisione varchar(30),    
    id_utente bigint unsigned,
    id_articolo bigint unsigned 
);

alter table valutazioni add foreign key id_utente(id_utente) 
 references utente(id) on update cascade on delete cascade;
alter table valutazioni add foreign key id_articolo(id_articolo) 
 references articolo(pid) on update cascade on delete cascade;

insert into valutazioni values(default, 'fatto bene', 'fatto male', 4, 'Decidi', 2, 1);
insert into valutazioni values(default, 'fatto bene', 'fatto male', 4, 'Decidi', 3, 1);
insert into valutazioni values(default, 'fatto male', 'fatto malissimo', 2, 'Decidi', 2, 2);
insert into valutazioni values(default, 'fatto bene', 'fatto benino', 3, 'Accettato', 2, 5);
insert into valutazioni values(default, 'fatto male', 'fatto malissimo', 0, 'Rifiutato', 2, 6);
insert into valutazioni values(default, 'fatto male', 'fatto malissimo', 2, 'Rifiutato', 2, 7);
insert into valutazioni values(default, default, default, default, 'Attesa Valutazioni',1, 3);
insert into valutazioni values(default, default, default, default, 'Attesa Valutazioni',1, 4);

create table utente_articolo(
    utente_id bigint unsigned, 
    articolo_id bigint unsigned,
    PRIMARY KEY(utente_id, articolo_id)
);

alter table utente_articolo add foreign key utente_id(utente_id) 
 references utente(id) on update cascade on delete cascade;
alter table utente_articolo add foreign key articolo_id(articolo_id) 
 references articolo(pid) on update cascade on delete cascade;

insert into utente_articolo values(2, 1 );
insert into utente_articolo values(2, 2 );
insert into utente_articolo values(3, 2 );
insert into utente_articolo values(2, 3 );
insert into utente_articolo values(2, 4 );
insert into utente_articolo values(3, 4 );
insert into utente_articolo values(3, 5 );
insert into utente_articolo values(2, 6 );
insert into utente_articolo values(3, 7 );
