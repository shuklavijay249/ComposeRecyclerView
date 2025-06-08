package com.shuklavijay249.composerecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shuklavijay249.composerecyclerview.compose.TvShowListItem
import com.shuklavijay249.composerecyclerview.data.TvShowList
import com.shuklavijay249.composerecyclerview.model.TvShow
import com.shuklavijay249.composerecyclerview.ui.theme.ComposeRecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //ScrollableColumnDemo()
            //LazyColumnDemo()
//            LazyColumnDemo2 {
//                Toast.makeText(this, it , Toast.LENGTH_LONG).show()
//                }
            DisplayTvShows {
                Toast.makeText(this, it.name,Toast.LENGTH_LONG).show()
                startActivity(InfoActivity.intent(this,it))
            }
        }
    }
}

@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..100) {
            Text(
                "User Name $i",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(10.dp)
            )
            HorizontalDivider(thickness = 5.dp, color = Color.Black)
        }
    }
}

@Composable
fun LazyColumnDemo() {
    LazyColumn {
        items(100) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(10.dp)
            )
            HorizontalDivider(thickness = 5.dp, color = Color.Black)
        }
    }
}

@Composable
fun LazyColumnDemo2(selectedItem: (String) -> (Unit)) {
    LazyColumn {
        items(100) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it Selected") }
            )
            HorizontalDivider(thickness = 5.dp, color = Color.Black)
        }
    }
}

//Displaying TvShow list

@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit) {

    val tvShows = remember { TvShowList.tvShows }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp,vertical = 8.dp)
    ) {
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }

}




