package org.nostress.behappy.fragment_menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_account.*
import org.nostress.behappy.LoginActivity
import org.nostress.behappy.R

class AccountFragment : Fragment() {

//    lateinit var auth : FirebaseAuth
//    var dataReference : DatabaseReference? = null
//    var database : FirebaseDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        auth = FirebaseAuth.getInstance()
//        database = FirebaseDatabase.getInstance()
//        dataReference = database?.getReference("profil")
//
//        loadProfil()

        btn_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            activity?.let{
                val intent = Intent (it, LoginActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

//    private fun loadProfil(){
//        val user = auth.currentUser
//        val userRef = dataReference?.child(user?.uid!!)
//
//        userRef?.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                txt_username_account.text = snapshot.child("username").value.toString()
//                txt_email_account.text = snapshot.child("email").value.toString()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
//    }

}