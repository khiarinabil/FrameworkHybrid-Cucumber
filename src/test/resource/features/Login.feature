@login
Feature:(order=1) Je souhaite tester la page de la connexion de l application

@login-cas-passant

Scenario: je souhaite testè avec un cas passant
Given je navigue vers la page login
When je saisi un valide adress mail "nabilkhiari9@gmail.com" dans le champ email
And je saisi une valide mot de passe "12345" dans le champs mot de passe
And je click sur le boutton login
Then un message de success affichè


@ligin-cas-non-passant
Scenario: je souhaite testè avec une cas non passant
Given je navigue vers la page login 
When je saisi une adress mail invalide  dans le champ adress mail
And  je saisi une mot de passe invalide "3453" dans le champ mot de passe
And je click sur le boutton login
Then Le message d erreur s affiche 

Scenario: je souhaite testè avec un valid adress mail et invalid mot de passe
Given je navigue vers la page login 
When je saisi un valide adress mail "nabilkhiari9@gmail.com" dans le champ email
And je saisi une mot de passe invalide "3453" dans le champ mot de passe
And je click sur le boutton login
Then Le message d erreur s affiche

Scenario: je souhaite testè avec un invalid adress mail et valid mot de passe
Given je navigue vers la page login 
When je saisi une adress mail invalide  dans le champ adress mail
And je saisi une valide mot de passe "12345" dans le champs mot de passe
And je click sur le boutton login
Then Le message d erreur s affiche

Scenario: je souhaite testè sans saisir mail et mot de passe
Given  je navigue vers la page login 
When  je saisi pas l adresse mail
And je saisi pas le mot de passe
And je click sur le boutton login
Then Le message d erreur s affiche



