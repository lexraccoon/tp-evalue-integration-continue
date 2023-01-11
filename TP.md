# Explication projet
Membres du groupe : 
- Hugo DEGARDIN
- Thomas DUCOULOMBIER
- Maxime FEBURIER
- Laura GONCALVES
- Lucas TAVERNIER

Pour débuter le projet, nous avons repris une MSPR de l'année précédente, dans laquelle nous avons du code JAVA qui génère des fichiers HTML formant un site web, et nous avons récupéré la VM Jenkins que nous avions créé.
Dans ce projet, nous possédions une pipeline avec un JenkinsFile contenant le build du projet, l'exécution de notre .jar générant notre site web et de nos tests, puis l'envoi d'un dossier, comportant notre site web, vers un serveur web pour héberger ce dernier.

Pour ce TP évalué, il fallait donc que nous modifions la fin de notre JenkinsFile pour packager notre dossier web, puis l'encapsuler dans une image Docker pour l'envoyer sur Nexus.

Pour cela, nous avons téléchargé Nexus sur notre machine grâce à la documentation officielle. Après son installation, nous avons créé un repository en docker hosted qu'on a nommé IntegrationContinueDocker. Nous avons créé un connecteur HTTP avec le port 8085 pour que le repository ne tourne pas sur la même port que le Nexus. Puis, nous avons ajouté le domaine "Docker Bearer Token Realm".

Ensuite, nous générons un fichier Dockerfile dans notre Github, car lors du build de l'image Docker, c'est ce fichier qui déterminera les étapes à réaliser. C'est-à-dire, envoyer notre dossier web vers le dossier Apache pour que notre site web fonctionne.

Enfin, nous avons modifié notre JenkinsFile pour ajouter les étapes nécessaires à la création de l'image Docker et de l'envoi vers notre Nexus. 
Il y a 4 étapes en plus :
- le build de l'image Docker gosecuri (nom de notre projet MSPR), 
- l'envoi vers le Nexus en utilisant un registre Docker personnalisé (l'ip de notre Nexus) et en poussant le container dans notre registre personnalisé,
- l'arrêt de tous les containers,
- le lancement de notre image docker.

Pour les difficultés que nous avons rencontré, nous avons eu un erreur lors du build de l'image car nous avions nommé le fichier de configuration "DockerFile" au lieu de "Dockerfile". Et, la dernière difficulté fut qu'à la fin nous n'avons pas réussi à accéder par le bon URL à notre dossier web.