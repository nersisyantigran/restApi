package restapi

import grails.converters.*

import grails.converters.deep.*
import groovy.json.JsonSlurper

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TekUserController {

    static allowedMethods = [create: "POST",update:"POST"]

    def show = {
        def user = params.firstName ? TekUser.findAllByFirstName(params.firstName) : TekUser.get(params.id)

        if (user) {
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
                wml user: user
            }
        } else {
            response.sendError 404
        }
    }
    @Transactional
    def update (String id) {
        def slurper = new JsonSlurper()
        def requestMap = slurper.parseText(request?.JSON?.toString())
        def user1 = TekUser.findById(id)
        def fn = requestMap["firstName"]
        def ln = requestMap["lastName"]

        user1.firstName = fn
        user1.lastName = ln
        user1.save flush: true
        }
    @Transactional
    def create() {
        def slurper = new JsonSlurper()
        def requestMap = slurper.parseText(request?.JSON?.toString())
        def object = requestMap["firstName"]
        def object2 = requestMap["lastName"]
        TekUser tekUser = new TekUser(firstName: object, lastName: object2)
        tekUser.save flush: true

        render("NAME= ${tekUser.firstName}") as JSON
    }

    def ajax() {
//render(view: "ajax")
        respond(view: "ajax")
    }
}





