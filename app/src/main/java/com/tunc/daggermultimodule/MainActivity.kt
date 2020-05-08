package com.tunc.daggermultimodule

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.google.gson.annotations.SerializedName
import dagger.android.DaggerActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = retrofit.create(RetrofitService::class.java)

        service.getTodos().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("firstTodo", it.first().title)
            }, {

            })
    }


    interface RetrofitService {
        @GET("todos")
        fun getTodos(): Observable<List<TodoResponse>>
    }

    data class TodoResponse(
        @SerializedName("userId") var userId: Int,
        @SerializedName("id") var id: Int,
        @SerializedName("title") var title: String,
        @SerializedName("completed") var isCompleted: Boolean
    )
}
