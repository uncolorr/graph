class BlockElement constructor(name: String) :BaseElement(name), IProductElementsList {

    private var elements = ProductElements()
    override fun getProductElements(): ProductElements {
        return elements
    }

}