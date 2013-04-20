import grails.converters.*
import org.joda.time.*

class PostController {

    def posts = [
        [
            id: '1', 
            title: 'Rails is Omakase',
            author: 'd2h',
            intro: 'There are lots of a la carte software environments in this world. Places where in order to eat, you must first carefully look over the menu of options to order exactly what you want.',
            extended: "I want this for my ORM, I want that for my template language, and let's finish it off with this routing library. Of course, you're going to have to know what you want, and you'll rarely have your horizon expanded if you always order the same thing, but there it is. It's a very popular way of consuming software. Rails is not that. Rails is omakase.",
            published_at: "2012-12-17"
        ],
        [
            id: '2', 
            title: 'The Parley Letter',
            author: 'd2h',
            intro: 'My [appearance on the Ruby Rogues podcast](http://rubyrogues.com/056-rr-david-heinemeier-hansson/) recently came up for discussion again on the private Parley mailing list.',
            extended: "A long list of topics were raised and I took a time to ramble at large about all of them at once. Apologies for not taking the time to be more succinct, but at least each topic has a header so you can skip stuff you don't care about. ### Maintainability It's simply not true to say that I don't care about maintainability. I still work on the oldest Rails app in the world.",
            published_at: "2012-12-24"
        ]
    ]

    def findAll = {
        println(' -- > finding all...')

        def m = [
            posts: posts
        ]
        render m as JSON
    }

    def find = {
        def id = params.id
        println(' -- > finding ' + id + '...')

        def m = [
            post: posts.find { it['id'] == id }
        ]
        render m as JSON
    }

    def update = {
        def id = params.id
        println(' -- > updating ' + id + '...')
        def data = request.JSON
        println(' -- > request payload: ' + data)

        // update the published_at
        def post = data.post
        post.id = id
        post.published_at = new DateTime()

        def m = [
            post: post
        ]
        render m as JSON
    }

    def create = {
        println(' -- > creating...')
        def data = request.JSON
        println(' -- > request payload: ' + data)

        // TODO: implement create
    }

    def delete = {
        def id = params.id
        println(' -- > deleting ' + id + '...')

        // TODO: implement delete
    }

}