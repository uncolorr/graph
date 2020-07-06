class Graph constructor(product: IProductElementsList) {

    var listOfElements = arrayListOf<BaseElement>()

    init {
        listOfElements.add(product as BaseElement)
        listOfElements.addAll(getObjects(product))
    }

    private fun getObjects(element: IProductElementsList): ArrayList<BaseElement> {

        val resultList = arrayListOf<BaseElement>()
        val list = element.getProductElements()

        if (list.listOfOAssemblies.isEmpty() && list.listOfOAssemblies.isEmpty()) {
            resultList.addAll(list.listOfObjects)
        }

        for (item in list.listOfOAssemblies) {
            println(item.name)
            item.parent = element as BaseElement
            for (j in list.listOfObjects) {
                j.parent = element
                element.children.add(j)
            }
            for (j in list.listOfBlocks) {
                j.parent = element
                element.children.add(j)
            }
            for (j in list.listOfOAssemblies) {
                j.parent = element
                element.children.add(j)
            }
            resultList.add(item)
            resultList.addAll(list.listOfObjects)
            resultList.addAll(getObjects(item))
        }

        for (item in list.listOfBlocks) {
            println(item.name)
            item.parent = element as BaseElement
            for (j in list.listOfObjects) {
                j.parent = element
                element.children.add(j)
            }
            for (j in list.listOfBlocks) {
                j.parent = element
                element.children.add(j)
            }
            for (j in list.listOfOAssemblies) {
                j.parent = element
                element.children.add(j)
            }
            resultList.add(item)
            resultList.addAll(list.listOfObjects)
            resultList.addAll(getObjects(item))
        }


        return resultList

    }

    fun findByName(name: String) : BaseElement?{
        for (item in listOfElements) {
            if(item.name == name){
                return item
            }
        }
        return null
    }

    fun getGraphSize(): Int{
        return listOfElements.size
    }

    fun print() {
        for(item in listOfElements) {

            if (item is Product) {
                println("Product")
            }
            if (item is ObjectElement) {
                println("Object")
            }
            if (item is BlockElement) {
                println("Block")
            }
            if (item is AssemblyElement) {
                println("Assembly")
            }
            println("name: ${item.name}")
            if (item.parent != null) {
                println("parent: ${item.parent?.name}")
            } else {
                println("parent is null")
            }

            println("children size: " + item.children.size)
            println()
        }
    }
}


/*
* internal static List<ObjectElement> GetObjects(IProductElementsList element)
        {
            var list = element.GetProductElementsList();
            List<ObjectElement> listObject = new List<ObjectElement>();
            foreach (var item in list.AssemblyElements)
            {
                listObject.AddRange(item.ProductElementsList.ObjectElements);
                if (item.ProductElementsList.BlockElements.Any())
                {
                    listObject.AddRange(GetObjects(item));
                }
            }

            foreach (var item in list.BlockElements)
            {
                listObject.AddRange(item.ProductElementsList.ObjectElements);
                if (item.ProductElementsList.AssemblyElements.Any())
                {
                    listObject.AddRange(GetObjects(item));
                }
            }
            return listObject;
        }
*
* */