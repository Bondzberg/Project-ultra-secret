package List;

public class InfiniteLinkedList<E> implements GenericList
{
    private Node head;
    public InfiniteLinkedList()
    {
        head = new Node(null);
    }

    @Override
    public boolean add(Object obj)
    {
        Node temp = new Node(obj);

        if(size()==0)
        {
            head.setNext(temp);

            return true;
        }
        getNode(size()-1).setNext(temp);
        head.setParent(getNode(size()-1));

        return true;
    }
    public void addAll(E ... values)
    {
        for(E value:values)
        {
            add(value);
        }
    }
    @Override
    public void add(int index, Object obj)
    {

        Node temp = new Node(obj);

        Node next = getNode(index);
        getNode(index-1).setNext(temp);
        temp.setNext(next);
    }

    @Override
    public boolean contains(Object obj)
    {
        Node temp = head.getNext();
        while(temp!= null)
        {
            if(temp.getValue().equals(obj))
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public Object get(int index)
    {
        if(size()<=index||index<0)
            return null;

        return getNode(index).getValue();
    }

    @Override
    public boolean isEmpty() {
        if(head.getNext() == null)
            return true;
        return false;
    }

    @Override
    public Object remove(int index)
    {
        if(size()-1<index||index<0)
            return null;
        Object ret;
        if(getNode(index) == null)
        {
            ret = getNode(index-1).getValue();
            getNode(index-2).setNext(null);
            return ret;
        }
        ret = getNode(index).getValue();
        getNode(index-1).setNext(getNode(index+1));
        return ret;
    }

    @Override
    public boolean remove(Object obj)
    {
        int index = getIndex(obj);
        if (remove(index) == null)
            return false;

        return true;
    }

    @Override
    public Object set(int index, Object obj)
    {
        if(size()<=index||index<0)
            return null;
        Object ret = getNode(index).getValue();
        getNode(index).setValue(obj);
        return ret;
    }

    @Override
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
    public int getIndex(Object obj)
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
