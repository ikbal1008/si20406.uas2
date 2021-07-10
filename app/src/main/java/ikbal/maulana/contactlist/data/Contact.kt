package ikbal.maulana.contactlist.data

import android.provider.ContactsContract
import com.google.firebase.database.Exclude

data class Contact(
        @get:Exclude
        var id: String? = null,
        var fullName: String? = null,
        var _contactNumber: String? = null
) {
}