import react.FC
import react.Props
import react.dom.html.ReactHTML.p
import react.key
import react.useState

/*You can add the ability to pass the list of items as an attribute to the component. In React, these attributes are
 called props. When the props of a component are changed in React, the framework automatically re-renders the component.

 The external modifier tells the compiler that the interface's implementation is provided externally, so it doesn't try
  to generate JavaScript code from the declaration.
 */
external interface VideoListProps : Props {
    var videos: List<Video>
    var selectedVideo: Video
}

val VideoList = FC<VideoListProps> { props ->
    for (video in props.videos) {
        p {
            key = video.id.toString()
            onClick = {
                props.selectedVideo = video
            }
            if (video == props.selectedVideo)
                +"▶ "
            +"${video.speaker}:  ${video.title}"
        }
    }
}
/*The key attribute helps the React renderer figure out what to do when the value of props.videos changes.
It uses the key to determine which parts of a list need to be refreshed and which ones stay the same
 */
/*
Defining an onClick function directly as lambda is concise and very useful for prototyping. However, due to the way
equality currently works in Kotlin/JS, performance-wise it's not the most optimized way to pass click handlers.
If you want to optimize rendering performance, consider storing your functions in a variable and passing them
 */
/*
The process of migrating state from components to their parents is called lifting state.
 */