package consumerService.data



import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("messages")
data class Message(
    val content: String,
    val content_type: ContentType,
    val sent: Long,
    val username: String,
    val user_avatar_image_link: String,
    val created_on: Long,
    @Id val id: String,
)

enum class ContentType {
    PLAIN
}