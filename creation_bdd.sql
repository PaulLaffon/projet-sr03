DROP TABLE IF EXISTS voiture_option_sup;
DROP TABLE IF EXISTS modele_type_finition;
DROP TABLE IF EXISTS option_sup_type_finition;
DROP TABLE IF EXISTS couleur_type_finition;
DROP TABLE IF EXISTS motorisation_type_finition;
DROP TABLE IF EXISTS type_jante_type_finition;
DROP TABLE IF EXISTS voiture;
DROP TABLE IF EXISTS modele;
DROP TABLE IF EXISTS motorisation;
DROP TABLE IF EXISTS type_jante;
DROP TABLE IF EXISTS option_sup;
DROP TABLE IF EXISTS couleur;
DROP TABLE IF EXISTS type_finition;





CREATE TABLE type_jante (
  id SERIAL PRIMARY KEY,
  diametre DECIMAL,
  matiere VARCHAR(100),
  prix DECIMAL
);

CREATE TABLE motorisation (
  id SERIAL PRIMARY KEY,
  nom_moteur VARCHAR(100),
  puissance INTEGER,
  prix DECIMAL
);

CREATE TABLE option_sup (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100),
  description TEXT,
  prix DECIMAL
);

CREATE TABLE couleur (
  id SERIAL PRIMARY KEY,
  couleur VARCHAR(100),
  prix DECIMAL
);

CREATE TABLE type_finition (
  id SERIAL PRIMARY KEY,
  type VARCHAR(100),
  prix DECIMAL
);


CREATE TABLE modele (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100),
  marque VARCHAR(100),
  prix DECIMAL
);

CREATE TABLE voiture (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100),
  modele_id BIGINT UNSIGNED,
  couleur_id BIGINT UNSIGNED,
  type_finition_id BIGINT UNSIGNED,
  motorisation_id BIGINT UNSIGNED,
  type_jante_id BIGINT UNSIGNED,
  FOREIGN KEY(modele_id) REFERENCES modele(id),
  FOREIGN KEY(couleur_id) REFERENCES couleur(id),
  FOREIGN KEY(type_finition_id) REFERENCES type_finition(id),
  FOREIGN KEY(motorisation_id) REFERENCES motorisation(id),
  FOREIGN KEY(type_jante_id) REFERENCES type_jante(id)
);

CREATE TABLE voiture_option_sup (
  voiture_id BIGINT UNSIGNED,
  option_sup_id BIGINT UNSIGNED,
  PRIMARY KEY (voiture_id, option_sup_id),
  FOREIGN KEY (voiture_id) REFERENCES voiture(id),
  FOREIGN KEY (option_sup_id) REFERENCES option_sup(id)
);


CREATE TABLE modele_type_finition (
  modele_id BIGINT UNSIGNED,
  type_finition_id BIGINT UNSIGNED,
  PRIMARY KEY (modele_id, type_finition_id),
  FOREIGN KEY (modele_id) REFERENCES modele(id),
  FOREIGN KEY (type_finition_id) REFERENCES type_finition(id)
);


CREATE TABLE option_sup_type_finition (
  option_sup_id BIGINT UNSIGNED,
  type_finition_id BIGINT UNSIGNED,
  PRIMARY KEY (option_sup_id, type_finition_id),
  FOREIGN KEY (option_sup_id) REFERENCES option_sup(id),
  FOREIGN KEY (type_finition_id) REFERENCES type_finition(id)
);

CREATE TABLE couleur_type_finition (
  couleur_id BIGINT UNSIGNED,
  type_finition_id BIGINT UNSIGNED,
  PRIMARY KEY (couleur_id, type_finition_id),
  FOREIGN KEY (couleur_id) REFERENCES couleur(id),
  FOREIGN KEY (type_finition_id) REFERENCES type_finition(id)
);

CREATE TABLE motorisation_type_finition (
  motorisation_id BIGINT UNSIGNED,
  type_finition_id BIGINT UNSIGNED,
  PRIMARY KEY (motorisation_id, type_finition_id),
  FOREIGN KEY (motorisation_id) REFERENCES motorisation(id),
  FOREIGN KEY (type_finition_id) REFERENCES type_finition(id)
);

CREATE TABLE type_jante_type_finition (
  type_jante_id BIGINT UNSIGNED,
  type_finition_id BIGINT UNSIGNED,
  PRIMARY KEY (type_jante_id, type_finition_id),
  FOREIGN KEY (type_jante_id) REFERENCES type_jante(id),
  FOREIGN KEY (type_finition_id) REFERENCES type_finition(id)
);

#On supprime tout ce qu'il y a dans les tables
DELETE FROM voiture_option_sup;
DELETE FROM modele_type_finition;
DELETE FROM option_sup_type_finition;
DELETE FROM couleur_type_finition;
DELETE FROM motorisation_type_finition;
DELETE FROM type_jante_type_finition;
DELETE FROM voiture;
DELETE FROM modele;
DELETE FROM motorisation;
DELETE FROM type_jante;
DELETE FROM option_sup;
DELETE FROM couleur;
DELETE FROM type_finition;

INSERT INTO type_finition(type,prix) VALUES ("Haute",59.0);
INSERT INTO type_finition(type,prix) VALUES ("Basse",20.0);
INSERT INTO type_finition(type,prix) VALUES ("Moyenne",54.0);
INSERT INTO motorisation(nom_moteur,puissance,prix) VALUES ("Moteur1",550,560.0);
INSERT INTO motorisation(nom_moteur,puissance,prix) VALUES ("Moteur2",620,700.0);
INSERT INTO motorisation(nom_moteur,puissance,prix) VALUES ("Moteur3",410,650.0);
INSERT INTO motorisation(nom_moteur,puissance,prix) VALUES ("Moteur4",350,480.0);
INSERT INTO modele(nom,marque,prix) VALUES ("Modele1","Marque1",420.0);
INSERT INTO modele(nom,marque,prix) VALUES ("Modele2","Marque2",320.0);
INSERT INTO modele(nom,marque,prix) VALUES ("Modele3","Marque3",520.0);
INSERT INTO modele(nom,marque,prix) VALUES ("Modele4","Marque4",480.0);
INSERT INTO couleur(couleur,prix) VALUES ("Rouge",20.3);
INSERT INTO couleur(couleur,prix) VALUES ("Vert",24.3);
INSERT INTO couleur(couleur,prix) VALUES ("Bleu",10.3);
INSERT INTO couleur(couleur,prix) VALUES ("Gris",29.3);
INSERT INTO type_jante(diametre,matiere,prix) VALUES (22.2, "Matiere1",78.7);
INSERT INTO type_jante(diametre,matiere,prix) VALUES (28.2, "Matiere2",47.6);
INSERT INTO type_jante(diametre,matiere,prix) VALUES (35.2, "Matiere3",39.6);
INSERT INTO type_jante(diametre,matiere,prix) VALUES (14.2, "Matiere4",24.6);
INSERT INTO option_sup(nom,description,prix) VALUES ("options1", "Description1",48.6);
INSERT INTO option_sup(nom,description,prix) VALUES ("options2", "Description2",65.6);
INSERT INTO option_sup(nom,description,prix) VALUES ("options3", "Description3",85.6);
INSERT INTO option_sup(nom,description,prix) VALUES ("options4", "Description4",97.6);
INSERT INTO voiture(nom,modele_id,couleur_id, type_finition_id, motorisation_id, type_jante_id) VALUES ("Voiture1",2,1,1,1,4); # VERIF QUE LES CARACTERISTIQUES CHOISIENT SONT COHERENTES (COULEUR CHOISIE POSSIBLE POUR LE TYPE FINIITION CHOISIE)
INSERT INTO voiture(nom,modele_id,couleur_id, type_finition_id, motorisation_id, type_jante_id) VALUES ("Voiture2",1,2,3,2,1);
INSERT INTO voiture(nom,modele_id,couleur_id, type_finition_id, motorisation_id, type_jante_id) VALUES ("Voiture3",3,4,2,4,3);
INSERT INTO voiture(nom,modele_id,couleur_id, type_finition_id, motorisation_id, type_jante_id) VALUES ("Voiture4",2,3,1,4,4);
INSERT INTO voiture(nom,modele_id,couleur_id, type_finition_id, motorisation_id, type_jante_id) VALUES ("Voiture5",3,1,2,4,3);

INSERT INTO voiture_option_sup(voiture_id,option_sup_id) VALUES (1,1);
INSERT INTO voiture_option_sup(voiture_id,option_sup_id) VALUES (1,4);
INSERT INTO voiture_option_sup(voiture_id,option_sup_id) VALUES (2,3);
INSERT INTO voiture_option_sup(voiture_id,option_sup_id) VALUES (3,2);
INSERT INTO voiture_option_sup(voiture_id,option_sup_id) VALUES (3,4);
INSERT INTO voiture_option_sup(voiture_id,option_sup_id) VALUES (4,4);
INSERT INTO voiture_option_sup(voiture_id,option_sup_id) VALUES (4,1);

INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (1,2);
INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (1,3);
INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (1,1);
INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (2,1);
INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (2,3);
INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (3,2);
INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (4,1);
INSERT INTO modele_type_finition(modele_id,type_finition_id) VALUES (4,3);

INSERT INTO option_sup_type_finition(option_sup_id,type_finition_id) VALUES (1,1);
INSERT INTO option_sup_type_finition(option_sup_id,type_finition_id) VALUES (1,2);
INSERT INTO option_sup_type_finition(option_sup_id,type_finition_id) VALUES (2,2);
INSERT INTO option_sup_type_finition(option_sup_id,type_finition_id) VALUES (2,3);
INSERT INTO option_sup_type_finition(option_sup_id,type_finition_id) VALUES (3,1);
INSERT INTO option_sup_type_finition(option_sup_id,type_finition_id) VALUES (4,1);
INSERT INTO option_sup_type_finition(option_sup_id,type_finition_id) VALUES (4,2);

INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (1,1);
INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (1,2);
INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (1,3);
INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (2,3);
INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (3,2);
INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (3,1);
INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (4,3);
INSERT INTO couleur_type_finition(couleur_id,type_finition_id) VALUES (4,2);

INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (1,1);
INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (1,2);
INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (2,2);
INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (2,3);
INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (3,1);
INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (4,1);
INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (4,2);
INSERT INTO motorisation_type_finition(motorisation_id,type_finition_id) VALUES (4,3);

INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (1,2);
INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (1,3);
INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (2,3);
INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (2,2);
INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (2,1);
INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (3,2);
INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (3,3);
INSERT INTO type_jante_type_finition(type_jante_id,type_finition_id) VALUES (4,1);





