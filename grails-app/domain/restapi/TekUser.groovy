package restapi

class TekUser {
    String firstName
    String lastName

    static mappings = {
        "/TekUser/$id?"(controller:"tekUser") {
            action = [GET:'show', PUT:'save', POST:'update', DELETE:'delete']
            format = "json"
        }
    }
    static constraints = {
    }
}
