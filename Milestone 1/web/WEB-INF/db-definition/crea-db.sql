/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kekko
 * Created: 8-mag-2018
 */

create table Users(
    id_user serial primary key,
    name varchar(110),
    surname varchar(120),
    email varchar(140),
    password varchar(50),
    urlProfImg varchar(300),
    descrizione varchar(130),
    ruolo tinyint,
    data date
);

create table News(
    id_news serial primary key,
    titolo varchar(50),
    testo varchar(10240),
    img varchar(50),
    didascalia varchar(30),
    categoria tinyint,
    data date,

    autore bigint unsigned,
    foreign key (autore) references Users(id_user) 
    on update cascade on delete cascade
);

    private LocalDate data;

create table Comments(
    id_comm serial primary key,
    contenuto varchar (100),
    data Date,

    autore bigint unsigned,
    foreign key (autore) references Users(id_user) 
    on update cascade on delete cascade,
    
    news bigint unsigned,
    foreign key (news) references News(id_news) 
    on update cascade on delete cascade
);

DROP TABLE  News;
DROP TABLE  Users;
DROP TABLE Comments;

delete from News where titolo = "Inserisci Titolo";
update Users set ruolo = 0;


insert into Users(name, surname, email, password, urlProfImg,descrizione,ruolo,data)
values ("Davide", "De Luca", "ginopippo@gmail.com", "bluesky", "immagine1.jpg",
"Il cielo e' sempre piu blu",0,'1981-02-03');

insert into Users(name, surname, email, password, urlProfImg,descrizione,ruolo,data)
values ("Mario", "Molinaro", "frellele@gmail.com", "wasabi", "immagine2.jpg",
"Cio che non ti uccide ti fortifica",0,'1987-06-17');

insert into Users(name, surname, email, password, urlProfImg,descrizione,ruolo,data)
values ("Giulio", "Campus", "asdrubale@gmail.com", "crosta", "immagine3.jpg",
"Non guardare al passato pensa al futuro",2,'1990-01-20');

insert into News(titolo,testo,img,didascalia,categoria,data,autore)
values("Vittoria di Marquez","Dominio di Marc Marquez, davanti a Johann Zarco e
    Andrea Iannone.Coinvolti in un incidente e fuori gara Andrea Dovizioso, Jorge Lorenzo 
    e Dani Pedrosa: erano in lotta per il secondo posto. 
    Battuti in volata Danilo Petrucci (4°) e Valentino Rossi (5°). 
    Nono Franco Morbidelli.","img/immagineNews1.jpg","Vittoria di Marquez",0,'2000-10-3',4);

insert into News(titolo,testo,img,didascalia,categoria,data,autore)
values("Lorenzo esce fuori","Il Joker si è svegliato. Dopo la vittoria di Austin ecco 
        il bis a Jerez de la Frontera, con una gara da padrone vinta 
        senza sforzo, partendo dalla quinta fila, risalendo in fretta, 
        prendendo la testa al 7° dei 25 giri e salutando tutti.
        Ma il vero colpo di scena è stato la clamorosa caduta a tre di Lorenzo, 
        Dovizioso e Pedrosa, che seguivano Marquez nell’ordine.",
        "img/immagineNews2.jpg","Lorenzo",4,'2008-11-30',2);


insert into News(titolo,testo,img,didascalia,categoria,data,autore)
values("Rossi quinto","Nel segno della Honda, ma non quella che ti aspetti: in 
                pole a Jerez, sede del GP di Spagna, c'è infatti Crutchlow 
                che fa esultare ancora una volta il suo team manager Lucio
                Cecchinello. L'inglese del team Lcr firma con 
                cui mette tutti in riga in qualifica, precedendo Dani Pedrosa,
                 2, e la Yamaha di Zarco: il francese , l'unico che
                 è riuscito a fara andare forte la M1, che però è quella del team Tech3.",
        "img/immagineNews3.jpg","Lorenzo",4,'2008-11-30',2);

insert into News(titolo,testo,img,didascalia,categoria,data,autore)
values("Doovizioso cade","Nelle Libere, che non concorrono all'accesso alla 
                qualifica, brillante prestazione della Suzuki, che conferma
                il buon feeling con questa pista e che piazza le sue due moto
                davanti a tutti. Miglior tempo per Andrea Iannone in 1 38\444,
                con Rins staccato di  e Marquez terzo a 0\392. Poi 4° Crutchlow,
                5° Pedrosa, 6° Dovizioso, 7° Rabat, 8° Petrucci, 
                9° Viñales e 10° Pol Espargaro. solo 14° Rossi,
                in grossa difficoltà.",
                "img/dovizioso.jpeg","Dovizioso",1,'2000-10-15',4);

insert into Comments(contenuto,autore,news,data) values("Articolo bellissimo!",4,7,'2016-11-30');
insert into Comments(contenuto,autore,news,data) values("Articolo fantastico!",4,7,'2017-11-30');
insert into Comments(contenuto,autore,news,data) values("Capolavoro!",4,7,'2017-1-03');
insert into Comments(contenuto,autore,news,data) values("Complimenti davvero!",4,7,'2018-11-30');

