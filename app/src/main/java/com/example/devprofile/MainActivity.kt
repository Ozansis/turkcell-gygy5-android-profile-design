package com.example.devprofile

import android.R.attr.fontWeight
import android.R.attr.icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devprofile.ui.theme.DevProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            DevProfileTheme() {
                Scaffold() { it ->
                    DevProfileScreen(modifier = Modifier.padding(it))
                }

            }

        }
    }
}


@Composable
fun DevProfileScreen(modifier: Modifier) {

    val skillNames = listOf(
        "Kotlin",
        "Android",
        "Jetpack Compose",
        "Firebase",
        "Git",
        "REST API"
    )

    val skillEmojis = listOf(
        "💻",
        "🤖",
        "🎨",
        "🔥",
        "📁",
        "🌐"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color(0xFF3949AB))
        ) {

            Text(
                text = "OZAN ŞİŞMANOĞLU",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(32.dp, top = 48.dp)
            )

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.BottomCenter)
                    .background(Color.White.copy(alpha = 0.3f), CircleShape)
            ) {

                Image(
                    painter = painterResource(R.drawable.erkek1),
                    contentDescription = "ozan",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp)
                )
            }

        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "About",
                fontSize = 24.sp,
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFFB300),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                InfoItem(R.drawable.outline_location_city_24, " Osmangazi Universitesi")
                InfoItem(R.drawable.outline_school_24, "Bilgisayar Mühendisliği")

            }


        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "Skills",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFB300),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            ShowSkill(skillNames, skillEmojis)


        }


    }


}


@Composable
fun ShowSkill(skills: List<String>, icons: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()

    ) {

        itemsIndexed(skills) { index, skill ->

            val icon = icons.getOrNull(index) ?: ":)"
            SkillCard(skill, icon)

        }


    }
}

@Composable
fun SkillCard(text: String, icon: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {

            Text(icon)
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text, fontSize = 18.sp, fontWeight = FontWeight.Bold)


        }


    }
}


@Composable
fun InfoItem(icon: Int, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun PreviewDevProfileScreen() {
    DevProfileTheme() {
        DevProfileScreen(modifier = Modifier)


    }
}






