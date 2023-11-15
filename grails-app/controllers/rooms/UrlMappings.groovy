package rooms

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/index_old"(view:"/index_old")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
