package org.example.Service;

import org.example.Model.ProblemModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemService {
    static final String JDBC = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/Problems";
    static final String uname = "root";
    static final String pass = "";
    public List<ProblemModel> fetchProblems() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC);
        try(Connection conn = DriverManager.getConnection(url, uname, pass);
            PreparedStatement stmt = conn.prepareStatement("SELECT * from Problems")) {
            List<ProblemModel>  problemModels = new ArrayList<>();

            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    problemModels.add(new ProblemModel(rs.getInt("id"), rs.getString("problemName"),
                            rs.getString("authorName")));
                }
            }
            return problemModels;
        }
    }

    public ProblemModel fetchProblem(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC);
        try(Connection conn = DriverManager.getConnection(url, uname, pass);
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * From Problems WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ProblemModel problemModel = new ProblemModel(resultSet.getInt("id"), resultSet.getString("authorName"),
                    resultSet.getString("problemName"));
            System.out.println(problemModel);
            return problemModel;
        }
    }

    public void postProblem(ProblemModel problemModel) throws ClassNotFoundException {
        Class.forName(JDBC);
        try(Connection conn = DriverManager.getConnection(url, uname, pass);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Problems(id, authorName, problemName) VALUES (?, ?, ?)")) {
            stmt.setInt(1, problemModel.getId());
            stmt.setString(2, problemModel.getAuthorName());
            stmt.setString(3, problemModel.getProblemName());
            stmt.executeUpdate();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateProblem(int id, ProblemModel problemModel) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC);
        try(Connection conn = DriverManager.getConnection(url, uname, pass);
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Problems SET problemName = ?, authorName = ? WHERE id = ?")) {
            preparedStatement.setString(1, problemModel.getProblemName());
            preparedStatement.setString(2, problemModel.getAuthorName());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteProblem(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC);
        try(Connection conn = DriverManager.getConnection(url, uname, pass);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Problems WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
