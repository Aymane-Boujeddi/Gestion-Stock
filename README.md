# Gestion-Stock

## 📋 Description
Système de gestion de stock avec valorisation FIFO (First In, First Out) pour une gestion optimale des stocks et approvisionnements. Cette application permet de gérer les produits, fournisseurs, commandes, stocks et mouvements de stock avec une traçabilité complète.

## 🏗️ Architecture
- **Backend**: Spring Boot 3.5.7
- **Base de données**: MySQL
- **Migration**: Liquibase
- **Mapping**: MapStruct 1.5.5
- **Documentation API**: SpringDoc OpenAPI 3
- **Validation**: Spring Boot Validation

## 🚀 Technologies Utilisées
- Java 17
- Spring Boot (Web, Data JPA, Validation)
- MySQL Connector
- Liquibase pour les migrations
- MapStruct pour le mapping DTO/Entity
- Lombok pour réduire le boilerplate
- SpringDoc pour la documentation Swagger

## 📦 Modules Principaux

### 🏪 Gestion des Produits
- Création, modification, consultation des produits
- Suivi du stock actuel par produit
- Gestion des seuils de stock

### 🤝 Gestion des Fournisseurs
- Enregistrement des fournisseurs
- Gestion des informations de contact
- Historique des commandes par fournisseur

### 📋 Gestion des Commandes
- Création de commandes avec détails
- Statuts: BROUILLON, EN_ATTENTE, LIVREE, ANNULEE
- Calcul automatique du montant total
- Mise à jour des stocks lors de la livraison

### 📤 Gestion des Bons de Sortie
- Création de bons de sortie avec motifs
- Statuts: BROUILLON, VALIDE, ANNULE
- Validation avec vérification des stocks disponibles
- Application de la méthode FIFO pour les sorties

### 📊 Gestion des Stocks
- Suivi des stocks par lot (FIFO)
- Traçabilité des mouvements (entrées/sorties)
- Historique complet des mouvements

## 🗂️ Structure du Projet

```
src/main/java/com/gestion/stock/
├── controller/          # Contrôleurs REST
├── dto/
│   ├── request/        # DTOs de requête
│   └── response/       # DTOs de réponse
├── entity/             # Entités JPA
├── enums/              # Énumérations
├── exception/          # Gestion des exceptions
├── mapper/             # Mappers MapStruct
├── repository/         # Repositories JPA
└── service/
    └── impl/          # Implémentations des services
```

## 🔧 Configuration

### Base de Données
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_stock_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### Liquibase
```properties
spring.liquibase.change-log=classpath:/db/changelog/db.changelog-master.xml
spring.liquibase.enabled=true
```

### Serveur
```properties
server.port=8080
server.servlet.context-path=/gestionStock/api/v1
```

## 📚 API Documentation
- **Swagger UI**: `http://localhost:8080/gestionStock/api/v1/swagger-ui.html`
- **API Docs**: `http://localhost:8080/gestionStock/api/v1/api-docs`

## 🎯 Fonctionnalités Clés

### Valorisation FIFO
- Les sorties de stock suivent la règle "Premier Entré, Premier Sorti"
- Traçabilité complète des lots
- Optimisation de la gestion des dates de péremption

### Validation des Stocks
- Vérification automatique des quantités disponibles
- Prévention des sorties sur stock insuffisant
- Mise à jour en temps réel des stocks

### Gestion des Statuts
- **Commandes**: BROUILLON → EN_ATTENTE → LIVREE/ANNULEE
- **Bons de Sortie**: BROUILLON → VALIDE/ANNULE
- Contrôle des transitions d'état

## 🚀 Installation et Démarrage

### Prérequis
- Java 17+
- MySQL 8.0+
- Maven 3.6+

### Étapes d'installation
1. **Cloner le projet**
```bash
git clone <repository-url>
cd Gestion-Stock
```

2. **Configurer la base de données**
```sql
CREATE DATABASE gestion_stock_db;
```

3. **Modifier application.properties**
```properties
spring.datasource.password=your_mysql_password
```

4. **Compiler et démarrer**
```bash
mvn clean install
mvn spring-boot:run
```

## 📋 Endpoints Principaux

### Produits
- `GET /produits` - Liste des produits
- `GET /produits/{id}` - Obtenir un produit par ID
- `POST /produits` - Créer un produit
- `PUT /produits/{id}` - Modifier un produit
- `DELETE /produits/{id}` - Supprimer un produit

### Fournisseurs
- `GET /fournisseurs` - Liste des fournisseurs
- `GET /fournisseurs/{id}` - Obtenir un fournisseur par ID
- `POST /fournisseurs` - Créer un fournisseur
- `PUT /fournisseurs/{id}` - Modifier un fournisseur
- `DELETE /fournisseurs/{id}` - Supprimer un fournisseur

### Commandes
- `GET /commandes` - Liste des commandes
- `GET /commandes/{id}` - Obtenir une commande par ID
- `GET /commandes/{id}/fournisseur` - Commandes par fournisseur
- `POST /commandes` - Créer une commande
- `PUT /commandes/{id}` - Modifier une commande
- `PUT /commandes/{id}/livree` - Livrer une commande
- `PUT /commandes/{id}/annulee` - Annuler une commande
- `DELETE /commandes/{id}` - Supprimer une commande

### Bons de Sortie
- `GET /bonsSortie` - Liste des bons de sortie
- `GET /bonsSortie/{id}` - Obtenir un bon de sortie par ID
- `POST /bonsSortie` - Créer un bon de sortie
- `PUT /bonsSortie/{id}` - Modifier un bon de sortie
- `PUT /bonsSortie/{id}/valider` - Valider un bon de sortie
- `PUT /bonsSortie/{id}/annuler` - Annuler un bon de sortie

### Stocks
- `GET /stock` - État des stocks
- `GET /stock/produit/{id}` - Stocks par produit (FIFO)
- `GET /stock/mouvements` - Historique des mouvements
- `GET /stock/mouvements/produit/{id}` - Mouvements par produit
- `GET /stock/alertes` - Produits sous seuil
- `GET /stock/valorisation` - Valorisation du stock

## 🔍 Modèle de Données

### Entités Principales
- **Produit**: Informations produit et stock actuel
- **Fournisseur**: Données fournisseur
- **Commande**: Commandes avec détails
- **BonSortie**: Bons de sortie avec items
- **Stock**: Lots de stock (FIFO)
- **MouvementStock**: Historique des mouvements

### Relations
- Produit ↔ Stock (1:N)
- Fournisseur ↔ Commande (1:N)
- Commande ↔ DetailsCommande (1:N)
- BonSortie ↔ BonSortieItem (1:N)
- Stock ↔ MouvementStock (1:N)

## 🛠️ Développement

### Ajout d'une nouvelle fonctionnalité
1. Créer l'entité JPA
2. Ajouter la migration Liquibase
3. Créer les DTOs (request/response)
4. Implémenter le mapper MapStruct
5. Créer le repository
6. Implémenter le service
7. Créer le contrôleur REST

### Bonnes Pratiques
- Utilisation de MapStruct pour le mapping
- Validation avec Bean Validation
- Gestion des exceptions centralisée
- Transactions avec @Transactional
- Documentation API avec SpringDoc

## 🧪 Tests avec Postman

Une collection Postman complète est disponible dans le dossier `Postman-Collection/` pour tester tous les endpoints de l'API.

### Collection incluse:
- **Gestion du stock.postman_collection.json**

### Exemples de requêtes disponibles:

#### Fournisseurs
```json
// Créer un fournisseur
POST /fournisseurs
{
  "nom": "Test Fournisseur",
  "adresse": "123 Test Street",
  "personneContact": "John Doe",
  "email": "test@example.com",
  "telephone": "0123456789",
  "ville": "Casablanca",
  "raisonSociale": "Test SARL",
  "ICE": "123456789012345"
}
```

#### Commandes
```json
// Créer une commande avec détails
POST /commandes
{
  "fournisseurId": 1,
  "statutCommande": "EN_ATTENTE",
  "detailsCommande": [
    {
      "produitId": 1,
      "quantite": 2,
      "prix": 200
    }
  ]
}
```

#### Bons de Sortie
```json
// Créer un bon de sortie
POST /bonsSortie
{
  "atelier": "Atelier Production A",
  "motif": "PRODUCTION",
  "motifDetails": "Production urgente pour commande client",
  "items": [
    {
      "produitId": 1,
      "quantite": 50
    }
  ]
}
```

### Import de la collection:
1. Ouvrir Postman
2. Cliquer sur "Import"
3. Sélectionner le fichier `Gestion du stock.postman_collection.json`
4. La collection sera importée avec tous les endpoints configurés

### Variables d'environnement suggérées:
- `base_url`: `http://localhost:8080/gestionStock/api/v1`
- `content_type`: `application/json`

## 👥 Contributeurs
- **Hajar** - Développeur principal

## 📄 Licence
Ce projet est sous licence privée.