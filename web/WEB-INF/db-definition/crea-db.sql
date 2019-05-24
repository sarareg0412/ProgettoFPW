create table organizzatore(
    id_autore bigint unsigned,
    nome varchar(100),
    cognome varchar(100),
    foto varchar(100),
    email varchar(100),
    pw varchar(100)

);

create table autore(
    id_autore bigint unsigned,
    nome varchar(100),
    cognome varchar(100),
    foto varchar(100),
    email varchar(100),
    pw varchar(100)

);

create table articolo(
    pid bigint(20) unsigned,
    titolo varchar(100),
    categorie varchar(250),
    data_creazione date,
    testo varchar(1000),
    stato varchar(15)
);
/*ta*/
create table valutazione(
    articolo_id bigint unsigned,
    comm_autori varchar(250),
    comm_org varchar(250),
    voto int,
    decisione varchar(30),
    alter table valutazione add foreign key articolo(articolo_id) 
references articolo (pid) on update cascade on delete cascade;
);
