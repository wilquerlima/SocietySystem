package steps

import societysystem.FieldController
import societysystem.SocietyController
import societysystem.Field
import societysystem.Society

/**
 * Created by felip_000 on 05/12/16.
 */
class TestAndDataOperations {
    def controller = new FieldController()
    def societyController = new SocietyController()

    public void cadastrarCampo(String name, int valor){
        def field = new Field(name: name, value: valor)
        //field.save()
        this.controller.saveField(field)
    }

    public void cadastrarCampo(Field field){
        this.controller.saveField(field)
    }

    public Field retornarCampoByname(String name){
        return Field.findByName(name)
    }

    public float returnProfit(String societyName){
        societyController.returnProfit(societyName)
    }

    public float returnBookedProfit(String societyName){
        societyController.returnBookedProfit(societyName)
    }

    public void saveSociety(Society society){
        this.societyController.save(society)
    }

}
