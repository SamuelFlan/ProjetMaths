$java -jar TSP.jar [type d'algorithme] [fichier d'entrée] ...

1. type d'algorithme:
h: heuristique
l: descente locale
r: recuit simulé
s: recuit simulé avec raffinement
d: descente locale avec raffinement

2. fichier d'entrée
chemin du fichier d'entrée
ex: jeu-essai/20.in3

3. Paramètres supplémentaires pour le recuit
température et refroidissement
ces paramètres sont facultatifs. Ils sont par défaut à:
t = 1000
r = 0.00001


EXEMPLE D'UTILISATION

$java -jar TSP.jar r jeu-essai/20.in3 1000 0.00001

Exécutera :
recuit
 avec le fichier jeu-essai/20.in3
 une température initiale de 1000
 un refroidissement de 0.00001
