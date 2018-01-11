package org.raaz.com.databindnig

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.databinding.DataBindingUtil
import android.view.View
import org.raaz.com.databindnig.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    internal lateinit var user: User
    internal lateinit var user2: User2
    internal lateinit var user3: User3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        user = User("Coderz", "Heaven")
        binding.setUser(user)
        binding.b1.setText("Update")
        binding.b1.setOnClickListener(View.OnClickListener {
            // Updatin BaseObservable
            user.setFirstName("New Updated First Name")
            user.setLastName("New Updated Last Name")
            // Updating ObservableFields
            user2.firstName.set("Apple")
            user2.lastName.set("iOS")

            // Updating  Observable Collections
            user3.name.put(0, "Heaven")
        })

        // ObservableFields
        user2 = User2()
        user2.firstName.set("Google")
        user2.lastName.set("Android")
        binding.setUser2(user2)

        // Observable Collections
        user3 = User3()
        user3.name.put(0, "Coderz")
        user3.name.put(1, "Heaven")
        binding.setUser3(user3)
    }
}
