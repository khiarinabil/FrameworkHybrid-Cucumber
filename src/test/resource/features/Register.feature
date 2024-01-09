@register
Feature:(order=0) je souhaite testè la page registration

  @registation-cas-passant
  Scenario: je souhaite testè la page registation avec un cas passant
    Given je navigue vers la page registration
    When je saisi les coordonneè de registation
      | firstName | Arun                       |
      | lastName  | motoori                    |
      
      | telephone |                 1234567890 |
      | password  |                      12345 |
    And je coche Privacy Policy
    And je click sur le boutton continu
    Then le compt crer avec succes

  Scenario: je souhaite testè la page registation avec un cas passant avec tous les coordonnes
    Given je navigue vers la page registration
    When je saisi les coordonneè de registation
      | firstName | Arun                      |
      | lastName  | motoori                   |
      
      | telephone |                1234567890 |
      | password  |                     12345 |
    And je select yes a Newsletter
    And je coche Privacy Policy
    And je click sur le boutton continu
    Then le compt crer avec succes

  @registration-avec-cas-non-passant
  Scenario: je souhaite testè la registation avec deplucation des donnèe
    Given je navigue vers la page registration
    When je saisi les coordonneè de registatuon avec dublication mail
      | firstName | Arun                       |
      | lastName  | motoori                    |
      | email     | nabilkhiari556@gmail.com |
      | telephone |                 1234567890 |
      | password  |                      12345 |
    And je select yes a Newsletter
    And je coche Privacy Policy
    And je click sur le boutton continu
    Then Le message d erreur duplicationmail affiche

  Scenario: je souhaite testè le registration sans saisi les coordoneè
    Given je navigue vers la page registration
    When je rempli aucun champ
    And je click sur le boutton continu
    Then Le message de erreur s affiche
