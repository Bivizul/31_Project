package aaa.bivizul.a31project.especdata.especstore

import aaa.bivizul.a31project.especdata.especmodel.Espec
import aaa.bivizul.a31project.especdata.especmodel.Getespec
import aaa.bivizul.a31project.especdata.especnet.EspecApi
import aaa.bivizul.a31project.especdata.especutil.especIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EspecStore {

    private val spbkApi = EspecApi()
    private val job = SupervisorJob()
    private val scope = CoroutineScope(especIoDispatcher + job)

    private val _getespec = MutableStateFlow<Getespec?>(null)
    val getespec: StateFlow<Getespec?> = _getespec.asStateFlow()

    fun getGetapost(espec: Espec) {
        scope.launch {
            val response = spbkApi.getGetespec(espec)
            _getespec.emit(response)
        }
    }

}