# API Spring - Jeux Olympiques


## Swagger
- **documentation swagger**: [ici](https://app.swaggerhub.com/apis-docs/Daniel:VRDX/Spring-Api/1.0.0)

## Collection Postman

Une collection Postman est disponible pour tester les endpoints de l'API.

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/23821582-876094a8-000d-47d1-b579-0b3c3d8018b9?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D23821582-876094a8-000d-47d1-b579-0b3c3d8018b9%26entityType%3Dcollection%26workspaceId%3Dab7e2bdf-a3ed-49ab-a925-62bb0bd22db4)

## Sécurité
Cette API utilise l'authentification par token (Bearer). Il vous suffit de creer un compte en avec la route `/register`, ou vous connecter avec `/login`.

## Endpoints

### Compte

- `POST /register` : Crée un nouveau compte, et renvoie un token.
- `POST /login` : Connecte un utilisateur, et renvoie un token.


## Les Endpoints suivants peuvent être visualisés par tous les utilisateurs.

### Utilisateurs

- `GET /admin/user` : Retourne la liste des utilisateurs.
- `GET /admin/user/{USER_ID}` : Retourne un utilisateur par ID.
- `PUT /admin/user/{USER_ID}` : Met à jour un utilisateur.
- `DELETE /admin/user/{USER_ID}` : Supprime un utilisateur.

### Tickets

- `GET /api/ticket` : Retourne la liste des billets.
- `POST /api/ticket` : Crée un nouveau billet.
- `PUT /api/ticket/{TICKET_ID}` : Met à jour un billet.
- `DELETE /api/ticket/{TICKET_ID}` : Supprime un billet.

## Les Endpoints suivants peuvent être visualisés par tous les utilisateurs ayant un rôle "ADMIN".

### Événements

- `GET /admin/event/{EVENT_ID}` : Retourne un événement par ID.
- `PUT /admin/event/{EVENT_ID}` : Met à jour un événement.
- `DELETE /admin/event/{EVENT_ID}` : Supprime un événement.
- `POST /admin/event` : Crée un nouvel événement.

### Stades

- `GET /admin/stadium` : Retourne la liste des stades.
- `POST /admin/stadium` : Crée un nouveau stade.
- `PUT /admin/stadium/{EVENT_ID}` : Met à jour un stade.
- `DELETE /admin/stadium/{EVENT_ID}` : Supprime un stade.
