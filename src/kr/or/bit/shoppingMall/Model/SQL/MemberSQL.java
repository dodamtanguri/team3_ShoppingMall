package kr.or.bit.shoppingMall.Model.SQL;public class MemberSQL {
    public static final String DELETE_MEMBER_QUERY = "UPDATE MEMBER SET DELFLAG = 'Y' WHERE ID = ?";
    public static final String SIGNUP_MEMBER_QUERY = "INSERT INTO memberTest (id,pwd,name,hp,card_num,address) values(?,?,?,?,?,?)";
    public static final String SIGNIN_MEMBER_QUERY = "SELECT id,pwd,name,hp,delflag,card_num,address FROM MEMBERTEST m WHERE id = ?";

}
