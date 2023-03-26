package io.github.jan.supabase.postgrest

import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
internal data class PostgrestErrorResponse(
    val message: String,
    val hint: String? = null,
    val details: String? = null,
    val code: String? = null,
)
