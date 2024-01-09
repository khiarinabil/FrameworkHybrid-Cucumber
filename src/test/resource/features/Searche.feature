@search
Feature:(order=2) je souhaite testè la fonctialitè de recherche
@searche-cas-passant
Scenario: je testè avec un vrai produit
Given je ouvre le application 
When je saisi un valide produit "HP" dans le champ de recherche
And je click sur le boutton recherche
Then le produit est existe


@searche-cas-non-passant
Scenario: je testè avec un proquit ne pas exist
Given je ouvre le application
When je saisi un invalide produit "Honda" dans le champ de recherche
And je click sur le boutton recherche
Then le message de erreur va affiche

Scenario: je testè sans saisi le nom de produit
Given je ouvre le application
When je saisie rien dans le champ de recherche
And je click sur le boutton recherche
Then le message de erreur va affiche