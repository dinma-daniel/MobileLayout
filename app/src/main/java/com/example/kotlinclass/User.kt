package com.example.kotlinclass

data class User(
    val bio: String,
    val id: String,
    val links: LinksX,
    val location: String,
    val name: String,
    val portfolio_url: String,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val updated_at: String,
    val username: String
)