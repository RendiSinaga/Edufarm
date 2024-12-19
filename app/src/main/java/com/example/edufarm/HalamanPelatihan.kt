package com.example.edufarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.edufarm.navigation.Routes
import com.example.edufarm.ui.components.BottomNavigationBar
import com.example.edufarm.ui.components.SearchBar
import com.example.edufarm.ui.theme.EdufarmTheme
import com.example.edufarm.ui.theme.poppinsFontFamily
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun PelatihanScreen(
    navController: NavController
) {
    val selectedItem = remember { mutableStateOf("Pelatihan") }
    val systemUiController = rememberSystemUiController()
    val topBarColor = colorResource(id = R.color.background)

    LaunchedEffect(Unit) {
        systemUiController.setStatusBarColor(
            color = topBarColor,
            darkIcons = true
        )
    }

    Scaffold(
        modifier = Modifier,
        bottomBar = { BottomNavigationBar(navController = navController, selectedItem = selectedItem) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.background))
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 35.dp)
            ) {
                Text(
                    text = "Pelatihan",
                    fontSize = 18.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                SearchBar(
                    placeholder = "Cari Pelatihan",
                )

                Spacer(modifier = Modifier.height(28.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(5) {
                        CardPelatihanKategori(navController)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}


@Composable
private fun CardPelatihanKategori(navController: NavController) {
    var isBookmarked by remember { mutableStateOf(false) }
    val progressCurrent = 1
    val progressTotal = 6
    val progressFraction = progressCurrent.toFloat() / progressTotal.toFloat()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
    ) {
        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.petani),
                    contentDescription = "Deskripsi Gambar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 19.dp, end = 15.dp)
                        .size(24.dp)
                        .background(
                            color = if (isBookmarked) Color.White else Color.Gray,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable { isBookmarked = !isBookmarked },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(
                            id = if (isBookmarked) R.drawable.bookmark_green else R.drawable.bookmark_putih
                        ),
                        contentDescription = "Bookmark",
                        modifier = Modifier.size(width = 16.dp, height = 18.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Pelatihan Menanam Kacang Tanah",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(
                    text = "Materi ini akan membahas cara menanam kacang tanah dari awal sampai akhir",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppinsFontFamily,
                    lineHeight = 13.sp,
                    color = colorResource(id = R.color.gray_bookmark),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                ) {
                    Button(
                        onClick = { navController.navigate(Routes.HALAMAN_SUB_MATERI) },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green)),
                        modifier = Modifier
                            .width(115.dp)
                            .height(30.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "Lihat Selengkapnya",
                            fontSize = 10.sp,
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(500),
                        )
                    }
                    Text(
                        text = "Progres Materi",
                        fontSize = 11.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .offset(x = 15.dp)
                    )

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                    ) {
                        CircularProgressIndicator(
                            progress = { progressFraction },
                            modifier = Modifier
                                .width(44.dp)
                                .height(44.dp),
                            color = colorResource(id = R.color.green),
                            strokeWidth = 4.dp,
                            trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
                        )
                        Text(
                            text = "$progressCurrent/$progressTotal",
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPelatihanScreen() {
    EdufarmTheme {
        Column (modifier = Modifier.background(colorResource(id = R.color.background))){
            PelatihanScreen(
                navController = rememberNavController()
            )
        }
    }
}