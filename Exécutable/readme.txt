$java -jar TSP.jar [type d'algorithme] [fichier d'entr�e] ...

1. type d'algorithme:
h: heuristique
l: descente locale
r: recuit simul�

2. fichier d'entr�e
chemin du fichier d'entr�e
ex: jeu-essai/20.in3

3. Param�tres suppl�mentaires pour le recuit
temp�rature et refroidissement
ces param�tres sont facultatifs. Ils sont par d�faut �:
t = 1000
r = 0.00001


EXEMPLE D'UTILISATION

$java -jar TSP.jar r jeu-essai/20.in3 1000 0.00001

Ex�cutera :
recuit
 avec le fichier jeu-essai/20.in3
 une temp�rature initiale de 1000
 un refroidissement de 0.00001
