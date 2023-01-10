# Explication projet
Membres du groupe : 
- Hugo DEGARDIN
- Thomas DUCOULOMBIER
- Maxime FEBURIER
- Laura GONCALVES
- Lucas TAVERNIER

Pour débuter le projet, nous avons repris une MSPR de l'année précédente, dans laquelle nous avons du code JAVA qui génère des fichiers HTML formant un site web.
Nous avions dans ce projet une pipeline avec un JenkinsFile contenant le build du projet, l'exécution de notre .jar générant notre site web et de nos tests, puis l'envoi d'un dossier, comportant notre site web, vers un serveur web pour héberger ce dernier.

Pour ce TP évalué, il fallait donc que nous modifions la fin de notre JenkinsFile pour packager notre site web puis l'encapsuler dans une image Docker pour l'envoyer sur Nexus.

Pour cela, nous avons télécharger Nexus grâce à la documentation officielle.
