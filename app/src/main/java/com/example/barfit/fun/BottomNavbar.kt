package com.example.barfit.`fun`

import com.example.barfit.R

sealed class BottomNavbar(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {
    // for home
    object Home: BottomNavbar(
        route = "home",
        title = "Home",
        icon = R.drawable.home_focused,
        icon_focused = R.drawable.home
    )

    // for report
    object Profile: BottomNavbar(
        route = "activity",
        title = "Activities",
        icon = R.drawable.user,
        icon_focused = R.drawable.user_focused
    )

}