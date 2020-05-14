abstract class BaseElement constructor(var name: String){

    var parent: BaseElement? = null
    var children: ArrayList<BaseElement?> = arrayListOf()
}