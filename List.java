/**
 * Author : Zhang Zhe
 */
class Listlink{
    public int data;
    public Listlink next;
    public Listlink(int data){
        this.data=data;
        this.next=null;
    }
}
class List {
    public Listlink head;
    public List(){
        this.head=null;
    }
    //头插法
    public void addFirst(int data){
        Listlink node = new Listlink(data);
        if(this.head==null){
            this.head=node;
        }else{
            Listlink cur=this.head;
            this.head=node;
            node.next=cur;
        }
    }
    //尾插法
    public void addLast(int data) {
        Listlink node = new Listlink(data);
        Listlink cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
                   while (cur.next!=null){
                       cur=cur.next;
                   }
                   cur.next=node;
        }
    }
    //打印单列表
    public void display(){
        Listlink cur = this.head;
        if(this.head==null){
            return;
        }
        while (cur!=null){
            System.out.print(cur.data+"    ");
            cur=cur.next;
        }
        System.out.println();
    }
    //获得长度
    public int getlength(){
        Listlink cur = this.head;
        int count = 0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    //插入到index位置
    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(0<index||index>getlength()){
            return false;
        }
        if(index==0){
            addFirst(data);
            return true;
        }else {
            Listlink node = new Listlink(data);
            Listlink cur = this.head;
            int count = 0;
            while (count<index-1){
                count++;
                cur=cur.next;
            }
            node.next=cur.next;
            cur.next=node;
        }
        return true;
    }
    //查询是否含有key
    public boolean contains(int key){
        Listlink cur = this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //找前驱
    public Listlink seachPrev(int key){
        Listlink prev = this.head;
        while(prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }
    //删除某key节点
    public void remove(int key){
        Listlink cur = seachPrev(key);
        Listlink prev = this.head;
        if(cur==null){
            System.out.println("没有要删除的节点！");
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        Listlink del = cur.next;
        cur.next=del.next;
    }
    //删除所有的key节点
    public void removeAll(int key){
        Listlink cur = this.head;
        Listlink prev = this.head.next;
        while(prev!=null){
            if(cur.next.data==key){
                cur.next=prev.next;
            }
            cur=prev;
            prev=prev.next;
        }
    }
    //逆序单列表
    public Listlink reverseList(){
        Listlink cur = this.head;
        Listlink prev = null;
        Listlink newHead = null;
        while (cur!=null){
            Listlink curNext=cur.next;
            if(curNext==null){
                 newHead = cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
}