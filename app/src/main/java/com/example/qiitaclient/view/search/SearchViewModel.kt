package com.example.qiitaclient.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qiitaclient.model.Article
import com.example.qiitaclient.repository.ArticleRepository
import kotlinx.coroutines.launch
import retrofit2.http.Query

class SearchViewModel:ViewModel() {
    private val repository = ArticleRepository()

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    fun searchArticles(query: String) {
        viewModelScope.launch {
            val result = repository.searchArticles(query)
            _articles.postValue(result ?: listOf())
        }
    }
}