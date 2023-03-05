package vistor;

/**
 * 访问接口  不同身份对待不同访问人执行方法
 *
 * 所以 一般接口定义是 固定必须各自业务实现接口 的抽象
 *
 * @author huql
 **/
public interface IVistor {

    void visit(Manager manager);


    void visit(Engineer engineer);
}
