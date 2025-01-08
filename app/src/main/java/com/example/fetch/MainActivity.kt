package com.example.fetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.fetch.Repository.ListRepository
import com.example.fetch.data.details

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repository = ListRepository()
        val viewModelFactory = ViewModelFactory(repository)
      viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        setContent {

            viewModel.getList()
            var items = viewModel.myResponse.observeAsState(initial = emptyList())
            if (items != null) {
                ListPage(items)
            }
        }
    }
}



@Composable
fun ListPage(items: State<List<details>>){



    // Group items by listId
    val groupedItems = items.value.groupBy { it.listId }

    LazyColumn {
        groupedItems.forEach { (listId, groupItems) ->
            item {
                Text(
                    text = "List ID: $listId",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(16.dp)
                )
            }
            groupedItems[listId]?.forEach { item ->
                item {
                  ItemCard(item = item)
                }
            }
        }
    }
}



@Composable
fun ItemCard(item: details) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${item.name}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "ID: ${item.id}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}




