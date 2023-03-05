import kotlinx.browser.document
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.p

/*The Kotlin wrappers for React come with a domain-specific language (DSL) that makes it possible to write HTML in pure
 Kotlin code. In this way, it's similar to JSX from JavaScript. However, with this markup being Kotlin, you get all the
  benefits of a statically typed language, such as autocomplete or type checking.
 */
fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find root")
    createRoot(container).render(Fragment.create {
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Videos to Watch"
            }
            for (video in unwatchedVideos) {
                p {
                    +"${video.speaker}:  ${video.title}"
                }
            }
            h3 {
                +"Videos Watched"
            }
            for (video in watchedVideos) {
                p {
                    +"${video.speaker}: ${video.title}"
                }
            }
        }
        div {
            h3 {
                +"John Doe: Building and breaking things"
            }
            img {
                src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
            }
        }
    })
}
data class Video(
    val id: Int,
    val title: String,
    val speaker: String,
    val videoURL: String
    )
val unwatchedVideos = listOf(
    Video(1, "Opening Keynote", "Andrey Breslav", "https://youtu.be/PsaFVLr8t4E"),
    Video(2, "Dissecting the stdlib", "Huyen Tue Dao", "https://youtu.be/Fzt_9I733Yg"),
    Video(3, "Kotlin and Spring Boot", "Nicolas Frankel", "https://youtu.be/pSiZVAeReeg")
)
val watchedVideos = listOf(
    Video(4, "Creating Internal DSLs in Kotlin", "Venkat Subramaniam", "https://youtu.be/JzTeAM8N1-o")
)