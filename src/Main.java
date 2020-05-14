public class Main {

    public static void main(String[] args) {

        Product product = new Product("root");
        // --- 1 уровень 1 индекс
        AssemblyElement assemblyElement11 = new AssemblyElement("11");

        BlockElement blockElement21 = new BlockElement("21");
        ObjectElement objectElement22 = new ObjectElement("22");

        ObjectElement objectElement31 = new ObjectElement("31");
        ObjectElement objectElement32 = new ObjectElement("32");
        AssemblyElement assemblyElement33 = new AssemblyElement("33");

        blockElement21.getProductElements().getListOfObjects().add(objectElement31);
        blockElement21.getProductElements().getListOfObjects().add(objectElement32);
        blockElement21.getProductElements().getListOfOAssemblies().add(assemblyElement33);

        assemblyElement11.getProductElements().getListOfBlocks().add(blockElement21);
        assemblyElement11.getProductElements().getListOfObjects().add(objectElement22);

        product.getProductElements().getListOfOAssemblies().add(assemblyElement11);

        Graph graph = new Graph(product);
        System.out.println("graph size: " + graph.getGraphSize());
        graph.print();


        BaseElement item = graph.findByName("22");
        if (item == null) {
            return;
        }
        if(item.getParent() != null) {
            System.out.println("founded parent: " + item.getParent().getName());
        } else {
            System.out.println("founded parent is null");
        }

    }
}
