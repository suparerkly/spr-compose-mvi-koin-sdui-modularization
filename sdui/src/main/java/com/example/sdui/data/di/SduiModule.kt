package com.example.sdui.data.di

import com.example.sdui.data.di.remote.SduiRemoteDatasource
import com.example.sdui.data.di.remote.SduiRemoteDatasourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module


val sduiModule =
    module {
        factoryOf(::SduiRemoteDatasourceImpl) { bind<SduiRemoteDatasource>() }
    }
