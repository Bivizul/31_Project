@file:Suppress("DEPRECATION")

package aaa.bivizul.a31project.especdata.especutil

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import com.onesignal.OneSignal
import java.text.SimpleDateFormat
import java.util.*

actual fun getEspecmm(): String {
    val manfacespec = android.os.Build.MANUFACTURER
    val modelespec = android.os.Build.MODEL
    return "$manfacespec $modelespec"
}

actual fun getEspecsim(especcon: Any): String {
    val context = especcon as Context
    val telmanespec = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanespec.simCountryIso
}

actual fun getEspecid(especcon: Any): String {
    val context = especcon as Context
    val sharedPreferences = context.getSharedPreferences("appprefespec", Context.MODE_PRIVATE)
    var especid = sharedPreferences.getString("espec_key", "noespec") ?: "noespec"
    if (especid == "noespec") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        especid = datetime + randomNum
        sharedPreferences.edit().putString("espec_key", especid).apply()
    }
    return especid
}

actual fun getEspecl(): String {
    return Locale.getDefault().language
}

actual fun getEspect(): String {
    val espectz = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var especzone = "00:00"
    if (espectz.length > 3) {
        especzone = espectz.substring(3)
    }
    return especzone
}

actual fun getEspecdlg(especcon: Any) {
    val context = especcon as Context
    val activity = especcon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Connect error")
        setMessage("Please try again later")
        setPositiveButton("Quit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkEspecnet(especcon: Any): Boolean {
    val context = especcon as Context
    val conmanespec =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfespec = conmanespec.activeNetworkInfo
    return netinfespec != null && netinfespec.isConnected
}

actual fun sigEspecoff() {
    OneSignal.disablePush(true)
}

internal actual fun getEspectactoff(especcon: Any) {
    val activity = especcon as Activity
    activity.finish()
    System.exit(0)
}