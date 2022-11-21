package demo14;


import java.util.LinkedList;

/*
    SNK类表示蛇，
    一条蛇有多个节点使用LinkedList集合存储Node节点，蛇出生时有4个节点
     */
public class SNK
{
    private LinkedList<Node>body;
    //设置蛇的运动方向,默认向左
    private Direction direction=Direction.LEFT;
    //蛇是否活着
    private boolean isLiving=true;
    public SNK() {
        initSNK();
    }
    public void initSNK()
    {
        //创建蛇的躯体
        body=new LinkedList<>();
        body.add(new Node(20,20));
        body.add(new Node(20,21));
        body.add(new Node(20,22));
        body.add(new Node(21,22));
    }
    //控制蛇移动:在蛇头的运动方向添加一个节点，然后把蛇尾的节点删除
    public void move()
    {
        if(isLiving) {
            Node head = body.getFirst();
            switch (direction) {
                case UP:
                    //在蛇头上边添加一个节点
                    body.addFirst(new Node(head.getx(), head.gety() - 1));
                    break;
                case DOWN:
                    body.addFirst(new Node(head.getx(), head.gety() + 1));
                    break;
                case LEFT:
                    body.addFirst(new Node(head.getx() - 1, head.gety()));
                    break;
                case RIGHT:
                    body.addFirst(new Node(head.getx() + 1, head.gety()));
                    break;
            }
            //删除最后的节点
            body.removeLast();
            //判断蛇是否撞墙
            head=body.getFirst();
            if(head.getx()<0||head.gety()<0||head.getx()>34||head.gety()>35)
            {
                isLiving=false;
            }
            //判断蛇是否碰到自己的身体
            for(int i=1;i<body.size();i++)
            {
                Node node=body.get(i);
                if(head.getx()==node.getx()&&head.gety()==node.gety())
                {
                    isLiving=false;
                }
            }
        }
    }
    public LinkedList<Node>getBody()
    {
        return body;
    }
    public void setBody(LinkedList<Node>body)
    {
        this.body=body;
    }
    public Direction getDirection()
    {
        return direction;
    }
    public void setDirection(Direction direction)
    {
        this.direction=direction;
    }

    public void eat(Node food)
    {
        Node head=body.getFirst();
        switch (direction) {
            case UP:
                //在蛇头上边添加一个节点
                body.addFirst(new Node(head.getx(), head.gety() - 1));
                break;
            case DOWN:
                body.addFirst(new Node(head.getx(), head.gety() + 1));
                break;
            case LEFT:
                body.addFirst(new Node(head.getx() - 1, head.gety()));
                break;
            case RIGHT:
                body.addFirst(new Node(head.getx() + 1, head.gety()));
                break;
        }
    }
}
