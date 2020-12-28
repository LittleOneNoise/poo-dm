- Spring Web : Créer des applications web, y compris RESTful, en utilisant Spring MVC. Utilise Apache Tomcat comme conteneur intégré par défaut.

- Spring Data JPA : Maintenir les données dans des librairies SQL avec l'API Java Persistence en utilisant Spring Data et Hibernate.

- Validation : Validation JSR-303 avec le validateur Hibernate.

- H2 Database : Fournit une base de données en mémoire rapide qui prend en charge l'API JDBC et l'accès R2DBC, avec une petite empreinte (2 Mo). Prend en charge les modes embarqué et serveur ainsi qu'une application de console basée sur un navigateur.


- Spring Boot DevTools : Fournit un redémarrage rapide des applications, LiveReload et des configurations pour une meilleure expérience de développement.

- Thymeleaf : Un moteur de template Java moderne côté serveur pour les environnements web et autonomes. Permet au HTML de s'afficher correctement dans les navigateurs et sous forme de prototypes statiques.

########################################################################################

QUESTIONS :

Q : Avec quelle partie du code avons-nous paramétré l'url d'appel /greeting ?
R : C'est grâce au "@GetMapping("/greeting")". En effet, l'annotation @GetMapping met en correspondance les requêtes HTTP GET avec des méthodes de traitement spécifiques. C'est une annotation composée qui agit comme un raccourci pour @RequestMapping(method = RequestMethod.GET).

Q: Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?
R : Le return à la fin de méthode sert à indiquer la vue (le fichier html dans notre cas) à afficher.

Q : Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?
R : Il est transmis via l'url et récupéré par la méthode GET.

Q : Etape 17 : Avez-vous remarqué une différence ?
R : Une table nommée ADDRESS s'est rajouté

Q : Expliquez l'apparition de la nouvelle table
R : Spring gère les entités dans le package "model" en les intégrant directement en table.

Q : Voyez-vous tout le contenu de data.sql ?
R : Nous voyons les données insérées dans le tableau grâce à la commande SQL écrite dans data.sql

Q : Etape 20 : Faites une requête de type SELECT sur la table Address. Voyez-vous tout le contenu de data.sql ?
R : Oui toutes les données ont été ajouté avec succès.

Q : Pouvez-vous trouver à quoi sert l'annotation @Autowired du code précédent sur internet ?
R: L'annotation @autowired sert à injecter des beans à notre bean. En d'autres termes, elle est utilisé pour automatiquement créer des liens entre nos dépendeances et ressources.

Q : Faut-il une clé API pour appeler OpenWeatherMap ?
R : Oui cela est obligatoire sinon la requête nous renvoit un message d'erreur

Q : Quelle URL appeler ?
R : api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}

Q : Quelle méthode HTTP utiliser ?
R : La méthode GET

Q : Comment passer les paramètres d'appels ?
R : Via des variables injectées dans la String contenant la structure de l'url

Q : Où est l'information dont j'ai besoin dans la réponse :
    - Pour afficher la température du lieu visé par les coordonnées GPS :
    R : Au niveau du paramètre "temp" dans le "main"
    - Pour afficher la prévision de météo du lieu visé par les coordonnées GPS :
    R : Au niveau du paramètre "weather"