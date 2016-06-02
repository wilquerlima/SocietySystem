package steps

import societysystem.FieldController
import societysystem.SocietyController
import societysystem.Field

/**
 * Created by felip_000 on 05/12/16.
 */
class TestAndDataOperations {
    def controller = new FieldController()

    public void cadastrarCampo(String name, int valor){
        def field = new Field(name: name, value: valor)
        //field.save()
        this.controller.saveField(field)
    }

    public Field retornarCampoByname(String name){
        return Field.findByName(name)
    }

}
