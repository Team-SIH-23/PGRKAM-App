package com.assignment.pgrkam_app.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.pgrkam_app.models.RecommendationResponseItem
import com.assignment.pgrkam_app.repository.RecommendationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendationViewModel @Inject constructor(private val repository: RecommendationRepository) :
    ViewModel() {

    private var _recommendationUiState =
        MutableStateFlow<List<RecommendationResponseItem>>(emptyList())
    val recommendationUiState: StateFlow<List<RecommendationResponseItem>> = _recommendationUiState

    fun getRecommendedJobs() {
        viewModelScope.launch {
            repository.getRecommendedJobs().catch {
                Log.d("ERROR",repository.getRecommendedJobs().first().toString())
            }.collect {
                _recommendationUiState.value = it
            }
        }
    }

}