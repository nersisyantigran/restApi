package restapi
import grails.converters.*


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TekUserController {



    def show = {
        def user = params.firstName ? TekUser.findAllByFirstName(params.firstName) : TekUser.get(params.id)

        if(user) {
             withFormat {
                 xml {
                     render user as XML
                 }
                 json {
                     def jsonify = user as JSON
                     jsonify.prettyPrint = true
                     render jsonify
//                    render (['success':'ok',data:list] as JSON)
                 }
                 html {
                     render(view: "index")
                 }
                 }
             }
         else {
             response.sendError 404
             }
         }

    }



