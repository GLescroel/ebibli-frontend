eBibli-frontend

Application web du système d'information des bibliothèques de la ville à destination des usagers.
Ce site web permet aux usagers de :
- consulter les ouvrages proposés dans les bibliothèques de la ville
- voir le nombre d'exemplaires disponibles 
- et les livres disponibles (ou non) dans chaque bibliothèque
- consulter la liste de leurs emprunts en cours et de les prolonger (une fois)
- consulter l'historique de leurs emprunts.

Ce client Rest interroge le backend qui expose les microservices Rest sur les url http://localhost:9001 à 9005 paramétrables dans le fichier application.properties

Pré-requis technique

Version de Java : 1.8
 JDK : jdk1.8.0_202
 Maven 3.6.0

Base de données : aucune (la base de données est connectée au backend)

Installation et déploiement:

Packaging
mvn clean package : le fichier ebibli-frontend-1.0.war qui contient l'application est généré

Il est maintenant possible de lancer l'application directement dans votre IDE en exécutant le Main
ou en ligne de commande (application standalone intégrant un conteneur web grace à SpringBoot) : mvn clean install spring-boot:run
ou de déployer le war dans un tomcat.

Le port de l'Application est paramétré dans application.propertie : http://localhost:8080/

Les microservices du backend (https://github.com/GLescroel/ebibli-backend) doit avoir été lancés préalablement

Documentation : la javadoc peut être générée via la commande mvn javadoc:javadoc puis consultée à partir de la page \target\site\apidocs\index.html

Comptes utilisateurs de test :
user@oc.com / USER = compte utilisateur
membre@oc.com / MEMBRE = compte membre de l'association
admin@oc.com / ADMIN = compte administrateur
dupont@oc.com / DUPONT = utilisateur
dubois@oc.com / DUBOIS = utilisateur
smith@oc.com / SMITH = utilisateur

Sources disponibles sur : https://github.com/GLescroel/ebibli-frontend
