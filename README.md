# Gestion des Professeurs et Départements

Ce projet JavaFX est une application permettant la gestion des professeurs et des départements dans une organisation. Elle offre des fonctionnalités d'ajout, de modification, de suppression et de recherche, avec une interface intuitive développée grâce à **Scene Builder**.

---

## Diagrammes
### 1. **Diagramme de Classe**

---
### 2. **MLD**
---
## Structure du Projet

### 1. **Package `Modules`**
Contient les classes représentant les entités principales du système.

#### **Classe `Departement`**
Représente un département :
- `id_depart` : Identifiant unique du département.
- `nom` : Nom du département.

#### **Classe `Professeur`**
Représente un professeur :
- `id_prof` : Identifiant unique du professeur.
- `nom`, `prenom`, `cin`, `adresse`, `telephone`, `email` : Attributs personnels.
- `dateRecrutement` : Date de recrutement.
- `id_depart` : Identifiant du département auquel il appartient.

---

### 2. **Package `Controllers`**
#### **Classe `GestionProfDepController`**
Gère les interactions avec l'interface utilisateur :
- **Méthodes pour les départements** :
  - `ajouterDep(ActionEvent actionEvent)` : Ajoute un département.
  - `supprimerDep(ActionEvent actionEvent)` : Supprime un département.
  - `profDep(ActionEvent actionEvent)` : Affiche les professeurs d’un département.
- **Méthodes pour les professeurs** :
  - `ajouterProf(ActionEvent actionEvent)` : Ajoute un professeur.
  - `modifierProf(ActionEvent actionEvent)` : Modifie un professeur sélectionné.
  - `supprimerProf(ActionEvent actionEvent)` : Supprime un professeur sélectionné.
  - `rechercherProf(ActionEvent actionEvent)` : Recherche un professeur par mot-clé.

#### **Classe `Dialogue`**
Gère les boîtes de dialogue pour ajouter ou modifier les objets :
- `ajouterProfesseurDialog()`
- `modifierProfesseurDialog(Professeur professeur)`
- `ajouterDepartementDialog()`

---

### 3. **Package `Metiers`**
Contient la logique métier.

#### **Interface `Metier`**
Déclare les méthodes métier principales :
- **Pour les professeurs** :
  - `ajouterProfesseur(Professeur professeur)`
  - `modifierProfesseur(Professeur professeur)`
  - `supprimerProfesseur(int id)`
  - `listerProfesseurs()`
  - `rechercherProfesseurParMotCle(String motCle)`
  - `professeurParDepartement(int idDepartement)`
- **Pour les départements** :
  - `ajouterDepartement(Departement departement)`
  - `supprimerDepartement(int id)`
  - `listerDepartements()`

#### **Classe `MetierImpl`**
Implémente l'interface **Metier** et fournit les définitions des méthodes.

---

### 4. **Package `Singleton`**
#### **Classe `SingletonClassDB`**
Gère la connexion unique à la base de données pour minimiser l'utilisation des ressources. Elle suit le design pattern Singleton.

**Méthodes principales** :
- `getInstance()` : Retourne une instance unique de la classe.
- `getConnection()` : Fournit une connexion à la base de données.

**Avantage** : Réduit la création multiple de connexions avec la base de données, ce qui optimise les performances.

---

### 5. **Interface Graphique avec Scene Builder**
L’interface utilisateur est conçue avec **Scene Builder** pour faciliter la disposition des éléments visuels. Les principales fonctionnalités sont accessibles via :
- **TableView** : Affichage des professeurs et départements.
- **TextField** : Recherche par mot-clé.
- **Buttons** : Actions d'ajout, de modification et de suppression.
- Les dialogues sont intégrés pour les entrées utilisateur détaillées.

---
## Application  
 

La classe `GestionProfDep` est le point d'entrée principal de l'application JavaFX. Elle étend la classe `Application` du framework JavaFX et remplace la méthode `start` pour configurer la scène et le stade principaux.  

- `public void start(Stage primaryStage)`: Cette méthode est appelée lorsque l'application est lancée. Elle effectue les tâches suivantes :  
    - Charge le fichier FXML : Elle utilise la classe `FXMLLoader` pour charger le fichier `Main.fxml`. Ce fichier définit la mise en page de l'interface utilisateur principale en utilisant XML.  
    - Crée la scène : Elle crée une nouvelle instance de `Scene` avec la mise en page FXML chargée.  
    - Configure le stade : Elle configure le stade principal (fenêtre principale) de l'application avec un titre ("Gestion des Professeurs") et la scène créée.  
    - Affiche le stade : Elle rend le stade principal visible en appelant `primaryStage.show()`.  

- `public static void main(String[] args)`: C'est la méthode principale qui sert de point d'entrée de l'application Java. Elle lance l'application JavaFX en appelant la méthode `launch`. La méthode `launch` appelle en interne la méthode `start` définie ci-dessus.
