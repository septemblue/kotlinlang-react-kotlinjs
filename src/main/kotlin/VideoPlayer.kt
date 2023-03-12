import csstype.Position
import csstype.px
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.img

/*
To tell Kotlin that a certain declaration is written in pure JavaScript, you should mark it with the external
 */
external interface VideoPlayerProps : Props {
    var video: Video
}

val VideoPlayer = FC<VideoPlayerProps> {props ->
    div {
        css {
            position = Position.absolute
            top = 10.px
            right = 10.px
        }
        h3 {
            +"${props.video.speaker}: ${props.video.title}"
        }
        img {
            src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
        }
    }
}