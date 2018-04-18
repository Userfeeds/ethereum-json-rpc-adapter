package io.userfeeds.parityapi.modules

import io.reactivex.Single
import io.userfeeds.parityapi.*
import retrofit2.Retrofit

class ParityModuleParityApi(retrofit: Retrofit) : ParityApi.ParityModule {

    private val parityGenericApi by lazy { retrofit.create(ParityGenericApi.ParityModule::class.java) }

    override fun getBlockHeaderByNumber(blockNumber: Long): Single<ParityApi.BlockHeaderResult> {
        return parityGenericApi.getBlockHeaderByNumber(ParityGenericApi.Request(method = "parity_getBlockHeaderByNumber", params = listOf(blockNumber.longToHex())))
                .unwrap()
    }

    override fun getEnode(): Single<String> {
        return parityGenericApi.getEnode(ParityGenericApi.Request(method = "parity_enode"))
                .unwrap()
    }
}


