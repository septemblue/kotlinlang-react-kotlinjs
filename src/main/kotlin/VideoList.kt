import react.FC
import react.Props
import react.dom.html.ReactHTML.p
import react.key

/*You can add the ability to pass the list of items as an attribute to the component. In React, these attributes are
 called props. When the props of a component are changed in React, the framework automatically re-renders the component.

 The external modifier tells the compiler that the interface's implementation is provided externally, so it doesn't try
  to generate JavaScript code from the declaration.
 */
external interface VideoListProps : Props {
    var videos: List<Video>
}

val VideoList = FC<VideoListProps>() { props ->
    for (video in props.videos) {
        p {
            key = video.id.toString()
            +"${video.speaker}:  ${video.title}"
        }
    }
}
/*The key attribute helps the React renderer figure out what to do when the value of props.videos changes.
It uses the key to determine which parts of a list need to be refreshed and which ones stay the same
 */