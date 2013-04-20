class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/posts"(controller: "post") {
            action = [GET: "findAll", POST: "create"]
        }
        "/posts/$id"(controller: "post") {
            action = [GET: "find", PUT: "update", DELETE: "delete"]
        }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
