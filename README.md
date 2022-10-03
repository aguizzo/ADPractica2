# ADPractica2
Pŕactica 2 de AD

DROP table users;
DROP table images;


create table users (
		username varchar (256) primary key, 
		password varchar (256)
);

create table images (
        id              int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        title           varchar (256) NOT NULL,
        description     varchar (1024) NOT NULL,
        keywords        varchar (256) NOT NULL,
        author          varchar (256) NOT NULL, /* Original author of the image */
        uploader 		varchar (256) NOT NULL, /* User inserting information in db */
        capture_date    varchar (10) NOT NULL,  /* Format AAAA/MM/DD asked to the user*/
        storage_date    varchar (10) NOT NULL,  /* Format AAAA/MM/DD filled automatically when stored */
        filename        varchar (512) NOT NULL, /* Only the name of the file, directory is fixed by the Web Application*/
        primary key (id) , 
		foreign key (uploader) references users(username)
);
