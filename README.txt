Projet Tuteuré Java réalisé par : MICHOT Rémi, TORTEVOIS Evan, LECOURT Grégoire
Un projet de développement java sous Eclipse d'une "Application de suivi des pointages d’horaires des employés d’une entreprise" et de son émulateur de pointeuse.

Vis-à-vis de l'organisation des sources de notre projet, nous avons architecturé nos sources de manière à respecter le pattern MVC (Modèle-vue-contrôleur).
Ainsi, nous pouvons retrouver trois packages différents contenant : les vues des interfaces au format FXML, les contrôleurs d'interface Java associés aux vues et enfin le modèle de classes Java qui permet la représentation d'employés d'une entreprise et de leurs caractéristiques.

Pour l'instanciation du modèle dans les applications, le pattern singleton est utilisé pour contenir toutes les données en un seul objet unique.
On notes tout de même que pour l'implémentation de l'émulateur de pointeuse, un package qui est greffé au projet lui est dédié. Un choix, car l'émulateur n'est qu'un outil de test pour notre projet.

3 Exécutable possibles, ceux-ci sont tous des lancements d'interface qui nécessite la librairie JavaFX (JavaFX doit être référencé dans la "Run Configuration").
Le premier permet le lancement de l'Application Centrale, localisation : fr.univtours.polytech.clocking.controller.ApplicationLauncher
Le second permet le lancement de l'émulateur de pointeuse, localisation : fr.univtours.polytech.clocking.emulator.ClockingLauncher
Le dernier permet le lancement des deux précédant simultanément, Localisation : fr.univtours.polytech.clocking.controller.DoubleLauncher
Afin de lancer le projet sous eclipse il est necessaire de : 
ajouter au projet les externals jars qui sont present dans le dossier lib,
ajouter dans les Run configurations une nouvelle configuration, avec pour Argument VM : --module-path "{path du dossier de lib javafx}" --add-modules javafx.controls,javafx.fxml

Les classes principales utilisées sont dans la partie modèle du projet :
Employee.java : représentation d'un employé et des informations associé tels que son ID, Nom, emploi du temps, historique de pointage...
Timeclock.java : représentation d'un pointage effectué par la pointeuse avec l'information de l'ID, la date, l'heure. C'est l'objet qui est sérialisé et transmit par socket lors des communications TCP en l'application centrale et la pointeuse.
ApplicationCentrale.java : représentation de la liste d'employés, objet instancier et utilisé en pattern singleton par l'Application Centrale

Information utile, les données sérialisées sont lues et écrites à la racine du projet, en fonction de leur nom de fichier (modifiable dans les paramètres).
Il est aussi important de savoir qu'Eclipse occupe les ports de connexion qui on put être ouvert lors du lancement d'une précédente connexion. Ainsi, pour continuer à utiliser un même port de communication entre application et pointeuse, après redémarrage de celle-ci, il est préférable de relancer L'IDE Eclispse.

Pour les contraintes d'ordres de lancement, il est préférable de d'abord lancer l'application centrale (ApplicationLauncher) puis l'émulateur de pointeuse (ClockingLauncher).
Même si normalement, fermer et ouvrir les Interfaces dans n'importe quel ordre fonctionne.