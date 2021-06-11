package com.dicoding.gitapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.gitapp.R
import com.dicoding.gitapp.api.Retrofit
import com.dicoding.gitapp.models.ItemUser
import com.dicoding.gitapp.ui.activities.DetailUser
import com.dicoding.gitapp.ui.adapter.AdapterUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentFollowers : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var rvUser: RecyclerView
    private lateinit var adapterUser: AdapterUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.follower_fragment, container, false)
        rvUser = view!!.findViewById(R.id.rv_follower)
        showRecyclerList()

        val username = (activity as DetailUser).username
        onGetData(username)

        return view
    }

    private fun onGetData(username: String) {
        Retrofit.userRepositories().getUsersFollowers(username).enqueue(object: Callback<List<ItemUser>>{
            override fun onResponse(call: Call<List<ItemUser>>, response: Response<List<ItemUser>>) {
                val data = response.body()
                adapterUser.setData(data as MutableList<ItemUser>)
            }

            override fun onFailure(call: Call<List<ItemUser>>, t: Throwable) {
            }

        })
    }

    private fun showRecyclerList(){
        rvUser.layoutManager = LinearLayoutManager(context)
        adapterUser = AdapterUser()
        rvUser.adapter = adapterUser
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentFollowers().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}