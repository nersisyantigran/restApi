package restapi

class TekEvent {

    String city
    String name
    static constraints = {
    }
    static mappings = {
        "/album/$id?"(controller:"album") {
            action = [GET:'show', PUT:'save', POST:'update', DELETE:'delete']
        }
    }
}
