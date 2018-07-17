package com.mwm.demo_kotlin.anonymous

@Suppress("unused", "UNUSED_PARAMETER")
object AnonymousTester {

    //region Manager
    fun useManager() {
        executeManager(object : Manager {
            override fun execute() {}
        })
    }

    private fun executeManager(manager: Manager) {}

    interface Manager {
        fun execute()
    }
    //endregion Manager

    //region ManagerImpl
    fun useManagerImpl() {
        executeManagerImpl(object : ManagerImpl() {
            override fun execute() {

            }
        })
    }

    private fun executeManagerImpl(managerImpl: ManagerImpl) {}

    open class ManagerImpl {
        open fun execute() {}
    }
    //endregion ManagerImpl

}