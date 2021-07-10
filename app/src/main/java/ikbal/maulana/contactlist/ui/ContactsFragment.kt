package ikbal.maulana.contactlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ikbal.maulana.contactlist.databinding.FragmentContactsBinding


class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    private val adapter = ContactAdapter()

    private lateinit var viewModel: ContactViewModel

    override fun  onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewContacts.adapter= adapter

        binding.addButton.setOnClickListener {
            AddContactDialogFragment().show(childFragmentManager,"")
        }

        viewModel.contact.observe(viewLifecycleOwner, Observer {
            adapter.addContact(it)
        })

        viewModel.getRealtimeUpdate()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}