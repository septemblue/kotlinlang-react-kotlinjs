import csstype.Display
import csstype.NamedColor
import csstype.Position
import csstype.px
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.img

/*
To tell Kotlin that a certain declaration is written in pure JavaScript, you should mark it with the external
 */
external interface VideoPlayerProps : Props {
    var video: Video
    var onWatchedVideoPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
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
        button {
            css {
                display = Display.block
                backgroundColor = if (props.unwatchedVideo) NamedColor.lightgreen else NamedColor.red
            }
            onClick = {
                props.onWatchedVideoPressed(props.video)
            }
            if (props.unwatchedVideo) {
                + "Mark as watched"
            } else {
                + "Mark as unwatched"
            }
        }
        div {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            EmailShareButton {
                url = props.video.videoURL
                EmailIcon {
                    size = 32
                    round = true
                }
            }
            TelegramShareButton {
                url = props.video.videoURL
                TelegramIcon {
                    size = 32
                    round = true
                }
            }
        }
        ReactPlayer{
            url = props.video.videoURL
            controls = true
        }
    }
}