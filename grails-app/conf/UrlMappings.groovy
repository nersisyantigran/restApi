class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')


            "/TekUser/$id?"(controller:"tekUser") {
                action = [GET: 'show', PUT: 'save', POST: 'update', DELETE: 'delete']
            }

                "/TekEvent/$id?"(controller:"tekEvent") {
                    action = [GET: 'show', PUT: 'save', POST: 'update', DELETE: 'delete']
                }
        }
	}

