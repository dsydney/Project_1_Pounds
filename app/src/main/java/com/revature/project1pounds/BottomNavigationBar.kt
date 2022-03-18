package com.revature.project1pounds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class BottomNavItem(

    val name: String,
    val route: String,
    val icon: ImageVector

)


@ExperimentalMaterialApi
@Composable
fun BottomNavBar() {

    val navController = rememberNavController()
    Scaffold(

        bottomBar = {

            BottomNavigationBar(
                items = listOf(

                    BottomNavItem(

                        name = "Macros",
                        route = "macros",
                        icon = Icons.Default.PieChart

                    ),

                    BottomNavItem(

                        name = "Calories",
                        route = "calories",
                        icon = Icons.Default.LocalDining

                    ),

                    BottomNavItem(

                        name = "Progress",
                        route = "progress",
                        icon = Icons.Default.Leaderboard

                    ),

                    BottomNavItem(

                        name = "Penalties",
                        route = "penalties",
                        icon = Icons.Default.AttachMoney

                    ),

                    BottomNavItem(

                        name = "Promotions",
                        route = "promotions",
                        icon = Icons.Default.LocalOffer

                    )

                ),
                navController = navController,
                onItemClick = {

                    navController.navigate(it.route)

                }

            )

        }

    ) {

        Navigation(navController = navController)

    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Navigation(

    navController: NavHostController

) {

    NavHost(navController = navController, startDestination = "macros") {

        composable("macros") {

            MacroScreen()

        }
        composable("calories") {

            CaloriesMain()

        }
        composable("progress") {

            ProgressMain()

        }
        composable("penalties") {

            PenaltiesMain()

        }
        composable("promotions") {

            promotionsScreen()

        }

    }

}

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(

    //
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit

) {

    //
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(

        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp

    ) {

        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(imageVector = item.icon, contentDescription = item.name)

                        if(selected) {

                            Text(

                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp

                            )

                        }

                    }

                }
            )
        }

    }

}