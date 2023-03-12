import csstype.Position
import csstype.px
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.img
import react.useState


data class Video(
    val id: Int,
    val title: String,
    val speaker: String,
    val videoURL: String
)
/*
The FC function creates a function component.
The Kotlin wrappers for React come with a domain-specific language (DSL) that makes it possible to write HTML in pure
 Kotlin code. In this way, it's similar to JSX from JavaScript. However, with this markup being Kotlin, you get all the
  benefits of a statically typed language, such as autocomplete or type checking.
 */
val App = FC<Props> {
    var unwatchedVideos: List<Video> by useState(listOf(
        Video(1, "Opening Keynote", "Andrey Breslav", "https://youtu.be/PsaFVLr8t4E"),
        Video(2, "Dissecting the stdlib", "Huyen Tue Dao", "https://youtu.be/Fzt_9I733Yg"),
        Video(3, "Kotlin and Spring Boot", "Nicolas Frankel", "https://youtu.be/pSiZVAeReeg")
    ))
    var watchedVideos: List<Video> by useState(listOf(
        Video(4, "Creating Internal DSLs in Kotlin", "Venkat Subramaniam", "https://youtu.be/JzTeAM8N1-o")
    ))

    var currentVideo : Video? by useState(null)
    h1 {
        +"KotlinConf Explorer"
    }
    div {
        h3 {
            +"Videos to Watch"
        }
        VideoList {
            videos = unwatchedVideos
            selectedVideo = currentVideo
            onSelectedVideo = { video ->
                currentVideo = video
            }
        }
        h3 {
            +"Videos Watched"
        }
        VideoList {
            videos = watchedVideos
            selectedVideo = currentVideo
            onSelectedVideo = { video ->
                currentVideo = video
            }
        }
    }
    currentVideo?.let {curr ->
        VideoPlayer {
            video = curr
            unwatchedVideo = curr in unwatchedVideos
            onWatchedVideoPressed = {
                if (video in unwatchedVideos) {
                    unwatchedVideos = unwatchedVideos - video
                    watchedVideos = watchedVideos + video
                } else {
                    watchedVideos = watchedVideos - video
                    unwatchedVideos = unwatchedVideos + video
                }
            }
        }
    }
}
