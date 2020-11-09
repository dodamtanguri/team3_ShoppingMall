package kr.or.bit.shoppingMall.Model.DAO;

import kr.or.bit.shoppingMall.Model.DTO.MemberDTO;
import kr.or.bit.shoppingMall.Utils.ConnectionPoolHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static kr.or.bit.shoppingMall.Model.SQL.MemberSQL.DELETE_MEMBER_QUERY;
import static kr.or.bit.shoppingMall.Model.SQL.MemberSQL.SIGNUP_MEMBER_QUERY;


public class MemberDAO {
    private static ConnectionPoolHelper instance = ConnectionPoolHelper.getInstance();
    private static MemberDAO dao;
    //싱글톤 패턴
//    public DAO() {}
//    public static DAO getInstance() {
//        if (dao == null)
//            dao = new DAO();
//        return dao;
//    }
    //회원가입
    public static int signUp(MemberDTO dto) {
        int resultRow = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn =instance.getConnection();
            pstmt = conn.prepareStatement(SIGNUP_MEMBER_QUERY);
            pstmt.setString(1,dto.getId());
            pstmt.setString(2, dto.getPwd());
            pstmt.setString(3,dto.getName());
            pstmt.setString(4,dto.getHp());
            pstmt.setString(5,dto.getCard_num());
            pstmt.setString(6, dto.getAddress());

            resultRow = pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            instance.freeConnection(conn, pstmt);
        }
    return resultRow;

    }

    //회원탈퇴
    public static int deleteMember(String id) {
        int resultRow = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = instance.getConnection();
            pstmt = conn.prepareStatement(DELETE_MEMBER_QUERY);
            pstmt.setString(1, id);

            resultRow = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            instance.freeConnection(conn, pstmt);
        }
        return resultRow;

    }
}
