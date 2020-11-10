package kr.or.bit.shoppingMall.Model.DAO;

import jdk.dynalink.beans.StaticClass;
import kr.or.bit.shoppingMall.Model.DTO.MemberDTO;
import kr.or.bit.shoppingMall.Utils.ConnectionPoolHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kr.or.bit.shoppingMall.Model.SQL.MemberSQL.*;


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
        System.out.println("connectio 확인");
        try {
            conn = instance.getConnection();
            pstmt = conn.prepareStatement(SIGNUP_MEMBER_QUERY);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPwd());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getHp());
            pstmt.setString(5, dto.getCard_num());
            pstmt.setString(6, dto.getAddress());

            resultRow = pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            instance.freeConnection(conn, pstmt);
        }
        return resultRow;

    }
////로그인
//    public static int signIn(String id, String pwd) {
//        int resultRow = 0;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try  {
//            conn = instance.getConnection();
//            pstmt = conn.prepareStatement(SIGNIN_MEMBER_QUERY);
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

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

    //SignIn  >> id랑 비밀번호 일치하는지 확인
    public int getMember(String id, String pwd) {
        MemberDTO dto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = instance.getConnection();
            pstmt = conn.prepareStatement(SIGNIN_MEMBER_QUERY);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).equals(pwd)) {
                    return 1;
                } else {
                    return 0;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            instance.freeConnection(conn, pstmt, rs);
        }
        return -1;
    }

    private static MemberDTO setMember(ResultSet rs) throws SQLException {
        String id = rs.getString("ID").trim();
        String pwd = rs.getString("PWD").trim();
        String name = rs.getString("NAME").trim();
        String hp = rs.getString("HP").trim();
        String delflag = rs.getString("DELFLAG").trim();
        String card_num = rs.getString("CARD_NUM").trim();
        String address = rs.getString("ADDRESS").trim();
        MemberDTO dto = new MemberDTO(id, pwd, name, hp, delflag, card_num, address);
        return dto;
    }


}
