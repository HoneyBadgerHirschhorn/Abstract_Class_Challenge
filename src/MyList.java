public class MyList implements NodeList{

    private ListItem root = null;

    public MyList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            //the list was empty so this item becomes head of list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
        int comparison = (currentItem.compareTo(newItem));
        if (comparison < 0){
            // newitem is greater, move right if possible
            if (currentItem.next() != null) {
                currentItem = currentItem.next();
            } else {
                // there is no next, so insert at end of list
                currentItem.setNext(newItem);
                newItem.setPrevious(currentItem);
                return  true;
            }
        } else if (comparison > 0) {
            // newitem is less, insert before
            if (currentItem.previous()!= null){
                currentItem.previous().setNext(newItem);
                newItem.setPrevious(currentItem.previous());
                newItem.setNext(currentItem);
                currentItem.setNext(newItem);
            } else {
                // node with a previous is the root
                newItem.setNext(this.root);
                this.root.setPrevious(newItem);
            }
            return true;
          } else {
            // equal
            System.out.println(newItem.getValue()+ " is already there, not added");
            return false;
        }
       }
        return false;
    }


    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
