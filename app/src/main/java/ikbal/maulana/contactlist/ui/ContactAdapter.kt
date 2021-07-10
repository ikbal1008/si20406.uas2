package ikbal.maulana.contactlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ikbal.maulana.contactlist.data.Contact
import ikbal.maulana.contactlist.databinding.RecyclerViewContactBinding

class ContactAdapter:RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var contacts = mutableListOf<Contact>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerViewContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewName.text = contacts[position].fullName
        holder.binding.textViewContact.text = contacts[position]._contactNumber
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun addContact(contact: Contact) {
        if (!contacts.contains(contact)){
            contacts.add(contact)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: RecyclerViewContactBinding): RecyclerView.ViewHolder(binding.root){

    }
}