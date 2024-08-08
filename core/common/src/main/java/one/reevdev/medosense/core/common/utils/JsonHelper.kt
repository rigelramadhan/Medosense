package one.reevdev.medosense.core.common.utils

import com.google.gson.Gson

fun <T> String.jsonToObject(className: Class<T>): T = Gson().fromJson(this, className)

fun Any.toJson(): String = Gson().toJson(this)