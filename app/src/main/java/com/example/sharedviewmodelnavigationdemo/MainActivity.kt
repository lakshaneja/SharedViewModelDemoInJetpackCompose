package com.example.sharedviewmodelnavigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.sharedviewmodelnavigationdemo.ui.MyViewModel
import com.example.sharedviewmodelnavigationdemo.ui.theme.SharedViewModelNavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharedViewModelNavigationDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = GraphRoute,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        navigation<GraphRoute>(startDestination = A) {
                            composable<A> { entry ->
                                val parent = remember(entry) {
                                    navController.getBackStackEntry(GraphRoute)
                                }

                                val vm = viewModel<MyViewModel>(parent)
                                ScreenA(vm, navController)
                            }

                            composable<B> { entry ->
                                val parent = remember(entry) {
                                    navController.getBackStackEntry(GraphRoute)
                                }

                                val vm = viewModel<MyViewModel>(parent)
                                ScreenB(
                                    vm = vm, {
                                        println("Value is ${vm.sharedStateFlow.value}")
                                        navController.navigate(C(vm.sharedStateFlow.value))
                                    },
                                    backEvent = {
                                        navController.navigateUp()
                                    }
                                )
                            }


                        }

                        composable<C> { entry ->
                            val name = entry.toRoute<C>().name
                            ScreenC(text = name)

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SharedViewModelNavigationDemoTheme {
        Greeting("Android")
    }
}
