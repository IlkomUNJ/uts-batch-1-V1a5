package com.example.uts_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uts_mobile.ui.theme.UTS_MobileTheme

object Routes {
    const val LOGIN = "login"
    const val DASHBOARD = "dashboard"
    const val ADD_STUDENT = "add_student"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTS_MobileTheme {
                AppNavigation()
            }
        }
    }
}


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.LOGIN
        ) {
            // Rute 1: Login Screen
            composable(Routes.LOGIN) {
                LoginScreen.SetupLayout(
                    onLoginSuccess = {
                        navController.navigate(Routes.DASHBOARD) {
                            popUpTo(Routes.LOGIN) { inclusive = true }
                        }
                    }
                )
            }

            composable(Routes.DASHBOARD) {

            }

            composable(Routes.ADD_STUDENT) {

            }
        }

}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    UTS_MobileTheme {

        AppNavigation()
    }
}
