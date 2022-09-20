package aaa.bivizul.a31project.especui.especwidget

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

actual fun especct(especcon: Any, especcc: String) {
    val context = especcon as Context
    val activity = (context as? Activity)
    val especpn = "com.android.chrome"
    val especb = CustomTabsIntent.Builder()
        .setShowTitle(false)
        .setInstantAppsEnabled(true)
        .build()
    if (especpn != null) {
        especb.intent.setPackage(especpn)
        especb.launchUrl(context, Uri.parse(especcc))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(especcc))
        activity?.startActivity(i)
    }
}