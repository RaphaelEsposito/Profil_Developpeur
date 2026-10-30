# Profil développeur Compose

## Description

Cette application Android affiche une fiche « Profil développeur » réalisée avec Jetpack Compose.
L'écran présente le nom, le rôle, une courte description, une liste de compétences, un contact
et une disponibilité. La disponibilité est une zone cliquable accessible, et un bouton « Contacter »
déclenche une action. Les composables reçoivent leurs données en paramètres, ce qui permet
d'afficher plusieurs profils différents, comme le montrent les deux previews.

## Notions utilisées

- fonctions composables (`@Composable`)
- paramètres et composants réutilisables
- `Modifier` et chaînage de modifiers
- padding externe / padding interne
- callbacks (`onClick: () -> Unit`)
- `Scaffold` et `innerPadding`
- `Surface`, `Column`, `Text`, `Button`
- accessibilité de base (`clickable` avec `Role.Button`, `semantics`, `contentDescription`)
- previews (`@Preview`)

## Explication

**1.**
`ProfileScreen`, `ProfileCard`, `ProfileHeader`, `SkillItem`, `InfoLine`, `AvailabilityBadge`,
`ContactButton`, ainsi que deux previews (`ProfileScreenJuniorPreview`, `ProfileScreenBackendPreview`).

**2.**
`ProfileScreen`. Il est appelé dans `MainActivity` à l'intérieur du `Scaffold`.

**3.**
Dans `ProfileScreen`, qui passe `Modifier.padding(16.dp)` à `ProfileCard` pour la décoller des bords
de l'écran. Dans `ProfileCard`, chaque `SkillItem` reçoit aussi `Modifier.padding(vertical = 4.dp)`
pour être espacé des autres. C'est le parent qui décide du placement.

**4.**
Dans `ProfileCard` (`Column(Modifier.padding(20.dp))`, entre le bord de la carte et son contenu),
dans `SkillItem` (autour du texte de l'étiquette) et dans `AvailabilityBadge` (autour du texte de
la zone cliquable). C'est le composant lui-même qui espace son contenu.

**5.**
`ContactButton` et `AvailabilityBadge` reçoivent un paramètre `onClick: () -> Unit`. Ils signalent
le clic sans décider de ce qui se passe ensuite : la décision est prise plus haut (`MainActivity`).

**6.**
Sur la zone personnalisée `AvailabilityBadge` : `clickable` avec `role = Role.Button` et un
`onClickLabel`, puis `semantics { contentDescription = ... }`. Un lecteur d'écran annonce donc
cet élément comme un bouton et lit une description claire de l'action.
Le `ContactButton` utilise un `Button` Material, qui expose déjà par défaut le rôle de bouton
et son texte aux services d'accessibilité : il est plus explicite qu'une simple zone cliquable.

**7.**
Ils n'affichent pas de données écrites en dur : tout arrive par paramètres (nom, rôle, compétence,
texte du bouton, callback…). Ils acceptent tous un `modifier: Modifier = Modifier`, ce qui laisse
le parent décider de leur taille et de leur placement. Les deux previews affichent ainsi deux
profils différents avec le même code.

## Capture d'écran

[Preview du profil](img.png)
