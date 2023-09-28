package com.assignment.pgrkam_app.repository

import android.content.Context
import com.assignment.pgrkam_app.models.RecommendationResponseItem
import com.assignment.pgrkam_app.utils.ReadJsonFromAssets
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecommendationRepository @Inject constructor(@ApplicationContext val context: Context) {

    suspend fun getRecommendedJobs(): Flow<List<RecommendationResponseItem>> {
        return flow {
            val gson = Gson()
            val jsonString = ReadJsonFromAssets.ReadJSONFromAssets(context, "recommendation.json")
            val listType = object : TypeToken<List<RecommendationResponseItem>>() {}.type
            val recommendationResponseItemList: List<RecommendationResponseItem> = gson.fromJson(jsonString, listType)
            emit(recommendationResponseItemList)
        }
    }

}