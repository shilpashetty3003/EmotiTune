package com.example.moodchanger.ui.home

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moodchanger.ui.calender.CalenderScreen
import com.example.moodchanger.ui.facescanner.FaceScannerScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            AnimatedBottomBar(
                selectedItem = selectedItem,
                navController
            ) {
                selectedItem = it
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeContent() }
            composable("scanner") { FaceScannerScreen() }
            composable("calendar") { CalenderScreen() }
        }
    }
}


@Composable
fun AnimatedBottomBar(
    selectedItem: Int,
    navController: NavController, itemSelected: (selected: Int) -> Unit
) {
    val items = listOf(
        BottomNavItem("Home", "home", Icons.Default.Home),
        BottomNavItem("Scanner", "scanner", Icons.Default.Person),
        BottomNavItem("Calendar", "calendar", Icons.Default.DateRange),
    )




    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = Color(0xFF54BD6E)
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = selectedItem == index

            Log.d(
                "TAG",
                "AnimatedBottomBar: " + navController.currentDestination + navController.currentBackStackEntry
            )
            // Animate icon size
            val iconSize by animateDpAsState(
                targetValue = if (isSelected) 30.dp else 24.dp,
                label = ""
            )

//            val iconColor by animateColorAsState(
//                targetValue = if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary,
//                label = ""
//            )
//            val textColor by animateColorAsState(
//                targetValue = if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary,
//                label = ""
//            )


            NavigationBarItem(

                selected = isSelected,
                onClick = {
                    itemSelected(index)
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
//                            tint = iconColor,
                            modifier = Modifier.size(iconSize)
                        )
                        if (isSelected) {
                            Text(
                                text = item.title,
//                                color = textColor,
                                fontSize = 12.sp
                            )
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White,
                    selectedIconColor = Color.Green,
                    selectedTextColor = Color.Green,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                ),
                label = null,
                alwaysShowLabel = false

            )
        }
    }
}

data class BottomNavItem(val title: String, val route: String, val icon: ImageVector)


@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
