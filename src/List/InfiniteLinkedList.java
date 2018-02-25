package List;

public class InfiniteLinkedList<E>
{
    private Node head;
    public InfiniteLinkedList()
    {
        head = new Node(null);
    }


    public boolean add(E obj)
    {
        Node temp = new Node(obj);

        if(size()==0)
        {
            head.setNext(temp);

            return true;
        }
        getNode(size()-1).setNext(temp);
        head.setParent(getNode(size()-1));
        getNode(size()-1).setNext(head);

        return true;
    }
    public void addAll(E ... values)
    {
        for(E value:values)
        {
            add(value);
        }
        head.setParent(getNode(size()-1));
        getNode(size()-1).setNext(head);
    }

    public void add(int index, E obj)
    {

        Node temp = new Node(obj);

        Node next = getNode(index);
        getNode(index-1).setNext(temp);
        temp.setNext(next);
    }




    public E get(int index)
    {
        if(size()<=index||index<0)
            return null;

        return (E)getNode(index).getValue();
    }


    public E getParentValue(E obj)
    {
        return (E)getNode(getIndex(obj)).getParent().getValue();
    }

    public E getNextValue(E obj)
    {
        return (E)getNode(getIndex(obj)).getNext().getValue();
    }

    public int size()
    {
        Node temp = head.getNext();
        int ret = 0;
        if(temp==null)
            return ret;
        while(!temp.equals(head))
        {
            ret++;
            temp = temp.getNext();
        }

        return ret;
    }
    public int getIndex(E obj)
    {
        int ret = 0;
        Node temp = head.next;
        while(temp!=null)
        {
            if(obj.equals(temp.getValue()))
            {
                return ret;
            }
            ret++;
            temp = temp.getNext();
        }
        return -1;
    }
    public Node getNode(int index)
    {
        if(index<0)
            return head;
        Node ret = head.getNext();
        for(int x = 0;x<index;x++)
        {
            ret = ret.getNext();
        }
        return ret;
    }
    private class Node<E>
    {
        private Node<E> next;
        private Node<E> parent;
        private E value;
        public Node(E data)
        {
            value = data;
            next = null;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> setNext(Node<E> next)
        {
            Node ret = this.next;
            this.next = next;
            return ret;
        }
        public Node<E> getNext()
        {
            return next;
        }

        public E getValue() {
            return value;
        }
    }
}
