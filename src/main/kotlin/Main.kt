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
            p {
                +"John Doe: Building and Breaking Things"
            }
            p {
                +"Jane Smith: Development Process"
            }
            p {
                +"Matt Miller: The Web 7.0"
            }
            h3 {
                +"Videos Watched"
            }
            p {
                +"Tom Jerry: Mouseless Development"
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