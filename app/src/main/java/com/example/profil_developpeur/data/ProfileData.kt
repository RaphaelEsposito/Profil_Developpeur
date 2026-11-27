package com.example.profil_developpeur.data

import androidx.annotation.DrawableRes
import com.example.profil_developpeur.R

/** Une compétence avec un niveau entre 0f et 1f. */
data class Skill(
    val name: String,
    val level: Float,
    val levelLabel: String,
    @DrawableRes val iconRes: Int
)

/** Un projet ou une expérience. */
data class Project(
    val title: String,
    val period: String,
    val description: String,
    val technologies: List<String>,
    @DrawableRes val iconRes: Int
)

/** Toutes les informations affichées sur l'écran de profil. */
data class DeveloperProfile(
    val name: String,
    val role: String,
    val description: String,
    val email: String,
    val location: String,
    val availability: String,
    val isAvailable: Boolean,
    val skills: List<Skill>,
    val projects: List<Project>
)

/**
 * Données locales, écrites directement dans le code
 * (pas d'API, pas de base de données).
 */
object SampleData {

    val raphael = DeveloperProfile(
        name = "Raphael Esposito",
        role = "Développeur Android junior",
        description = "Étudiant en développement, je conçois des applications mobiles " +
                "avec Kotlin et Jetpack Compose. J'aime les interfaces claires, " +
                "accessibles et bien structurées.",
        email = "esposito.raphael@outlook.com",
        location = "France",
        availability = "Disponible pour une alternance",
        isAvailable = true,
        skills = listOf(
            Skill("Kotlin", 0.8f, "Avancé", R.drawable.ic_code),
            Skill("Jetpack Compose", 0.7f, "Intermédiaire", R.drawable.ic_phone_android),
            Skill("Material 3", 0.6f, "Intermédiaire", R.drawable.ic_star),
            Skill("Git", 0.7f, "Intermédiaire", R.drawable.ic_work),
            Skill("SQL", 0.5f, "Notions", R.drawable.ic_storage)
        ),
        projects = listOf(
            Project(
                title = "Profil développeur",
                period = "2026",
                description = "Fiche de profil en Compose : composants réutilisables, " +
                        "listes Lazy et thème Material 3 clair / sombre.",
                technologies = listOf("Kotlin", "Compose", "M3"),
                iconRes = R.drawable.ic_phone_android
            ),
            Project(
                title = "Application de tâches",
                period = "2026",
                description = "Petite liste de tâches avec ajout, suppression et filtres " +
                        "simples, réalisée pendant la formation.",
                technologies = listOf("Kotlin", "Compose"),
                iconRes = R.drawable.ic_event_available
            ),
            Project(
                title = "Site vitrine",
                period = "2025",
                description = "Site web responsive pour présenter une association locale.",
                technologies = listOf("HTML", "CSS", "JS"),
                iconRes = R.drawable.ic_code
            )
        )
    )

    /** Second profil fictif, utilisé dans les previews. */
    val lea = DeveloperProfile(
        name = "Léa Martin",
        role = "Développeuse full-stack freelance",
        description = "Six ans d'expérience sur des applications web et mobiles. " +
                "Je travaille en freelance pour des PME.",
        email = "lea.martin@example.com",
        location = "Lyon",
        availability = "En mission jusqu'en juin",
        isAvailable = false,
        skills = listOf(
            Skill("TypeScript", 0.9f, "Expert", R.drawable.ic_code),
            Skill("Kotlin", 0.6f, "Intermédiaire", R.drawable.ic_phone_android),
            Skill("PostgreSQL", 0.8f, "Avancé", R.drawable.ic_storage)
        ),
        projects = listOf(
            Project(
                title = "Plateforme de réservation",
                period = "2024 – 2025",
                description = "API REST et front web pour un réseau de salles de sport.",
                technologies = listOf("Node", "React", "SQL"),
                iconRes = R.drawable.ic_work
            )
        )
    )
}