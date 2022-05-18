package com.jjoh.composeui.basicConcept

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jjoh.composeui.ui.theme.ComposeUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUiTheme {
                Greeting("안드입니다!")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("오종진") }, backgroundColor = Color(0xfff25287))
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text(text = "클릭")
            }
        },
    ) {
        //Text(text = "안녕하세요 $name")
        MyComposableView()
    }
}

@Composable
fun RowItem() {
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "안녕하세요",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요")
    }
}

@Composable
fun MyComposableView() {
    Log.d(TAG, "MyComposableView: ")

    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ) {
        (1..20).forEach { _ ->
            RowItem()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    ComposeUiTheme() {
        Greeting(name = "오종진")
    }
}

