package com.example.kotlin_tuesday

import java.io.Serializable

data class ResponseDTO(
	val name: String? = null,
	val postId: Int? = null,
	val id: Int? = null,
	val body: String? = null,
	val email: String? = null
)