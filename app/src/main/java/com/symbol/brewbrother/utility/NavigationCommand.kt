package com.symbol.brewbrother.utility

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class ToDirection(val directions: NavDirections): NavigationCommand()
    object back : NavigationCommand()
}