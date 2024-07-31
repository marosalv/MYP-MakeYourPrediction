package com.marosalvsoftware.myp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.settings.DefaultListSettings
import com.marosalvsoftware.myp.settings.MySettings


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavHostController,
    activity: MainActivity,
    paddings: PaddingValues
) {

    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.padding(paddings),
        topBar = {
            MyTopBar(screen = Screen.Settings, scrollBehaviour, activity.baseContext, navController)
        }) { paddingValues ->

        Column(
            modifier = Modifier
                .background(brush = MySettings.ColorThemeLight.background)
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Setting Screen",
                color = MySettings.ColorThemeLight.text,
                fontSize = MaterialTheme.typography.h4.fontSize
            )

            for (set in DefaultListSettings.usedSet_List)
                CardCreator(size = SizeSelector.AUTO)
                {
                    Text(
                        modifier = Modifier.padding(MySettings.Paddings.small),
                        text = set.name + " " + set.value.toString(),
                        color = MySettings.ColorThemeLight.text,
                        fontSize = MaterialTheme.typography.body1.fontSize
                    )

                }

        }
    }
}

@Composable
fun CardCreator(size: SizeSelector, composable: @Composable () -> Unit) {
    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MySettings.Paddings.medium)
            .sizeCase(size),
        shape = RoundedCornerShape(MySettings.Paddings.large),
        elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small),
        colors = CardDefaults.cardColors(containerColor = MySettings.ColorThemeLight.cardBacground)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MySettings.Paddings.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            composable()
        }
    }
}

@Stable
private fun Modifier.sizeCase(size: SizeSelector): Modifier {
    return when (size) {
        SizeSelector.AUTO -> this
        SizeSelector.SMALL -> this.size(50.dp)
        SizeSelector.MEDIUM -> this.size(120.dp)
        SizeSelector.BIG -> this.size(240.dp)
    }
}

enum class SizeSelector {
    SMALL,
    MEDIUM,
    BIG,
    AUTO
}
