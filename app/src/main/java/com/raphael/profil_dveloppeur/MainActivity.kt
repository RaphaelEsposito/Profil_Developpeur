package com.raphael.profil_dveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raphael.profil_dveloppeur.ui.theme.ProfilDéveloppeurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDéveloppeurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        name = "Raphael Esposito",
                        role = "Développeur Android junior",
                        description = "Étudiant en développement, Je découvre Jetpack Compose.",
                        skills = listOf("Kotlin", "Jetpack Compose", "Git"),
                        contact = "esposito.raphael@outlook.com",
                        availability = "Disponible pour une alternance",
                        isAvailable = true,
                        onContactClick = {},
                        onAvailabilityClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Écran principal
 */
@Composable
fun ProfileScreen(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    contact: String,
    availability: String,
    isAvailable: Boolean,
    onContactClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        ProfileCard(
            name = name,
            role = role,
            description = description,
            skills = skills,
            contact = contact,
            availability = availability,
            isAvailable = isAvailable,
            onContactClick = onContactClick,
            onAvailabilityClick = onAvailabilityClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

/**
 * Fiche de profil
 */
@Composable
fun ProfileCard(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    contact: String,
    availability: String,
    isAvailable: Boolean,
    onContactClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            ProfileHeader(name = name, role = role)

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = "Compétences",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )
            for (skill in skills) {
                SkillItem(
                    skill = skill,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }

            InfoLine(
                label = "Contact",
                value = contact,
                modifier = Modifier.padding(top = 16.dp)
            )

            AvailabilityBadge(
                text = availability,
                isAvailable = isAvailable,
                onClick = onAvailabilityClick,
                modifier = Modifier.padding(top = 12.dp)
            )

            ContactButton(
                text = "Contacter",
                onClick = onContactClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }
    }
}

/**
 * En-tête
 */
@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = role,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

/**
 * Une compétence affichée sous forme d'étiquette.
 */
@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Text(
            text = skill,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

/**
 * Information secondaire sous la forme « libellé : valeur ».
 */
@Composable
fun InfoLine(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Composable
fun AvailabilityBadge(
    text: String,
    isAvailable: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = if (isAvailable) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.errorContainer
        }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClickLabel = "Voir les détails de disponibilité",
                    role = Role.Button,
                    onClick = onClick
                )
                .semantics {
                    contentDescription = "Disponibilité : $text. Appuyer pour voir les détails."
                }
                .padding(16.dp)
        )
    }
}

/**
 * Bouton d'action réutilisable.
 */
@Composable
fun ContactButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, name = "Android junior – disponible")
@Composable
fun ProfileScreenJuniorPreview() {
    ProfilDéveloppeurTheme {
        ProfileScreen(
            name = "Léa Martin",
            role = "Développeuse Android junior",
            description = "Étudiante en développement, passionnée par les interfaces " +
                    "mobiles claires et accessibles. Je découvre Jetpack Compose.",
            skills = listOf("Kotlin", "Jetpack Compose", "Git", "Material 3"),
            contact = "lea.martin@example.com",
            availability = "Disponible pour une alternance",
            isAvailable = true,
            onContactClick = {},
            onAvailabilityClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Backend – non disponible")
@Composable
fun ProfileScreenBackendPreview() {
    ProfilDéveloppeurTheme {
        ProfileScreen(
            name = "Karim Benali",
            role = "Développeur backend",
            description = "Six ans d'expérience sur des API REST et des bases de données. " +
                    "J'aime le code propre et bien testé.",
            skills = listOf("PHP / Symfony", "PostgreSQL", "Docker"),
            contact = "Sur LinkedIn uniquement",
            availability = "En mission jusqu'en juin",
            isAvailable = false,
            onContactClick = {},
            onAvailabilityClick = {}
        )
    }
}