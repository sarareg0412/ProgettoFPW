create table organizzatore(
    id_organizzatore serial primary key,
    nome varchar(100),
    cognome varchar(100),
    foto varchar(100),
    email varchar(100),
    pw varchar(100)
);

insert into organizzatore values(default, 'Gianni', 'Bianchi', 'https://www.itsmarcopolo.it/wp-content/uploads/2017/08/sagoma-profilo.jpeg', 'gianni.bianchi@gmail.com','gianni');

create table autore(
    id_autore serial primary key,
    nome varchar(100),
    cognome varchar(100),
    foto varchar(100),
    email varchar(100),
    pw varchar(100)
);

insert into autore values(default, 'Sara', 'Regali', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'sara98.regali@gmail.com','sara');
insert into autore values(default, 'Mario', 'Rossi', 'https://www.nanopress.it/wp-content/uploads/2018/02/Immagini-profilo-Facebook.jpg', 'mario.rossi@gmail.com','mario');

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
    id_valutazione serial primary key
    comm_autori varchar(250),
    comm_org varchar(250),
    voto int,
    decisione varchar(30),
    id_articolo bigint unsigned 
    foreign key id_articolo references articolo(pid) on update cascade on delete cascade,
    id_org bigint unsigned references organizzatore(id_organizzatore)
);
insert into valutazione values(default, 'prova', 'prova', 4, );
in
create table autori_articoli(
    autore_id bigint unsigned references autore(id_autore) on update cascade on delete cascade,
    articolo_id bigint unsigned references articolo(pid) on update cascade on delete cascade,
    PRIMARY KEY(autore_id, articolo_id)
);

create table autori_valutazioni(
    autore_id bigint unsigned references autore(id_autore) on update cascade on delete cascade,
    valutazione_id bigint unsigned references valutazione(id_valutazione) on update cascade on delete cascade,
    PRIMARY KEY (autore_id, valutazione_id)
);

create table organizzatori_articoli(
    organizzatore_id bigint unsigned references organizzatore(id_organizzatore) on update cascade on delete cascade,
    articolo_id bigint unsigned references articolo(pid) on update cascade on delete cascade,
    PRIMARY KEY(organizzatore_id, articolo_id)
);

