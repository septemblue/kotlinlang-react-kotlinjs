import react.FC
import react.Props
import react.dom.html.ReactHTML.p

val VideoList = FC<Props>() {
    for (video in unwatchedVideos) {
        p {
            +"${video.speaker}:  ${video.title}"
        }
    }
}
