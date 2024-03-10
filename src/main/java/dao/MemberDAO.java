package dao;

import domain.MemberVO;
import lombok.Cleanup;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String query = "select mid, mpw, mname, email, mdate from mvc_member where mid =? and mpw = ?";
        MemberVO memberVO = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement =
                connection.prepareStatement(query);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        memberVO = MemberVO.builder()
                .mid(resultSet.getString(1))
                .mpw(resultSet.getString(2))
                .mname(resultSet.getString(3))
                .email(resultSet.getString(4))
                .mdate(resultSet.getDate(5).toLocalDate())
                .build();
        return memberVO;
    }

    public void insert(MemberVO memberVO) throws Exception {
        String sql = "INSERT INTO mvc_member values (?, ?, ?, ?, now())";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, memberVO.getMid());
            pstmt.setString(2, memberVO.getMpw());
            pstmt.setString(3, memberVO.getMname());
            pstmt.setString(4, memberVO.getEmail());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MemberVO> selectAll() throws Exception {
        List<MemberVO> memberVOList = new ArrayList<>();
        String sql = "select * from mvc_member";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            MemberVO memberVO = MemberVO.builder().mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                            .email(rs.getString("email"))
                                    .mdate(rs.getDate("mdate").toLocalDate())
                                            .build();
            memberVOList.add(memberVO);
        }

        return memberVOList;
    }

    public MemberVO selectOne(String mid) throws Exception{
        String sql = "select * from mvc_member where mid = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, mid);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        MemberVO memberVO = MemberVO.builder().mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .email(rs.getString("email"))
                .mdate(rs.getDate("mdate").toLocalDate())
                .build();
        return memberVO;
    }

    public int deleteOne(String mid) throws Exception{
        String sql = "delete from mvc_member where mid = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, mid);
        int row = pstmt.executeUpdate();
        return row;
    }

    public int updateOne(MemberVO memberVO) throws Exception{
        String sql = "update mvc_member set mpw = ?, mname = ? , email = ? where mid = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(4, memberVO.getMid());
        pstmt.setString(1, memberVO.getMpw());
        pstmt.setString(2, memberVO.getMname());
        pstmt.setString(3, memberVO.getEmail());
        int row = pstmt.executeUpdate();
        return row;
    }
}